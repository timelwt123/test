package entity;

import java.util.Date;

public class dayxs {
private int id;
private String bookname;
private Date xsday;
private double soldprice;
private int dayquanity;
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
public synchronized Date getXsday() {
	return xsday;
}
public synchronized void setXsday(Date xsday) {
	this.xsday = xsday;
}
public synchronized double getSoldprice() {
	return soldprice;
}
public synchronized void setSoldprice(double soldprice) {
	this.soldprice = soldprice;
}
public synchronized int getDayquanity() {
	return dayquanity;
}
public synchronized void setDayquanity(int dayquanity) {
	this.dayquanity = dayquanity;
}




}
