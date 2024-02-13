package ATM_Machine;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

class Transaction {
    private String type;
    private float amount;
    private Date timestamp;

    public Transaction(String type, float amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = new Date();
    }

    public String getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(timestamp);
    }
}

class ATM {
    private float balance;
    private final int PIN = 5674;
    private ArrayList<Transaction> transactions;

    public ATM() {
        balance = 10000; // Set initial balance
        transactions = new ArrayList<>();
    }

    public void check_pin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+------------------------------------------+");
        System.out.println("+             Welcome to the               +");
        System.out.println("+               ATM Machine                +");
        System.out.println("+------------------------------------------+\n");
        System.out.print("Please enter your PIN: ");


        int enteredPin = scanner.nextInt();
        if (enteredPin == PIN) {

            System.out.println("\n--------PIN accepted. Access granted.--------\n");
            menu();
        } else {
            System.out.println("\n-------Incorrect PIN. Please try again.-------\n");
            check_pin(); // Recursive call to prompt for PIN again
        }
    }//end

    public void menu() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("         .......... Menu ..........         ");
        System.out.println("              1. Check Balance              ");
        System.out.println("              2. Withdraw                   ");
        System.out.println("              3. Deposit                    ");
        System.out.println("              4. Transaction History        ");
        System.out.println("              5. Exit                       \n");

        System.out.print("Enter a valid choice: ");

        int choice;
        do {
            choice = scanner.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.print("Invalid choice. Please enter a number between 1 and 5: ");
            }
        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                showTransactionHistory();
                break;
            case 5:
                exit();
                break;
        }


    }//end

    public void checkBalance() {
        System.out.println("---------------------------------------------------");
        System.out.println("           Current Balance: Rs." + balance);
        System.out.println("---------------------------------------------------\n");
        menu();
    }//end

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter amount to withdraw: ");
        float amount = scanner.nextFloat();

        if (amount <= 0) {
            System.out.println("  \nInvalid amount. Please enter a positive number.");
            withdraw();

        } else if (amount > balance) {
            System.out.println("---------------------------------------------------");
            System.out.println("      Insufficient balance. Enter valid amount     ");
            System.out.println("---------------------------------------------------");
            withdraw();

        } else {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));

            System.out.println("\nRs." + amount + " withdrawn successfully.");
            System.out.println("---------------------------------------------------");
            System.out.println("        Your Account Balance: Rs." + balance);
            System.out.println("---------------------------------------------------");
        }
        menu();
    }//end

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter amount to deposit: ");
        float amount = scanner.nextFloat();

        if (amount <= 0) {
            System.out.println("\nInvalid amount. Please enter a positive number.");
            deposit();
        } else {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("\nRs." + amount + " deposited successfully.");

            System.out.println("---------------------------------------------------");
            System.out.println("      Your Account Balance: Rs." + balance);
            System.out.println("---------------------------------------------------");
        }
        menu();
    }//end

    public void showTransactionHistory() {
        System.out.println("\n                       Transaction History                ");
        if (transactions.isEmpty()) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("|                       No transactions yet.                         |");
            System.out.println("---------------------------------------------------------------------");
        } else {
            System.out.println("+-------------------+-----------------------+-----------------------+");
            System.out.println("|        Type       |         Amount        |       Timestamp       |");
            System.out.println("+-------------------+-----------------------+-----------------------+");
            for (Transaction transaction : transactions) {
                System.out.printf("| %-17s | %-21s | %-21s |\n", transaction.getType(), "Rs." + transaction.getAmount(), transaction.getTimestamp());
            }
            System.out.println("+-------------------+-----------------------+-----------------------+");
        }
        menu();
    }//end

    public void exit() {
        System.out.println("________________________________________________________________");
        System.out.println("        Thank you for using the ATM Machine. Goodbye!!!         ");
        System.out.println("________________________________________________________________");
        System.exit(0);
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.check_pin();
    }
}
