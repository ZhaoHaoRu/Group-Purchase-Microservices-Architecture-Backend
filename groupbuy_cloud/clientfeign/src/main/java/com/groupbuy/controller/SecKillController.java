package com.groupbuy.controller;

import com.alibaba.fastjson.JSONObject;
import com.groupbuy.feign.SeckillFeign;
import com.groupbuy.utils.messageUtils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/seckill")
@RestController
@Component
@Api(tags = "秒杀")
public class SecKillController {
    @Resource
    SeckillFeign seckillFeign;

    @PostMapping("/purchase")
    @ApiOperation("处理秒杀请求")
    public @ResponseBody
    Object secKill(@RequestBody JSONObject secKillData) {
        return seckillFeign.secKill(secKillData);
    }

    @GetMapping("/secKillResult")
    @ApiOperation("查询秒杀结果")
    public Object secKillResult(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId) {
        return seckillFeign.secKillResult(userId, groupId);
    }
}
