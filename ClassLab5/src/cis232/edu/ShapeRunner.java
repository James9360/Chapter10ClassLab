package cis232.edu;

import java.io.*;
import java.util.Scanner;

public class ShapeRunner 
{
	public static void main(String[] args) throws IOException
	{
		FileOutputStream fis = new FileOutputStream ("shapes.dat", true);
		
		Scanner keyboard = new Scanner (System.in);
		boolean notNegative = true;
		
		int input = getInput(keyboard);

		while (true)
		{
			enterShape(keyboard, input, notNegative, fis);
			System.out.print ("\nWant to enter another shape?(Yes(0) No(1): ");
			int temp = keyboard.nextInt();
			if (temp == 1)
			{
				fis.close();
				break;
			}
			input = getInput(keyboard);
		}	
	}
	
	public static int getInput (Scanner keyboard)
	{	
		System.out.print("What shape do you want to find the area?"
				+ "\nRectangle(1)"
				+ "\nSquare(2) "
				+ "\nCircle(3)"
				+ "\nEnter choice: ");	
		int input = keyboard.nextInt();
		while (input < 1 || input > 3)
		{
			System.out.print("Please enter a valid choice: ");
			input = keyboard.nextInt();
		}
		
		return input;
	}
	
	public static Shape enterShape (Scanner keyboard, int input, boolean notNegative, FileOutputStream file) throws IOException
	{
		ObjectOutputStream data = new ObjectOutputStream (file);
		if (input == 1)
		{
			Rectangle r1 = null;
			double length, width;
			while (notNegative)
			{
				System.out.print("\nEnter the length: ");
				length = keyboard.nextDouble();
				System.out.print("Enter the width: ");
				width = keyboard.nextDouble();
				try
				{
					r1 = new Rectangle(length, width);
					System.out.printf("The area of the Rectangle is %.2f%n", r1.getArea());
					appendToFile (r1, data);
					notNegative = false;
				}
				catch (IllegalArgumentException e)
				{
					System.out.println ("Invalid input, please enter positive numbers");
					
				}		
			}
			return r1;
		}
		
		else if (input == 2)
		{
			Square s1 = null;
			double length;
			while (notNegative)
			{
				System.out.print("\nEnter the length: ");
				length = keyboard.nextDouble();
				try
				{
					s1 = new Square(length);
					System.out.printf("The area of the Square is %.2f%n", s1.getArea());
					appendToFile (s1, data);
					notNegative = false;
				}
				catch (IllegalArgumentException e)
				{
					System.out.println ("Invalid input, please enter positive numbers");
					
				}		
			}
			return s1;
		}
		
		else
		{
			Circle c1 = null;
			double radius;
			while (notNegative)
			{
				System.out.print("\nEnter the Radius: ");
				radius = keyboard.nextDouble();
				try
				{
					c1 = new Circle (radius);
					System.out.printf("The area of the Circle is %.2f%n", c1.getArea());
					appendToFile (c1, data);
					notNegative = false;
				}
				catch (IllegalArgumentException e)
				{
					System.out.println ("Invalid input, please enter positive numbers");
					
				}				
			}
			return c1;
		}
	}
	
	public static void appendToFile (Shape s1, ObjectOutputStream data) throws IOException
	{
		data.writeObject(s1);
	}
}
