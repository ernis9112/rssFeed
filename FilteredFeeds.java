import java.util.ArrayList;


class FilteredFeeds {
	
    private FilterType filter;
 
    public FilteredFeeds(FilterType ifilter) {
        this.filter = ifilter;
    }
    public void executeFiltering() {
        this.filter.filter();
    }
}
