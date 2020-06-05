import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Manager extends JPanel {
	private static int[][] memory;
	private static int size;
	private static int countElement;
	private static int countFree;
	private static ArrayList<File> files;
	private int x = 0;
	private int y = 0;
	private static int sixe_i = 4;
	
	public static void startup(int _size) {
		size = _size;
		countFree = size / sixe_i;
		countElement = size / sixe_i;
		if (files != null) {
			files.removeAll(files);
		}
		files = new ArrayList<File>();
		if ((countElement % 40) == 0) {
			memory = new int[(countElement / 40)][];
		} else {
			memory = new int[(countElement / 40) + 1][];
		}
		for (int i = 0; i < memory.length; i++) {
			memory[i] = new int[40];
			for (int j = 0; j < memory[i].length; j++) {
				memory[i][j] = 1;
			}
		}
		if ((countElement % 40) != 0) {
			memory[(countElement / 40)] = new int[countElement % 40];
			for (int j = 0; j < countElement % 40; j++) {
				memory[countElement / 40][j] = 1;
			}
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (memory != null) {
			for (int i = 0; i < memory.length; i++) {
				if (memory[i] != null) {
					for (int j = 0; j < memory[i].length; j++) {
						if (memory[i][j] == 1)
							g.setColor(Color.GRAY);
						else {
							if (memory[i][j] == 2) {
								g.setColor(Color.BLUE);
							} else {
								if (memory[i][j] == 3) {
									g.setColor(Color.RED);
								}
							}
						}
						g.fillRect(x, y, 11, 11);
						x += 12;
					}
					x = 0;
					y += 12;
				}
			}
		}
		y = 0;
	}
	
	public static boolean addFile(String name, int size) {
		if (files != null) {
			for (int i = 0; i < files.size(); i++) {
				if (files.get(i).getNode().getName().equals(name)) {
					JOptionPane.showMessageDialog(null, "¬ведите другое им€");
					return false;
				}
			}
		}
		if (size / 4 > countFree) {
			JOptionPane.showMessageDialog(null, "¬ведите меньший размер");
			return false;
		}
		countFree -= size / 4;
		countElement = size / 4;
		Place[] ps = new Place[countElement];
		int ps_id = 0;
		for (int i = 0; i < memory.length && countElement > 0; i++) {
			for (int j = 0; j < memory[i].length && countElement > 0; j++) {
				if (memory[i][j] == 1) {
					countElement--;
					memory[i][j] = 2;
					ps[ps_id++] = new Place(i, j);
				}
			}
		}
		int sizeLocal = 0;
		if(size / 4 > 3) {
			sizeLocal = 3*4;
			size -=sizeLocal;
		} else {
			sizeLocal = size;
			size = 0;
		}
		IndexNode knot = new IndexNode(ps,name, sizeLocal);
		knot.indexNode(ps);
		while (size > 0) {
			if(size / 4 > 3) {
				sizeLocal = 3*4;
				size -=sizeLocal;
				knot.setNode(ps,name, sizeLocal);
			} else {
				sizeLocal = size;
				size = 0;
				knot.setNode(ps,name, sizeLocal);
			}
		}		
		File file = new File(knot);
		files.add(file);		
		return true;
	}
	
	public static void Delete(String s) {
		Place[] ps = getfile(s).getNode().getpositions();
		if (ps != null) {
			for (int i = 0; i < ps.length; i++) {
				memory[ps[i].I][ps[i].J] = 1;
			}
		}
		countFree += getfile(s).getNode().fileSize() / 2;
		files.remove(getfile(s));
	}
	
	public static File getfile(String s) {
		if (files != null) {
			for (int i = 0; i < files.size(); i++) {
				if (files.get(i).getNode().getName().equals(s)) {
					return files.get(i);
				}
			}
		}
		return null;
	}

	public static void setMemoryPoint(int i, int j, int p) {
		memory[i][j] = p;
	}

	public static void setSize(int s) {
		size = s;
	}
	public static int[][] get() {
		return memory;
	}
	public static void setFree() {
		countFree = size / sixe_i;
	}
	
}
