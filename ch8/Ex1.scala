/* 
Extend the following BankAccount class to a CheckingAccount class that 
charges $1 for every deposit and withdrawal:

class BankAccount(initialBalance: Double) :
  private var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
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

    override def deposit(amount: Double): Double =
        super.deposit(amount-1)
        currentBalance
    
    override def withdraw(amount: Double): Double =
        super.withdraw(amount+1)
        currentBalance


@main def ex1 =

    val account1 = CheckingAccount(100)
    account1.deposit(10)
    account1.withdraw(10)
    
    assert(account1.currentBalance == 98)
