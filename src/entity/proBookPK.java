package entity;

	import java.io.Serializable;

	public class proBookPK implements Serializable {
	private String BookName;
	private String FromName;
	public proBookPK() {
		super();
	}
	
	public synchronized String getBookName() {
		return BookName;
	}

	public synchronized void setBookName(String bookName) {
		BookName = bookName;
	}

	public synchronized String getFromName() {
		return FromName;
	}

	public synchronized void setFromName(String fromName) {
		FromName = fromName;
	}

	@Override
	public boolean equals(Object o){
	    if (o instanceof proBookPK) {
	    	proBookPK pk = (proBookPK) o;
	        if(this.BookName.equals(pk.getBookName())&&this.FromName.equals(pk.getFromName())){
	            return true;
	        }

	    }
	    return false ;
	}
}
