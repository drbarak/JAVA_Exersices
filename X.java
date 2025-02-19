package ירושה;

public class X 
{
	public X()
	{
		this(0, 0);
		System.out.print("X1,");
	}
	public X(int num)
	{
		System.out.print("X2,");
	}
	public X(int num1, int num2)
	{
		System.out.print("X3,");
	}
}
/*
public class Y extends X
{
	public Y()
	{
		System.out.print("Y1,");
	}
	public Y(int num)
	{
		this(num, num);
		System.out.print("Y2,");
	}
	public Y(int num1, int num2)
	{
		super(num1, num2);
		System.out.print("Y3,");
	}
}
*/