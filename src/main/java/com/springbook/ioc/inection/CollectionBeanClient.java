package com.springbook.ioc.inection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		// list 객체 출력
		List<String> addressList= bean.getAddressList();
		System.out.println("==List 출력==");
		for(String s:addressList) {
			System.out.println(s);
		}
		
		
		// set 객체 출력
		Set<String> addressSet = bean.getAddressSet();
		System.out.println("\n==Set 출력==");
		for(String s:addressSet) {
			System.out.println(s);
		}
		// map 객체 출력
		Map<String, String> addressMap = bean.getAddressMap();
		Set<String> keys = addressMap.keySet();
		System.out.println("\n==Map 출력==");
		for(String key:keys) {
			System.out.printf("이름:%s, 주소:%s\n",key,addressMap.get(key));
		}
		
		// Spring 컨데이너 종료 
		factory.close();
	}
}
