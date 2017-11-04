package color;

import java.util.ArrayList;
import java.util.HashMap;
import color.sort.*;

public abstract class AbsSort {
	private static ArrayList<ExColor> Scolors=null;
	
	static HashMap<SortName,AbsSort> sorts=null;
	
	protected  ArrayList<ExColor> colors=null;
	protected int steps=0;
	
	protected  final SortName name;
	
	protected AbsSort(SortName name)
	{
		this.name=name;
		this.colors=new	ArrayList<ExColor>(getColors().size());
		this.colors.addAll(getColors());
	}
	
	public void restart()
	{
		this.colors=new	ArrayList<ExColor>(getColors(true).size());
		this.colors.addAll(getColors());
	}
	
	abstract public void sort();
	protected int extra()
	{
		Panel.getPanel(this.name).repaint();
		this.steps++;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<ExColor> getExColor()
	{
		return this.colors;
	}
	
	public static AbsSort getSorts(SortName e)
	{
		if(sorts==null)
		{
			sorts=new HashMap<SortName,AbsSort>();
			sorts.put(SortName.INSTER, new InsertSort(SortName.INSTER));
			sorts.put(SortName.BUBBLE, new BubbleSort(SortName.BUBBLE));
			sorts.put(SortName.SHELL, new ShellSort(SortName.SHELL));
			sorts.put(SortName.SELECT, new SelectSort(SortName.SELECT));
			sorts.put(SortName.QUICK, new QuickSort(SortName.QUICK));
			sorts.put(SortName.MERGE, new MergeSort(SortName.MERGE));
			sorts.put(SortName.HEAP, new HeapSort(SortName.HEAP));
		
		}
		return sorts.get(e);
	}
	
	public static ArrayList<ExColor> getColors()
	{
		return getColors(false);
	}
	public static ArrayList<ExColor> getColors(boolean mass)
	{
		if(Scolors==null)
		{
			Scolors = new ArrayList<ExColor>();
			int[] arr={255,0,0};
			for(int i=0;i<arr.length;i++)
			{
				for(int j=0;j<=255;j++)
				{
					Scolors.add(new ExColor(arr[0],arr[1],arr[2],2*i*255+j));
					arr[(i+1)%arr.length]=j;
				}
				for(int j=255;j>=0;j--)
				{
					arr[i]=j;
					Scolors.add(new ExColor(arr[0],arr[1],arr[2],(2*i+1)*255+255-j));
				}
			}
			mass=true;
		}
		if(mass)
		{
			for(int a=0;a<Scolors.size();a++)
			{
				int j=(int)(Math.random()*Scolors.size());
				ExColor c=Scolors.get(j);
				Scolors.set(j, Scolors.get(a));
				Scolors.set(a, c);
			}
		}

		return Scolors;
	}
}
