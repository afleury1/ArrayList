package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.bms.problemdomain.*;


public class manager{
	private final static String FILEPATH = ".\\res\\books.txt";
	private static ArrayList<Book> booksList = new ArrayList<Book>();
	
	
	
	/**
	  * Creates the Main Management menu.
	  */
	public manager() throws FileNotFoundException {
		// TODO Auto-generated constructor stub	
		boolean on = true;
		parseSupply();
		Scanner in = new Scanner(System.in);
		while(on) {
			System.out.println("Welcome to ABC Book Company: How may we assist you?");
			System.out.println("1     Checkout Book");
			System.out.println("2     Find Books by Title");
			System.out.println("3     Display Books by Type");
			System.out.println("4     Produce Random Book List");
			System.out.println("5     Save and Exit");
			String in1 = in.nextLine();
			switch(in1) {
				case("1"):
					System.out.print("Enter ISBN of Book: ");
					checkout(Long.parseLong(in.next()));
					in.nextLine();
					break;
				case("2"):
					System.out.print("Enter title to search:");
					searchTitle(in.nextLine());
					break;
				case("3"):
					System.out.println("1     Children's Book");
					System.out.println("2     Cookbooks");
					System.out.println("3     Paperback");
					System.out.println("4     Periodicals");
					System.out.printf("%nEnter type of book: ");
					searchType(in.nextInt(), in);
					
					break;
				case("4"):
					System.out.print("Enter number of Books: ");
					shuffleBooks(in.nextInt());
					in.nextLine();
					break;
				case("5"):
					saveSupply();
					on = false;
					break;
				default:
					System.out.println("Sorry, Please Try again, error was with:" + in1);
			}
		}
		in.close();

	}
	/**
	 * Reads from the specified book table and creates the specified book objects
	 */
	public static void parseSupply() throws FileNotFoundException {
		FileReader file = new FileReader(FILEPATH);
		Scanner books = new Scanner(file);
		while(books.hasNextLine()) {
			String currentLine = books.nextLine();
			String[] bookSpecs = currentLine.split(";");
			long type = Long.parseLong(bookSpecs[0]) % 10;
			switch((int)type) {
			case(0):
			case(1):
				ChildrensBook childrensbook = new ChildrensBook(Long.parseLong(bookSpecs[0]), bookSpecs[1],Integer.parseInt(bookSpecs[2]) ,  Integer.parseInt(bookSpecs[3]), bookSpecs[4], bookSpecs[5], bookSpecs[6]);
				booksList.add(childrensbook);
				break;
			case(2):
			case(3):
				Cookbook cookbook = new Cookbook(Long.parseLong(bookSpecs[0]), bookSpecs[1],Integer.parseInt(bookSpecs[2]) ,  Integer.parseInt(bookSpecs[3]), bookSpecs[4], bookSpecs[5], bookSpecs[6]);
				booksList.add(cookbook);
				break;
			case(4):
			case(5):
			case(6):
			case(7):
				Paperback paperback = new Paperback(Long.parseLong(bookSpecs[0]), bookSpecs[1], Integer.parseInt(bookSpecs[2]) ,Integer.parseInt(bookSpecs[3]),bookSpecs[4], bookSpecs[5], Integer.parseInt(bookSpecs[6]), bookSpecs[7]);
				booksList.add(paperback);
				break;
			case(8):
			case(9):
				Periodical periodical = new Periodical(Long.parseLong(bookSpecs[0]), bookSpecs[1],Integer.parseInt(bookSpecs[2]) ,  Integer.parseInt(bookSpecs[3]), bookSpecs[4], bookSpecs[5]);
				booksList.add(periodical);
				break;
			default:
				System.out.println("Darn something Broke! ");		
			}
			
		}
		books.close();
	}
	/**
	 * When the book has been chosen by the client and has available copies, they can check it out using the ISBN. This removes an instance from the available category.
	 * Lots of Suppressed Warnings, I'm a efficient coder not a thoughtful one.
	 * @param isbn The ISBN of selected book to checkout.
	 */
	@SuppressWarnings("unlikely-arg-type")
	private static void checkout(Long isbn) {
		@SuppressWarnings("unused")
		boolean isBook = false; //When true, the ISBN has been associated to a book
		Periodical periodicalBook = new Periodical(); 
		for(int i = 0; i < booksList.size(); i++) {
			if(!booksList.get(i).getClass().equals(periodicalBook)) {
				if(booksList.get(i).getISBN() == (isbn)) {
					if ( booksList.get(i).getAvailable()>0) {
						booksList.get(i).setAvailable(booksList.get(i).getAvailable()-1);
						System.out.printf("The book \"%s \"  has been checked out. %n", booksList.get(i).getTitle());
						System.out.printf("It can be found at %s. %n", booksList.get(i).getCallNumber());
						isBook = true;
					}else {
						System.out.println("Sorry, that book is Unavailable at the moment.");
					}
				}
				if (isBook = false) {
					System.out.println("Sorry, We can't seem to find what you are looking for.");
				}
			}
		}
	}
	/**
	 * Searches through the array of books for books with Titles matching the query.
	 * @param title Title of the book being searched for
	 **/
	private static void searchTitle(String title) {
		ArrayList<Book> searchResults = new ArrayList<Book>();
		for(int i = 0; i < booksList.size(); i++) {
			if (booksList.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
				searchResults.add(booksList.get(i));
			}
		}if (searchResults.size() > 0) {
			System.out.println("Matching Books:");
			for(int i = 0; i < searchResults.size(); i++ ) {
			System.out.println(searchResults.get(i).toString());
		}
		}else {
			System.out.println("No search results for that title");
		}
		
		
	}

