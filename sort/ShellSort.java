package color.sort;

import color.AbsSort;
import color.ExColor;
import color.SortName;

public class ShellSort extends AbsSort {

	public ShellSort(SortName name) {
		super(name);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void sort() {
		this.steps=0;
		for(int i=(int)colors.size()/2;i>0;i=(int)i/2)
		{
			sort(i);
		}

	}
	private void sort(int dk)
	{
		ExColor t;
		int j;
		for(int i=0+dk;i<colors.size();i++)
		{
			if(colors.get(i).num<colors.get(i-dk).num)
			{
				t=colors.get(i);
				for(j=i-dk;j>=0&&t.num<colors.get(j).num;j-=dk)
				{
					colors.set(j+dk, colors.get(j));
					this.steps++;
					if(j%2==0)
						this.extra();
				}
				colors.set(j+dk, t);
				this.extra();
			}
		}
	}

}



