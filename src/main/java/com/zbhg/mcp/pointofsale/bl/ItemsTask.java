package com.zbhg.mcp.pointofsale.bl;

import com.zbhg.mcp.pointofsale.bean.ItemsInfo;
import com.zbhg.mcp.pointofsale.dao.ItemsDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ItemsTask {
    public String addItem(ItemsInfo itemInfo) throws SQLException, ClassNotFoundException {
        Date date = java.sql.Date.valueOf(LocalDate.now());
        itemInfo.setCreationDate(date);
        ItemsDAO itemDAO = new ItemsDAO();
        if(itemDAO.addItem(itemInfo))
            return "Item Added Successfully!";
        return "Item Not Added!";
    }

    public String updateItem(ItemsInfo itemInfo) throws SQLException, ClassNotFoundException {
        Date date = java.sql.Date.valueOf(LocalDate.now());
        itemInfo.setCreationDate(date);
        ItemsDAO itemDAO = new ItemsDAO();
        if(itemDAO.updateItem(itemInfo))
            return "Item Updated Successfully!";
        return "Item Not Updated!";
    }

    public List<ItemsInfo> findItem(ItemsInfo itemInfo) throws SQLException, ClassNotFoundException {
        List<ItemsInfo> items = new ArrayList<>();
        ItemsDAO itemsDAO = new ItemsDAO();
        items = itemsDAO.findItem(itemInfo);
        return items;
    }

}
