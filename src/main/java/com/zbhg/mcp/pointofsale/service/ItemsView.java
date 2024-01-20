package com.zbhg.mcp.pointofsale.service;

import com.zbhg.mcp.pointofsale.bean.ItemsInfo;
import com.zbhg.mcp.pointofsale.bl.ItemsTask;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

public class ItemsView {
    public static void ItemsMenu() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        System.out.print("\033[H\033[2J"); // Clear the console

        System.out.println("\tItems Menu\n");
        System.out.println("\t 1 - Add New Item");
        System.out.println("\t 2 - Update Item Details");
        System.out.println("\t 3 - Find Items");
        System.out.println("\t 4 - Remove Existing Item");
        System.out.println("\t 5 - Back To Main Menu");

        System.out.print("\n Press 1 to 5 to select an option: ");
        String inp = scanner.nextLine();
        input = Integer.parseInt(inp);

        if(input == 1)
        {
            ItemsView.AddItem();
        }
        else if(input == 2)
        {
            ItemsView.updateItem();
        }
        else if(input == 3)
        {
            ItemsView.findItem();
        }
        else if(input == 4)
        {
            //ItemsView.deleteItem();
        }
        else if(input == 5)
        {
            return;
        }
        ItemsView.ItemsMenu();
        scanner.close();
    }

    // Add Item
    public static void AddItem() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\tEnter Item Description: ");
        String description = scanner.nextLine();

        System.out.print("\tEnter Item Price: ");
        int price = 0;

        // Validate that the input is a valid integer
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid price as an integer.");
            scanner.nextLine(); // Clear the buffer
        }

        price = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("\tEnter Item Quantity: ");
        int quantity = 0;

        // Validate that the input is a valid integer
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid quantity as an integer.");
            scanner.nextLine(); // Clear the buffer
        }

        quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        ItemsInfo itemInfo = new ItemsInfo();
        itemInfo.setDescription(description);
        itemInfo.setPrice(price);
        itemInfo.setQuantity(quantity);

        try {
            ItemsTask itemsTask = new ItemsTask();
            String message = itemsTask.addItem(itemInfo);
            System.out.println("\n\t" + message);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("An Error Occurred");
            e.getMessage();
        }

    }

    public static void updateItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\tEnter Item ID: ");
        int id = 0;

        // Validate that the input is a valid integer
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid id as an integer.");
            scanner.nextLine(); // Clear the buffer
        }

        id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\tEnter Item Description: ");
        String description = scanner.nextLine();

        System.out.print("\tEnter Item Price: ");
        int price = 0;

        // Validate that the input is a valid integer
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid price as an integer.");
            scanner.nextLine(); // Clear the buffer
        }

        price = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("\tEnter Item Quantity: ");
        int quantity = 0;

        // Validate that the input is a valid integer
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid quantity as an integer.");
            scanner.nextLine(); // Clear the buffer
        }

        quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        ItemsInfo itemInfo = new ItemsInfo();
        itemInfo.setId(id);
        itemInfo.setDescription(description);
        itemInfo.setPrice(price);
        itemInfo.setQuantity(quantity);

        try {
            ItemsTask itemsTask = new ItemsTask();
            String message = itemsTask.updateItem(itemInfo);
            System.out.println("\n\t" + message);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("An Error Ocuured");
            e.getMessage();
        }
    }

    public static void findItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\tItem ID: ");
        int itemId = scanner.nextInt();

        System.out.print("\tDescription: ");
        scanner.nextLine(); // Consume the newline character left by nextInt()
        String description = scanner.nextLine();

        System.out.print("\tPrice: ");
        int price = scanner.nextInt();

        System.out.print("\tQuantity: ");
        int quantity = scanner.nextInt();

        System.out.print("\tCreation Date: ");
        Date date = Date.valueOf(scanner.next());
        System.out.println("\n\t" + date);
        boolean d = date.toString().length() == 10;

        if (itemId > 0 || !description.isEmpty() || price > 0 || quantity > 0 || d) {

            ItemsInfo itemInfo = new ItemsInfo();
            itemInfo.setId(itemId);
            itemInfo.setDescription(description);
            itemInfo.setPrice(price);
            itemInfo.setQuantity(quantity);
            itemInfo.setCreationDate(date);

            List<ItemsInfo> items = null;

            try {
                items = new ArrayList<>();
                ItemsTask itemTask = new ItemsTask();
                items = itemTask.findItem(itemInfo);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("An Error Occurred");
                e.getMessage();
            }

            if (items != null && !items.isEmpty()) {
                System.out.println(" ---------------------------------------------------------------------------------");
                System.out.println("\tItem ID\t\tDescription\t\t\tPrice\t\tQuantity");
                System.out.println(" ---------------------------------------------------------------------------------");
                for (ItemsInfo item : items) {
                    System.out.println(String.format("\t%d\t\t%s\t\t\t\t%d\t\t%d", item.getId(), item.getDescription(), item.getPrice(), item.getQuantity()));
                }
                System.out.println(" ---------------------------------------------------------------------------------");
            } else {
                System.out.println("\n\t\tNo Data matches with given input!");
            }
            System.out.println(" Press any key to continue!");
            scanner.next(); // Wait for any key press
        } else {
            return;
        }
    }
}
