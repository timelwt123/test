package entity;

public class moreKucun {
	private String bookname;
	private int quanity;
	private double price;
	
	public synchronized double getPrice() {
		return price;
	}
	public synchronized void setPrice(double price) {
		this.price = price;
	}
	public synchronized String getBookname() {
		return bookname;
	}
	public synchronized void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public synchronized int getQuanity() {
		return quanity;
	}
	public synchronized void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	public moreKucun(String bookname, int quanity, double price) {
		super();
		this.bookname = bookname;
		this.quanity = quanity;
		this.price = price;
	}

}
