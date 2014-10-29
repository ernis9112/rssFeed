
public class LithuanianReaderFactory implements ReaderFactory {

	@Override
	public Reader createReader(String option) {
		
		Reader someRead = null;
		
		if(option.equals("15min")){
			someRead = new RssReader15min();
		}else
		if(option.equals("delfi")){
			someRead = new RssReaderDelfi();
		}
		return someRead;
	}

}
