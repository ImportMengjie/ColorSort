package color.sort;

import color.ExColor;
import color.SortName;

public class SelectSort extends color.AbsSort{

	public SelectSort(SortName name) {
		super(name);
	}

	@Override
	public void sort() {
		this.steps=0;
		ExColor t;
		int k=0;
		for(int i=0;i<colors.size();i++)
		{
			k=i;
			for(int j=i;j<colors.size();j++)
			{
				if(colors.get(k).num>colors.get(j).num)
				{
					k=j;
					this.extra();
				}
			}
			t=colors.get(k);
			colors.set(k,colors.get(i));
			colors.set(i, t);
			this.extra();
		}
		
	}


}
