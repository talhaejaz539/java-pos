package com.zbhg.mcp.pointofsale.dao;

import com.zbhg.mcp.pointofsale.bean.ItemsInfo;
import com.zbhg.mcp.pointofsale.util.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsDAO {

    Connection con;
    PreparedStatement preparedStatement;
    Utilities utilities;

    public ItemsDAO() throws SQLException, ClassNotFoundException {
        utilities = new Utilities();
    }

    public boolean addItem(ItemsInfo itemInfo) throws SQLException {

        getConnection();
        preparedStatement = con.prepareStatement(Queries.addItem);
        preparedStatement.setString(1, itemInfo.getDescription());
        preparedStatement.setInt(2, itemInfo.getPrice());
        preparedStatement.setInt(3, itemInfo.getQuantity());
        preparedStatement.setDate(4, itemInfo.getCreationDate());

        int result = preparedStatement.executeUpdate();
        closeConnection();

        return result == 1;
    }

    public boolean updateItem(ItemsInfo itemInfo) throws SQLException {

        getConnection();
        preparedStatement = con.prepareStatement(Queries.updateItem);
        preparedStatement.setString(1, itemInfo.getDescription());
        preparedStatement.setInt(2, itemInfo.getPrice());
        preparedStatement.setInt(3, itemInfo.getQuantity());
        preparedStatement.setDate(4, itemInfo.getCreationDate());
        preparedStatement.setInt(5, itemInfo.getId());

        int result = preparedStatement.executeUpdate();
        closeConnection();

        return result == 1;
    }

    public List<ItemsInfo> findItem(ItemsInfo itemInfo) throws SQLException {
        List<ItemsInfo> items = null;

        getConnection();
        preparedStatement = con.prepareStatement(Queries.findItem);
        preparedStatement.setInt(1, itemInfo.getId());
        preparedStatement.setString(2, itemInfo.getDescription());
        preparedStatement.setInt(3, itemInfo.getPrice());
        preparedStatement.setInt(4, itemInfo.getQuantity());
        preparedStatement.setDate(5, itemInfo.getCreationDate());

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            items = new ArrayList<>();
            do {
                itemInfo.setId(resultSet.getInt(1));
                itemInfo.setDescription(resultSet.getString(2));
                itemInfo.setPrice(resultSet.getInt(3));
                itemInfo.setQuantity(resultSet.getInt(4));
                itemInfo.setCreationDate(resultSet.getDate(5));
                items.add(itemInfo);
            } while (resultSet.next());
        }

        closeConnection();

        return items;
    }

    private void getConnection() {
        con = utilities.getConnection();
    }

    private void closeConnection() throws SQLException {
        utilities.closeConnection();
        preparedStatement.close();
    }
}
