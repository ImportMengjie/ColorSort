package color;

public enum SortName {
	INSTER("��������"),SHELL("ϣ������"),SELECT("ѡ������"),HEAP("������"),BUBBLE("ð������")
	,QUICK("��������"),MERGE("�鲢����");
	
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
