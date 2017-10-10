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
                + "\n\tAccount Number: " + accountNumber
                + "\n\tAccount Balance: " + balance
                + "\n\tAccount Currency Type: " + currencyType
                + "\n}\n";
       return s;
    }
}
