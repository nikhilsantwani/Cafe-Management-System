import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Cafe {
    private Map<String, Double> menu;
    private List<Order> orders;

    public Cafe() {
        this.menu = new HashMap<>();
        this.orders = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        menu.put("Coffee", 250.23);
        menu.put("Tea", 20.40);
        menu.put("Sandwich", 350.78);
        menu.put("Cake", 500.12);
    }

    public void displayMenu() {
        System.out.println("\nMenu:");
        for (Map.Entry<String, Double> item : menu.entrySet()) {
            System.out.println(item.getKey() + " - $" + item.getValue());
        }
    }

    public void placeOrder(String itemName, int quantity) {
        if (menu.containsKey(itemName)) {
            double price = menu.get(itemName);
            Order order = new Order(itemName, quantity, price);
            orders.add(order);
            System.out.println("Order placed: " + order);
        } else {
            System.out.println("Item not found in the menu.");
        }
    }

    public void displayOrders() {
        System.out.println("\nOrders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0.0;
        for (Order order : orders) {
            totalRevenue += order.getTotalPrice();
        }
        return totalRevenue;
    }
}

class Order {
    private String itemName;
    private int quantity;
    private double unitPrice;

    public Order(String itemName, int quantity, double unitPrice) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return quantity * unitPrice;
    }

    
    public String toString() {
        return itemName + " x" + quantity + " - $" + getTotalPrice();
    }
}

 class CafeManagementSystem {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCafe Management System");
            System.out.println("1. Display Menu");
            System.out.println("2. Place Order");
            System.out.println("3. Display Orders");
            System.out.println("4. Calculate Total Revenue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    cafe.displayMenu();
                    break;

                case 2:
                    System.out.print("Enter Item Name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    cafe.placeOrder(itemName, quantity);
                    break;

                case 3:
                    cafe.displayOrders();
                    break;

                case 4:
                    System.out.println("Total Revenue: $" + cafe.calculateTotalRevenue());
                    break;

                case 5:
                    System.out.println("Exiting Cafe Management System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}