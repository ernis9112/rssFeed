import java.util.ArrayList;

public abstract class AbstractLogger {
	
	public static int READ = 3;
	public static int WRITE = 4;
    protected int mask;
    
	protected AbstractLogger next;
	
	protected ArrayList<String> logMessages = new ArrayList<String>();

	public void setNext(AbstractLogger logger) {
		next = logger;
	}
	
	public void message(String msg, int priority) {
        if (priority <= mask) {
        	addLog(msg);
        }
        if (next != null) {
            next.message(msg, priority);
        }
    }
	
    public abstract void addLog(String log);

    public abstract ArrayList<String> getLogMessages();
}
