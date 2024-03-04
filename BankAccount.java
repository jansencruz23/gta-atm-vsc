public class BankAccount {
    private String pinNumber = "1234";
    private double currentBalance = 3000;
    private double savingsBalance = 3000;

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double balance) {
        this.currentBalance = balance;
    }
    
    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double balance) {
        this.savingsBalance = balance;
    }
}
