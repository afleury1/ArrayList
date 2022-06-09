package sait.bms.problemdomain;

public class Periodical extends Book{
	private String frequency;
	/**
	 * 
	 * @param isbn Identifier of Book
	 * @param callNumber CallNumber of Book
	 * @param available Number of available copies
	 * @param total Total copies of Book
	 * @param title Title of Book
	 * @param frequency Frequency of Releases
	 */
	public Periodical(long isbn, String callNumber, int available, int total, String title, String frequency) {
		this.frequency = frequency;
		setISBN(isbn);
		setCallNumber(callNumber);
		setAvailable(available);
		setTotal(total);
		setTitle(title);
	}
	/**
	 * generic constructor for type checking
	 */
	public Periodical() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * return Frequency of Releases
	 * @return Frequency
	 */
	public String getFrequency() {
		return frequency;
	}
	/**
	 * Overrides the ToString method to return all info on the book, including class specific attributes
	 */
	public String toString() {
		
		switch(frequency) {
			case("D"):
				frequency = "Daily";
				break;
			case("W"):
				frequency = "Weekly";
				break;
			case("M"):
				frequency = "Monthly";
				break;
			case("B"):
				frequency = "Bi-Monthly";
				break;
			case("Q"):
				frequency = "Quarterly";
				break;
			}
		
		String bookInfo = String.format(
				  "%-18s%s %n%-18s%s %n%-18s%d %n%-18s%d %n%-18s%s %n%-18s%s %n","ISBN:", this.getISBN(),"Call Number:", this.getCallNumber(),"Available:", this.getAvailable(),"Total:", this.getTotal(),"Title:", this.getTitle(),"Frequency:", frequency);
		return bookInfo;
	}
}
