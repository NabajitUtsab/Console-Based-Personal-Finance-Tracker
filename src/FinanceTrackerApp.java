import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinanceTrackerApp {

    static Scanner scanner = new Scanner(System.in);

    static List<Transaction> transactions = new ArrayList<Transaction>();


    public static void main(String[] args) {

        while (true) {
            optionsBar();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addTransaction();
                    break;
                case 2:
                    viewAllTransactions();
                    break;
                case 3:
                    updateTransaction();
                    break;
                case 4:
                    deleteTransaction();
                    break;
                case 5:
                    calculateBalance();
                    break;
                case 6:
                    System.out.println("Exiting.......................");
                    return;

                default:
                    System.out.println("Please give valid option !");
                    break;


            }

        }

    }


    //option bar
    public static void optionsBar() {
        System.out.println("\n======= PERSONAL FINANCE TRACKER =======");
        System.out.println("1. Add Transaction");
        System.out.println("2. View All Transactions");
        System.out.println("3. Update Transaction");
        System.out.println("4. Delete Transaction");
        System.out.println("5. Calculate Balance");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");

    }


    // Add Transcation Section
    public static void addTransaction() {
        System.out.print("Enter transaction ID: ");
        String id = scanner.next();
        scanner.nextLine();

        System.out.println("Enter type (Income/Expense): ");
        String type = scanner.next();
        scanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter date(DD-MM-YYYY): ");
        String date = scanner.next();
        scanner.nextLine();

        System.out.println("Enter description: ");
        String description = scanner.nextLine();


        if (amount < 0 || (!type.equalsIgnoreCase("INCOME") && !type.equalsIgnoreCase("EXPENSE"))) {
            System.out.println("Please enter a valid type (Income/Expense) or amount should be positive number");
            return;
        }

        Transaction t1 = new Transaction(id, type, amount, date, description);
        transactions.add(t1);

        System.out.println("Transaction added successfully");
    }


    //view Transaction
    public static void viewAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("There are no transactions");
        }
        for (Transaction t : transactions) {
            System.out.println(t.toString());
        }
    }


    //update transactions
    public static void updateTransaction() {

        if (transactions.isEmpty()) {
            System.out.println("There are no transactions");
            return;
        }

        System.out.print("Enter transaction ID: ");
        String id = scanner.next();

        boolean found = false;

        for (Transaction t : transactions) {

            if (t.getId().equals(id)) {
                found = true;

                System.out.println(t.toString());

                System.out.println("Enter which one you want to update: ");
                System.out.println("a. Type");
                System.out.println("b. Amount");
                System.out.println("c. Date");
                System.out.println("d. Description");
                System.out.println("e. All");

                String choice = scanner.next();

                switch (choice) {

                    case "a":
                        System.out.print("Enter new type (Income/Expense): ");
                        t.setType(scanner.next());
                        break;

                    case "b":
                        double amount;
                        while (true) {
                            System.out.print("Enter amount to update: ");
                            amount = scanner.nextDouble();
                            if (amount < 0) {
                                System.out.println("Amount cannot be negative. Try again.");
                            } else {
                                break;
                            }
                        }
                        t.setAmount(amount);
                        break;

                    case "c":
                        System.out.print("Enter date (DD-MM-YYYY): ");
                        t.setDate(scanner.next());
                        break;

                    case "d":
                        scanner.nextLine(); // clear buffer
                        System.out.print("Enter description: ");
                        t.setDescription(scanner.nextLine());
                        break;

                    case "e":
                        System.out.print("Enter new type (Income/Expense): ");
                        t.setType(scanner.next());

                        double amt;
                        while (true) {
                            System.out.print("Enter amount: ");
                            amt = scanner.nextDouble();
                            if (amt < 0) {
                                System.out.println("Amount cannot be negative.");
                            } else {
                                break;
                            }
                        }
                        t.setAmount(amt);

                        System.out.print("Enter date (DD-MM-YYYY): ");
                        t.setDate(scanner.next());

                        scanner.nextLine();
                        System.out.print("Enter description: ");
                        t.setDescription(scanner.nextLine());
                        break;

                    default:
                        System.out.println("Invalid option!");
                }

                System.out.println("Updated transaction successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Transaction not found!");
        }
    }



    //Delete transaction
    public static void deleteTransaction() {
        if (transactions.isEmpty()) {
            System.out.println("There are no transactions");
            return;
        }

        System.out.print("Enter transaction ID: ");
        String id = scanner.next();

        for (Transaction t : transactions) {
            if (t.getId().equals(id)) {
                transactions.remove(t);
                System.out.println("Transaction deleted successfully");
                return;
            }
        }

        System.out.println("Transaction not found!");

    }


    //Calculate transaction
    public static void calculateBalance() {

        if (transactions.isEmpty()) {
            System.out.println("There are no transactions");
            return;
        }

        double inc = 0, exp = 0;

        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("INCOME")) {
                inc += t.getAmount();
            } else if (t.getType().equalsIgnoreCase("Expense")) {
                exp += t.getAmount();
            }
        }
        System.out.println("Total income is: " + inc);
        System.out.println("Total expense is: " + exp);
        System.out.println("Your balance is: " + (inc - exp));

    }


}
