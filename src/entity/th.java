package entity;

public class th {
private int id;
private String username;
private String bookname;
private int thnum;

public synchronized int getId() {
	return id;
}
public synchronized void setId(int id) {
	this.id = id;
}
public synchronized String getUsername() {
	return username;
}
public synchronized void setUsername(String username) {
	this.username = username;
}
public synchronized String getBookname() {
	return bookname;
}
public synchronized void setBookname(String bookname) {
	this.bookname = bookname;
}
public synchronized int getThnum() {
	return thnum;
}
public synchronized void setThnum(int thnum) {
	this.thnum = thnum;
}

}
