package org.zkoss.demo.zk8.mvvm;


import org.zkoss.bind.annotation.ClientCommand;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.annotation.NotifyCommand;

@ClientCommand({"doChange", "upateData"})
@NotifyCommand(value="upateData", onChange="_vm_.data")
public class ClientNotifyCommandVM {
	private String data;
	private int count = 0;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Command
    @NotifyChange({"count", "data"})
    public void doChange() {
		System.out.println("doChange");
		count++;
		data = "data: " + count;
    }

    @Command
    public void upateData() {
    	System.out.println("upateData");
    }
}
