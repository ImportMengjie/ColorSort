package color.sort;

import color.ExColor;
import color.SortName;

public class MergeSort extends color.AbsSort{
	
	private ExColor[] temp;
	public MergeSort(SortName name) {
		super(name);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void sort() {
		if(temp==null)
			temp= colors.toArray(new ExColor[0]);
		merge(0,colors.size()-1);
		
	}
	
	public void merge(int start,int end)
	{
		if(start<end)
		{
			int mid=(int)(start+end)/2;
			merge(start,mid);
			merge(mid+1,end);
			mergeArr(start,end,mid);
		}
	}
	
	public void mergeArr(int low,int high,int mid)
	{
		int i=low;
		int j=mid+1;
		int k=0;
		while(i<=mid&&j<=high)
		{
			if(colors.get(i).num<colors.get(j).num)
				temp[k++]=colors.get(i++);
			else
				temp[k++]=colors.get(j++);		
		}
		while(i<=mid)
			temp[k++]=colors.get(i++);
		while(j<=high)
			temp[k++]=colors.get(j++);
		for(int a=0;a<k;a++)
		{
			colors.set(low+a, temp[a]);
			this.extra();
		}
	
	}


}
