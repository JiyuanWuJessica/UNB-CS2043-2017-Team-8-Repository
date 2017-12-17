public class OfferBookMain {

	public static void main(String[] args) {
		DataManager dm = new DataManager();
		OfferBookControl control = new OfferBookControl(dm);
		OfferBookUI ui = new OfferBookUI(control);
				
		ui.displayOfferBookForm();
		ui.enterBookInfo();
	}

}