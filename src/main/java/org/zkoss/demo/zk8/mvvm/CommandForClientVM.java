package org.zkoss.demo.zk8.mvvm;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class CommandForClientVM {
	private String msg;
	public void setMsg(String msg) {this.msg = msg;}
	public String getMsg() {return this.msg;}
	@Command
	@NotifyChange("msg")
	public void doClick(@BindingParam("label") String msg) {
		this.msg = msg;
	}
}
