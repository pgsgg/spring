package com.ezen.biz;

import org.springframework.stereotype.Component;

@Component("speaker")
public interface Speaker {
	void volumeUp();
	
	void volumeDown();
}
