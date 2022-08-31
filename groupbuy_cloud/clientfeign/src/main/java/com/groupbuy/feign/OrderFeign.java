package com.groupbuy.feign;

import com.alibaba.fastjson.JSONObject;
import com.groupbuy.utils.messageUtils.Message;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "order")
public interface OrderFeign {
    @GetMapping("/order/getOrderByUserId")
    @ApiOperation("通过用户id获取其订单信息")
//    Message<List<JSONObject>> getOrderByUserId(@RequestParam int userId);
    Object getOrderByUserId(@RequestParam int userId);


    @GetMapping("/order/getOrderInfo")
    @ApiOperation("通过团长用户id获取其所有售出的订单信息")
//    Message<List<JSONObject>> getOrderInfo(@RequestParam int userId);
    Object getOrderInfo(@RequestParam int userId);


    @GetMapping("/order/getOrderByGroupId")
    @ApiOperation("团长通过团购Id查看团购订单查看团购订单")
//    Message<List<JSONObject>> getOrderByGroupId(@RequestParam int groupId);
    Object getOrderByGroupId(@RequestParam int groupId);


    @GetMapping("/order/addToCart")
    @ApiOperation("在团购页面将物品加入购物车")
//    Message<String> addToCart(@RequestParam("userId")int userId, @RequestParam("groupId")int groupId,
//                                     @RequestParam("goodsId")int goodsId, @RequestParam("goodsNumber")int goodsNumber);
    Object addToCart(@RequestParam("userId")int userId, @RequestParam("groupId")int groupId,
                              @RequestParam("goodsId")int goodsId, @RequestParam("goodsNumber")int goodsNumber);

    @GetMapping("/order/addOrder")
    @ApiOperation("用户下订单")
//    Message<String> addOrder(@RequestParam("groupId")int groupId, @RequestParam("userId")int userId,
//                                    @RequestParam("addressId")int addressId, @RequestParam("time")String time);
    Object addOrder(@RequestParam("groupId")int groupId, @RequestParam("userId")int userId,
                             @RequestParam("addressId")int addressId, @RequestParam("time")String time);


    @GetMapping("/order/deleteOneOrder")
    @ApiOperation("团长通过订单号取消单个订单")
//    Message<String> deleteOneOrder(@RequestParam int orderId);
    Object deleteOneOrder(@RequestParam int orderId);


    @GetMapping("/order/deleteOrderByGroupId")
    @ApiOperation("团长删除团购后所有此团购订单都删除和退款")
//    Message<String> deleteOrderByGroupId(@RequestParam int groupId);
    Object deleteOrderByGroupId(@RequestParam int groupId);

    @GetMapping("/order/getGroupCart")
    @ApiOperation("用户查看团购的购物车")
//    Message<JSONObject> getGroupCart(@RequestParam("groupId")int groupId, @RequestParam("userId")int userId);
    Object getGroupCart(@RequestParam("groupId")int groupId, @RequestParam("userId")int userId);

}
