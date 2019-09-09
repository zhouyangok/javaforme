package com.crazyang.service;

import com.crazyang.common.response.AjaxResponse;
import com.crazyang.entity.ProductEntity;
import com.crazyang.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description: 商品服务层
 * @Author zhouyang
 * @Date 2019/9/7 下午5:06.
 */

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public AjaxResponse getProductList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductEntity> productList = productMapper.getProductList();
        return AjaxResponse.success(productList);
    }

    public AjaxResponse getProductById(Integer id) {
        return null;
    }

    public AjaxResponse insertProduct(ProductEntity productEntity) {
        return null;
    }

    public AjaxResponse updateProductById(ProductEntity productEntity) {
        return null;
    }

    public AjaxResponse deleteById(Integer id){
        return null;
    }

}
