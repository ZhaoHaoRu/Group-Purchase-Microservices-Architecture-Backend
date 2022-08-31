package com.groupbuy.service;


import com.alibaba.fastjson.JSONArray;
import com.groupbuy.entity.Goods;
import com.groupbuy.entity.GroupBuying;
import com.groupbuy.entity.User;

import java.math.BigDecimal;
import java.util.Set;

//@Service
public interface SecKillService {
    // TODO　获取秒杀团购商品的库存
    Set<Goods> getAllSecKillGoods();

    // TODO　通过商品ID查询库存数量
    Goods getSecKillGoodsById(int id);

    //　TODO 根据用户ID和团购ID查询是否下过单
    boolean isOrdered(GroupBuying groupBuying, User user);

    boolean orderExceptionHandle(JSONArray goodsData, int i);

    // TODO 一个事务：减少库存，下订单
    boolean SecKillExecution(int userId, int addressId, int groupId, BigDecimal price, JSONArray goodsData);

    // TODO　获取秒杀结果
    boolean SecKillResult(Integer userId, Integer groupId);

}
