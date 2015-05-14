package org.zkoss.demo.zk8.mvvm;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.util.Clients;

public class JsonToPOJOVM {
	public static class DataObject {
		private String title;
		public void setTitle(String title) {
			this.title = title;
		}
		public String getTitle() {return title;}
		public String toString() {
			return title;
		}
	}
	@Command
	public void dataChange(@BindingParam("data") DataObject data) {
		Clients.log(data.toString());
	}
}
