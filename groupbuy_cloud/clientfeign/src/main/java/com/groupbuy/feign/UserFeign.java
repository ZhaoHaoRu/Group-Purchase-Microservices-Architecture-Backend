package com.groupbuy.feign;

import com.groupbuy.entity.Address;
import com.groupbuy.entity.GroupBuying;
import com.groupbuy.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.groupbuy.utils.messageUtils.Message;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@FeignClient(value = "user")
public interface UserFeign {

    @PostMapping(path= "/user/userAuth")
    @ApiOperation("用户登录验证")
//    @ResponseBody Message<User> userAuth(@RequestParam("userName") String userName, @RequestParam("password") String password);
    @ResponseBody Object userAuth(@RequestParam("userName") String userName, @RequestParam("password") String password);


    @PostMapping(path="/user/register")
    @ApiOperation("新用户注册")
//    @ResponseBody Message<User> register(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("email") String email);
    @ResponseBody Object register(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("email") String email);


    @GetMapping("/user/getUserById")
    @ApiOperation("通过id获取用户")
//    Message<User> getUserById(@RequestParam int id);
    Object getUserById(@RequestParam int id);


    @GetMapping("/user/getUserCollection")
    @ApiOperation("获取用户收藏的团购")
//    Message<Set<GroupBuying>> getUserCollection(@RequestParam int id);
    Object getUserCollection(@RequestParam int id);


    @GetMapping("/user/getUserAddress")
    @ApiOperation("获取用户地址")
//    Message<Set<Address> > getUserAddress(@RequestParam int id);
    Object getUserAddress(@RequestParam int id);

    @GetMapping("/user/setNewAddress")
    @ApiOperation("新增用户地址")
//    Message<Integer> setNewAddress(@RequestParam("userId") int userId, @RequestParam("receiver") String receiver, @RequestParam("phone") String phone, @RequestParam("region") String region, @RequestParam("location") String location);
    Object setNewAddress(@RequestParam("userId") int userId, @RequestParam("receiver") String receiver, @RequestParam("phone") String phone, @RequestParam("region") String region, @RequestParam("location") String location);

    @GetMapping("/user/getCreatedGroup")
    @ApiOperation("获取用户创建的团购")
//    Message<Set<GroupBuying>> getCreatedGroup(@RequestParam("userId") int userId);
    Object getCreatedGroup(@RequestParam("userId") int userId);

    @GetMapping("/user/recommend")
    @ApiOperation("向用户推荐团购")
//    Message<Set<GroupBuying>> groupRecommend(@RequestParam("userId") int userId);
    Object groupRecommend(@RequestParam("userId") int userId);

}
