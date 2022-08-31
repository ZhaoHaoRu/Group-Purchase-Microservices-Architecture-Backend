package com.groupbuy.feign;

import com.alibaba.fastjson.JSONObject;
import com.groupbuy.entity.GroupBuying;
import com.groupbuy.entity.User;
import com.groupbuy.entity.VO.ChangeGroup;
import com.groupbuy.utils.messageUtils.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Component
public class FeignError implements GroupFeign {

    @Override
    public Message<GroupBuying> getGroupById(int id) {
        return null;
    }

    @Override
    public Message<GroupBuying> createGroup(JSONObject groupBuying) {
        return null;
    }

    @Override
    public Message<User> collectGroup(Integer userId, Integer groupId) {
        return null;
    }

    @Override
    public Message<Set<GroupBuying>> getGroupByTag(String tag) {
        return null;
    }

    @Override
    public Message<Set<GroupBuying>> getAllGroup() {
        return null;
    }

    @Override
    public Message<Set<GroupBuying>> getCollectedGroup(Integer userId) {
        return null;
    }

    @Override
    public Message<String> endGroup(int groupId) {
        return null;
    }

    @Override
    public Message<String> deleteGroup(int groupId) {
        return null;
    }

    @Override
    public Message<String> changeGroup(ChangeGroup groupBuying) {
        return null;
    }

    @Override
    public Message<Boolean> judgeCollected(Integer userId, Integer groupId) {
        return null;
    }
}
