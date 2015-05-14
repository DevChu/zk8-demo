package org.zkoss.demo.zk8.mvvm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class AutoVM {
	Item item;

	public AutoVM() {
		item = new Item("A");
	}
	
	public Item getItem() {
		return item;
	}

	@Command
	@NotifyChange("item")
	public void cmd(){
		item.setName("B");
	}
	
	static public class Item {
		String name;
		public Item(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
