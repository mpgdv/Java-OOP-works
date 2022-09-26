import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Pilas
{
	
	public static Stack<String> st = new Stack<>(); //pila
	public static String str = "";

	public static void main(String args[])
	{
		JFrame frame = new JFrame("Pila");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(220,250);
		frame.setLayout(null);
		
		JTextField text1 = new JTextField();
		text1.setBounds(13,8,113,20);
		
		JTextField text2 = new JTextField();
		text2.setBounds(82,39,113,20);


		JButton push = new JButton("push");
		push.setBounds(130,5,65,26);
		
		
		JButton pop = new JButton("pop");	
		pop.setBounds(13,36,65,26);		

		JTextArea area = new JTextArea();
		area.setBounds(13,69,182,133);
		
		frame.add(text1);
		frame.add(push);
		frame.add(pop);
		frame.add(text2);
		frame.add(area);
		
		
		
		push.addActionListener(new ActionListener()  
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
				str = text1.getText();
				st.push(str);
				area.setText("");
				for(String x: st)
				{
					area.insert(x+"\n",0);
					text1.setText("");
				}
			}
		});

		pop.addActionListener(new ActionListener()  
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
			    if(st.empty() == false)
			    {
				text2.setText(st.pop());
				area.setText("");
				for(String x: st)
				{
 				         area.insert(x + "\n",0);
				     
				}
                            }
			    else{
				area.setText("No hay elementos");
			    }
			}
		});
		
		
		
		frame.setVisible(true);
		
		
	}
}