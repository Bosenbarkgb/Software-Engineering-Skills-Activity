package numbers;

import java.math.BigInteger;

public class Rational extends Number implements Comparable<Number> {

  private static final long serialVersionUID = 1L;
  private int numerator;
  private int denominator;

  // Default constructor
  public Rational() {
    this(0, 1); // chaining with 2 param constructor
  }

  // One param (numerator) constructor
  public Rational(int numerator) {
    this(numerator, 1); // chaining with 2 param constructor
  }

  // Two param (numerator, denominator) constructor
  public Rational(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator can't be zero.");
    }

    // Normalize the rational number if the denominator is negative
    // Ensures that the rational number is always represented with a positive denominator
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }

    // Simplify the fraction
    int gcd = gcd(numerator, denominator);
    this.numerator = numerator / gcd;
    this.denominator = denominator / gcd;
  }

  public Rational(Rational original) {
    this.numerator = original.numerator;
    this.denominator = original.denominator;
  }

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  // Helper method for Euclidean algorithm
  private static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  @Override
  public int intValue() {
    return numerator / denominator;
  }

  @Override
  public long longValue() {
    return (long) numerator / denominator;
  }

  @Override
  public float floatValue() {
    return (float) numerator / denominator;
  }

  @Override
  public double doubleValue() {
    return (double) numerator / denominator;
  }

  @Override
  public int compareTo(Number o) {
    double thisVal = this.doubleValue();
    double otherVal = o.doubleValue();
    return Double.compare(thisVal, otherVal);
  }

  public Rational opposite() {
    return new Rational(-this.numerator, this.denominator);
  }

  public Rational reciprocal() {
    if (this.numerator == 0) {
      throw new IllegalArgumentException("Can't get the reciprocal of 0");
    }
    return new Rational(this.denominator, this.numerator);
  }

  // multiplies the top and bottom values
  public Rational times(Rational r) {
    return new Rational(
      this.numerator * r.numerator,
      this.denominator * r.denominator
    );
  }

  public Rational plus(Rational r) {
    int newNumerator =
      this.numerator * r.denominator + r.numerator * this.denominator;
    int newDenominator = this.denominator * r.denominator;
    return new Rational(newNumerator, newDenominator);
  }

  public Rational minus(Rational r) {
    BigInteger aNumerator = BigInteger.valueOf(this.numerator);
    BigInteger aDenominator = BigInteger.valueOf(this.denominator);
    BigInteger bNumerator = BigInteger.valueOf(r.numerator);
    BigInteger bDenominator = BigInteger.valueOf(r.denominator);

    // Perform the operations using BigInteger
    BigInteger newNumerator = aNumerator
      .multiply(bDenominator)
      .subtract(aDenominator.multiply(bNumerator));
    BigInteger newDenominator = aDenominator.multiply(bDenominator);

    // Check for overflow when converting back to int
    if (
      newNumerator.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
      newNumerator.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0 ||
      newDenominator.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
      newDenominator.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
    ) {
      throw new IllegalArgumentException("Operation causes integer overflow");
    }

    // Calculate gcd of BigInteger values
    BigInteger gcd = newNumerator.gcd(newDenominator);
    newNumerator = newNumerator.divide(gcd);
    newDenominator = newDenominator.divide(gcd);

    // Convert BigInteger back to int
    return new Rational(newNumerator.intValue(), newDenominator.intValue());
  }

  public Rational dividesBy(Rational r) {
    // check for division by 0
    if (r.numerator == 0) {
      throw new IllegalArgumentException("Division by 0 is invalid");
    }

    // Multiply by reciprocal of r
    return new Rational(
      this.numerator * r.denominator,
      this.denominator * r.numerator
    );
  }

  public Rational raisedToThePowerOf(int n) {
    if (this.numerator == 0 && n < 0) {
      throw new IllegalArgumentException("Can't raise 0 to a negative power");
    }

    // Handling negative powers by using the reciprocal
    if (n < 0) {
      // Swap numerator and denominator for reciprocal
      int newNumerator = (int) Math.pow(this.denominator, -n); // Raising to -n makes it positive
      int newDenominator = (int) Math.pow(this.numerator, -n);
      return new Rational(newNumerator, newDenominator);
    } else {
      int newNumerator = (int) Math.pow(this.numerator, n);
      int newDenominator = (int) Math.pow(this.denominator, n);
      return new Rational(newNumerator, newDenominator);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (o instanceof Rational) {
      Rational other = (Rational) o;
      return (
        this.numerator == other.numerator &&
        this.denominator == other.denominator
      );
    } else if (o instanceof Float) {
      float difference = Math.abs(this.floatValue() - (Float) o);
      return difference < Math.pow(2, -20);
    } else if (o instanceof Double) {
      double difference = Math.abs(this.doubleValue() - (Double) o);
      return difference < Math.pow(2, -40);
    }
    return false;
  }

  public boolean greaterThan(Number n) {
    return this.doubleValue() > n.doubleValue();
  }

  public boolean greaterThan(Rational r) {
    int thisNumerator = this.numerator * r.denominator;
    int rNumerator = r.numerator * this.denominator;

    return thisNumerator > rNumerator;
  }

  public boolean lessThan(Rational r) {
    // Convert both rationals to a common denominator and compare numerators
    int thisNumerator = this.numerator * r.denominator;
    int rNumerator = r.numerator * this.denominator;

    return thisNumerator < rNumerator;
  }

  public boolean isZero() {
    return this.numerator == 0; // If the numerator is 0, the whole rational number is 0.
  }

  public boolean isOne() {
    return this.numerator == this.denominator && this.numerator != 0;
  }

  public boolean isMinusOne() {
    return this.numerator == -this.denominator && this.numerator != 0;
  }

  public String toString() {
    // Ensure the negative sign is always in the numerator for representation
    if (denominator < 0) {
      return (-numerator) + "/" + (-denominator); // Correct the sign placement
    } else if (denominator == 1) {
      return String.valueOf(numerator); // Whole number representation
    } else {
      return numerator + "/" + denominator; // Standard fraction representation
    }
  }
}
