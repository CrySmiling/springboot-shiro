package com.lzh.shiro.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/*
 * @author H
 *
 * @date 2019/7/30
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String globalException(HttpServletRequest request, Exception e){
		return "发生错误：" + e.getMessage();
	}
}
