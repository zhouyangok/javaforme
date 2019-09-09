package com.crazyang.mapper;

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

public interface ProductMapper {

    /**
     * 获取商品列表
     *
     * @return
     */
    @Select("select * from product where status = 0")
    List<ProductEntity> getProductList();

    /**
     * 根据id获取商品列表
     *
     * @param id
     * @return
     */
    @Select("select * from product where status = 0 and id =#{id}")
    ProductEntity getById(Integer id);

    /**
     * 新增商品
     *
     * @param productEntity
     * @return
     */
    @Insert("insert into product (product_name,product_price,product_number,product_img,describe,create_time)values(#{productName},#{productPrice},#{productNumber},#{describe},#{productImg},#{createDate},#{updateDate})")
    int insert(ProductEntity productEntity);

    /**
     * 更新商品
     *
     * @param productEntity
     * @return
     */
    @Update("update product set product_name = #{productName},product_price = #{productPrice},product_number= #{productNumber},update_time=#{updateTime}  WHERE id = #{id}")
    int update(ProductEntity productEntity);

    /**
     * 根据id删除商品
     *
     * @param id
     * @return
     */
    @Delete("update product set status=-1 where id =#{id}")
    int delete(Integer id);

}
