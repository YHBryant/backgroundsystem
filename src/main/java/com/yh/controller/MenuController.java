package com.yh.controller;

import com.yh.dto.MenuDto;
import com.yh.pojo.MenuInfo;
import com.yh.pojo.UserInfo;
import com.yh.service.MenuService;
import com.yh.tools.SplitePageBean;
import com.yh.vo.AssignPermessionVo;
import com.yh.vo.MenuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//声明这个control是一个restful风格的control
//等同于@ResponseBody+@Controller
@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    //获取所有菜单信息
    @RequestMapping("getAllMenu")
    public Object getAllMenu(@RequestParam int roleId){
//        System.out.println(menuService.getAllMenu(1));
        return menuService.getAllMenu(roleId);
    }

    @RequestMapping("assignPermissionController")
    public Object assignPermission(@RequestBody AssignPermessionVo vo){
        System.out.println(vo);
        return menuService.modifyMenuByRoleId(vo);
    }

    @RequestMapping(value = "getMenuAll")
    public Object getMenuAll(){
        return menuService.getMenuAll();
    }

    //获取所有用户信息与分页
    @ResponseBody
    @RequestMapping(value = "menuInfoList",method = RequestMethod.POST)
    public Object menuInfoList(@RequestBody(required = false) MenuInfoVo menuInfoVo){
        //当前第几页,每页多少行
        List<MenuInfo> menuInfoList = this.menuService.getMenuInfosPageBy(menuInfoVo);
        //获取分页类对象
        SplitePageBean splitePageBean = new SplitePageBean();
        //获取数据条数
        int count = this.menuService.getCount(menuInfoVo);
        splitePageBean.setCurrentPage(menuInfoVo.getSplitePageBean().getCurrentPage());
        splitePageBean.setPageCount(count%6==0?count/6:count/6+1);
        splitePageBean.setDataCount(count);
        MenuDto menuDto = new MenuDto();
        menuDto.setSplitePageBean(splitePageBean);
        menuDto.setMenuInfoList(menuInfoList);
        return menuDto;
    }


    @RequestMapping("getMenuInfoBy")
    public Object getMenuInfoBy(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
//        System.out.println(userInfo);
        return menuService.getMenuInfoBy(userInfo);
    }
}
