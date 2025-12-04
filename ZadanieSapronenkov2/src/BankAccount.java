import java.time.LocalDateTime;

public class BankAccount {

    private String ownerName;
    private int balance;
    private LocalDateTime openedAt;
    private boolean isBlocked;

    // Конструктор с одним параметром имя владельца
    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.openedAt = LocalDateTime.now();
        this.isBlocked = false;
    }

    public boolean deposit(int amount) {
        if (isBlocked || amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (isBlocked || amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer(BankAccount otherAccount, int amount) {
        if (isBlocked || otherAccount.isBlocked) {
            return false;
        }
        if (amount <= 0 || amount > balance) {
            return false;
        }

        this.balance -= amount;

        otherAccount.balance += amount;

        return true;
    }
    
    public int getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }
}
