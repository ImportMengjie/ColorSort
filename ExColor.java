package color;

import java.awt.Color;

@SuppressWarnings("serial")
public class ExColor extends Color implements java.lang.Comparable<ExColor>{
	public final int num;
	
	
	ExColor(int r,int g,int b,int num)
	{
		super(r,g,b);
		this.num=num;
	}
	@Override
	public int compareTo(ExColor o) {
		return num-o.num;
	}
}
