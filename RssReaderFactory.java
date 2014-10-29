
public class RssReaderFactory {

	public RssReader createReader(String readerType) {
		
        RssReader specificReader = null;
		
		if(readerType.equals("15min")){
			specificReader = new RssReader15min();
		}else
		if(readerType.equals("delfi")){
			specificReader = new RssReaderDelfi();
		}
		return specificReader;
	}

}
