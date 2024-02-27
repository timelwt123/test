package entity;

public class upBean {
private String bookname;
private Double soldprice;
public synchronized String getBookname() {
	return bookname;
}
public synchronized void setBookname(String bookname) {
	this.bookname = bookname;
}
public synchronized Double getSoldprice() {
	return soldprice;
}
public synchronized void setSoldprice(Double soldprice) {
	this.soldprice = soldprice;
}
public upBean(String bookname, Double soldprice) {
	super();
	this.bookname = bookname;
	this.soldprice = soldprice;
}


}
