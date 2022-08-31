package com.groupbuy.service;

import com.alibaba.fastjson.JSONObject;
import com.groupbuy.entity.Goods;
import com.groupbuy.entity.GroupBuying;
import com.groupbuy.entity.User;
import com.groupbuy.entity.VO.ChangeGoods;
import com.groupbuy.entity.VO.ChangeGroup;
import com.groupbuy.utils.messageUtils.Message;

import java.util.Set;


public interface GroupService {
    Message<GroupBuying> getGroupById(int id);

    Message<String> endGroup(int groupId);

    Message<String> deleteGroup(int groupId);

    Message<String> changeGroup(ChangeGroup groupBuying);

    Message<GroupBuying> createGroup(JSONObject groupBuying);

    Message<User> collectGroup(Integer userId, Integer groupId);

    Message<Set<GroupBuying>> getGroupByTag(String category);

    Message<Set<GroupBuying>> getAllGroup();

    Message<Set<GroupBuying>> getCollectedGroup(Integer userId);

    Set<Goods> FilterByInventory(Set<Goods> goodsList);

    Message<Boolean> judgeCollected(Integer userId, Integer groupId);

    // TODO 对于更新了库存了商品进行修改
    void updateProduct(ChangeGoods goods);

    // TODO 在新建团购和修改团购（修改了团购价格）时将商品加入redis
    void addNewProduct(Goods goods);
}
