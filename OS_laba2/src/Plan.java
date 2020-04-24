import java.util.ArrayList;
import java.util.Random;

public class Plan {
	public static final int TIME = 5;
	ArrayList<Process> Processes;
	private int maxPrioritet = -1;
	private int k;
	public Plan() {
		Processes = new ArrayList<Process>();
		Random length = new Random();
		for (int i = 0; i < length.nextInt(10) + 1; i++) {
			int prioritet = length.nextInt(100) + 1;
			if (prioritet < maxPrioritet || maxPrioritet == -1) {
				maxPrioritet = prioritet;
				k = i;
			}
			Process proc = new Process("Номер процесса:" + (i + 1), prioritet);
			Processes.add(proc);
		}
	}
	
	public void Start() {
		int i = maxPrioritet;
		int j = 0;
		while(j < Processes.size())
		{
			Processes.get(k).start(TIME);
			Processes.get(k).Change();
			i = 0;
			for(int l = 0; l < Processes.size(); l++) {	
				if((Processes.get(l).getprioritet() < i || i == 0) && Processes.get(l).getprioritet() != 0) {
					i = Processes.get(l).getprioritet();
					k = l;
				}
			}
			j++;
		}
		
	}
}
