package com.yh.test;

import com.yh.pojo.UserInfo;
import com.yh.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml","spring-entity.xml");
        UserService bean = context.getBean(UserService.class);
//        UserInfo userInfo = context.getBean("jks", UserInfo.class);
        //登录验证
//        if(bean.loginCheck(userInfo)){
//            System.out.println("login success");
//        }else {
//            System.out.println("login field");
//        }
        //添加
//        if(bean.addUserMessage(userInfo)){
//            System.out.println("add success");
//        }else {
//            System.out.println("add field");
//        }

        //查询
//        UserInfo userInfoMapById = bean.getUserInfoMapById(1);
//        System.out.println(userInfoMapById);

        //修改
//        UserInfo userInfo = context.getBean("jm", UserInfo.class);
//        UserInfo u = new UserInfo();
//        u.setName("da");
//        u.setPassword("5444");
//        u.setEmail("444@sdfdas");
//        u.setUsername("sdfd");
//        u.setUserId(1);
//        if(bean.updateUserMessage(u)){
//            System.out.println("update success");
//        }else {
//            System.out.println("update field");
//        }

        //删除
//        int userInfo = bean.delUserMessage(1);
//        System.out.println(userInfo);
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("fsafa");
//        userInfo.setEmail("dsdaf");
//        userInfo.setName("sdf");
//        boolean b = bean.addUserMessage(userInfo);
//        System.out.println(b);
    }
}
