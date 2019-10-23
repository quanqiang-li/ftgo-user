package com.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.util.WebUtil;

/**
 * 用户服务
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("user")
public class UserContrller {

	@Value("${spring.profiles.active}")
	private String host;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 验证用户真实有效
	 * 
	 * @param userId
	 * @return
	 */
	@PostMapping("/validUser/{userId}")
	public String validUser(@PathVariable("userId") String userId, HttpServletRequest req) {
		try {
			// 睡眠2秒，方便调试
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 得到客户端ip，并记录log
		String ipAddr = WebUtil.getIpAddr(req);
		String info = String.format("这里是%s,接收到来自%s的请求,参数userId=%s", host, ipAddr, userId);
		logger.info(info);
		return info;
	}

}
