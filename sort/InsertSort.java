package color.sort;

import color.*;

public class InsertSort extends AbsSort{

	public InsertSort(SortName name) {
		super(name);
	}

	@Override
	public void sort() {
		this.steps=0;
		ExColor t;
		int j;
		for(int i=1;i<colors.size();i++)
		{
			if(colors.get(i).num<colors.get(i-1).num)
			{
				t=colors.get(i);
				for(j=i-1;j>=0&&colors.get(j).num>t.num;j--)
				{
					colors.set(j+1, colors.get(j));
					this.steps++;
					if(j%20==0)
						this.extra();
				}
				colors.set(j+1, t);
				this.extra();
			}
		}
		
		
	}

}
