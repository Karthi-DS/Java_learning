package lab_exs_and_HW.worksheet_4;

import java.util.Arrays;

public class RestaurantOrder {

    private String customerName;
    private String orderType;
    private StringBuilder specialInstructions;
    private String[] items;
    private int itemCount;

    public RestaurantOrder(String customerName, String orderType, int capacity) {
        this.customerName = customerName;
        this.orderType = orderType;
        this.specialInstructions = new StringBuilder();
        this.items = new String[capacity];
        this.itemCount = 0;
    }

    public void addItem(String item) {
        if (itemCount < items.length) {
            items[itemCount] = item;
            itemCount++;
        }
    }

    public void addSpecialInstruction(String instruction) {
        specialInstructions.append(instruction).append(" ");
    }

    public void displayOrderSummary() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Type: " + orderType);
        System.out.println("Items Ordered: ");
        for (int i = 0; i < itemCount; i++) {
            System.out.println("- " + items[i]);
        }
        System.out.println("Special Instructions: " + specialInstructions.toString());
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {

        RestaurantOrder order1 = new RestaurantOrder("Karthi", "Online", 5);
        order1.addItem("Burger");
        order1.addItem("Fries");
        order1.addSpecialInstruction("No onions.");
        order1.displayOrderSummary();

        RestaurantOrder order2 = new RestaurantOrder("Arun", "Offline", 4);
        order2.addItem("Pizza");
        order2.addItem("Coke");
        order2.addSpecialInstruction("Extra cheese.");
        order2.displayOrderSummary();

        RestaurantOrder order3 = new RestaurantOrder("Meena", "Online", 6);
        order3.addItem("Pasta");
        order3.addItem("Garlic Bread");
        order3.addItem("Juice");
        order3.addSpecialInstruction("Less spicy.");
        order3.displayOrderSummary();
    }
}

