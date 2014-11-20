import java.util.ArrayList;

public class NullLogger extends AbstractLogger {
		
	protected ArrayList<String> logMessages = new ArrayList<String>();

	public NullLogger(int mask) {
        this.mask = mask;
    }
	
    public void addLog(String log) {
    	//silence is gold
    }

    public ArrayList<String> getLogMessages() {
        return logMessages;
    }
}
