package cis232.edu;

public class Circle implements Shape
{
	private double radius;
	
	public Circle (double radius)
	{
		if (radius <= 0)
		{
			throw new IllegalArgumentException("Invalid input");
		}
		this.radius = radius;
	}
	
	public double getArea()
	{
		return Math.PI * Math.pow(radius, 2);
	}
	
	public String toString ()
	{
		return String.format("The area of the Circle is: %.2f", getArea());
	}
}
