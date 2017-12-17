import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OfferBookServlet
 */
@WebServlet("/OfferBookServlet")
public class OfferBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OfferBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		UserAccountObject user = (UserAccountObject)request.getSession().getAttribute("UserObject");
		
		if (user != null) {
			DataManager dm = new DataManager();
			OfferBookControl control = new OfferBookControl(dm);
			
			// Retrieve submitted user input data with name “keywords”
			int userID = user.ID;
			String title = request.getParameterValues("bookTitle")[0];
			String author = request.getParameterValues("bookAuthor")[0];
			String ISBN = request.getParameterValues("ISBN")[0];
			String description = request.getParameterValues("bookDescription")[0];

			TextbookObject offer = control.processOfferBook(title, author, ISBN, description, userID, description);
			
			if (offer != null) {
				writer.println("<h2>Offer created.</h2>");
				writer.println("<hr>");
				writer.println("<p><a href=Main.html>Home</a></p>");
			} else {
				writer.println("<h2>Error While Offering Book.</h2>");
				writer.println("<hr>");
				writer.println("<p><a href=OfferTextbook.html>Retry</a></p>");
			}
		} else {
			writer.println("<h2>You must log in to offer a textbook.</h2>");
			writer.println("<hr>");
			writer.println("<p><a href=Main.html>Home</a></p>");
			writer.println("<p><a href=Login.html>Login</a></p>");
		}
		
	}
}