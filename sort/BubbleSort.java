package color.sort;

import color.ExColor;
import color.SortName;

public class BubbleSort extends color.AbsSort{

	public BubbleSort(SortName name) {
		super(name);
	}

	@Override
	public void sort() {
		ExColor t;
		this.steps=0;
		boolean isChange=true;
		for(int i=0;isChange&&i<colors.size();i++)
		{
			isChange=false;
			for(int j=colors.size()-1;j>i;j--)
			{
				if(colors.get(j).num<colors.get(j-1).num)
				{
					isChange=true;
					t=colors.get(j);
					colors.set(j, colors.get(j-1));
					colors.set(j-1, t);
					this.steps++;
					if(j%20==0)
						this.extra();
				}
			}
			this.extra();
		}
		
		
	}


}
