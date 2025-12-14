package restaurant_billing_system;

import java.util.*;

public class Restaurant {
    private List<MenuItem> menu = new ArrayList<>();
    private List<OrderItem> order = new ArrayList<>();
    private static final double GST_RATE = 0.05; // 5% GST

    // Add menu item
    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    // Remove menu item
    public void removeMenuItem(int id) {
        menu.removeIf(item -> item.getId() == id);
    }

    // Display menu
    public void displayMenu() {
        System.out.println("\n---- MENU ----");
        for (MenuItem item : menu) {
            System.out.println(item.getId() + ". " + item.getName() + " - ₹" + item.getPrice());
        }
    }

    // Add item to order
    public void addToOrder(int itemId, int quantity) {
        for (MenuItem item : menu) {
            if (item.getId() == itemId) {
                order.add(new OrderItem(item, quantity));
                return;
            }
        }
        System.out.println("Item not found!");
    }

    // Remove item from order
    public void removeFromOrder(int itemId) {
        order.removeIf(o -> o.getItem().getId() == itemId);
    }

    // Calculate total
    public double calculateSubtotal() {
        double total = 0;
        for (OrderItem o : order) {
            total += o.getTotalPrice();
        }
        return total;
    }

    // Print bill
    public void printBill() {
        System.out.println("\n===== ITEMIZED BILL =====");
        System.out.printf("%-15s %-10s %-10s%n", "Item", "Qty", "Price");

        for (OrderItem o : order) {
            System.out.printf("%-15s %-10d ₹%-10.2f%n",
                    o.getItem().getName(),
                    o.getQuantity(),
                    o.getTotalPrice());
        }

        double subtotal = calculateSubtotal();
        double gst = subtotal * GST_RATE;
        double total = subtotal + gst;

        System.out.println("----------------------------");
        System.out.printf("Subtotal : ₹%.2f%n", subtotal);
        System.out.printf("GST (5%%) : ₹%.2f%n", gst);
        System.out.printf("Total    : ₹%.2f%n", total);
        System.out.println("============================");
    }
}

