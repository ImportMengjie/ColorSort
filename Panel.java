package color;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Hashtable;
import java.util.List;

import javax.swing.*;


@SuppressWarnings("serial")
public class Panel extends JPanel{
	
	private static Hashtable<SortName,Panel> panels=null;
	public static long StartTime=0;
	public int endTime=0;
	private final SortName name;
	static {
		panels=new Hashtable<SortName,Panel>();
		for(SortName e:SortName.values())
		{
			addPanel(e);
		}
	}
	
	private static void addPanel(SortName name)
	{
		panels.put(name, new Panel(name));
	}
	
	private Panel(SortName name)
	{
		this.name=name;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		List<ExColor> colors=AbsSort.getSorts(this.name).getExColor();
		Graphics2D g2=(Graphics2D) g;
		int num=0;
		for(ExColor e:colors)
		{
			g2.setColor(e);
			g2.drawLine(num, 0,num, 255);
			num++;
		}

				int half=(int)this.getSize().getHeight()/2;
				g2.setColor(Color.black);
				g2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, half/2));
				g2.drawString(getStr()+name.getName(), colors.size(), half);
				g2.drawString("steps:"+AbsSort.getSorts(name).steps, colors.size(), half*2);

	
		
	}
	
	private String getStr()
	{
		if(ColorFrame.threads.get(this.name)!=null)
		{
			if(ColorFrame.threads.get(this.name).isAlive())
				endTime=(int) (System.currentTimeMillis()-StartTime);
		}
		return String.format("%2ds%3dms ",endTime/1000,endTime%1000);
	}
	
	public static Panel getPanel(SortName e)
	{
		return panels.get(e);
	}
	
	public static Panel[] getPanelArr()
	{
		Panel[] arr=new Panel[panels.size()];
		int a=0;
		for(Panel c:panels.values())
		{
			arr[a++]=c;
		}

		return arr;
	}
}
