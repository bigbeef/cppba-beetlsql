package com.cppba.web;

import com.cppba.UserDao;
import com.cppba.entity.User;
import com.cppba.util.CommonUtil;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
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
    @Resource
    private UserDao userDao;

    //返回403错误
    @RequestMapping("/403.htm")
    public void login(
            HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            PageQuery pageQuery = new PageQuery();
            /*List<User> userList = userDao.select(null, null,0,0);
            for (User user : userList) {
                System.out.println(user);
                List<Card> cardList = (List<Card>) user.get("card");
                System.out.println(cardList);
            }*/

            User user = new User();
            user.setAge(11);
            List<User> userList = userDao.selectUser(user);
            for (User u : userList) {
                System.out.println(u);
            }

           /* User user = new User();
            user.setAge(123);
            user.setName("小明");
            userDao.insert(user);*/
            
            //sqlManager.genPojoCodeToConsole("Card");
            //sqlManager.genSQLTemplateToConsole("UserCard");
            CommonUtil.responseBuildJson("403", "你无权访问该资源!", null, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
