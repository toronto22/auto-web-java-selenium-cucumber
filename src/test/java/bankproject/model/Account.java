package bankproject.model;

public class Account {
    public String customerName;
    public String accountNumber;
    public int balance;
    public String currency;

    public Account(String customerName, String accountNumber, int balance, String currency) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
    }

    public Account(String customerName, String accountNumber, String currency) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.currency = currency;
    }
}
