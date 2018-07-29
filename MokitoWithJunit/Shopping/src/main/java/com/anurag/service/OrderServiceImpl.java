package com.anurag.service;

import com.anurag.bean.Order;
import com.anurag.dao.OrderDAO;
import com.anurag.service.exception.OrderException;

import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {

    OrderDAO dao;

    public boolean placeOrder(Order order) throws OrderException {
        int result=0;
        try {
            result=dao.create(order);
        } catch (SQLException e) {
           throw new OrderException(e);
        }
        return result>0?true:false;
    }

    public boolean cancelOrder(int orderId) throws OrderException {
        int result=0;
        try {
            Order order=dao.read(orderId);
            order.setStatus("Canceled");
            result=dao.update(order);
        } catch (SQLException e) {
            throw new OrderException(e);
        }
        return result>0?true:false;
    }

    public boolean deleteOrder(int orderId) throws OrderException {
        int result=0;
        try {
            result=dao.delete(orderId);
        } catch (SQLException e) {
            throw new OrderException(e);
        }
        return result>0?true:false;
    }

    public void setDao(OrderDAO dao) {
        this.dao = dao;
    }
}
