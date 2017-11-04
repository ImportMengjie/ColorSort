package color;

import java.awt.*;
import java.util.Hashtable;
import javax.swing.*;

@SuppressWarnings("serial")
public class ColorFrame extends JFrame{
	
	public static Hashtable<SortName,Thread> threads=new Hashtable<SortName,Thread>();
	
	
	public ColorFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		//this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setSize(1750, 800);
		this.setTitle("有颜色的排序");
		Panel[] p=Panel.getPanelArr();
		this.setLayout(new GridLayout(p.length+1,1,0,20));
		for(Panel a:p)
		{
			this.getContentPane().add(a);
		}
		JButton start=new JButton("开始排序");
		this.add(start);
		start.addActionListener((e)->{
			start.setEnabled(false);
			threads.clear();
			for(SortName n:SortName.values())
			{
				threads.put(n, new ColorThread(n));
			}
			for(AbsSort a:AbsSort.sorts.values())
			{
				a.restart();
			}
			
			Panel.StartTime=System.currentTimeMillis();

			for(Thread t:threads.values())
			{
				t.start();
			}
			new Thread(new Runnable(){
				@Override
				public void run() {
					s:
					while(true)
					{
						for(Thread t:threads.values())
						{
							if(t.isAlive())
								continue s;
						}
					break;
					}
					Panel.StartTime=0;
					start.setEnabled(true);
			
				}	
			}).start();
			
		});
	}
	

	public static void main(String[] args)
	{
		ColorFrame frame=new ColorFrame();
		frame.setVisible(true);
		//frame.repaint();
	}

}
