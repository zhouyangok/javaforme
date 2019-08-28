/*
package com.crazyang.base.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @ClassName MybatisPlusConfig
 * @Description: mybatis分页配置文件
 * @Author zhouyang
 * @Date 2019/8/26 下午10:28.
 *//*

@Configuration
@MapperScan("com.crazyang.mapper")
public class MybatisPlusConfig {
    */
/**
     * 分页插件
     *//*

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 开启 count 的 join 优化,只针对 left join !!!
        return new PaginationInterceptor().setCountSqlParser(new JsqlParserCountOptimize(true));
    }
}
*/
