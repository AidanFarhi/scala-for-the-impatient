/*
2. Extend the BankAccount class of the preceding exercise into a 
class SavingsAccount that earns interest every month (when a method 
earnMonthlyInterest is called) and has three free deposits or withdrawals 
every month. Reset the transaction count in the earnMonthlyInterest method.
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


class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance):
    override def deposit(amount: Double): Double = super.deposit(amount-1)
    override def withdraw(amount: Double): Double = super.withdraw(amount+1)


class SavingsAccount(initialBalance: Double, val interestRate: Double) extends CheckingAccount(initialBalance):
    private var transactionCount = 0
    override def deposit(amount: Double): Double =
        if transactionCount >= 3 then 
            super.deposit(amount) 
        else 
            super.deposit(amount+1)
        transactionCount += 1
        currentBalance
    override def withdraw(amount: Double): Double =
        if transactionCount >= 3 then 
            super.withdraw(amount) 
        else 
            super.withdraw(amount-1)
        transactionCount += 1
        currentBalance
    def earnMonthlyInterest(): Double =
        transactionCount = -1
        deposit(currentBalance * interestRate)


@main def main =
    val sa = SavingsAccount(1000, 0.15)
    sa.deposit(100)
    sa.deposit(100)
    sa.deposit(100)
    sa.deposit(100) // $1 charge
    assert(sa.currentBalance == 1399)
    sa.earnMonthlyInterest()
    assert(sa.currentBalance == 1608.85)
    sa.withdraw(8.85)
    sa.withdraw(100)
    sa.withdraw(100)
    assert(sa.currentBalance == 1400)
    sa.withdraw(100) // $1 charge
    assert(sa.currentBalance == 1299)
