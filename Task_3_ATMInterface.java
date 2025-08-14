import java.util.Scanner;

class Account {
    private double money;
    
    public Account(double startBalance) {
        this.money = startBalance;
    }
    
    public double checkBalance() {
        return money;
    }
    
    public void addMoney(double amt) {
        if (amt > 0) {
            money += amt;
            System.out.println("Deposit of $" + amt + " successful. Current balance: $" + money);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    public void takeMoney(double amt) {
        if (amt > 0 && amt <= money) {
            money -= amt;
            System.out.println("Withdrawal of $" + amt + " successful. Current balance: $" + money);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

class Machine {
    private Account userAccount;
    
    public Machine(Account userAccount) {
        this.userAccount = userAccount;
    }
    
    public void showOptions() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    
    public void doTransaction(int option, Scanner input) {
        switch (option) {
            case 1:
                System.out.println("Current balance: $" + userAccount.checkBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmt = input.nextDouble();
                userAccount.addMoney(depositAmt);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmt = input.nextDouble();
                userAccount.takeMoney(withdrawAmt);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}

public class Task_3_ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter initial account balance: $");
        double startBalance = sc.nextDouble();
        
        Account userAccount = new Account(startBalance);
        Machine atmMachine = new Machine(userAccount);
        
        while (true) {
            atmMachine.showOptions();
            System.out.print("Select an option: ");
            int option = sc.nextInt();
            atmMachine.doTransaction(option, sc);
        }
    }
}
