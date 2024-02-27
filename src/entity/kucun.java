package entity;

public class kucun {
private String bookname;
private double soldprice;
private int quanity;
private int id;

public synchronized int getId() {
	return id;
}
public synchronized void setId(int id) {
	this.id = id;
}
public synchronized String getBookname() {
	return bookname;
}
public synchronized void setBookname(String bookname) {
	this.bookname = bookname;
}
public synchronized double getSoldprice() {
	return soldprice;
}
public synchronized void setSoldprice(double soldprice) {
	this.soldprice = soldprice;
}
public synchronized int getQuanity() {
	return quanity;
}
public synchronized void setQuanity(int quanity) {
	this.quanity = quanity;
}

}
