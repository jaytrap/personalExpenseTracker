import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> categories = new ArrayList<>();
        List<Double> amounts= new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello welcome to expense tracker!");
        String endEntry = "";
        do{
            System.out.println("Enter the category of expense");
            String category = scanner.nextLine();
            categories.add(category);
            System.out.println("Enter the amount of expense");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Enter a valid number");
                scanner.nextLine();
            }
            double amount = scanner.nextDouble();
            amounts.add(amount);
            scanner.nextLine();
            System.out.println("Enter any key to continue and x to exit");
            endEntry = scanner.nextLine();
        }while (!endEntry.equals("x"));
        displayPutExpenses(amounts, categories);
    }

    static Double getTotalExpenses(List<Double> amounts) {
        Double totalExpenses = 0.0;
        for (Double amount : amounts) {
            totalExpenses += amount;
        }
        return totalExpenses;
    }
    static void displayPutExpenses(List<Double> amounts, List<String> categories) {
        System.out.println("------ Tracked Expenses ------");
        System.out.printf("%-20s %10s%n", "Category", "Amount");
            for (int i = 0; i < categories.size(); i++) {
                System.out.printf("%-20s %10.2f%n",categories.get(i),amounts.get(i));
            }
            System.out.printf("%-20s %10.2f%n","Total",getTotalExpenses(amounts));

    }
}