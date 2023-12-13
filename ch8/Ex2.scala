package ex2

/* 
Extend the BankAccount class of the preceding exercise into a 
class SavingsAccount that earns interest every month (when a method 
earnMonthlyInterest is called) and has three free deposits or 
withdrawals every month. Reset the transaction count in the 
earnMonthlyInterest method.
*/

class BankAccount(initialBalance: Double):

    private var balance = initialBalance

    def currentBalance = balance

    def deposit(amount: Double) = 
        balance += amount
        balance

    def withdraw(amount: Double) =
        balance -= amount
        balance


class SavingsAccount(initialBalance: Double, var monthlyInterest: Double = 0.05) 
    extends BankAccount(initialBalance):

    private var transactionCount = 0

    override def deposit(amount: Double): Double =
        if transactionCount >= 3 then
            super.deposit(amount-1)
        else
            super.deposit(amount)
        transactionCount += 1
        currentBalance

    override def withdraw(amount: Double): Double =
        if transactionCount >= 3 then
            super.withdraw(amount+1)
        else
            super.withdraw(amount)
        transactionCount += 1
        currentBalance

    def earnMonthlyInterest(): Double =
        super.deposit(currentBalance * monthlyInterest)
        transactionCount = 0
        currentBalance


@main def ex2 =

    val savingsAccount = SavingsAccount(1000, 0.1)

    savingsAccount.deposit(10)              // no charge       -> 1010.00
    savingsAccount.withdraw(10)             // no charge       -> 1000.00
    savingsAccount.deposit(10)              // no charge       -> 1010.00
    savingsAccount.withdraw(10)             // charge $1       ->  999.00
    savingsAccount.earnMonthlyInterest()    // 999 + 999 * 0.1 -> 1098.90

    assert(savingsAccount.currentBalance == 1098.9)
