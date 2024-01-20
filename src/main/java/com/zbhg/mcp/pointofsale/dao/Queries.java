package com.zbhg.mcp.pointofsale.dao;

public class Queries {
    public static String addItem = "INSERT INTO items (description, price, quantity, creationDate) " +
            "VALUES (?, ?, ?, ?)";

    public static String updateItem = "UPDATE items SET description = ?, price = ?, quantity = ?, creationDate = ?" +
            " WHERE itemId = ?";

    public static String findItem = "SELECT * FROM items WHERE itemId = ? OR description = ? OR price = ? OR " +
            "quantity = ? OR creationDate = ?";
}
