
public class Argument {
	public Object argumentValue;
	public Argument(int a)
	{
		this.argumentValue = (int)a;
	}
	public Argument(double a)
	{
		this.argumentValue = (double)a;	
	}
	public Argument(String a)
	{
		this.argumentValue = (String)a;	
	}
	public String getValue()
	{
		return argumentValue.toString();
	}
}
