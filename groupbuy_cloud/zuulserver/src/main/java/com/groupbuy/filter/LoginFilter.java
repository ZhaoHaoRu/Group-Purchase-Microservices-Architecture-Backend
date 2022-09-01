package com.groupbuy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器顺序: 值越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //比如某些接口不需要过滤 就可以在这里定义
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //System.out.println(request.getRequestURI());///apigateway/order/api/v1/order/save
        //System.out.println(request.getRequestURL());//http://localhost:9000/apigateway/order/api/v1/order/save

        //判断需要拦截的接口路径
        if("/user/userAuth".equalsIgnoreCase(request.getRequestURI())){
            //true执行拦截器run方法
            return true;
        }
        return false;
    }

    /**
     * 业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //先拿到上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //拿到一个token对象
        String token = request.getHeader("token");

        //也可以从请求参数获取
        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }

        //登陆校验逻辑    最好是写一个解密token算法 如果单纯去访问数据就有些慢了 可以使用jwt
        if (StringUtils.isBlank(token) || !token.equals("2113")){
            //是否继续往下走 设置为false
            requestContext.setSendZuulResponse(false);
            //设置http状态码     HttpStatus:这是spring自带的一个状态码类
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        System.out.println("拦截器");
        return null;
    }
}
