package com.yajun.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yajun.dao.OrdersDao;
import com.yajun.domain.Orders;
import com.yajun.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersDao ordersDao;

    public Long insetOrders(Orders orders) {
        return ordersDao.insetOrders(orders);
    }

    public List<OrdersVo> selectOrders(Long userId, Integer orderStatus) {
        return ordersDao.selectOrders(userId,orderStatus);
    }

    public PageInfo<OrdersVo> pageOrders(int pageIndex, int pageSize, Long userId, Integer orderStatus) {
        PageHelper.startPage(pageIndex, pageSize);
        List<OrdersVo> ordersVoList = ordersDao.selectOrders(userId,orderStatus);
        PageInfo<OrdersVo> pageInfo = new PageInfo<>(ordersVoList);
        return pageInfo;
    }

    public Orders selectOrdersByCarInfoIdAndUserId(Long carInfoId, Long userId, Integer status) {
        return ordersDao.selectOrdersByCarInfoIdAndUserId(carInfoId,userId,status);
    }

    public Orders selectOrdersById(Long orderId) {
        return ordersDao.selectOrdersById(orderId);
    }

    public int updateStatus(Long orderId, Integer status) {
        return ordersDao.updateStatus(orderId, status);
    }

    public int updateStatusByOrderNo(String orderNo, Integer status){
        return ordersDao.updateStatusByOrderNo(orderNo, status);
    }

    public PageInfo<OrdersVo> pageOrdersByStatusList(int pageIndex, int pageSize, Long userId, List<Integer> orderStatusList){
        PageHelper.startPage(pageIndex, pageSize);
        List<OrdersVo> ordersVoList = ordersDao.selectOrdersByStatusList(userId,orderStatusList);
        PageInfo<OrdersVo> pageInfo = new PageInfo<>(ordersVoList);
        return pageInfo;
    }
}
