package color.sort;

import color.ExColor;
import color.SortName;

public class QuickSort extends color.AbsSort{

	public QuickSort(SortName name) {
		super(name);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void sort() {
		this.steps=0;
		sort(0,colors.size()-1);
		
	}
	
	private void sort(int low,int high){
		if(low<high)
		{
			int a = partition(low,high);
			sort(low,a-1);
			sort(a+1,high);	
		}
	}
	
	private int partition(int low,int high)
	{
		ExColor t=colors.get(low);
		while(low<high)
		{
			while(low<high&&t.num<=colors.get(high).num)
				high--;
			colors.set(low, colors.get(high));
			this.extra();
			while(low<high&&t.num>=colors.get(low).num)
				low++;
			colors.set(high, colors.get(low));
			this.extra();
		}
		colors.set(low, t);
		this.extra();
		return low;
	}

}
