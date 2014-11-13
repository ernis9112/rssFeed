
public class FailedState implements State
{
	public void doAction(ProcessContext context) {
	   Logger.getInstance().addLog("Reading procces failed");
	   context.setState(this);	
	}

	public String toString(){
		return "Fail State";
	}
}
