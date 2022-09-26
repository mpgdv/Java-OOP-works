import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Formatter;


public class TemperatureConverter
{
	static double conCel;
	static double conFah;
	static double conKel;
	static double conRan;

	public static void main(final String[] args)
	{
		final JFrame frame = new JFrame("Temperaturas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(380,250);

		final JLabel celsius = new JLabel("   Celsius");
		final JLabel fahrenheit = new JLabel("   Fahrenheit");
		final JLabel kelvin = new JLabel("   Kelvin");
		final JLabel rankine = new JLabel("   Rankine");

		JTextField cel = new JTextField();
		JTextField fah = new JTextField();
		JTextField kel = new JTextField();
		JTextField ran = new JTextField();

		frame.setLayout(new GridLayout(4, 2));
		frame.add(celsius);
		frame.add(cel);
		frame.add(fahrenheit);
		frame.add(fah);
		frame.add(kelvin);
		frame.add(kel);
		frame.add(rankine);
		frame.add(ran);



		cel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				try{

					TemperatureConverter.conCel = Double.parseDouble(cel.getText());
					//Convertir a fahrenheit
					fah.setText(String.format(" %.2f",((TemperatureConverter.conCel*(1.8))+32)));
					//Convertir a Kelvin
					kel.setText(String.format(" %.2f",(TemperatureConverter.conCel+273.15)));
					//Convertir a Rankine
					ran.setText(String.format(" %.2f",((TemperatureConverter.conCel*(1.8))+491.7)));
				}
				catch(NumberFormatException e1)
				{
					TemperatureConverter.conCel = 0;
				}
			}
		});


		fah.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				try{

					TemperatureConverter.conFah = Double.parseDouble(fah.getText());
					//Convertir a Celcius
					cel.setText(String.format(" %.2f",((TemperatureConverter.conFah - 32)*0.556))); //*
					//Convertir a Kelvin
					kel.setText(String.format(" %.2f",((TemperatureConverter.conFah-32)*0.556 + 273.15)));
					//Convertir a Rankine
					ran.setText(String.format(" %.2f",(TemperatureConverter.conFah + 459.7)));
				}
				catch(NumberFormatException e1)
				{
					TemperatureConverter.conFah = 0;
				}
			}
		});

		kel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				try{

					TemperatureConverter.conKel = Double.parseDouble(kel.getText());
					//Convertir a Celcius
					cel.setText(String.format(" %.2f",(TemperatureConverter.conKel - 273.15 )));
					//Convertir a Fahrenheit
					fah.setText(String.format(" %.2f",((TemperatureConverter.conKel - 273.15)*1.8 + 32)));
					//Convertir a Rankine
					ran.setText(String.format(" %.2f",((TemperatureConverter.conKel)*1.8)));
				}
				catch(NumberFormatException e1)
				{
					TemperatureConverter.conKel = 0;
				}
			}
		});

		ran.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				try{

					TemperatureConverter.conRan = Double.parseDouble(ran.getText());
					//Convertir a Celcius

					cel.setText(String.format(" %.2f",((TemperatureConverter.conRan - 491.67) * 0.556 )));
					//Convertir a Fahrenheit
					fah.setText(String.format(" %.2f",(TemperatureConverter.conRan - 459.67)));
					//Convertir a Kelvin
					kel.setText(String.format(" %.2f",((TemperatureConverter.conRan)*0.556)));
				}
				catch(NumberFormatException e1)
				{
					TemperatureConverter.conRan = 0;
				}
			}
		});

		frame.setVisible(true);

	}

}
