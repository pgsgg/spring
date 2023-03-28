package com.ezen.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.UserVO;
import com.ezen.biz.service.UserService;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");

		UserService userService = (UserService) container.getBean("userService");
		
		UserVO user = new UserVO();
		user.setId("user1");
		user.setPassword("1234");
		
		UserVO result = userService.getUser(user);
		if (result != null) {
			System.out.println("로그인에 성공하였습니다.");
			System.out.println("사용자 정보: " + result);
		} else {
			System.out.println("로그인에 실패하였습니다.");
		}
		
		container.close();
	}

}





