package restaurant_billing_system;

import java.util.*;

public class Billing {

	public static void main(String[] args) {

		
		 Scanner sc = new Scanner(System.in);
	        Restaurant restaurant = new Restaurant();

	        // Initial Menu
	        restaurant.addMenuItem(new MenuItem(1, "Burger", 120));
	        restaurant.addMenuItem(new MenuItem(2, "Pizza", 250));
	        restaurant.addMenuItem(new MenuItem(3, "Coffee", 80));

	        int choice;

	        do {
	            System.out.println("\n1. Show Menu");
	            System.out.println("2. Add Item to Order");
	            System.out.println("3. Remove Item from Order");
	            System.out.println("4. Add Menu Item");
	            System.out.println("5. Remove Menu Item");
	            System.out.println("6. Print Bill");
	            System.out.println("0. Exit");
	            System.out.print("Enter choice: ");
	            

	            choice = sc.nextInt();
	            System.out.println();
	            
	            switch (choice) {
	                case 1:
	                    restaurant.displayMenu();
	                    break;

	                case 2:
	                    System.out.print("Enter Item ID: ");
	                    int id = sc.nextInt();
	                    System.out.print("Enter Quantity: ");
	                    int qty = sc.nextInt();
	                    restaurant.addToOrder(id, qty);
	                    System.out.println("Order has been Successfully..");
	                    break;

	                case 3:
	                    System.out.print("Enter Item ID to remove: ");
	                    restaurant.removeFromOrder(sc.nextInt());
	                    System.out.println("Order Cancel Successfully..");
	                    break;

	                case 4:
	                    System.out.print("Enter new Item ID: ");
	                    int newId = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Enter price: ");
	                    double price = sc.nextDouble();
	                    restaurant.addMenuItem(new MenuItem(newId, name, price));
	                    System.out.println("Menu Item Added..");
	                    break;

	                case 5:
	                    System.out.print("Enter Item ID to remove from menu: ");
	                    restaurant.removeMenuItem(sc.nextInt());
	                    System.out.println("Menu Item Removed..");
	                    break;

	                case 6:
	                    restaurant.printBill();
	                    break;

	                case 0:
	                    System.out.println("Thank you! Visit again.");
	                    break;

	                default:
	                    System.out.println("Invalid choice!");
	            }
	        } while (choice != 0);

	        sc.close();
	}

}
