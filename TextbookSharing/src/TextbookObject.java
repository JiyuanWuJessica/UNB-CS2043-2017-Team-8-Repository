public class TextbookObject {
	public String bookTitle, bookAuthor, bookStatus, ISBN, description, contributorID;
	
	public TextbookObject(String titleIn, String authorIn, String statusIn, String ISBNIn, String contributorIDIn, String descriptionIn) {
		bookTitle = titleIn;
		bookAuthor = authorIn;
		bookStatus = statusIn;
		ISBN = ISBNIn;
		contributorID = contributorIDIn;
		description = descriptionIn;
	}
	
}