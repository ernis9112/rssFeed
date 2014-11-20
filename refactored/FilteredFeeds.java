class FilteredFeeds {
	
    private FilterType filter;
 
    public FilteredFeeds() {
    }
    
    public void setFilter(FilterType ifilter){
    	this.filter = ifilter;
    }
    
    public void executeFiltering() throws Exception {
        this.filter.filter();
    }
}
