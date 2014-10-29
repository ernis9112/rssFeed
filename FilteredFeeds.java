import java.util.ArrayList;


class FilteredFeeds {
	
    private FilterType filter;
 
    public FilteredFeeds(FilterType ifilter) {
        this.filter = ifilter;
    }
    public ArrayList<String> executeFiltering() {
        return this.filter.filter();
    }
}
