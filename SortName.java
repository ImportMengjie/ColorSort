package color;

public enum SortName {
	INSTER("≤Â»Î≈≈–Ú"),SHELL("œ£∂˚≈≈–Ú"),SELECT("—°‘Ò≈≈–Ú"),HEAP("∂—≈≈–Ú"),BUBBLE("√∞≈›≈≈–Ú")
	,QUICK("øÏÀŸ≈≈–Ú"),MERGE("πÈ≤¢≈≈–Ú");
	
	private final String name;
	private SortName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}

}
