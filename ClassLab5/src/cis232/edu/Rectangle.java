package cis232.edu;

import java.io.*;

public class Rectangle implements Shape
{
	private double length;
	private double width; 
	
	public Rectangle (double length, double width)
	{
		if (width <= 0 || length <= 0)
		{
			throw new IllegalArgumentException("Invalid input");
		}
		this.length = length;
		this.width = width;
	}
	
	public double getArea()
	{
		return length*width;
	}
	
	public String toString ()
	{
		return String.format("The area of the Rectangle is: %.2f", getArea());
	}
}
