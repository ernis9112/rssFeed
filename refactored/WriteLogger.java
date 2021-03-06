import java.util.ArrayList;

public class WriteLogger extends AbstractLogger {
		
	protected ArrayList<String> logMessages = new ArrayList<String>();

	public WriteLogger(int mask) {
        this.mask = mask;
    }
	
    public void addLog(String log) {
        logMessages.add(log);
    }

    public ArrayList<String> getLogMessages() {
        return logMessages;
    }
}
