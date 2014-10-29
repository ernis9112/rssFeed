import java.util.ArrayList;


public class FeedsByAuthorFilter implements FilterType {
	
	private String author;
	
	public FeedsByAuthorFilter(String iAuthor){
		this.author = iAuthor;
	}
	
	public void filter(){
		// get feeds from database
		Database db = new Database();
		try {
			db.executeQuery("SELECT title from rssfeeds WHERE author = '" + author + "'", "select");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
