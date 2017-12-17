import java.util.ArrayList;
public class OfferBookControl {
	private DataManager dataManager;
	
	public OfferBookControl(DataManager dm) {
		this.dataManager = dm;
	}
	
	public TextbookObject processOfferBook(String title, String author, String status, String ISBN, int contributorID, String description) {
		return dataManager.enterBookInfo(title, author, status, ISBN, contributorID, description);
	}
}