
public class ForeignReaderFactory implements ReaderFactory {

	@Override
	public Reader createReader(String option) {
		
		Reader someRead = null;
		
		if(option.equals("bbc")){
			someRead = new RssReaderBbc();
		}else
		if(option.equals("guardian")){
			someRead = new RssReaderGuardian();
		}
		return someRead;
	}

}
