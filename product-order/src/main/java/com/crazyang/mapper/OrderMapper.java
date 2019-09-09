package com.crazyang.mapper;

import com.crazyang.entity.OrderEntity;
import com.crazyang.entity.ProductEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName ProductMapper
 * @Description: 商品mapper类
 * @Author zhouyang
 * @Date 2019/9/7 下午4:56.
 */

public interface OrderMapper {

    /**
     * 获取订单列表
     *
     * @return
     */
    @Select("select * from order where status = 0")
    List<OrderEntity> getOrderList();

    /**
     * 根据用户id获取订单列表
     *
     * @param userId
     * @return
     */
    @Select("select * from order where status = 0 and user_id =#{userId}")
    ProductEntity getByUserId(Integer userId);

    /**
     * 新增订单
     *
     * @param orderEntity
     * @return
     */
    @Insert("insert into order (user_id,product_id,order_price,create_time,remark)values(#{userId},#{productId},#{orderPrice},#{createTime},#{remark})")
    int insert(OrderEntity orderEntity);

    /**
     * 更新订单
     *
     * @param orderEntity
     * @return
     */
    @Update("update order set product_id = #{productId},order_price = #{orderPrice},,update_time=#{updateTime}  WHERE id = #{id}")
    int update(OrderEntity orderEntity);

    /**
     * 根据id删除订单
     *
     * @param id
     * @return
     */
    @Delete("update order set status=-1 where id =#{id}")
    int delete(Integer id);

}
