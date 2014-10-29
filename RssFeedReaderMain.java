public class RssFeedReaderMain {

	public static void main(String[] args) {
		
		RssReader reader = null;
		RssReaderFactory readerFactory = new RssReaderFactory();
		reader = readerFactory.createReader("15min");
		
		try {
	         reader.writeFeed("http://www.15min.lt/rss");  
	    } catch (Exception e) {  
	         e.printStackTrace();  
	    } 
		
		NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("namai");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bites");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");

	}

}
