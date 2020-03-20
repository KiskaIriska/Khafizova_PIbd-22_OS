import java.util.ArrayList;

public class MyStack {
	private ArrayList<String> list = new ArrayList<String>();
	
	public void push(String num)
	{
		list.add(num);
	}
	
	public String pop()
	{
		if(list.size() == 0) {
			return null;
		}		
		String a = list.get(list.size()-1);
		list.remove(list.size()-1);
		return a;
	
	}
	
	public int myStackSize() {
		return list.size();
	}
}
