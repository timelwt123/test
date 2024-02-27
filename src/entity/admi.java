package entity;

public class admi {
private String name;
private String pwd;
public synchronized String getName() {
	return name;
}
public synchronized void setName(String name) {
	this.name = name;
}
public synchronized String getPwd() {
	return pwd;
}
public synchronized void setPwd(String pwd) {
	this.pwd = pwd;
}

}
