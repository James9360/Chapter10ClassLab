package cis232.edu;

import java.io.*;
import java.util.ArrayList;

public class ReadShapes 
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream("shapes.dat");
		ArrayList<Shape> shapeArray = new ArrayList<Shape>();
		boolean endOfFile = false;
		
		while (!endOfFile)
		{
			try 
			{
				ObjectInputStream input = new ObjectInputStream (fis);
				shapeArray.add((Shape)input.readObject());
			} 
			catch (ClassNotFoundException e) 
			{
				System.out.println("Tried to read a Shape but that class does not exist!");
				e.printStackTrace();
			}
			catch (EOFException e)
			{			
				endOfFile = true;
			}
			
		}
		for (Shape s : shapeArray)
		{
			System.out.println(s);
		}		
	}
}
