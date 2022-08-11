package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();
        //orderDetail.setUserId(7L);
        //orderDetail.setItemId(1L);
        orderDetail.setOrderAt(LocalDateTime.now());

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        Assert.notNull(newOrderDetail,"orderdetail.create()");
    }


}