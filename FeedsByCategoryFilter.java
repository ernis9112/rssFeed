public class FeedsByCategoryFilter implements FilterType {
	
	private String category;
	
	public FeedsByCategoryFilter(String iCategory){
		this.category = iCategory;
	}
	
	public void filter() throws Exception{
		// get feeds from database
		final IConnection conn = new ProxyConnection();
		try {
			conn.executeQuery("SELECT title from rssfeeds WHERE category = '" + category + "'", "select");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
