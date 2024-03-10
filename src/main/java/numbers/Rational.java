package numbers;

public class Rational
{
    private int numerator;
    private int denominator;

    // Default constructor
    public Rational() 
    {
        this(0, 1); // chaining with 2 param constructor
    }
    
    // One param (numerator) constructor
    public Rational(int numerator)
    {
    	this(numerator, 1); // chaining with 2 param constructor
    }
    
    // Two param (numerator, denominator) constructor
    public Rational(int numerator, int denominator)
    {
    	if (denominator == 0) 
    	{
            throw new IllegalArgumentException("Denominator can't be zero.");
        }

        // Normalize the rational number if the denominator is negative
    	// Ensures that the rational number is always represented with a positive denominator
        if (denominator < 0) 
        {
            numerator = -numerator;
            denominator = -denominator;
        }

        // Simplify the fraction
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }
    
    public Rational(Rational original)
    {
    	this.numerator = original.numerator;
    	this.denominator = original.denominator;
    }

    public int getNumerator() 
    {
        return numerator;
    }

    public int getDenominator() 
    {
        return denominator;
    }
    
    // Helper method for Euclidean algorithm
    private static int gcd(int a, int b) 
    {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    public Rational opposite()
    {
    	return new Rational(-this.numerator, this.denominator);
    }
}