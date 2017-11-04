package color.sort;

import color.ExColor;
import color.SortName;

public class HeapSort extends color.AbsSort{

	public HeapSort(SortName name) {
		super(name);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void sort() {
		this.steps=0;
		ExColor t;
		for(int i=(colors.size()-1)/2;i>0;i--)
			heapAdjust(i,colors.size()-1);
		for(int i=(colors.size()-1);i>1;i--)
		{
			t=colors.get(0);
			colors.set(0, colors.get(i));
			colors.set(i, t);
			this.extra();
			heapAdjust(0,i-1);
		}
		
		
	}
	
	private void heapAdjust(int low,int high){
		ExColor t=colors.get(low);
		for(int j=2*low;j<=high;j*=2)
		{
			if(j<high&&colors.get(j).num<=colors.get(j+1).num)
				j++;
			if(t.num>colors.get(j).num)
				break;
			colors.set(low, colors.get(j));
			low=j;
			this.extra();
		}
		colors.set(low,t);
		this.extra();
	}


}
