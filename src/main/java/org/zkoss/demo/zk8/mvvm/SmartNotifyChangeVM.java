package org.zkoss.demo.zk8.mvvm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.bind.annotation.ClientCommand;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.annotation.NotifyCommand;
import org.zkoss.bind.annotation.SmartNotifyChange;
import org.zkoss.zk.ui.Component;

public class SmartNotifyChangeVM {
	String url = "./include/06.zul";
	public String getUrl(){
		return url;
	}
	@Command
	@NotifyChange("url")
	public void reload1(){
		
	}
	@Command
	@SmartNotifyChange("url")
	public void reload2(){
		
	}
	@Command
	@NotifyChange("url")
	public void reload3(){
		url = "./include/06.zul?" + new java.util.Date().getTime();
	}
	@Command
	@SmartNotifyChange("url")
	public void reload4(){
		url = "./include/06.zul?" + new java.util.Date().getTime();
	}
	public Date getNow(){
		return new Date();
	}
	
	public Converter getConverter(){
		return new Converter() {
			public Object coerceToUi(Object val, Component component, BindContext ctx) {
				if(val instanceof String){
					return val +"?tms=" + System.currentTimeMillis();
				}
				return val;
			}
			public Object coerceToBean(Object val, Component component, BindContext ctx) {
				return null;
			}
		};
	}
}
