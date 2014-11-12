public class FeedsByAuthorFilter implements FilterType {
	
	private String author;
	
	public FeedsByAuthorFilter(String iAuthor){
		this.author = iAuthor;
	}
	
	public void filter() throws Exception{
		// get feeds from database
		final IConnection conn = new ProxyConnection();
		try {
			conn.executeQuery("SELECT title from rssfeeds WHERE author = '" + author + "'", "select");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
