package sait.bms.problemdomain;

public class Paperback extends Book {
	private String genre;
	private int year;
	private String author;
	/**
	 * @param isbn Identifier of Book
	 * @param callNumber CallNumber of Book
	 * @param available Number of available copies
	 * @param total Total copies of Book
	 * @param title Title of Book
	 * @param author Author(s) of book
	 * @param year Year Book was released
	 * @param genre Genre of Book
	 */
	public Paperback(long isbn, String callNumber, int available, int total, String title,String author,int year, String genre) {
		this.genre = genre;
		this.year = year;
		this.author = author;
		setISBN(isbn);
		setCallNumber(callNumber);
		setAvailable(available);
		setTotal(total);
		setTitle(title);
	}
	/**
	 * generic constructor for type checking
	 */
	public Paperback() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * return Author(s) of Book
	 * @return Author(s)
	 */
	public String getAuthors() {
		return author;
	}
	/**
	 * return Genre of Book
	 * @return Genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * return Year book was Released
	 *@return Year 
	 */
	
	public int getYear() {
		return year;
	}
	/**
	 * Overrides the ToString method to return all info on the book, including class specific attributes
	 */
	public String toString() {
		switch(genre) {
		case("A"):
			genre = "Adventure";
			break;
		case("D"):
			genre = "Drama";
			break;
		case("E"):
			genre = "Education";
			break;
		case("C"):
			genre = "Classic";
			break;
		case("F"):
			genre = "Fantasy";
			break;
		case("S"):
			genre = "Science Fiction";
			break;
		}
		
		String bookInfo = String.format(
				  "%-18s%s %n%-18s%s %n%-18s%d %n%-18s%d %n%-18s%s %n%-18s%s %n%-18s%s %n%-18s%s %n","ISBN:", this.getISBN(),"Call Number:", this.getCallNumber(),"Available:", this.getAvailable(),"Total:", this.getTotal(),"Title:", this.getTitle(),"Author:", author,"Year:", year,"Genre:", genre);
		return bookInfo;
	}

}
