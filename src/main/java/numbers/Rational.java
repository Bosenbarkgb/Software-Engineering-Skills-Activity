package numbers;

public class Rational
{
    private int numerator;
    private int denominator;

    // Default constructor
    public Rational() 
    {
        this.numerator = 0;
        this.denominator = 1;
    }
    
    // One param (numerator) constructor
    public Rational(int numerator)
    {
    	this.numerator = numerator;
    	this.denominator = 1;
    }
    
    // Two param (numerator, denominator) constructor
    public Rational(int numerator, int denominator)
    {
    	this.numerator = numerator;
    	this.denominator = denominator;
    }
    
    public int numerator() 
    {
    	   return 0;
    }

    public int denominator() 
    {
    	  return 1;
    }

    public int getNumerator() 
    {
        return numerator;
    }

    public int getDenominator() 
    {
        return denominator;
    }
}