using System;

public class Program
{
	public static void Main()
	{
	Punkt punkt1 = new Punkt();
	Punkt punkt2 = new Punkt(100,100);
	
	Console.WriteLine("Punkt1: Wsp�rz�dna x= " +punkt1.PobierzX());
	Console.WriteLine("Punkt1: Wsp�rz�dna y= " +punkt1.PobierzY());
	Console.WriteLine("Punkt2: Wsp�rz�dna x= " +punkt2.PobierzX());
	Console.WriteLine("Punkt2: Wsp�rz�dna y= " +punkt2.PobierzY());
	}
}