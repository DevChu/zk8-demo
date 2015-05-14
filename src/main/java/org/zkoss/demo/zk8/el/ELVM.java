package org.zkoss.demo.zk8.el;


import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class ELVM {
	
	private String value;
	
	public ELVM() {
		value = "value";
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Command @NotifyChange("value")
	public void click(@BindingParam("key")String key) {
		value = key;
	}
	
	public static String add = "N";
}
