import java.util.LinkedHashMap;


public class RssFeedReaderMain {

	public static void main(String[] args) throws Exception {
		
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
		fFeeds = new FilteredFeeds();
		
		fFeeds.setFilter(new FeedsByCategoryFilter("Futbolas"));		
		fFeeds.executeFiltering();
		
		fFeeds.setFilter(new FeedsByAuthorFilter("15min"));		
		fFeeds.executeFiltering();
		// Strategy end-----------------------------------------------
		
	NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("namai");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bites");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
    
        // Facade ------------------------------------------------------
        Facade facade = new Facade();        
        LinkedHashMap categories = facade.getNewsPerCategoryCounts();        
        // Facade end---------------------------------------------------
        
        // Abstract factory---------------------------------------------
        ReaderFactory fac1 = new LithuanianReaderFactory();
        Reader read1 = fac1.createReader("15min");
        read1.writeFeed("http://www.15min.lt/rss");
        
        ReaderFactory fac2 = new ForeignReaderFactory();
        Reader read2 = fac2.createReader("guardian");
        read2.writeFeed("http://www.15min.lt/rss");
        // Abstract factory end ----------------------------------------

	// State factory------------------------------------------------
        ProcessContext context = new ProcessContext();
        
        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        RssReader reader2 = null;
		RssReaderFactory readerFactory2 = new RssReaderFactory();
		reader = readerFactory2.createReader("15min");
		
		try {
	         reader.writeFeed("http://www.15min.lt/rss");  
	    } catch (Exception e) {
	    	FailedState failedState = new FailedState();
	    	failedState.doAction(context);
	        System.out.println(context.getState().toString());
	        e.printStackTrace();  
	    }
        
        ProgressState progressState = new ProgressState();
        progressState.doAction(context);
        System.out.println(context.getState().toString());
        
        DoneState doneState = new DoneState();
        doneState.doAction(context);
        System.out.println(context.getState().toString());
        // State end ---------------------------------------------------
	}

}
