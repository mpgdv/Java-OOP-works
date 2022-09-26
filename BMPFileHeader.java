import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;






public class BMPFileHeader
{
	static JButton button = new JButton("Seleccionar archivo");
	static JLabel l1 = new JLabel("Tamano del archivo: ");
	static JLabel l2 = new JLabel("Anchura: ");
	static JLabel l3 = new JLabel("Altura: ");
	static JLabel l4 = new JLabel("Profundidad en bits: ");
	static JLabel l5 = new JLabel("Tamano de la imagen: ");
	static JLabel l6 = new JLabel();
	
	static JTextField tam_arc = new JTextField();
	static JTextField ancho = new JTextField();
	static JTextField alto = new JTextField();
	static JTextField prof = new JTextField();
	static JTextField tam_im = new JTextField();

	static File arch;
	
	public static void main(String args[])
	{
		


		JFrame f = new JFrame("Encabezado de BMP");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setLayout(new FlowLayout());
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();

		tam_arc.setEditable(false);
		ancho.setEditable(false);
		alto.setEditable(false);
		prof.setEditable(false);
		tam_im.setEditable(false);	
		
		f.add(p1);
		f.add(p2);
		f.add(p3);

		p1.add(button);
		p1.add(l6);
		p2.setLayout(new GridLayout(5,2,10,10));
		p2.add(l1);
		p2.add(tam_arc);
		p2.add(l2);
		p2.add(ancho);
		p2.add(l3);
		p2.add(alto);
		p2.add(l4);
		p2.add(prof);
		p2.add(l5);
		p2.add(tam_im);
		p3.add(l6);
		
		f.setSize(300,270);
		f.setResizable(false);
		
			
		button.addActionListener(new ActionListener()
		{
         		@Override
         		public void actionPerformed(ActionEvent e) 
				{
					JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
					fc.showOpenDialog(f);
					arch = fc.getSelectedFile();
					
					try
					{
					
						if(arch.getName().endsWith(".bmp")){
							
							RandomAccessFile in = new RandomAccessFile(arch,"r");
						
							in.seek(2);
							tam_arc.setText(""+conv(in.readInt())+" bytes");
							in.seek(18);
							ancho.setText(""+conv(in.readInt())+" pixeles");
							in.seek(22);
							alto.setText(""+conv(in.readInt())+" pixeles");
							in.seek(28);
							prof.setText(""+conv2(in.readUnsignedShort())+" bits por pixel");
							in.seek(34);
							tam_im.setText(""+conv(in.readInt()) + " bytes");
						
							l6.setText("");
						
							in.close();
						
						}else{
						 	l6.setText("Seleccione un archivo de tipo BMP por favor");
							l6.setForeground(Color.RED);
						 	tam_arc.setText("");
						 	ancho.setText("");
						 	alto.setText("");
						 	prof.setText("");
						 	tam_im.setText("");
						}
						
						
					}
					catch(Exception ex)
					{
						
					}
				}
			});
				
	f.setVisible(true);	
		
	}

	public static int conv(int i)
	{
	    return((i&0xff)<<24)+((i&0xff00)<<8)+((i&0xff0000)>>8)+((i>>24)&0xff);
	}	

	public static int conv2(int i)
	{
	    return((i&0xff)<<8)+((i>>8)&0xff);
	}


}




