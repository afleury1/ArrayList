package sait.bms.problemdomain;

public class ChildrensBook extends Book {
	private String format;
	private String author;
	/**
	 * 
	 * @param isbn Identifier of Book
	 * @param callNumber CallNumber of Book
	 * @param available Number of available copies
	 * @param total Total copies of Book
	 * @param title Title of Book
	 * @param authors Name(s) of authors of Book
	 * @param format Format of Book
	 */
	public ChildrensBook(long isbn, String callNumber, int available, int total, String title,String authors, String format) {
		this.format = format;
		this.author = authors;
		setISBN(isbn);
		setCallNumber(callNumber);
		setAvailable(available);
		setTotal(total);
		setTitle(title);
	}
	/**
	 * generic constructor for type checking
	 */
	public ChildrensBook() {
		
	}
	/**
	 * returns the authors
	 * @return Author
	 */
	public String getAuthors() {
		return author;
	}
	/**
	 * returns the format
	 * @return Format of Book
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * Overrides the ToString method to return all info on the book, including class specific attributes/
	 */
	public String toString() {
		switch(format) {
		case("P"):
			format = "Picture book";
			break;
		case("E"):
			format = "Early readers";
			break;
		case("C"):
			format = "Chapter book";
			break;
		}
		String bookInfo = String.format(
				  "%-18s%s %n%-18s%s %n%-18s%d %n%-18s%d %n%-18s%s %n%-18s%s %n%-18s%s %n","ISBN:", this.getISBN(),"Call Number:", this.getCallNumber(),"Available:", this.getAvailable(),"Total:", this.getTotal(),"Title:", this.getTitle(),"Authors:", author,"Format:" ,format);

		return bookInfo;
	}
}
