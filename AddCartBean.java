package ecomerce;


import java.io.Serializable;

@SuppressWarnings("serial")

public class AddCartBean implements Serializable {
	private String pcode, pname;
	private float pprice;
	private int pstock;

	public AddCartBean() {

	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public float getPprice() {
		return pprice;
	}

	public void setPprice(float pprice) {
		this.pprice = pprice;
	}

	public int getPstock() { 
		return pstock;
	}

	public void setPstock(int pstock) {
		this.pstock = pstock;
	}

	@Override
	public String toString() {
		return "<pre>" + pcode + "\t" + pname + "\t" + pprice + "\t" + pstock + "</pre>";
	}

}
