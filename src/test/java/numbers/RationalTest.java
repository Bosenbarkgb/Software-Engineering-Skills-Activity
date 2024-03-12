package numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RationalTest {

  /**
   * Tests the {@link Rational#gcd(int, int)} method for accuracy in calculating the greatest common divisor (GCD).
   * The test cases cover various scenarios, including:
   * - Testing the GCD of two identical numbers.
   * - Testing the GCD of numbers where one is a divisor of the other.
   * - Testing the GCD where one of the numbers is 0, which should return the absolute value of the other number.
   * - Testing the GCD with a negative number, expecting a positive GCD as the result, since GCD is always positive or 0.
   */
  @Test
  void testGcd() {
    // Arrange, Act and Assert
    assertEquals(3, Rational.gcd(3, 3));
    assertEquals(1, Rational.gcd(1, 3));
    assertEquals(3, Rational.gcd(0, 3));
    assertEquals(-1, Rational.gcd(-1, 3));
  }

  /**
   * Tests the {@link Rational#intValue()} method to ensure it
   * correctly returns the integer value of a Rational number.
   * This test verifies the method's ability to convert a simple
   * rational number (where the denominator is 1) directly to its integer equivalent.
   */
  @Test
  void testIntValue() {
    // Arrange, Act and Assert
    assertEquals(1, (new Rational(1)).intValue());
  }

  /**
   * Tests the {@link Rational#intValue()} method to verify that it
   * throws an {@link ArithmeticException} when attempting to convert a Rational number
   * with a denominator of 0 to an integer.
   * This scenario simulates a division by zero situation,
   * which is undefined in mathematics and should result in an exception.
   */
  @Test
  void testIntValue2() {
    // Arrange
    Rational rational = new Rational(1);
    rational.denominator = 0;

    // Act and Assert
    assertThrows(ArithmeticException.class, () -> rational.intValue());
  }

  /**
   * Tests the {@link Rational#longValue()} method to ensure it
   * accurately converts a Rational number to a long.
   */
  @Test
  void testLongValue() {
    // Arrange, Act and Assert
    assertEquals(Rational.serialVersionUID, (new Rational(1)).longValue());
  }

  /**
   * Tests the {@link Rational#longValue()} method to verify that it
   * throws an {@link ArithmeticException} when converting a Rational number
   * with a denominator of 0 to a long. This scenario tests how the method
   * handles division by zero situations, which are mathematically undefined and should lead to an exception.
   */
  @Test
  void testLongValue2() {
    // Arrange
    Rational rational = new Rational(1);
    rational.denominator = 0;

    // Act and Assert
    assertThrows(ArithmeticException.class, () -> rational.longValue());
  }

  /**
   * Tests the {@link Rational#floatValue()} method to ensure it
   * correctly converts a Rational number to a float.
   * This test verifies the conversion of a simple rational number (1/1)
   * to its floating-point representation, expecting an exact match.
   */
  @Test
  void testFloatValue() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new Rational(1)).floatValue());
  }

  /**
   * Tests the {@link Rational#doubleValue()} method to ensure it accurately converts
   * a Rational number to a double.
   * This test checks the conversion of a straightforward rational number (1/1) to its
   * double-precision floating-point representation, expecting a precise match.
   */
  @Test
  void testDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(1.0d, (new Rational(1)).doubleValue());
  }

  /**
   * Tests the {@link Rational#compareTo(Number)} method to verify its ability to
   * correctly compare a Rational object with an @code Integer object.
   * This test ensures that a Rational object representing the number 1
   * correctly identifies as equal to an @code Integer object also representing the number 1.
   */
  @Test
  void testCompareTo() {
    // Arrange
    Rational rational = new Rational(1);

    // Act and Assert
    assertEquals(0, rational.compareTo(Integer.valueOf(1)));
  }

  /**
   * Tests the {@link Rational#compareTo(Number)} method to confirm that a
   * Rational object correctly compares to another Rational object representing the same value.
   * This test checks if two Rational objects, both representing the number 1,
   * are considered equal by the comparison.
   */
  @Test
  void testCompareTo3() {
    // Arrange
    Rational rational = new Rational(1);

    // Act and Assert
    assertEquals(0, rational.compareTo(new Rational(1)));
  }

  /**
   * Tests the {@link Rational#opposite()} method to ensure it correctly
   * calculates the additive inverse of a rational number.
   * This test verifies that the opposite of 1/1 is correctly determined to be -1/1.
   */
  @Test
  void testOpposite() {
    // Arrange and Act
    Rational actualOppositeResult = (new Rational(1)).opposite();

    // Assert
    assertEquals(-1, actualOppositeResult.getNumerator());
    assertEquals(1, actualOppositeResult.getDenominator());
  }

  /**
   * Tests the {@link Rational#opposite()} method for handling edge cases,
   * specifically the use of Integer.MIN_VALUE as the denominator.
   * This test verifies the method's ability to correctly negate a
   * rational number with a large negative denominator without altering its magnitude.
   */
  @Test
  void testOpposite2() {
    // Arrange and Act
    Rational actualOppositeResult =
      (new Rational(1, Integer.MIN_VALUE)).opposite();

    // Assert
    assertEquals(1, actualOppositeResult.getNumerator());
    assertEquals(Integer.MIN_VALUE, actualOppositeResult.getDenominator());
  }

  /**
   * Tests the {@link Rational#opposite()} method to ensure it correctly
   * handles situations where the rational number's denominator is zero,
   * simulating an invalid rational number and expecting an {@link IllegalArgumentException} to be thrown.
   */
  @Test
  void testOpposite3() {
    // Arrange
    Rational rational = new Rational(1);
    rational.denominator = 0;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rational.opposite());
  }

  /**
   * Tests the {@link Rational#reciprocal()} method to verify it correctly computes
   * the multiplicative inverse of a rational number.
   * This test confirms that the reciprocal of 1/1 is accurately determined to be 1/1,
   * maintaining the identity property of multiplicative inverses.
   */
  @Test
  void testReciprocal() {
    // Arrange and Act
    Rational actualReciprocalResult = (new Rational(1)).reciprocal();

    // Assert
    assertEquals(1, actualReciprocalResult.getDenominator());
    assertEquals(1, actualReciprocalResult.getNumerator());
  }

  /**
   * Tests the {@link Rational#reciprocal()} method to verify it
   * throws an {@link IllegalArgumentException} when called on a rational number representing 0.
   * This test ensures the method correctly handles the case where calculating the reciprocal of 0,
   * which is mathematically undefined.
   */
  @Test
  void testReciprocal2() {
    // Arrange, Act and Assert
    assertThrows(
      IllegalArgumentException.class,
      () -> (new Rational(0)).reciprocal()
    );
  }

  /**
   * Tests the {@link Rational#reciprocal()} method to ensure it correctly
   * calculates the reciprocal of a negative rational number.
   * This test verifies the reciprocal of -1 is accurately calculated as -1,
   * demonstrating the method's handling of negative values.
   */
  @Test
  void testReciprocal3() {
    // Arrange and Act
    Rational actualReciprocalResult = (new Rational(-1)).reciprocal();

    // Assert
    assertEquals(-1, actualReciprocalResult.getNumerator());
    assertEquals(1, actualReciprocalResult.getDenominator());
  }

  /**
   * Tests the {@link Rational#plus(Rational)} method to ensure it
   * correctly calculates the sum of two rational numbers.
   * This test confirms that adding 1 to 1 results in a rational number equivalent to 2.
   */
  @Test
  void testPlus() {
    // Arrange
    Rational rational = new Rational(1);

    // Act
    Rational actualPlusResult = rational.plus(new Rational(1));

    // Assert
    assertEquals(1, actualPlusResult.getDenominator());
    assertEquals(2, actualPlusResult.getNumerator());
  }

  /**
   * Tests the {@link Rational#plus(Rational)} method with a denominator of
   * Integer.MIN_VALUE to verify how it handles addition under extreme conditions.
   * This test examines the behavior when adding a rational number with a
   * very large denominator, focusing on edge case handling.
   */
  @Test
  void testPlus3() {
    // Arrange
    Rational rational = new Rational(1, Integer.MIN_VALUE);

    // Act
    Rational actualPlusResult = rational.plus(new Rational(1));

    // Assert
    assertEquals(-2147483647, actualPlusResult.getNumerator());
    assertEquals(Integer.MIN_VALUE, actualPlusResult.getDenominator());
  }

  /**
   * Tests the {@link Rational#plus(Rational)} method for potential overflow
   * or illegal argument situations by adding two rational numbers with extreme denominators.
   * This test aims to ensure robust error handling when addition might lead to invalid or undefined states.
   */
  @Test
  void testPlus4() {
    // Arrange
    Rational rational = new Rational(1, Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(
      IllegalArgumentException.class,
      () -> rational.plus(new Rational(1, Integer.MIN_VALUE))
    );
  }

  /**
   * Tests the {@link Rational#minus(Rational)} method to ensure it
   * correctly calculates the difference between two rational numbers.
   * This test confirms that subtracting 1 from 1 results in a rational number equivalent to 0.
   */
  @Test
  void testMinus() {
    // Arrange
    Rational rational = new Rational(1);

    // Act
    Rational actualMinusResult = rational.minus(new Rational(1));

    // Assert
    assertEquals(0, actualMinusResult.getNumerator());
    assertEquals(1, actualMinusResult.getDenominator());
  }

  /**
   * Tests the {@link Rational#minus(Rational)} method to ensure it
   * correctly calculates the difference between two rational numbers,
   * especially under extreme conditions such as using Integer.MIN_VALUE as a denominator.
   * This test checks the subtraction result for a rational number
   * with a very large negative denominator, verifying accurate arithmetic handling.
   */
  @Test
  void testMinus3() {
    // Arrange
    Rational rational = new Rational(1, Integer.MIN_VALUE);

    // Act
    Rational actualMinusResult = rational.minus(new Rational(1));

    // Assert
    assertEquals(-2147483647, actualMinusResult.getNumerator());
    assertEquals(Integer.MIN_VALUE, actualMinusResult.getDenominator());
  }

  /**
   * Tests the {@link Rational#minus(Rational)} method to verify it
   * throws an {@link IllegalArgumentException} when subtraction could result in an invalid state,
   * such as underflow or overflow conditions, specifically
   * when both operands involve Integer.MIN_VALUE as a denominator.
   */
  @Test
  void testMinus4() {
    // Arrange
    Rational rational = new Rational(1, Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(
      IllegalArgumentException.class,
      () -> rational.minus(new Rational(1, Integer.MIN_VALUE))
    );
  }

  /**
   * Tests the {@link Rational#times(Rational)} method to ensure it
   * correctly calculates the product of two rational numbers,
   * confirming that multiplying two rational numbers representing 1 results in 1.
   */
  @Test
  void testTimes() {
    // Arrange
    Rational rational = new Rational(1);

    // Act
    Rational actualTimesResult = rational.times(new Rational(1));

    // Assert
    assertEquals(1, actualTimesResult.getDenominator());
    assertEquals(1, actualTimesResult.getNumerator());
  }

  /**
   * Tests the {@link Rational#times(Rational)} method to examine
   * multiplication involving a rational number with an extreme denominator,
   * such as Integer.MIN_VALUE. This test ensures the class
   * correctly handles such extreme cases without error.
   */
  @Test
  void testTimes3() {
    // Arrange
    Rational rational = new Rational(1, Integer.MIN_VALUE);

    // Act
    Rational actualTimesResult = rational.times(new Rational(1));

    // Assert
    assertEquals(1, actualTimesResult.getNumerator());
    assertEquals(Integer.MIN_VALUE, actualTimesResult.getDenominator());
  }

  /**
   * Tests the {@link Rational#times(Rational)} method for robustness by verifying
   * it throws an {@link IllegalArgumentException} when multiplication involves
   * two rational numbers with Integer.MIN_VALUE as denominators,
   * potentially leading to arithmetic issues.
   */
  @Test
  void testTimes4() {
    // Arrange
    Rational rational = new Rational(1, Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(
      IllegalArgumentException.class,
      () -> rational.times(new Rational(1, Integer.MIN_VALUE))
    );
  }

  /**
   * Tests the {@link Rational#dividedBy(Rational)} method to ensure it correctly
   * calculates the quotient of dividing two rational numbers representing 1,
   * confirming that the operation results in a rational number equivalent to 1.
   */
  @Test
  void testDividedBy() {
    // Arrange
    Rational rational = new Rational(1);

    // Act
    Rational actualDividedByResult = rational.dividedBy(new Rational(1));

    // Assert
    assertEquals(1, actualDividedByResult.getDenominator());
    assertEquals(1, actualDividedByResult.getNumerator());
  }

  /**
   * Tests the {@link Rational#dividedBy(Rational)} method to verify it
   * throws an {@link IllegalArgumentException} when attempting to divide
   * by a rational number representing 0, which simulates a division by zero scenario.
   */
  @Test
  void testDividedBy2() {
    // Arrange
    Rational rational = new Rational(1);

    // Act and Assert
    assertThrows(
      IllegalArgumentException.class,
      () -> rational.dividedBy(new Rational(0))
    );
  }

  /**
   * Tests the {@link Rational#dividedBy(Rational)} method to ensure it correctly
   * calculates the quotient when dividing by a negative rational number,
   * specifically testing division by -1 to confirm the resulting rational number
   * is the negative inverse of the original.
   */
  @Test
  void testDividedBy3() {
    // Arrange
    Rational rational = new Rational(1);

    // Act
    Rational actualDividedByResult = rational.dividedBy(new Rational(-1));

    // Assert
    assertEquals(-1, actualDividedByResult.getNumerator());
    assertEquals(1, actualDividedByResult.getDenominator());
  }

  /**
   * Tests the {@link Rational#dividedBy(Rational)} method for its error handling when
   * the denominator of the rational number to be divided is set to 0,
   * aiming to confirm correct exception throwing for operations on invalid rational numbers.
   */
  @Test
  void testDividedBy5() {
    // Arrange
    Rational rational = new Rational(1);
    rational.denominator = 0;

    // Act and Assert
    assertThrows(
      IllegalArgumentException.class,
      () -> rational.dividedBy(new Rational(1))
    );
  }

  /**
   * Tests the {@link Rational#raisedToThePowerOf(int)} method to verify its capability to
   * accurately raise a rational number to a given power.
   * This test confirms that raising a rational number representing 1 to the power of 1 results
   * in a rational number equivalent to 1/1.
   */
  @Test
  void testRaisedToThePowerOf() {
    // Arrange and Act
    Rational actualRaisedToThePowerOfResult =
      (new Rational(1)).raisedToThePowerOf(1);

    // Assert
    assertEquals(1, actualRaisedToThePowerOfResult.getDenominator());
    assertEquals(1, actualRaisedToThePowerOfResult.getNumerator());
  }

  /**
   * Tests the {@link Rational#raisedToThePowerOf(int)} method to ensure it
   * correctly handles raising zero to any positive power,
   * confirming that the result is a rational number equivalent to 0/1.
   */
  @Test
  void testRaisedToThePowerOf2() {
    // Arrange and Act
    Rational actualRaisedToThePowerOfResult =
      (new Rational(0)).raisedToThePowerOf(1);

    // Assert
    assertEquals(0, actualRaisedToThePowerOfResult.getNumerator());
    assertEquals(1, actualRaisedToThePowerOfResult.getDenominator());
  }

  /**
   * Tests the {@link Rational#raisedToThePowerOf(int)} method for error handling
   * when attempting to raise zero to a negative power,
   * verifying it throws an {@link IllegalArgumentException}
   * as the operation is mathematically undefined.
   */
  @Test
  void testRaisedToThePowerOf3() {
    // Arrange, Act and Assert
    assertThrows(
      IllegalArgumentException.class,
      () -> (new Rational(0)).raisedToThePowerOf(-1)
    );
  }

  /**
   * Tests the {@link Rational#raisedToThePowerOf(int)} method to examine
   * its behavior when applied to a rational number with a large negative denominator,
   * ensuring the operation accurately maintains the number's value when raised to the power of 1.
   */
  @Test
  void testRaisedToThePowerOf4() {
    // Arrange and Act
    Rational actualRaisedToThePowerOfResult =
      (new Rational(1, Integer.MIN_VALUE)).raisedToThePowerOf(1);

    // Assert
    assertEquals(1, actualRaisedToThePowerOfResult.getNumerator());
    assertEquals(
      Integer.MIN_VALUE,
      actualRaisedToThePowerOfResult.getDenominator()
    );
  }

  /**
   * Tests the {@link Rational#raisedToThePowerOf(int)} method to verify it handles
   * extreme power values correctly, specifically testing raising a rational number
   * to the power of Integer.MIN_VALUE and expecting an exception
   * due to potential overflow or other mathematical constraints.
   */
  @Test
  void testRaisedToThePowerOf5() {
    // Arrange, Act and Assert
    assertThrows(
      IllegalArgumentException.class,
      () ->
        (new Rational(1, Integer.MIN_VALUE)).raisedToThePowerOf(
            Integer.MIN_VALUE
          )
    );
  }

  /**
   * Tests the {@link Rational#equals(Object)} method to confirm that a
   *  rational number is considered equal to itself, demonstrating reflexivity.
   */
  @Test
  void testEqualsSelf() {
    Rational rational = new Rational(1, 2);
    assertTrue(
      rational.equals(rational),
      "A rational number should be equal to itself."
    );
  }

  /**
   * Tests the {@link Rational#equals(Object)} method to ensure it correctly
   * identifies objects of different types as not equal to a rational number,
   * demonstrating type specificity in equality checks.
   */
  @Test
  void testEqualsDifferentType() {
    Rational rational = new Rational(1, 2);
    String nonRationalObject = "Not a rational number";
    assertFalse(
      rational.equals(nonRationalObject),
      "A rational number should not equal an object of a different type."
    );
  }

  /**
   * Tests the {@link Rational#equals(Object)} method to verify that
   * two rational numbers representing the same mathematical value are considered equal,
   * regardless of their internal numerator and denominator representation.
   */
  @Test
  void testEqualsEqualRationals() {
    Rational rational1 = new Rational(1, 2);
    Rational rational2 = new Rational(2, 4);
    assertTrue(
      rational1.equals(rational2),
      "Two rational numbers with the same value should be equal."
    );
  }

  /**
   * Tests the {@link Rational#equals(Object)} method to confirm that two
   * rational numbers with different values are correctly identified as not equal.
   */
  @Test
  void testEqualsDifferentRationals() {
    Rational rational1 = new Rational(1, 2);
    Rational rational2 = new Rational(2, 5);
    assertFalse(
      rational1.equals(rational2),
      "Two rational numbers with different values should not be equal."
    );
  }

  /**
   * Tests the {@link Rational#equals(Object)} method for its handling of comparisons
   *  between rational numbers and floating-point numbers, focusing on precision thresholds for equality checks.
   */
  @Test
  void testEqualsWithFloat() {
    Rational rational = new Rational(1, 2);
    Float closeEnoughFloat = 0.5f; // Within the precision threshold
    assertTrue(
      rational.equals(closeEnoughFloat),
      "A rational number should be considered equal to a float if the difference is within the floating-point precision threshold."
    );

    Float tooFarFloat = 0.51f; // Outside the precision threshold
    assertFalse(
      rational.equals(tooFarFloat),
      "A rational number should not be equal to a float if the difference is outside the floating-point precision threshold."
    );
  }

  /**
   * Tests the {@link Rational#equals(Object)} method with a {@link Double}
   * to ensure it accurately identifies equality between a rational number and a double-precision floating-point number.
   * This includes testing for an exact match and verifying that slight differences
   * outside the precision threshold result in non-equality.
   */
  @Test
  void testEqualsWithDouble() {
    Rational rational = new Rational(2, 3);
    Double exactDouble = 2.0 / 3; // Exact match
    assertTrue(
      rational.equals(exactDouble),
      "A rational number should be equal to a double if exactly matching."
    );

    Double tooFarDouble = 0.67; // Outside the precision threshold
    assertFalse(
      rational.equals(tooFarDouble),
      "A rational number should not be equal to a double if the difference is outside the floating-point precision threshold."
    );
  }

  /**
   * Tests the {@link Rational#equals(Object)} method with an {@link Integer} to verify that a
   * rational number is correctly identified as equal to an integer when their mathematical values match exactly.
   */
  @Test
  void testEqualsWithInteger() {
    Rational rational = new Rational(1, 1);
    Integer one = 1;
    assertTrue(
      rational.equals(one),
      "A rational number should be equal to an Integer if exactly matching."
    );
  }

  /**
   * Tests the {@link Rational#greaterThan(Number)} method to ensure it correctly identifies
   * that a rational number is not greater than an equivalent integer representation.
   */
  @Test
  void testGreaterThan() {
    // Arrange
    Rational rational = new Rational(1);

    // Act and Assert
    assertFalse(rational.greaterThan(Integer.valueOf(1)));
  }

  /**
   * Tests the {@link Rational#greaterThan(Number)} method to verify that a rational number
   * is correctly identified as greater than a lesser integer value.
   */
  @Test
  void testGreaterThan2() {
    // Arrange
    Rational rational = new Rational(1);

    // Act and Assert
    assertTrue(rational.greaterThan(Integer.valueOf(0)));
  }

  /**
   * Tests the {@link Rational#greaterThan(Number)} method to confirm that a rational number
   * is not considered greater than an equivalent rational number.
   */
  @Test
  void testGreaterThan4() {
    // Arrange
    Rational rational = new Rational(1);

    // Act and Assert
    assertFalse(rational.greaterThan((Number) new Rational(1)));
  }

  /**
   * Tests the {@link Rational#greaterThan(Rational)} method to ensure it correctly
   * identifies that a rational number is not greater than an equivalent rational number.
   */
  @Test
  void testGreaterThan5() {
    // Arrange
    Rational rational = new Rational(1);

    // Act and Assert
    assertFalse(rational.greaterThan(new Rational(1)));
  }

  /**
   * Tests the {@link Rational#greaterThan(Rational)} method to verify that a
   * rational number is accurately identified as greater than a lesser rational number.
   */
  @Test
  void testGreaterThan6() {
    // Arrange
    Rational rational = new Rational(1);

    // Act and Assert
    assertTrue(rational.greaterThan(new Rational(0)));
  }

  /**
   * Tests the {@link Rational#lessThan(Number)} method to verify it accurately
   * determines when a rational number is not less than an equivalent integer value.
   */
  @Test
  void testLessThan() {
    // Arrange
    Rational rational = new Rational(1);

    // Act and Assert
    assertFalse(rational.lessThan(Integer.valueOf(1)));
  }

  /**
   * Tests the {@link Rational#lessThan(Number)} method to ensure it
   * correctly identifies when a rational number is less than a greater integer value.
   */
  @Test
  void testLessThan2() {
    // Arrange
    Rational rational = new Rational(0);

    // Act and Assert
    assertTrue(rational.lessThan(Integer.valueOf(1)));
  }

  /**
   * Tests the {@link Rational#lessThan(Number)} method for comparing a rational number
   * against an equivalent rational number, expecting a result of false.
   */
  @Test
  void testLessThan4() {
    // Arrange
    Rational rational = new Rational(1);

    // Act and Assert
    assertFalse(rational.lessThan((Number) new Rational(1)));
  }

  /**
   * Tests the {@link Rational#lessThan(Rational)} method for comparing a rational number
   * against an equivalent rational number using the specific rational comparison.
   */
  @Test
  void testLessThan5() {
    // Arrange
    Rational rational = new Rational(1);

    // Act and Assert
    assertFalse(rational.lessThan(new Rational(1)));
  }

  /**
   * Tests the {@link Rational#lessThan(Rational)} method to ensure it correctly identifies
   * when a rational number is less than a greater rational number.
   */
  @Test
  void testLessThan6() {
    // Arrange
    Rational rational = new Rational(0);

    // Act and Assert
    assertTrue(rational.lessThan(new Rational(1)));
  }

  /**
   * Tests the {@link Rational#isZero()} method to confirm it correctly identifies
   * a non-zero rational number as not being zero.
   */
  @Test
  void testIsZero() {
    // Arrange, Act and Assert
    assertFalse((new Rational(1)).isZero());
  }

  /**
   * Tests the {@link Rational#isZero()} method to confirm it correctly identifies
   * a non-zero rational number as not being zero.
   */
  @Test
  void testIsZero2() {
    // Arrange
    Rational rational = new Rational(1);
    rational.numerator = 0;

    // Act and Assert
    assertTrue(rational.isZero());
  }

  /**
   * Tests the {@link Rational#isOne()} method to confirm it correctly identifies
   * when a rational number represents one and when it does not.
   */
  @Test
  void testIsOne() {
    // Arrange, Act and Assert
    assertTrue((new Rational(1)).isOne());
    assertFalse((new Rational(0)).isOne());
  }

  /**
   * Tests the {@link Rational#isMinusOne()} method to verify it accurately
   * identifies a rational number representing -1.
   */
  @Test
  void testIsMinusOne() {
    // Arrange, Act and Assert
    assertFalse((new Rational(1)).isMinusOne());
  }

  /**
   * Tests the {@link Rational#isMinusOne()} method to ensure it recognizes a
   * rational number with a numerator of -1 and a denominator of 1 as representing -1.
   */
  @Test
  void testIsMinusOne2() {
    // Arrange
    Rational rational = new Rational(1);
    rational.numerator = -1;
    rational.denominator = 1;

    // Act and Assert
    assertTrue(rational.isMinusOne());
  }

  /**
   * Tests the {@link Rational#isMinusOne()} method to confirm it does not
   * mistakenly identify a rational number with a numerator of -1 and a
   * denominator of -1 as representing -1.
   */
  @Test
  void testIsMinusOne3() {
    // Arrange
    Rational rational = new Rational(1);
    rational.numerator = -1;
    rational.denominator = -1;

    // Act and Assert
    assertFalse(rational.isMinusOne());
  }

  /**
   * Tests the {@link Rational#toString()} method to verify its ability to
   * correctly convert rational numbers to their string representation.
   * This includes testing for simple cases and handling of negative denominators,
   * ensuring the output format adheres to mathematical notation.
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("1", (new Rational(1)).toString());
    assertEquals(
      "1/-2147483648",
      (new Rational(1, Integer.MIN_VALUE)).toString()
    );
  }

  /**
   * Tests the default constructor of {@link Rational},
   * along with the getters for {@link Rational#getNumerator()}
   * and {@link Rational#getDenominator()}, to ensure the rational number is initialized to 0/1.
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Rational actualRational = new Rational();
    int actualDenominator = actualRational.getDenominator();

    // Assert
    assertEquals(0, actualRational.getNumerator());
    assertEquals(1, actualDenominator);
  }

  /**
   * Tests the constructor of {@link Rational} that takes a single integer argument,
   * along with {@link Rational#getDenominator()} and, {@link Rational#getNumerator()}
   * to ensure the rational number is initialized correctly as the integer over 1.
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    Rational actualRational = new Rational(1);
    int actualDenominator = actualRational.getDenominator();

    // Assert
    assertEquals(1, actualDenominator);
    assertEquals(1, actualRational.getNumerator());
  }

  /**
   * Verifies that the constructor {@link Rational#Rational(int, int)}
   * correctly reduces the fraction to its simplest form when numerator and denominator are equal.
   */
  @Test
  void testNewRational() {
    // Arrange and Act
    Rational actualRational = new Rational(3, 3);

    // Assert
    assertEquals(1, actualRational.getDenominator());
    assertEquals(1, actualRational.getNumerator());
  }

  /**
   * Confirms that {@link Rational#Rational(int, int)} initializes a rational number correctly
   * without reducing when the numerator and denominator are not simplifiable to 1.
   */
  @Test
  void testNewRational2() {
    // Arrange and Act
    Rational actualRational = new Rational(1, 3);

    // Assert
    assertEquals(1, actualRational.getNumerator());
    assertEquals(3, actualRational.getDenominator());
  }

  /**
   * Tests {@link Rational#Rational(int, int)} for correct initialization and
   * reduction to 0/1 when the numerator is 0, regardless of the denominator's value.
   */
  @Test
  void testNewRational3() {
    // Arrange and Act
    Rational actualRational = new Rational(0, 3);

    // Assert
    assertEquals(0, actualRational.getNumerator());
    assertEquals(1, actualRational.getDenominator());
  }

  /**
   * Verifies that {@link Rational#Rational(int, int)} handles negative denominators
   * by ensuring the rational number's canonical form has the negative sign on the numerator.
   */
  @Test
  void testNewRational4() {
    // Arrange and Act
    Rational actualRational = new Rational(-1, 3);

    // Assert
    assertEquals(-3, actualRational.getDenominator());
    assertEquals(1, actualRational.getNumerator());
  }

  /**
   * Ensures that {@link Rational#Rational(int, int)}
   *  throws an {@link IllegalArgumentException} when initialized with a denominator of 0.
   */
  @Test
  void testNewRational5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Rational(3, 0));
  }

  /**
   * Confirms that {@link Rational#Rational(int, int)}
   * correctly converts a negative denominator into a negative numerator,
   * maintaining the rational number's canonical form.
   */
  @Test
  void testNewRational6() {
    // Arrange and Act
    Rational actualRational = new Rational(3, -1);

    // Assert
    assertEquals(-3, actualRational.getNumerator());
    assertEquals(1, actualRational.getDenominator());
  }

  /**
   * Tests the copy constructor {@link Rational#Rational(Rational)}
   * to verify it correctly duplicates the numerator and denominator of the provided rational number.
   */
  @Test
  void testNewRational7() {
    // Arrange and Act
    Rational actualRational = new Rational(new Rational(1));

    // Assert
    assertEquals(1, actualRational.getDenominator());
    assertEquals(1, actualRational.getNumerator());
  }
}
