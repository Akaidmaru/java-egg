public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(300);
        BankAccount account2 = new BankAccount(500);
        try{
            System.out.println(account1.withdraw(301));
            System.out.println(account2.withdraw(450));
        } catch(Exception error){
            System.out.println("Error: " + error.getMessage());
        }
    }
}
