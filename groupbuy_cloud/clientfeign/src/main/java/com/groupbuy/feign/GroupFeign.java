package com.groupbuy.feign;

import com.alibaba.fastjson.JSONObject;
import com.groupbuy.entity.GroupBuying;
import com.groupbuy.entity.User;
import com.groupbuy.entity.VO.ChangeGroup;
import com.groupbuy.utils.messageUtils.Message;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

//@FeignClient(value = "group", fallback = FeignError.class)
@FeignClient(value = "group")
public interface GroupFeign {
    @GetMapping("/group/getGroupById")
    @ApiOperation("通过团购id获取团购")
//    Message<GroupBuying> getGroupById(@RequestParam int id);
    Object getGroupById(@RequestParam int id);




    @PostMapping("/group/createGroup")
    @ApiOperation("添加团购")
//    @ResponseBody Message<GroupBuying> createGroup(@RequestBody JSONObject groupBuying);
    @ResponseBody Object createGroup(@RequestBody JSONObject groupBuying);


    @PostMapping("/group/collectGroup")
    @ApiOperation("收藏团购")
//    @ResponseBody Message<User> collectGroup(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId);
    @ResponseBody Object collectGroup(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId);


    @PostMapping("/group/getGroupByTag")
    @ApiOperation("根据标签选取团购")
//    @ResponseBody Message<Set<GroupBuying>> getGroupByTag(@RequestParam("tag") String tag);
    @ResponseBody Object getGroupByTag(@RequestParam("tag") String tag);


    @PostMapping("/group/getAllGroups")
    @ApiOperation("获取所有的团购")
//    @ResponseBody Message<Set<GroupBuying>> getAllGroup();
    @ResponseBody Object getAllGroup();

    @PostMapping("/group/getCollectedGroups")
    @ApiOperation("获取用户已经订阅的团购")
//    @ResponseBody Message<Set<GroupBuying>> getCollectedGroup(@RequestParam("userId") Integer userId);
    @ResponseBody Object getCollectedGroup(@RequestParam("userId") Integer userId);

    @GetMapping("/group/endGroup")
    @ApiOperation("结束团购")
//    Message<String> endGroup(@RequestParam int groupId);
    Object endGroup(@RequestParam int groupId);

    @GetMapping("/group/deleteGroup")
    @ApiOperation("删除团购")
//    Message<String> deleteGroup(@RequestParam int groupId);
    Object deleteGroup(@RequestParam int groupId);

    @PostMapping("/group/changeGroup")
    @ApiOperation("修改团购（必须传回ID)")
//    Message<String> changeGroup(@RequestBody ChangeGroup groupBuying);
    Object changeGroup(@RequestBody ChangeGroup groupBuying);

    @GetMapping("/group/judgeCollected")
    @ApiOperation("判断是否是已收藏团购")
//    Message<Boolean> judgeCollected(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId);
    Object judgeCollected(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId);

}
