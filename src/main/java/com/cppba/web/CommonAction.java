package com.cppba.web;

import com.cppba.entity.Card;
import com.cppba.entity.User;
import com.cppba.util.CommonUtil;
import org.beetl.sql.core.SQLManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
@Controller
public class CommonAction {

    @Resource
    private SQLManager  sqlManager;

    //返回403错误
    @RequestMapping("/403.htm")
    public void login(
            HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // User user = sqlManager.unique(user.class, 2);
            //System.out.println(user.toString());

            Map<String,Object> params = new HashMap<>();
            //params.put("age",11);
            List<User> userList = sqlManager.select("user.select", User.class, params);
            for (User user : userList) {
                System.out.println(user);
                List<Card> cardList = (List<Card>) user.get("card");
                System.out.println(cardList);
            }

            //sqlManager.genPojoCodeToConsole("Card");
            //sqlManager.genSQLTemplateToConsole("UserCard");
            CommonUtil.responseBuildJson("403", "你无权访问该资源!", null, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
