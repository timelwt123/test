package entity;

import java.util.Date;

public class morebook {
/*
 * 批量进货表
 * */

private String bookname;
private String fromname;
private double sumprice;
private Date datetime;
private int num;

public morebook(String bookname, String fromname, double sumprice, Date datetime, int num) {
	super();
	this.bookname = bookname;
	this.fromname = fromname;
	this.sumprice = sumprice;
	this.datetime = datetime;
	this.num = num;
}
public synchronized int getNum() {
	return num;
}
public synchronized void setNum(int num) {
	this.num = num;
}
public synchronized double getSumprice() {
	return sumprice;
}
public synchronized void setSumprice(double sumprice) {
	this.sumprice = sumprice;
}
public synchronized Date getDatetime() {
	return datetime;
}
public synchronized void setDatetime(Date datetime) {
	this.datetime = datetime;
}
public synchronized String getBookname() {
	return bookname;
}
public synchronized void setBookname(String bookname) {
	this.bookname = bookname;
}
public synchronized String getFromname() {
	return fromname;
}
public synchronized void setFromname(String fromname) {
	this.fromname = fromname;
}

}
