public class Transaction {

    private String id;
    private String type;
    private double amount;
    private String date;
    private String description;

    public Transaction() {}

    public Transaction(String id, String type, double amount, String date, String description) {
        this.id = id;
        setType(type);
        setAmount(amount);
        setDate(date);
        setDescription(description);
    }

    public void setType(String type) {
        if (type.equalsIgnoreCase("INCOME") || type.equalsIgnoreCase("EXPENSE")) {
            this.type = type.toUpperCase();
        } else {
            System.out.println("Type must be INCOME or EXPENSE. Try Again!");
            System.out.println("Enter type(Income/Expense): ");

        }
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            System.out.println("Amount must be positive value. Try Again!");
            System.out.println("Enter amount: ");
            return;
        }
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Id = " + id +
                ", Type = " + type +
                ", Amount = " + amount + " Taka" +
                ", Date = " + date +
                ", Description = " + description;
    }
}
