import java.sql.SQLException;
import java.util.ArrayList;


public class RssFeedReaderMain {

	public static void main(String[] args) {
		
		// Factory----------------------------------------------------
		RssReader reader = null;
		RssReaderFactory readerFactory = new RssReaderFactory();
		reader = readerFactory.createReader("15min");
		
		try {
	         reader.writeFeed("http://www.15min.lt/rss");  
	    } catch (Exception e) {  
	         e.printStackTrace();  
	    }
		// Factory end------------------------------------------------
		
		// Strategy---------------------------------------------------
		FilteredFeeds fFeeds = null;
		fFeeds = new FilteredFeeds(new FeedsByCategoryFilter("Lietuva"));
		fFeeds.executeFiltering();
		// Strategy end-----------------------------------------------

		NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("namai");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bites");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");

	}

}
