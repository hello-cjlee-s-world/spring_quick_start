package com.springbook.ioc.inection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	// List, Set, Map 선언
	private List<String> addressList;
	private Set<String> addressSet;
	private Map<String,String> addressMap;
	// Properties 선언
	private Properties addressProp;
	
	public CollectionBean() {
		System.out.println("====> CollectionBean 객체 생성");
	}
	
	public void setAddressList(List<String> addressList) {
		this.addressList=addressList;
	}
	public List<String> getAddressList(){
		return addressList;
	}

	public Set<String> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}

	public Map<String,String> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<String,String> addressMap) {
		this.addressMap = addressMap;
	}

	public Properties getAddressProp() {
		return addressProp;
	}

	public void setAddressProp(Properties addressProp) {
		this.addressProp = addressProp;
	}
	
	
}
