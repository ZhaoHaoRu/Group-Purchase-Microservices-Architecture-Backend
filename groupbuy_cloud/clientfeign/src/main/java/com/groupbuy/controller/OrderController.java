package com.groupbuy.controller;

import com.alibaba.fastjson.JSONObject;
import com.groupbuy.feign.OrderFeign;
import com.groupbuy.utils.messageUtils.Message;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderFeign orderFeign;

    @GetMapping("/getOrderByUserId")
    @ApiOperation("通过用户id获取其订单信息")
    public Object getOrderByUserId(@RequestParam int userId){
        return orderFeign.getOrderByUserId(userId);
    }

    @GetMapping("/getOrderInfo")
    @ApiOperation("通过团长用户id获取其所有售出的订单信息")
    public Object getOrderInfo(@RequestParam int userId){
        System.out.println("getOrderInfo");
        System.out.println(userId);
        return orderFeign.getOrderInfo(userId);
    }

    @GetMapping("/getOrderByGroupId")
    @ApiOperation("团长通过团购Id查看团购订单查看团购订单")
    public Object getOrderByGroupId(@RequestParam int groupId){
        return orderFeign.getOrderByUserId(groupId);
    }

    @GetMapping("/addToCart")
    @ApiOperation("在团购页面将物品加入购物车")
    public Object addToCart(@RequestParam("userId")int userId, @RequestParam("groupId")int groupId,
                                     @RequestParam("goodsId")int goodsId, @RequestParam("goodsNumber")int goodsNumber){
        return orderFeign.addToCart(userId,groupId,goodsId,goodsNumber);
    }

    @GetMapping("/addOrder")
    @ApiOperation("用户下订单")
    public Object addOrder(@RequestParam("groupId")int groupId, @RequestParam("userId")int userId,
                                    @RequestParam("addressId")int addressId, @RequestParam("time")String time){
        return orderFeign.addOrder(groupId,userId,addressId,time);
    }

    @GetMapping("/deleteOneOrder")
    @ApiOperation("团长通过订单号取消单个订单")
    public Object deleteOneOrder(@RequestParam int orderId){
        return orderFeign.deleteOneOrder(orderId);
    }

    @GetMapping("/deleteOrderByGroupId")
    @ApiOperation("团长删除团购后所有此团购订单都删除和退款")
    public Object deleteOrderByGroupId(@RequestParam int groupId){
        return orderFeign.deleteOrderByGroupId(groupId);
    }

    @GetMapping("getGroupCart")
    @ApiOperation("用户查看团购的购物车")
    public Object getGroupCart(@RequestParam("groupId")int groupId, @RequestParam("userId")int userId){
        return orderFeign.getGroupCart(groupId, userId);
    }

}
