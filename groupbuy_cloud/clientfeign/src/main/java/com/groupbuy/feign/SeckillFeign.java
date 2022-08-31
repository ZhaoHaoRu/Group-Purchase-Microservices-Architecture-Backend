package com.groupbuy.feign;

import com.alibaba.fastjson.JSONObject;
import com.groupbuy.utils.messageUtils.Message;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "seckill")
public interface SeckillFeign {
    // TODO:秒杀商品在系统初始化时加入缓存如何操作？

    @PostMapping("/seckill/purchase")
    @ApiOperation("处理秒杀请求")
//    @ResponseBody Message<String> secKill(@RequestBody JSONObject secKillData);
    @ResponseBody Object secKill(@RequestBody JSONObject secKillData);


    @GetMapping("/seckill/secKillResult")
    @ApiOperation("查询秒杀结果")
//    Message<String> secKillResult(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId);
    Object secKillResult(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId);


}
