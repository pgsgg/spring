package com.ezen.biz.desing_pattern;

/*
 * 사용자가 필요한 객체를 생성해 주는 클래스
 */
public class BeanFactory {
	public Object getBean(String beanName) {
		if (beanName.equals("Samsung")) {
			return new SamsungTV();
		} else if (beanName.equals("LG")) {
			return new LGTV();
		}
		return null;
	}
}
