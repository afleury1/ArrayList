package sait.bms.problemdomain;


public class Book {
	public long ISBN;
	public String callNumber;
	public int available;
	public int total;
	public String title; 
	

	
	/** Sets the title of the book
	 * @param title the title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/** Sets the total Copies of book
	 * @param total Total Copies of book
	 */
	public void setTotal(int total) {
		this.total = total;
		
	}
	/**
	 * ISBN Sets the Book Identifier
	 * @param ISBN The Book Identifier
	 */
	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
	/**
	 * Sets the amount of available copies
	 * @param available Amount of available copies
	 * 
	 */
	public void setAvailable(int available) {
		this.available = available;
	}
	/**
	 * Sets the books Callnumber
	 * @param callNumber CallNumber of the book
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	/**
	 * 
	 * @return The Title of Book
	 */
	public String getTitle() {
		return title;
		
	}
	/**
	 * 
	 * @return The total copies of a book
	 */
	public int getTotal() {
		return total;
		
	}
	/**
	 * 
	 * @return The ISBN of book (identifier)
	 */
	public long getISBN() {
		return ISBN;
		
	}
	/**
	 * 
	 * @return Amount Available (int)
	 */
	public int getAvailable() {
		return available;
		
	}
	/**
	 * 
	 * @return The CallNumber (String)
	 */
	public String getCallNumber() {
		return callNumber;
		
	}
	

}	
