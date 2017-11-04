package color;

public class ColorThread extends Thread{
	private SortName name;
	
	public ColorThread(SortName name)
	{
		this.name=name;
	}

	@Override
	public void run() {
		AbsSort.getSorts(name).sort();
	}

	@Override
	public int hashCode() {
		// TODO �Զ����ɵķ������
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO �Զ����ɵķ������
		if(obj instanceof ColorThread)
			return name.equals((ColorThread)obj);
		return false;
	}
	
	
	
}
