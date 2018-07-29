package com.anurag.service;

import com.anurag.bean.Order;
import com.anurag.service.exception.OrderException;

public interface OrderService {
    boolean placeOrder(Order order) throws OrderException;
    boolean cancelOrder(int orderId)throws OrderException;
    boolean deleteOrder(int orderId)throws OrderException;
}
