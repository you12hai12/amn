package com.yhd.amn.common.base;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
public class BaseController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private StringRedisTemplate redisTemplate;


    protected  <T> Page<T> getPage() {
        Integer current = StringUtils.isEmpty(request.getParameter("current"))?1:Integer.parseInt(request.getParameter("current"));
        Integer size = StringUtils.isEmpty(request.getParameter("size"))?10000:Integer.parseInt(request.getParameter("size"));
        Page<T> page = new Page<>(current,size);
        String orderBy = request.getParameter("orderBy");
        if(!StringUtils.isEmpty(orderBy)) {
            String[] columns = orderBy.split(",");
            for(int i = 0; i < columns.length; i++) {
                if("ASC".equals(columns[i].substring(columns[i].indexOf(" ") + 1).toUpperCase())) {
                    page.getOrders().add(OrderItem.asc(this.HumpToUnderline(columns[i].substring(0,columns[i].indexOf(" ") + 1))));
                } else if ("DESC".equals(columns[i].substring(columns[i].indexOf(" ") + 1).toUpperCase())) {
                    page.getOrders().add(OrderItem.desc(this.HumpToUnderline(columns[i].substring(0,columns[i].indexOf(" ") + 1))));
                }
            }
        }
        return page;
    }

/*    protected  <T> Page<T> getPage() {
        Integer current = StringUtils.isEmpty(request.getParameter("current"))?1:Integer.parseInt(request.getParameter("current"));
        Integer size = StringUtils.isEmpty(request.getParameter("size"))?10:Integer.parseInt(request.getParameter("size"));
        Page<T> page = new Page<>(current,size);
        String orderBy = request.getParameter("orderBy");
        if(!StringUtils.isEmpty(orderBy)) {
            String column = this.HumpToUnderline(orderBy.substring(orderBy.indexOf(" ") + 1));
            if("ASC".equals(orderBy.substring(0,orderBy.indexOf(" ")).toUpperCase())) {
                page.setOrders(OrderItem.ascs(column.split(",")));

            } else if("DESC".equals(orderBy.substring(0,orderBy.indexOf(" ")).toUpperCase())) {
                page.setOrders(OrderItem.descs(column.split(",")));
            }
        }
        return page;
    }*/

    private String HumpToUnderline(String para){
        StringBuilder sb=new StringBuilder(para);
        int temp=0;//定位
        if (!para.contains("_")) {
            for(int i=0;i<para.length();i++){
                if(Character.isUpperCase(para.charAt(i))){
                    sb.insert(i+temp, "_");
                    temp+=1;
                }
            }
        }
        return sb.toString().toUpperCase();
    }
}
