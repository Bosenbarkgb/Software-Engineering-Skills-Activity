package numbers;

public class Rational extends Number implements Comparable<Number> {

  public static final long serialVersionUID = 1L;
  /**
   * Numerator for rational number
   */
  public int numerator;
  /**
   * Denominator for rational number
   */
  public int denominator;

  /**
   * Constructs a rational number representing 0/1.
   */
  public Rational() {
    this.numerator = 0;
    this.denominator = 1;
  }

  /**
   * Constructs a rational number representing a/1.
   *
   * @param a The numerator.
   */
  public Rational(int a) {
    this.numerator = a;
    this.denominator = 1;
  }

  /**
   * Constructs a rational number a/b in canonical form.
   * Canonical form ensures the negative sign, if any, is on the numerator and the fraction is in its simplest form.
   *
   * @param a The numerator.
   * @param b The denominator. Must not be zero.
   * @throws IllegalArgumentException If b is 0 or if the operation would result in an integer overflow.
   */
  public Rational(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException("Denominator cannot be zero.");
    }
    if (b < 0) {
      a = -a;
      b = -b;
    }
    int gcd = gcd(a, b);
    this.numerator = a / gcd;
    this.denominator = b / gcd;
  }

  /**
   * Constructs a new Rational object that is a copy of the specified Rational object.
   *
   * @param r The Rational object to copy.
   * @throws NullPointerException If the specified Rational object is null.
   */
  public Rational(Rational r) {
    if (r == null) {
      throw new NullPointerException("Rational object cannot be null.");
    }
    this.numerator = r.numerator;
    this.denominator = r.denominator;
  }

  /**
   * Computes the greatest common divisor of two integers.
   *
   * @param a An integer.
   * @param b Another integer.
   * @return The greatest common divisor of a and b.
   */
  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
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
   * Returns the value of the specified number as an int.
   * This may involve rounding or truncation.
   *
   * @return The numeric value represented by this object after conversion to type int.
   */
  @Override
  public int intValue() {
    return numerator / denominator;
  }

  /**
   * Returns the value of the specified number as a long.
   * This may involve rounding or truncation.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  @Override
  public long longValue() {
    return (long) numerator / denominator;
  }

  /**
   * Returns the value of the specified number as a float.
   * This may involve rounding.
   *
   * @return The numeric value represented by this object after conversion to type float.
   */
  @Override
  public float floatValue() {
    return (float) numerator / denominator;
  }

  /**
   * Returns the value of the specified number as a double.
   * This may involve rounding.
   *
   * @return The numeric value represented by this object after conversion to type double.
   */
  @Override
  public double doubleValue() {
    return (double) numerator / denominator;
  }

  /**
   * Compares this Rational with the specified Object for order.
   * Returns a negative integer, zero, or a positive integer as this Rational
   * is less than, equal to, or greater than the specified Object.
   *
   * @param o the Object to be compared.
   * @return A negative integer, zero, or a positive integer as this object
   *         is less than, equal to, or greater than the specified object.
   */
  @Override
  public int compareTo(Number o) {
    double thisVal = this.doubleValue();
    double otherVal = o.doubleValue();
    return Double.compare(thisVal, otherVal);
  }

  /**
   * Returns the additive inverse of this rational number.
   * The additive inverse of a/b is -a/b.
   *
   * @return A new Rational object that is the additive inverse of this Rational.
   * @throws IllegalArgumentException If the operation would cause an integer overflow.
   */
  public Rational opposite() {
    return new Rational(-numerator, denominator);
  }

  /**
   * Returns the multiplicative inverse (reciprocal) of this rational number.
   * The multiplicative inverse of a/b is b/a.
   *
   * @return A new Rational object that is the multiplicative inverse of this Rational.
   * @throws IllegalArgumentException If this value is 0 or if the operation would cause an integer overflow.
   */
  public Rational reciprocal() {
    if (numerator == 0) {
      throw new IllegalArgumentException("Cannot find reciprocal of 0.");
    }
    return new Rational(denominator, numerator);
  }

  /**
   * Returns a new Rational number which is the sum of this value and the specified Rational r.
   *
   * @param r The Rational number to add to this value.
   * @return A new Rational representing the sum of this value and r.
   */
  public Rational plus(Rational r) {
    int commonDenominator = this.denominator * r.denominator;
    int numeratorSum =
      this.numerator * r.denominator + r.numerator * this.denominator;
    return new Rational(numeratorSum, commonDenominator);
  }

  /**
   * Returns a new Rational number which is the difference between this value and the specified Rational r.
   *
   * @param r The Rational number to subtract from this value.
   * @return A new Rational representing the difference between this value and r.
   */
  public Rational minus(Rational r) {
    int commonDenominator = this.denominator * r.denominator;
    int numeratorDifference =
      this.numerator * r.denominator - r.numerator * this.denominator;
    return new Rational(numeratorDifference, commonDenominator);
  }

  /**
   * Returns a new Rational number which is the product of this value and the specified Rational r.
   *
   * @param r The Rational number to multiply by this value.
   * @return A new Rational representing the product of this value and r.
   */
  public Rational times(Rational r) {
    return new Rational(
      this.numerator * r.numerator,
      this.denominator * r.denominator
    );
  }

  /**
     * Returns a new Rational number which is the quotient of dividing this value by the specified Rational r.
     
     * @param r The Rational number by which to divide this value.
     * @return A new Rational representing the quotient of this value and r.
     * @throws IllegalArgumentException if r is 0.
     */
  public Rational dividedBy(Rational r) {
    if (r.numerator == 0) {
      throw new IllegalArgumentException("Cannot divide by Rational number 0.");
    }
    return new Rational(
      this.numerator * r.denominator,
      this.denominator * r.numerator
    );
  }

  /**
   * Returns a new Rational number which is this value raised to the power of n.
   *
   * @param n The exponent to which to raise this value.
   * @return A new Rational representing this value raised to the power of n.
   * @throws IllegalArgumentException If this value is 0 and n is negative or if the operation would cause an integer overflow.
   */
  public Rational raisedToThePowerOf(int n) {
    if (numerator == 0 && n < 0) {
      throw new IllegalArgumentException(
        "0 cannot be raised to a negative power."
      );
    }
    int newNumerator = (int) Math.pow(numerator, n);
    int newDenominator = (int) Math.pow(denominator, n);
    return new Rational(newNumerator, newDenominator);
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o The reference object with which to compare.
   * @return true if this object is the same as the o argument; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Number)) return false;

    if (o instanceof Rational) {
      Rational r = (Rational) o;
      return this.numerator * r.denominator == this.denominator * r.numerator;
    }

    double difference = Math.abs(
      this.doubleValue() - ((Number) o).doubleValue()
    );
    if (o instanceof Float || o instanceof Double) {
      return difference < Math.pow(2, -40);
    } else {
      return difference == 0;
    }
  }

  /**
   * Returns true if this value is strictly greater than the specified number n.
   *
   * @param n The number to compare with this value.
   * @return true if this value is greater than n; false otherwise.
   */
  public boolean greaterThan(Number n) {
    return Double.compare(this.doubleValue(), n.doubleValue()) > 0;
  }

  /**
   * Returns true if this value is strictly greater than the specified Rational r.
   *
   * @param r The Rational to compare with this value.
   * @return true if this value is greater than r; false otherwise.
   */
  public boolean greaterThan(Rational r) {
    return this.compareTo(r) > 0;
  }

  /**
   * Returns true if this value is strictly less than the specified number n.
   *
   * @param n The number to compare with this value.
   * @return true if this value is less than n; false otherwise.
   */
  public boolean lessThan(Number n) {
    return Double.compare(this.doubleValue(), n.doubleValue()) < 0;
  }

  /**
   * Returns true if this value is strictly less than the specified Rational .
   *
   * @param r The Rational to compare with this value.
   * @return true if this value is less than r; false otherwise.
   */
  public boolean lessThan(Rational r) {
    return this.compareTo(r) < 0;
  }

  /**
   * Checks if this Rational number is 0.
   *
   * @return true if this value is 0; false otherwise.
   */
  public boolean isZero() {
    return numerator == 0;
  }

  /**
   * Checks if this Rational number is 1 in its canonical form.
   *
   * @return true if this value is 1; false otherwise.
   */
  public boolean isOne() {
    return numerator == denominator;
  }

  /**
   * Checks if this Rational number is -1 in its canonical form.
   *
   * @return true if this value is -1; false otherwise.
   */
  public boolean isMinusOne() {
    return numerator == -1 && denominator == 1;
  }

  /**
   * Returns a string representation of this Rational number.
   * Whole numbers are represented without a denominator.
   *
   * @return A string representation of this value.
   */
  @Override
  public String toString() {
    if (denominator == 1) {
      return String.valueOf(numerator);
    } else {
      return numerator + "/" + denominator;
    }
  }
}
