public class BankAccount {
    double initialBalance;

    public BankAccount() {
    }

    public BankAccount(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public String withdraw(double amount) throws Exception{
        if (amount > getInitialBalance()){
            throw new Exception("SaldoInsuficienteException");
        }
        return "Has retirado: " + amount + "$ de tu cuenta";
    }
}
