package entity;

public class monthxs {
private int id;
private String bookname;
private int monthxs;
private double monsumprice;
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
public synchronized int getMonthxs() {
	return monthxs;
}
public synchronized void setMonthxs(int monthxs) {
	this.monthxs = monthxs;
}
public synchronized double getMonsumprice() {
	return monsumprice;
}
public synchronized void setMonsumprice(double monsumprice) {
	this.monsumprice = monsumprice;
}


}
