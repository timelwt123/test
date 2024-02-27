package entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

public class inBook {
private String BookName;
private int BookNum;
private String FromName;
private int id;
private double fprice;

public synchronized double getFprice() {
	return fprice;
}
public synchronized void setFprice(double fprice) {
	this.fprice = fprice;
}
public synchronized int getId() {
	return id;
}
public synchronized void setId(int id) {
	this.id = id;
}
public synchronized String getBookName() {
	return BookName;
}
public synchronized void setBookName(String bookName) {
	BookName = bookName;
}
public synchronized int getBookNum() {
	return BookNum;
}
public synchronized void setBookNum(int bookNum) {
	BookNum = bookNum;
}
public synchronized String getFromName() {
	return FromName;
}
public synchronized void setFromName(String fromName) {
	FromName = fromName;
}
}
