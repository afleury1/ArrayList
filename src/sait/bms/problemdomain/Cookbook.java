package sait.bms.problemdomain;

public class Cookbook extends Book {
	private String diet;
	private String publishers;
	/**
	 * 
	 * @param isbn Identifier of Book
	 * @param callNumber CallNumber of Book
	 * @param available Number of available copies
	 * @param total Total copies of Book
	 * @param title Title of Book
	 * @param publishers Name(s) of publishers for Book
	 * @param diet Diet type of Book
	 */
	public Cookbook(long isbn, String callNumber, int available, int total, String title,String publishers, String diet) {
		this.diet = diet;
		this.publishers = publishers;
		setISBN(isbn);
		setCallNumber(callNumber);
		setAvailable(available);
		setTotal(total);
		setTitle(title);
	}
	/**
	 * generic constructor for type checking
	 */
	public Cookbook() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * returns the Diet
	 * @return Diet
	 */
	public String getDiet() {
		return diet;
	}
	/**
	 * returns the Publishers
	 * @return Publishers
	 */
	public String getPublishers() {
		return publishers;
	}
	/**
	 * Overrides the ToString method to return all info on the book, including class specific attributes/
	 */
	public String toString() {
		switch(diet) {
		case("D"):
			diet = "Diabetic";
			break;
		case("V"):
			diet = "Vegetarian";
			break;
		case("G"):
			diet = "Gluten-free";
			break;
		case("I"):
			diet = "International";
			break;
		case("N"):
			diet = "None";
			break;
		}
		String bookInfo = String.format(
				  "%-18s%s %n%-18s%s %n%-18s%d %n%-18s%d %n%-18s%s %n%-18s%s %n%-18s%s %n","ISBN:", this.getISBN(),"Call Number:", this.getCallNumber(),"Available:", this.getAvailable(),"Total:", this.getTotal(),"Title:", this.getTitle(),"Publishers:", publishers,"Diet:" ,diet);
		return bookInfo;
	}

}
