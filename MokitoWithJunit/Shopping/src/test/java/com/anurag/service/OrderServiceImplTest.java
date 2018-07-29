package com.anurag.service;

import com.anurag.bean.Order;
import com.anurag.dao.OrderDAO;
import com.anurag.service.exception.OrderException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class OrderServiceImplTest{
    OrderServiceImpl orderService=new OrderServiceImpl();
    @Mock
    OrderDAO orderDAO;
    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);
        orderService.setDao(orderDAO);
    }

   @Test
    public void placeOrderTest_Should_Create_Order() throws SQLException, OrderException {

       Order order=new Order();
      when(orderDAO.create(order)).thenReturn(new Integer(1));
      boolean result=orderService.placeOrder(order);
      verify(orderDAO).create(order);
       assertTrue(result);

   }
    @Test
    public void placeOrderTest_Should_Not_Create_Order() throws SQLException, OrderException {

        Order order=new Order();
        when(orderDAO.create(order)).thenReturn(new Integer(0));
        boolean result=orderService.placeOrder(order);
        verify(orderDAO).create(order);
        assertFalse(result);

    }
    @Test(expected = OrderException.class)
    public void placeOrderTest_Should_Throw_Order_Exception() throws SQLException, OrderException {

        Order order=new Order();
        when(orderDAO.create(order)).thenThrow(SQLException.class);
        orderService.placeOrder(order);
    }
    @Test
    public void cancelOrderTest_Should_Cancel_The_Order() throws SQLException, OrderException {
        Order order=new Order();
        when(orderDAO.read(123)).thenReturn(order);
        when(orderDAO.update(order)).thenReturn(new Integer(1));
        boolean result=orderService.cancelOrder(123);
        assertTrue(result);
        verify(orderDAO).read(123);
        verify(orderDAO).update(order);
    }
    @Test
    public void cancelOrderTest_Should_Not_Cancel_The_Order() throws SQLException, OrderException {
        Order order=new Order();
        when(orderDAO.read(123)).thenReturn(order);
        when(orderDAO.update(order)).thenReturn(new Integer(0));
        boolean result=orderService.cancelOrder(123);
        assertFalse(result);
        verify(orderDAO).read(123);
        verify(orderDAO).update(order);
    }
    @Test(expected = OrderException.class)
    public void cancelOrderTest_Should_Throw_Exception_OnRead() throws SQLException, OrderException {

        when(orderDAO.read(123)).thenThrow(SQLException.class);
        orderService.cancelOrder(123);


    }

    @Test(expected = OrderException.class)
    public void cancelOrderTest_Should_Throw_Exception_OnUpdate() throws SQLException, OrderException {
        Order order=new Order();
        when(orderDAO.read(123)).thenReturn(order);
        when(orderDAO.update(order)).thenThrow(SQLException.class);
        orderService.cancelOrder(123);
    }

}
