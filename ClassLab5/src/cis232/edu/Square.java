package cis232.edu;

public class Square implements Shape
{
	private double length;
	
	public Square (double length)
	{
		if (length <= 0)
		{
			throw new IllegalArgumentException("Invalid input");
		}
		this.length = length;
	}
	
	public double getArea()
	{
		return Math.pow(length, 2);
	}
	
	public String toString ()
	{
		return String.format("The area of the Square is: %.2f", getArea());
	}
}
