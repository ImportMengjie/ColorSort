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
		// TODO 自动生成的方法存根
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO 自动生成的方法存根
		if(obj instanceof ColorThread)
			return name.equals((ColorThread)obj);
		return false;
	}
	
	
	
}
