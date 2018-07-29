package com.anurag.dao;

import com.anurag.bean.Order;

import java.sql.SQLException;

public interface OrderDAO {
    int create(Order order) throws SQLException;
    Order read(int orderId) throws SQLException;
    int update(Order order) throws  SQLException;
    int delete (int orderId) throws SQLException;

}
