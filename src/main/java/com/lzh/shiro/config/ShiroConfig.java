package com.lzh.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/*
 * @author H
 *
 * @date 2019/7/30
 *
 */
@Configuration
public class ShiroConfig {
	/**
	 * 注入ShiroRealm
	 * 不能省略，会导致ShiroRealm中service无法注入
	 * @return
	 */
	@Bean
	public ShiroRealm shiroRealm(){
		return new ShiroRealm();
	}

	/**
	 * 注入securityManager
	 * @return
	 */
	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(shiroRealm());
		return manager;
	}

	/**
	 * Filter工厂，设置过滤条件
	 * @param securityManager
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

		//Shiro的核心安全接口
		bean.setSecurityManager(securityManager);

		//设置登录页
		bean.setLoginUrl("/login");

		//自定义拦截规则
		Map<String, String> map = new HashMap<>(16);
		map.put("/", "anon");
		//设置登出
		map.put("/logout", "logout");
		//对所有用户认证
		map.put("/**", "authc");

		bean.setFilterChainDefinitionMap(map);
		return bean;
	}

	/**
	 * 注册AuthorizationAttributeSourceAdvisor
	 * 如果要开启注解@RequiresRoles等注解，必须添加
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);

		return advisor;
	}
}
