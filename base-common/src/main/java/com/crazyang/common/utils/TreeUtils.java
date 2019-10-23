package com.crazyang.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.sun.jndi.toolkit.dir.SearchFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TreeUtils
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/10/23 下午10:14.
 */

public class TreeUtils {

    /**
     * 最简单的一种方式
     */

    /*public List<Object> findTypeTree() throws BusinessException {
        Map<String,Object> map = new HashMap<>();
        map.put("EQ_parentId",0);
        Map<String, SearchFilter> filters = SearchFilter.parse(map);
        List<Order> orderList = new ArrayList<>();
        Order order = new Order("sortNum");
        orderList.add(order);
        Sort sort = new Sort(orderList);
        //默认查询出所有的一级类别
        List<TypeInfo> typeList = (List<TypeInfo>) typeInfoRepository.findAll(DynamicSpecifications.bySearchFilter(filters.values(), TypeInfo.class),sort);
        List<Object> list = new ArrayList<>();
        for (TypeInfo typeInfo : typeList) {
            JSONObject treeObject = new JSONObject(true);
            treeObject.put("id", typeInfo.getTypeId());
            treeObject.put("text", typeInfo.getName());
            treeObject.put("children", getChildren(typeInfo.getTypeId()));
            list.add(treeObject);
        }
        return list;
    }
    public List<Object> getChildren(Long parentId){
        List<Object> list = new ArrayList<>();
        List<TypeInfo> children = typeInfoRepository.findTypeInfoByParentIdAndSortNum(parentId);
        for (TypeInfo typeInfo : children) {
            JSONObject obj = new JSONObject(true);
            obj.put("id", typeInfo.getTypeId());
            obj.put("text", typeInfo.getName());
            obj.put("children", getChildren(typeInfo.getTypeId()));
            list.add(obj);
        }
        return list;*/
//    }

    /**
     * 第二简单的一种方式
     */


   /* public class Menu {
        private Integer menuId;//菜单主键自增ID

        private Integer menuPid;//菜单父ID,0为根目录

        private String menuLeafNode;//是否是叶子节点 1:是 0:否

        private String menuName;//菜单名称

        private String menuURL;//菜单URL

        private String menuStatus;//菜单状态 1:有效 -1:无效

        private Integer menuOrder;//菜单排序

        @JsonInclude(JsonInclude.Include.NON_NULL) //忽略空值输出JSON
        private List<Menu> child;//子菜单


        get / set ...

    }



    *//**
     * 查询所有菜单树
     * JDK1.8
     *//*
    private List<Menu> getMenuTreeList(List<Menu> menuList,int pid) {
        // 查找所有菜单
        List<Menu> childrenList = new ArrayList<>();
        menuList.stream()
                .filter(d -> Objects.equals(pid, d.getMenuPid()))
                .collect(Collectors.toList())
                .forEach(d -> {
                    if(d.getMenuLeafNode().equals("0"))
                        d.setChild(getMenuTreeList(menuList,d.getMenuId()));
                    childrenList.add(d);
                });
        return childrenList;
    }





    *//**
     * 递归取出所有关系树
     * @param list
     * @param pid
     * @return
     *//*
    private List<Menu> getMenuTree(List<Menu> list,int pid) {
        List<Menu> menuList=new ArrayList<>();
        //取出所有菜单
        for (int i = 0;i< list.size();i++) {
            Menu menu = list.get(i);
            if (menu.getMenuPid() == pid ) {//取出所有父菜单
                if(menu.getMenuLeafNode().equals("0")) {
                    menu.setChild(getMenuTree(list, menu.getMenuId()));
                }
                menuList.add(menu);
            }

        }
        return menuList;
    }




    *//**
     * 取出所有关系树其它实现
     * @param list
     * @param parentID
     * @return
     *//*
    private List<Map<String,Object>> getMenuTreeList(List<Menu> list,int parentID) {
        List<Map<String,Object>> menuList=new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        //取出所有菜单
        for (int i = 0;i< list.size();i++) {
            Menu menu = list.get(i);
            if (menu.getMenuPid() == parentID ) {//取出所有父菜单
                map=object2Map(menu);//返回菜单加入父对象
                map.remove("createDate");
                list.remove(menu);
                if(menu.getMenuLeafNode().equals("0")) {
                    map.put("child", getMenuTreeList(list, menu.getMenuId()));
                }else{
                    map.remove("child");
                }
                menuList.add(map);
            }

        }
        return menuList;
    }


    *//**
     * 实体对象转成Map
     * @param obj 实体对象
     * @return
     *//*
    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }



    调用 ：


    Map<String,Object>  map  = new HashMap<>();
    List<Menu> list = menuDao.selectAll();
        map.put("menuTree",getTreeList(list,0));
    //map.put("menuTree",getMenuTree(list,0));
        return toJson(map);
*/
}
