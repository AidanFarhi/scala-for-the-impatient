
/*
1. Extend the following BankAccount class to a CheckingAccount class 
that charges $1 for every deposit and withdrawal:

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
    override def deposit(amount: Double): Double = super.deposit(amount-1)
    override def withdraw(amount: Double): Double = super.withdraw(amount+1)
        

@main def main =
    val ca1 = CheckingAccount(1000)
    ca1.deposit(100)
    ca1.withdraw(100)
    assert(ca1.currentBalance == 998)
