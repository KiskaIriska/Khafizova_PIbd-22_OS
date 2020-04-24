import java.util.ArrayList;
import java.util.Random;

public class MainClass {
	public static void main(String[] args) {
		ArrayList<Process> Processes= new ArrayList<Process>();
		Random length = new Random();
		for(int i = 0; i < length.nextInt(4)+1; i++)
		{
			int prioritet = length.nextInt(5) + 1;
			Process proc = new Process("Номер процесса:"+(i+1),prioritet);
			Processes.add(proc);
			proc.start(proc.TIME);
		}
	}
}
