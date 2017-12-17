import java.sql.*;
import java.util.*;

public class DataManager {
	Connection connection = null;

	public DataManager() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.err.println(e.toString());
		}

		String url = "jdbc:mysql://cs2043.cs.unb.ca:3306/cs2043team8";

		try {
			connection = DriverManager.getConnection(url, "cs2043team8", "4ObCL2XO");
		} catch (SQLException e) {
			System.err.println("Database connection error.");
		}

	}
	
	public TextbookObject enterBookInfo(String bookTitle, String bookAuthor, String status, String ISBN,
			String contributorID, String description) {
		TextbookObject offer = null;

		try {
			offer = new TextbookObject(bookTitle, bookAuthor, status, ISBN, contributorID, description);

			Statement st = connection.createStatement();
			String query = "INSERT INTO Textbook(Title, ISBN, Status, Author, Description, ContributorID) VALUES ('" + bookTitle
					+ "','" + ISBN + "','available','" + bookAuthor + "','" + description + "',"+ contributorID + "); ";
			
			System.out.println(query);
			int result = st.executeUpdate(query);
			System.out.println("Result: " + result);

		} catch (SQLException e) {
			System.err.println("SQL error: getBooksByKeywords");
			System.out.println(e.getMessage());
		}

		return offer;
	}
}
