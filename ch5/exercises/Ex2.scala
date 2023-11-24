
// 2. Write a class BankAccount with methods deposit and withdraw, and a read-only property balance.

class BankAccount:

    private var _balance = 0.0

    def this(initialBalance: Double) =
        this()
        _balance = initialBalance

    def balance = _balance
    def deposit(amount: Double) = _balance += amount
    def withdraw(amount: Double) = _balance -= amount


@main def ex2 = 

    val account1 = BankAccount()
    val account2 = BankAccount(100.00)

    account1.deposit(140.00)
    account1.withdraw(25.00)
    account2.withdraw(50.00)

    assert(account1.balance == 115.00)
    assert(account2.balance == 50.00)
