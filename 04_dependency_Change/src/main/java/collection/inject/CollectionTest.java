package collection.inject;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionTest {

	public static void main(String[] args) {
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");

		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		
		List<String> addrList = bean.getAddressList();
		
		for(String address : addrList) {
			System.out.println(address);
		}
		
		List<Book> bookList = bean.getBookList();
		for(Book book : bookList) {
			System.out.println(book);
		}
		
		Set<String> movieList = bean.getMovieList();
		for(String movie : movieList) {
			System.out.println(movie);
		}
		
		Map<String, String> map = bean.getPrefList();
		Set<String> keys = map.keySet(); // 모든 키 정보를 읽어온다.
		for(String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
		
		Properties propList = bean.getPropList();
		Set<String> items = (Set) propList.keySet();
		for(String item : items) {
			System.out.println(item + " : " + propList.getProperty(item));
		}
		
	}

}
