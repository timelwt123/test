package entity;

public class proBook {
private proBookPK pk;//����
private double Price;
public synchronized proBookPK getPk() {
	return pk;
}
public synchronized void setPk(proBookPK pk) {
	this.pk = pk;
}
public synchronized double getPrice() {
	return Price;
}
public synchronized void setPrice(double price) {
	Price = price;
}


}
