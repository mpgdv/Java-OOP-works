import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Conjuntos
{
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Conjuntos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,650);	
		frame.setLayout(null);

	//Conjuntos
		
		JTextArea areaA = new JTextArea();
		JTextArea areaB = new JTextArea();
		JTextArea area = new JTextArea("Introduzca elementos separados por espacios\n en cada conjunto y seleccione una operacion");
		areaA.setBounds(0,0,240,190);
		areaB.setBounds(250,0,240,190);
		area.setBounds(0,410,500,200);
		
		frame.add(areaA);
		frame.add(areaB);
		frame.add(area);
		
	//Botones

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,2));
		panel1.setBounds(0,200,250,200);
		
		 
		String[] operacion = {"A","B","A ^ B","A u B","A-B","B-A"};
		JRadioButton[] operaciones =new JRadioButton[6];
		ButtonGroup op = new ButtonGroup();
		
		for(int i=0; i<6; i++)
		{
			operaciones[i] = new JRadioButton(operacion[i]);
			op.add(operaciones[i]);
			panel1.add(operaciones[i]);
		}
		frame.add(panel1);
		
	
	
	//Imagenes del diagrama
		JLabel diagrama = new JLabel(new ImageIcon(Conjuntos.class.getResource("/Tarea8_Diagrama.png")));	
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout());
		panel2.setBounds(250,200,250,200);
		panel2.add(diagrama);
		frame.add(panel2);
		

	//ActionListener Botones
		
		operaciones[0].addActionListener(new ActionListener()  //A
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
				//Imagen
				diagrama.setIcon(new ImageIcon(Conjuntos.class.getResource("/Tarea8_A.png")));
				
				String conjuntoA = areaA.getText();
				TreeSet<String> A = new TreeSet<>();
				String[] palabras_areaA = conjuntoA.split(" ");
				
				for(int i=0; i<palabras_areaA.length;i++)
				{
					A.add(palabras_areaA[i]);
				}

				//String conjunto_a = String.valueOf(A);
				String conjunto_a = A.toString();
				area.setText(conjunto_a);
			}
		});

		operaciones[1].addActionListener(new ActionListener()  //B
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
				//Imagen
				diagrama.setIcon(new ImageIcon(Conjuntos.class.getResource("/Tarea8_B.png")));
				
				
				String conjuntoB = areaB.getText();
				String[] palabras_areaB = conjuntoB.split(" ");
				TreeSet<String> B = new TreeSet<>();

				
				for(int i=0; i<palabras_areaB.length;i++)
				{
					B.add(palabras_areaB[i]);
				}

				String conjunto_b = B.toString();
				area.setText(conjunto_b);
			}
		});

		operaciones[2].addActionListener(new ActionListener()  //intersección A B
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
				//Imagen
				diagrama.setIcon(new ImageIcon(Conjuntos.class.getResource("/Tarea8_A_B.png")));
				
				String conjuntoA = areaA.getText();
				String[] palabras_areaA = conjuntoA.split(" ");
				TreeSet<String> A = new TreeSet<>();
				
				for(int i=0; i<palabras_areaA.length;i++)
				{
					A.add(palabras_areaA[i]);
				}	
				
				String conjuntoB = areaB.getText();
				String[] palabras_areaB = conjuntoB.split(" ");
				TreeSet<String> B = new TreeSet<>();

				for(int i=0; i<palabras_areaB.length;i++)
				{
					B.add(palabras_areaB[i]);
				}	
				
				TreeSet<String> inter = new TreeSet<>();
				inter.addAll(A);
				inter.retainAll(B);
				
				String interseccion = inter.toString();
				area.setText(interseccion);
				
				
			}
		});

		operaciones[3].addActionListener(new ActionListener()  
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
				//Imagen
				diagrama.setIcon(new ImageIcon(Conjuntos.class.getResource("/Tarea8_AuB.png")));
				
				String conjuntoA = areaA.getText();
				String[] palabras_areaA = conjuntoA.split(" ");
				TreeSet<String> A = new TreeSet<>();
				
				for(int i=0; i<palabras_areaA.length;i++)
				{
					A.add(palabras_areaA[i]);
				}	
				
				String conjuntoB = areaB.getText();
				String[] palabras_areaB = conjuntoB.split(" ");
				TreeSet<String> B = new TreeSet<>();

				for(int i=0; i<palabras_areaB.length;i++)
				{
					B.add(palabras_areaB[i]);
				}	
				
				TreeSet<String> un = new TreeSet<>();
				un.addAll(A);
				un.addAll(B);
				
				String union = un.toString();
				area.setText(union);
			}
		});

		operaciones[4].addActionListener(new ActionListener()  
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
				//Imagen
				diagrama.setIcon(new ImageIcon(Conjuntos.class.getResource("/Tarea8_A-B.png")));
				
				String conjuntoA = areaA.getText();
				String[] palabras_areaA = conjuntoA.split(" ");
				TreeSet<String> A = new TreeSet<>();
				
				for(int i=0; i<palabras_areaA.length;i++)
				{
					A.add(palabras_areaA[i]);
				}	
				
				String conjuntoB = areaB.getText();
				String[] palabras_areaB = conjuntoB.split(" ");
				TreeSet<String> B = new TreeSet<>();

				for(int i=0; i<palabras_areaB.length;i++)
				{
					B.add(palabras_areaB[i]);
				}	
				
				TreeSet<String> a_sin_b = new TreeSet<>();
				a_sin_b.addAll(A);
				a_sin_b.removeAll(B);
				
				String diferencia1 = a_sin_b.toString();
				area.setText(diferencia1);
			}
		});

		operaciones[5].addActionListener(new ActionListener()  
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
				//Imagen
				diagrama.setIcon(new ImageIcon(Conjuntos.class.getResource("/Tarea8_B-A.png")));
				
				String conjuntoA = areaA.getText();
				String[] palabras_areaA = conjuntoA.split(" ");
				TreeSet<String> A = new TreeSet<>();
				
				for(int i=0; i<palabras_areaA.length;i++)
				{
					A.add(palabras_areaA[i]);
				}	
				
				String conjuntoB = areaB.getText();
				String[] palabras_areaB = conjuntoB.split(" ");
				TreeSet<String> B = new TreeSet<>();

				for(int i=0; i<palabras_areaB.length;i++)
				{
					B.add(palabras_areaB[i]);
				}	
				
				TreeSet<String> b_sin_a = new TreeSet<>();
				b_sin_a.addAll(B);
				b_sin_a.removeAll(A);
				
				String diferencia2 = b_sin_a.toString();
				area.setText(diferencia2);
			}
		});


		frame.setVisible(true);	
	}
}