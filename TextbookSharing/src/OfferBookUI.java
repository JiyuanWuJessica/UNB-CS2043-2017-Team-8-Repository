import java.util.ArrayList;
import java.util.Scanner;

public class OfferBookUI {
	
	OfferBookControl offerBookControl;
	
	public OfferBookUI(OfferBookControl control) {
		this.offerBookControl = control;
	}

	public void displayOfferBookForm() {
		System.out.println("Enter your user ID, the book title, ISNB, a short description, author, and the reason you would like to offer the book. separated with a ','. Enter 0 to exit");
	}
	
	public void enterBookInfo() {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(",");
		ArrayList<String> bookInfo = new ArrayList<String>();
		while (true) {
			String info = scanner.next();
			if (bookInfo.equals("0")) break;
			bookInfo.add(info);
		}
		scanner.close();
		
		OfferInfoObject offer = OfferBookControl.processOfferBook(bookInfo);
		
		displayOffer(offer);
	}
	
	public void displayOffer(OfferInfoObject offer) {
		System.out.println("Textbook offered successfully:");

		System.out.println("Offer ID: " + offer.offerId);
		System.out.println("Date offered: " + offer.date); 
		System.out.println("Offer reason: " + offer.reason);
		System.out.println("Offered Book ID: " + offer.bookId);
		System.out.println("Offered User ID: " + offer.userId);
		System.out.println("Amount of Book Offered: " + offer.amount); 
		System.out.println();
	}
}