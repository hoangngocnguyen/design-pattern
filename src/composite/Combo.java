package composite;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Component {
	private String name;

	// Chứa danh sách các Component (combo hoặc product)
	private List<Component> listItem = new ArrayList<Component>();

	@Override
	public double getTongTien() {
		double sum = 0;
		for (Component c : this.listItem) {
			sum += c.getTongTien();
		}
		return sum;
	}
	
	@Override
	public void in(String indent) {
		// In combo hiện tại
		System.out.println(indent + "|-- " + this.name);
		
		// In thằng con, đệ quy
		for (Component c : this.listItem) {
			c.in(indent + "    ");	// tăng khoảng cách đối với con
		}
		
	}
	
	
	public void add(Component c) {
		this.listItem.add(c);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Component> getListItem() {
		return listItem;
	}

	public void setListItem(List<Component> listItem) {
		this.listItem = listItem;
	}

	public Combo(String name, List<Component> listItem) {
		super();
		this.name = name;
		this.listItem = listItem;
	}
	
	public Combo(String name) {
		super();
		this.name = name;
	}

	public Combo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
