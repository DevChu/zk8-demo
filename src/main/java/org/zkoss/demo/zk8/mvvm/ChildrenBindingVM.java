package org.zkoss.demo.zk8.mvvm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelArray;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.ListModelMap;
import org.zkoss.zul.ListModelSet;
import org.zkoss.zul.Window;
public class ChildrenBindingVM implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Node> nodes_l;
	private String[] nodes_a = new String[] {
			"Apple", "Orange", "Mango"};
	private Map<String, Node> nodes_m;
	private Set<Object> nodes_s;
	private ListModelList<Node> model_l;
	private ListModelArray<Object> model_a;
	private ListModelMap<String, Node> model_m;
	private ListModelSet<Object> model_s;
	
	public ListModelList<Node> getModel_l() {
		return model_l;
	}

	public void setModel_l(ListModelList<Node> model_l) {
		this.model_l = model_l;
	}

	public ListModelArray<Object> getModel_a() {
		return model_a;
	}

	public void setModel_a(ListModelArray<Object> model_a) {
		this.model_a = model_a;
	}

	public ListModelMap<String, Node> getModel_m() {
		return model_m;
	}

	public void setModel_m(ListModelMap<String, Node> model_m) {
		this.model_m = model_m;
	}

	public ListModelSet<Object> getModel_s() {
		return model_s;
	}

	public void setModel_s(ListModelSet<Object> model_s) {
		this.model_s = model_s;
	}

	@Init
	public void init() {
		nodes_l = new ArrayList<Node>();
		for (int i = 0; i < 5; i++) {
			nodes_l.add(new Node("" + i, "Node#" + i));
		}
		model_l = new ListModelList<Node>(nodes_l, true);
		model_a = new ListModelArray<Object>(nodes_a);
		nodes_m = new HashMap<String, Node>();
		for (int i = 0; i < 5; i++) {
			nodes_m.put("item " + i, new Node("" + i, "Node#" + i));
		}
		model_m = new ListModelMap<String, Node>(nodes_m, true);
		nodes_s = new HashSet<Object>();
		for (int i = 0; i < 5; i++) {
			nodes_s.add(new Node("" + i, "Node#" + i));
		}
		model_s = new ListModelSet<Object>(nodes_s, true);
	}
	
	@Command
	@NotifyChange({"model_l", "model_a", "model_m","model_s"})
	public void change_model(Window win) {
		nodes_l = new ArrayList<Node>();
		for (int i = 0; i < 3; i++) {
			nodes_l.add(new Node("" + i, "New Node#" + i));
		}
		model_l = new ListModelList<Node>(nodes_l, true);
		String[] nodes_a_new = new String[] {
				"New Apple", "New Orange", "New Mango", "New Banana"};
		model_a = new ListModelArray<Object>(nodes_a_new);
		Map<String,Node> nodes_m_new = new HashMap<String, Node>();
		for (int i = 0; i < 3; i++) {
			nodes_m_new.put("new item " + i, new Node("" + i, "New Node#" + i));
		}
		model_m = new ListModelMap<String, Node>(nodes_m_new, true);
		Set<Object> nodes_s_new = new HashSet<Object>();
		for (int i = 0; i < 5; i++) {
			nodes_s_new.add(new Node("" + i, "New Node#" + i));
		}
		model_s = new ListModelSet<Object>(nodes_s_new, true);
	}
	
	@Command
	public void add() {
		nodes_l.add(new Node("5", "Node#5 - node")); //Because of live model
		model_l.add(new Node("6", "Node#6 - model"));
		nodes_m.put("new item 5", new Node("5", "Node#5 - node"));
		model_m.put("new item 6", new Node("6", "Node#6 - model"));
		nodes_s.add(new Node("5", "Node#5 - node"));
		model_s.add(new Node("6", "Node#6 - model"));
	}
	
	@Command
	public void update() {
		Node n = nodes_l.get(0);
		n.setName("<model node change>");
		model_l.set(0, n);
		nodes_a[0] += "<model node change>";
		model_a.set(0, nodes_a[0]);
		n = (Node) model_m.getElementAt(0).getValue();
		model_m.put(model_m.getElementAt(0).getKey(), new Node(n.getId(), "<model node change>"));
	}
	
	@Command
	public void remove() {
		model_l.remove(model_l.getSize() - 1);
		model_m.remove(model_m.getElementAt(model_m.getSize() - 1).getKey());
		model_s.remove(model_s.getElementAt(model_s.getSize() - 1));
	}
	
	public class Node implements Serializable{
		private static final long serialVersionUID = 1L;
		String id;
		String name;
		
		public Node (String id, String name) {
			this.id = id;
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
