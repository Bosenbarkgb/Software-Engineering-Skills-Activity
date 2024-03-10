package numbers;

import java.math.BigInteger;

public class Rational extends Number implements Comparable<Number> {

  private static final long serialVersionUID = 1L;
  private int numerator;
  private int denominator;

  /**
   * Constructs a {@code Rational} number with numerator 0 and denominator 1.
   */
  public Rational() {
    this(0, 1); // chaining with 2 param constructor
  }

  /**
   * Constructs a {@code Rational} number with the specified numerator and 1 as the denominator.
   *
   * @param numerator The numerator of the rational number.
   */
  public Rational(int numerator) {
    this(numerator, 1); // chaining with 2 param constructor
  }

  /**
   * Constructs a {@code Rational} number with the specified numerator and denominator. Automatically
   * simplifies the fraction and ensures the denominator is positive.
   *
   * @param numerator   The numerator of the rational number.
   * @param denominator The denominator of the rational number. Cannot be zero.
   * @throws IllegalArgumentException if the denominator is zero.
   */
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

  /**
   * Constructs a new {@code Rational} that is a copy of the specified {@code Rational}.
   *
   * @param original The {@code Rational} to copy.
   */
  public Rational(Rational original) {
    this.numerator = original.numerator;
    this.denominator = original.denominator;
  }

  /**
   * Returns the numerator of this rational number.
   *
   * @return The numerator.
   */
  public int getNumerator() {
    return numerator;
  }

  /**
   * Returns the denominator of this rational number.
   *
   * @return The denominator.
   */
  public int getDenominator() {
    return denominator;
  }

  /**
   * Calculates the greatest common divisor (GCD) of two integers. Uses the Euclidean algorithm.
   *
   * @param a The first integer.
   * @param b The second integer.
   * @return The GCD of {@code a} and {@code b}.
   */
  private static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  /**
   * Returns the integer part of the rational number
   */
  @Override
  public int intValue() {
    return numerator / denominator;
  }

  /**
   * Returns the long part of the rational number
   */
  @Override
  public long longValue() {
    return (long) numerator / denominator;
  }

  /**
   * Returns the float representation of the rational number
   */
  @Override
  public float floatValue() {
    return (float) numerator / denominator;
  }

  /**
   * Returns the double representation of the rational number
   */
  @Override
  public double doubleValue() {
    return (double) numerator / denominator;
  }

  /**
   * Compares the rational numer with another number
   */
  @Override
  public int compareTo(Number o) {
    double thisVal = this.doubleValue();
    double otherVal = o.doubleValue();
    return Double.compare(thisVal, otherVal);
  }

  /**
   * Returns the additive inverse of this rational number.
   *
   * @return A {@code Rational} representing the additive inverse.
   */
  public Rational opposite() {
    return new Rational(-this.numerator, this.denominator);
  }

  /**
   * Returns the multiplicative inverse (reciprocal) of this rational number.
   *
   * @return A {@code Rational} representing the reciprocal.
   * @throws IllegalArgumentException if the numerator is zero.
   */
  public Rational reciprocal() {
    if (this.numerator == 0) {
      throw new IllegalArgumentException("Can't get the reciprocal of 0");
    }
    return new Rational(this.denominator, this.numerator);
  }

  /**
   * Multiplies this rational number by another rational number.
   *
   * @param r The rational number to multiply by.
   * @return The product of this rational number and {@code r}.
   */
  public Rational times(Rational r) {
    return new Rational(
      this.numerator * r.numerator,
      this.denominator * r.denominator
    );
  }

  /**
   * Adds another rational number to this rational number.
   *
   * @param r The rational number to add.
   * @return The sum of this rational number and {@code r}.
   */
  public Rational plus(Rational r) {
    int newNumerator =
      this.numerator * r.denominator + r.numerator * this.denominator;
    int newDenominator = this.denominator * r.denominator;
    return new Rational(newNumerator, newDenominator);
  }

  /**
   * Subtracts another rational number from this rational number.
   *
   * @param r The rational number to subtract.
   * @return The difference between this rational number and {@code r}.
   */
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

  /**
   * Divides this rational number by another rational number.
   *
   * @param r The rational number to divide by.
   * @return The quotient of this rational number divided by {@code r}.
   * @throws IllegalArgumentException if {@code r} is zero.
   */
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

  /**
   * Raises this rational number to the power of {@code n}.
   *
   * @param n The exponent.
   * @return This rational number raised to the power of {@code n}.
   * @throws IllegalArgumentException if attempting to raise zero to a negative power.
   */
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

  // Logic to check equality of object
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

  /**
   * Checks if this rational number is greater than another number.
   *
   * @param n The number to compare against.
   * @return {@code true} if this is greater than {@code n}; {@code false} otherwise.
   */
  public boolean greaterThan(Number n) {
    return this.doubleValue() > n.doubleValue();
  }

  /**
   * Compares this rational number with another rational number to determine if this number is strictly greater.
   *
   * This method performs the comparison by converting both rational numbers to a common denominator and then comparing
   * their numerators. This approach avoids the need for floating-point arithmetic and preserves the accuracy of the comparison.
   *
   * @param r The rational number to compare against.
   * @return {@code true} if this rational number is strictly greater than {@code r}; {@code false} otherwise.
   */
  public boolean greaterThan(Rational r) {
    int thisNumerator = this.numerator * r.denominator;
    int rNumerator = r.numerator * this.denominator;

    return thisNumerator > rNumerator;
  }

  /**
   * Checks if this rational number is less than another rational number.
   *
   * @param r The rational number to compare against.
   * @return {@code true} if this is less than {@code r}; {@code false} otherwise.
   */
  public boolean lessThan(Rational r) {
    // Convert both rationals to a common denominator and compare numerators
    int thisNumerator = this.numerator * r.denominator;
    int rNumerator = r.numerator * this.denominator;

    return thisNumerator < rNumerator;
  }

  /**
   * Checks if this rational number is zero.
   *
   * @return {@code true} if this rational number is zero; {@code false} otherwise.
   */
  public boolean isZero() {
    return this.numerator == 0; // If the numerator is 0, the whole rational number is 0.
  }

  /**
   * Checks if this rational number is one.
   *
   * @return {@code true} if this rational number is one; {@code false} otherwise.
   */
  public boolean isOne() {
    return this.numerator == this.denominator && this.numerator != 0;
  }

  /**
   * Checks if this rational number is minus one.
   *
   * @return {@code true} if this rational number is minus one; {@code false} otherwise.
   */
  public boolean isMinusOne() {
    return this.numerator == -this.denominator && this.numerator != 0;
  }

  // Logic for representation as String
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
