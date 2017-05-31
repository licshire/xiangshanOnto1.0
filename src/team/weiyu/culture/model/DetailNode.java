package team.weiyu.culture.model;

import java.util.ArrayList;

public class DetailNode {

	private ArrayList<String> keys;
	private ArrayList<String> values;
	
	public DetailNode(ArrayList<String> keys, ArrayList<String> values) {
		super();
		this.setKeys(keys);
		this.setValues(values);
	}

	public ArrayList<String> getValues() {
		return values;
	}

	public void setValues(ArrayList<String> values) {
		this.values = values;
	}

	public ArrayList<String> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<String> keys) {
		this.keys = keys;
	}
	
}
