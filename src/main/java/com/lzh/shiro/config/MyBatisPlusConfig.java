package com.lzh.shiro.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 * @author H
 *
 * @date 2019/7/30
 *
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.lzh.shiro.mapper*")
public class MyBatisPlusConfig {
	/**
	 * 分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor(){
		return new PaginationInterceptor();
	}
}
