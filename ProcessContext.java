
public class ProcessContext
{
	private State state;

	public ProcessContext(){
		state = null;
	}

	public void setState(State state){
		this.state = state;		
	}

	public State getState(){
		return state;
	}
}
