import java.util.ArrayList;

public class MyStack {
	private ArrayList<Argument> list = new ArrayList();
	
	public void push(Argument num)
	{
		list.add(num);
	}
	
	public Argument pop()
	{
		if(list.size() == 0) {
			return null;
		}		
		Argument a = list.get(list.size()-1);
		list.remove(list.size()-1);			
		return a;
	}
	
	public int myStackSize() {
		return list.size();
	}
}