	/**
	 * Searches through book types 
	 * @param search The type of book to search for.
	 * @param in The Input stream for Menu
	 */
	private static void searchType(int search, Scanner in) {
		in.nextLine();
		Book book = new Book();
		String key;
		String key2 = "";
		switch(search) {
		case(1): //Case ChildrensBook
			System.out.println("Enter a Format (P for Picture book, E for Early Readers, or C for Chapters): ");
			key = in.nextLine().toUpperCase();
			
			switch(key) {
			case("P"):
				key2 = "Picture book";
				break;
			case("E"):
				key2 = "Early readers";
				break;
			case("C"):
				key2 = "Chapter book";
				break;
			}
			book = new ChildrensBook();
			for(int i = 0; i < booksList.size(); i++) {
				if (booksList.get(i).getClass().equals(book.getClass())) {
						if(((ChildrensBook) booksList.get(i)).getFormat().equals(key) || ((ChildrensBook) booksList.get(i)).getFormat().equals(key2) ){
							System.out.println(booksList.get(i).getTitle());
							System.out.println(booksList.get(i).toString());
						}
				}
			}	
			break;
		case(2): //Case CookBook
			System.out.println("Enter a Diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None): ");
			key = in.nextLine().toUpperCase();
			book = new Cookbook();
			switch(key) {
			case("D"):
				key2 = "Diabetic";
				break;
			case("V"):
				key2 = "Vegetarian";
				break;
			case("G"):
				key2 = "Gluten-free";
				break;
			case("I"):
				key2 = "International";
				break;
			case("N"):
				key2 = "None";
				break;
			}
			book = new Cookbook();
			for(int i = 0; i < booksList.size(); i++) {
				if (booksList.get(i).getClass().equals(book.getClass())) {
						if(((Cookbook) booksList.get(i)).getDiet().equals(key) || ((Cookbook) booksList.get(i)).getDiet().equals(key2) ){
							System.out.println(booksList.get(i).getTitle());
							System.out.println(booksList.get(i).toString());
						}
				}
			}	
			break;
		case(3): //Case Paperback
			System.out.println("Enter a Genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction): ");
			key = in.nextLine().toUpperCase();
			book = new Paperback();
			switch(key) {
			case("A"):
				key2 = "Adventure";
				break;
			case("D"):
				key2 = "Drama";
				break;
			case("E"):
				key2 = "Education";
				break;
			case("C"):
				key2 = "Classic";
				break;
			case("F"):
				key2 = "Fantasy";
				break;
			case("S"):
				key2 = "Science Fiction";
				break;
			}
			for(int i = 0; i < booksList.size(); i++) {
				if (booksList.get(i).getClass().equals(book.getClass())) {
						if(((Paperback) booksList.get(i)).getGenre().equals(key) || ((Paperback) booksList.get(i)).getGenre().equals(key2) ){
							System.out.println(booksList.get(i).getTitle());
							System.out.println(booksList.get(i).toString());
						}
				}
			}	
			break;
		case(4): //Case Periodical
			System.out.println("Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly): ");
			key = in.nextLine().toUpperCase();
			book = new Periodical();
			switch(key) {
			case("D"):
				key2 = "Daily";
				break;
			case("W"):
				key2 = "Weekly";
				break;
			case("M"):
				key2 = "Monthly";
				break;
			case("B"):
				key2 = "BiMonthly";
				break;
			case("Q"):
				key2 = "Quarterly";
				break;
			}
			for(int i = 0; i < booksList.size(); i++) {
				if (booksList.get(i).getClass().equals(book.getClass())) {
						if(((Periodical) booksList.get(i)).getFrequency().equals(key) || ((Periodical) booksList.get(i)).getFrequency().equals(key2) ){
							System.out.println(booksList.get(i).getTitle());
							System.out.println(booksList.get(i).toString());
						}
				}
			}	
			break;
		}
	}
	/**
	 * 
	 * @param returnCount The amount of books to be returned
	 */
	private static void shuffleBooks(int returnCount) {
		ArrayList<Book> tempList = booksList;
		Collections.shuffle(tempList);
		System.out.println();
		if (returnCount > booksList.size()) {
			returnCount = booksList.size();
		}
			for(int i = 0; i < returnCount; i++) {
				System.out.println(tempList.get(i).toString());
			}
	}
	/**
	 * This parses through the array of books and saves their properties back to the specified file.
	 * @throws FileNotFoundException
	 */
	private static void saveSupply() throws FileNotFoundException {
		String tempString;
		File saveTo = new File(FILEPATH);
		PrintWriter saving = new PrintWriter(saveTo);
		for (int i = 0; i < booksList.size(); i++) {
			Book temp = booksList.get(i);
			int type = (int) (temp.getISBN() % 10);
			tempString = temp.getISBN() + ";"+ temp.getCallNumber() + ";" + temp.getAvailable() + ";" + temp.getTotal() + ";" + temp.getTitle()+";" ;
			switch (type) {
			case(0):
			case(1):
				ChildrensBook temp1 = (ChildrensBook) temp;
				tempString += temp1.getAuthors() + ";" + temp1.getFormat();
				break;
			case(2):
			case(3):
				Cookbook temp2 = (Cookbook) temp;
				tempString +=  temp2.getPublishers() + ";" + temp2.getDiet();
				break;
			case(4):
			case(5):
			case(6):
			case(7):
				Paperback temp3 = (Paperback) temp;
				tempString += temp3.getAuthors() + ";" + temp3.getYear() + ";" + temp3.getGenre();
				break;
			case(8):
			case(9):
				Periodical temp4 = (Periodical) temp;
				tempString += temp4.getFrequency();
				break;
			
			}
			if(i < booksList.size()-1) {
				saving.println(tempString);
			}else {
				saving.print(tempString);
			}
		}
		System.out.println("Saving Complete!");
		saving.close();
	}

}
