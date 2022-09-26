import java.util.*;
//import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Formatter;
import java.util.*;

public class Directorio
{
		private static ArrayList<String> nombres = new ArrayList<String>();
		private static ArrayList<String> telefonos = new ArrayList<String>();  
		private static int in = 0;
		private static int n = 0;
		
		
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Directorio");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		//frame.setResizable(false); 
		
		JLabel nom = new JLabel("Nombre:");
		JLabel tel = new JLabel("Telefono:");
		JLabel num = new JLabel("0",SwingConstants.CENTER);
		JLabel note = new JLabel("",SwingConstants.CENTER);
		
		JButton borrar = new JButton("Borrar");
		JButton nuevo = new JButton("Nuevo");
		JButton ant = new JButton("<<");
		JButton sig = new JButton(">>");

		JTextField t_nom = new JTextField(20);
		JTextField t_tel = new JTextField(20);
		
		JPanel pan = new JPanel(new GridLayout(4,1,10,10));
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel(new GridLayout(1,2,5,5));
		JPanel pan4 =  new JPanel(new GridLayout(1,3,10,10));
		
		
		pan.setBorder(new EmptyBorder(10,10,10,10));
		
		frame.add(pan);
		
		pan.add(pan1);
		pan.add(pan2);
		pan.add(pan3);
		pan.add(pan4);
		
		
		pan1.add(nom);
		pan1.add(t_nom);
		pan2.add(tel);
		pan2.add(t_tel);
		pan3.add(borrar);
		pan3.add(nuevo);
		pan4.add(ant);
		pan4.add(num);
		pan4.add(sig);
		
		
		
		nuevo.addActionListener(new ActionListener()  
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
				in = Character.getNumericValue((num.getText()).charAt(0)) +1;
				nombres.add(t_nom.getText());
				telefonos.add(t_tel.getText()); 
				
				num.setText(String.valueOf(in));
				
			}
		});
		
		borrar.addActionListener(new ActionListener()  
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
				
			  n = Character.getNumericValue((num.getText()).charAt(0)); 

			
      			  if(nombres.isEmpty() == false && telefonos.isEmpty()==false)
			  {
				if(n==1 && in ==1)
				{
					nombres.remove(n-1);
				  	telefonos.remove(n-1);
				  	--in;
				  
				  t_nom.setText("");
				  t_tel.setText("");
				  num.setText("0");
				}
				
				else if(n>= 1 && n<in)
				{
				   nombres.remove(n-1);
				   telefonos.remove(n-1);
				   --in;
				
				   t_nom.setText(nombres.get(n-1));
				   t_tel.setText(telefonos.get(n-1));
				}
				
				else if(n == in && in>1)
				{
				   t_nom.setText(nombres.get(n-2));
				   t_tel.setText(telefonos.get(n-2));
				   num.setText(String.valueOf(n-1));

				   nombres.remove(n-1);
				   telefonos.remove(n-1);
				   --in;
				   
					
				   
				}
				
			  }

				
			}
		});
		
		//JButton sig = new JButton(">>");
		
		sig.addActionListener(new ActionListener()  
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
				n = Character.getNumericValue((num.getText()).charAt(0)) +1;
				
				if((n-1)<in)
				{
				  t_nom.setText(nombres.get(n-1));
				  t_tel.setText(telefonos.get(n-1));
				  num.setText(String.valueOf(n));
				}
			}
		});

		ant.addActionListener(new ActionListener()  
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
				n = Character.getNumericValue((num.getText()).charAt(0)) - 1;
				
				if((n-1)>=0)
				{
				  t_nom.setText(nombres.get(n-1));
				  t_tel.setText(telefonos.get(n-1));
				  num.setText(String.valueOf(n));
				}
			}
		});


		
		

		
		frame.setVisible(true);
	}
}