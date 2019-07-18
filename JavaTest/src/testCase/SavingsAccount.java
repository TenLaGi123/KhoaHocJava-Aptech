package testCase;

public class SavingsAccount {
    private static Integer annualInterestRate;
    private Double savingsbalance;
    SavingsAccount(Double savingsbalance){
        this.savingsbalance = savingsbalance;
    }

    public Double calculateMonthlyInterest(){
        double monthlyInterest = savingsbalance*((annualInterestRate/100)/12);
        savingsbalance += monthlyInterest;
        return monthlyInterest;
    }

    public static void modifyInterestRate(int annualInterestRate1){
        annualInterestRate = annualInterestRate1;
    }
}
