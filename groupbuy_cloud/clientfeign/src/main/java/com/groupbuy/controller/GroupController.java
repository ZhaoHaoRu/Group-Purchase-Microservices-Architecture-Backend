package com.groupbuy.controller;

import com.alibaba.fastjson.JSONObject;
import com.groupbuy.entity.GroupBuying;
import com.groupbuy.entity.User;
import com.groupbuy.entity.VO.ChangeGroup;
import com.groupbuy.feign.GroupFeign;
import com.groupbuy.utils.messageUtils.Message;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Resource
    private GroupFeign groupFeign;

    @GetMapping("/getGroupById")
    @ApiOperation("通过团购id获取团购")
    public Object getGroupById(@RequestParam int id) {
        System.out.println(groupFeign.getGroupById(id));
        return groupFeign.getGroupById(id);
    }



    @PostMapping("/createGroup")
    @ApiOperation("添加团购")
//    public @ResponseBody Message<GroupBuying> createGroup(@RequestBody JSONObject groupBuying) {
//        return groupFeign.createGroup(groupBuying);
//    }
    public @ResponseBody Object createGroup(@RequestBody JSONObject groupBuying) {
        return groupFeign.createGroup(groupBuying);
    }

    @PostMapping("/collectGroup")
    @ApiOperation("收藏团购")
//    public @ResponseBody Message<User> collectGroup(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId) {
//        return groupFeign.collectGroup(userId, groupId);
//    }
    public @ResponseBody Object collectGroup(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId) {
        return groupFeign.collectGroup(userId, groupId);
    }

    @PostMapping("/getGroupByTag")
    @ApiOperation("根据标签选取团购")
//    public @ResponseBody Message<Set<GroupBuying>> getGroupByTag(@RequestParam("tag") String tag) {
//        return groupFeign.getGroupByTag(tag);
//    }
    public @ResponseBody Object getGroupByTag(@RequestParam("tag") String tag) {
        return groupFeign.getGroupByTag(tag);
    }

    @PostMapping("/getAllGroups")
    @ApiOperation("获取所有的团购")
//    public @ResponseBody Message<Set<GroupBuying>> getAllGroup() {
//        return groupFeign.getAllGroup();
//    }
    public @ResponseBody Object getAllGroup() {
        return groupFeign.getAllGroup();
    }


    @PostMapping("/getCollectedGroups")
    @ApiOperation("获取用户已经订阅的团购")
//    public @ResponseBody Message<Set<GroupBuying>> getCollectedGroup(@RequestParam("userId") Integer userId) {
//        return groupFeign.getCollectedGroup(userId);
//    }
    public @ResponseBody Object getCollectedGroup(@RequestParam("userId") Integer userId) {
        return groupFeign.getCollectedGroup(userId);
    }


    @GetMapping("/endGroup")
    @ApiOperation("结束团购")
//    public Message<String> endGroup(@RequestParam int groupId){
//        return groupFeign.endGroup(groupId);
//    }
    public Object endGroup(@RequestParam int groupId){
        return groupFeign.endGroup(groupId);
    }


    @GetMapping("/deleteGroup")
    @ApiOperation("删除团购")
//    public Message<String> deleteGroup(@RequestParam int groupId){
//        return groupFeign.deleteGroup(groupId);
//    }
    public Object deleteGroup(@RequestParam int groupId){
        return groupFeign.deleteGroup(groupId);
    }


    @PostMapping("/changeGroup")
    @ApiOperation("修改团购（必须传回ID)")
//    public Message<String> changeGroup(@RequestBody ChangeGroup groupBuying){
//        return groupFeign.changeGroup(groupBuying);
//    }
    public Object changeGroup(@RequestBody ChangeGroup groupBuying){
        return groupFeign.changeGroup(groupBuying);
    }

    @GetMapping("/judgeCollected")
    @ApiOperation("判断是否是已收藏团购")
//    public Message<Boolean> judgeCollected(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId) {
//        return groupFeign.judgeCollected(userId, groupId);
//    }
    public Object judgeCollected(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId) {
        return groupFeign.judgeCollected(userId, groupId);
    }
}
