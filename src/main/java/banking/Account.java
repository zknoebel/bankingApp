package banking;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Account {
    @Id
    private long accountNumber;

    private Double balance = new Double(0);

    //dollars = 0
    //euros = 1
    //yen = 2
    private int currencyType = 0;

    private String username;

    public Account() {
        //empty
    }

    public Account(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getCurrencyType() {
        switch (currencyType) {
            case 0:
                return "DOLLAR";

            case 1:
                return "EURO";

            case 2:
                return "YEN";

            default:
                return "Not set";
        }
    }

    public void setCurrencyType(int i) {
        currencyType = i;
    }

    public Double getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void addToBalance(Double amountToAdd) {
        balance += amountToAdd;
    }

    public void subtractFromBalance(Double amountToSubtract) {
        balance -= amountToSubtract;
    }

    @Override
    public String toString() {
        String s = "\n{"
                + "\n\tUsername: " + getUsername()
                + "\n\tAccount Number: " + getAccountNumber()
                + "\n\tAccount Balance: " + getBalance()
                + "\n\tAccount Currency Type: " + getCurrencyType()
                + "\n}\n";
       return s;
    }
}
