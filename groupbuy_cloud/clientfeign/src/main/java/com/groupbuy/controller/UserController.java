package com.groupbuy.controller;

import com.groupbuy.entity.Address;
import com.groupbuy.entity.GroupBuying;
import com.groupbuy.entity.User;
import com.groupbuy.feign.UserFeign;
import com.groupbuy.utils.messageUtils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@Api(tags = "用户")
@RequestMapping(path = "/user")
public class UserController {

    @Resource
    private UserFeign userFeign;

    @PostMapping(path= "/userAuth")
    @ApiOperation("用户登录验证")
    public @ResponseBody Object userAuth(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        return userFeign.userAuth(userName, password);
    }

    @PostMapping(path="/register")
    @ApiOperation("新用户注册")
    public @ResponseBody Object register(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("email") String email) {
        return userFeign.register(userName, password, email);
    }


    @GetMapping("/getUserById")
    @ApiOperation("通过id获取用户")
    public Object getUserById(@RequestParam int id) {
        return userFeign.getUserById(id);
    }

    @GetMapping("/getUserCollection")
    @ApiOperation("获取用户收藏的团购")
    public Object getUserCollection(@RequestParam int id) {
        return userFeign.getUserCollection(id);
    }

    @GetMapping("/getUserAddress")
    @ApiOperation("获取用户地址")
    public Object getUserAddress(@RequestParam int id) {
        return userFeign.getUserAddress(id);
    }

    @GetMapping("/setNewAddress")
    @ApiOperation("新增用户地址")
    public Object setNewAddress(@RequestParam("userId") int userId, @RequestParam("receiver") String receiver, @RequestParam("phone") String phone, @RequestParam("region") String region, @RequestParam("location") String location) {
        return userFeign.setNewAddress(userId, receiver, phone, region, location);
    }

    @GetMapping("/getCreatedGroup")
    @ApiOperation("获取用户创建的团购")
    public Object getCreatedGroup(@RequestParam("userId") int userId) {
        return userFeign.getCreatedGroup(userId);
    }

    @GetMapping("/recommend")
    @ApiOperation("向用户推荐团购")
    public Object groupRecommend(@RequestParam("userId") int userId) {
        return userFeign.groupRecommend(userId);
    }
}
