package banking;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.text.DecimalFormat;

@Entity
@Table()
public class Account {
    @Id
    private long accountNumber;

    private Double balance = 0d;

    //dollars = 0
    //euros = 1
    //yen = 2
    private int currencyType = 0;

    private String username;

    @Transient
    private DecimalFormat df = new DecimalFormat("#.00");

    public Account() {
        //empty
    }

    Account(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    long getAccountNumber() {
        return accountNumber;
    }

    private String stringCurrencyType() {
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

    int getCurrencyType() {
        return currencyType;
    }

    void setCurrencyType(int i) {
        currencyType = i;
    }

    Double getBalance() {
        return balance;
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    void setBalance(Double balance) {
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
                + "\n\tAccount Balance: " + df.format(getBalance())
                + "\n\tAccount Currency Type: " + stringCurrencyType()
                + "\n}\n";
       return s;
    }
}
