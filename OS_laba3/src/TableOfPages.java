import java.util.ArrayList;

public class TableOfPages {
	private ArrayList<Page> pagesRecords;

	public ArrayList<Page> getPagesRecords() {
		return pagesRecords;
	}

	public void setPagesRecords(ArrayList<Page> pagesRecords) {
		this.pagesRecords = pagesRecords;
	}

	public TableOfPages() {
		pagesRecords = new ArrayList<Page>();
	}

	public Page get(int index) {
		return pagesRecords.get(index);
	}

	public int size() {
		return pagesRecords.size();
	}

	public void add(Page page) {
		pagesRecords.add(page);
	}
}
