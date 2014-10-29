import java.util.ArrayList;


public class FeedsByCategoryFilter implements FilterType {
	
	private String category;
	
	public FeedsByCategoryFilter(String iCategory){
		this.category = iCategory;
	}
	
	public void filter(){
		// get feeds from database
		Database db = new Database();
		try {
			db.executeQuery("SELECT title from rssfeeds WHERE category = '" + category + "'", "select");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
