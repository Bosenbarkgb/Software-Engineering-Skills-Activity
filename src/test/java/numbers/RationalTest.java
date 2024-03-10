package numbers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RationalTest {

  /**
   * Tests the default constructor which should create a Rational number equivalent to zero.
   */
  @Test
  public void defaultConstructorShouldCreateZero() {
    Rational rational = new Rational();
    assertThat(rational.getNumerator(), is(0));
    assertThat(rational.getDenominator(), is(1));
  }

  /**
   * Tests the constructor with a single parameter for the numerator which should set the denominator to 1.
   */
  @Test
  public void numeratorAsSingleParamTest() {
    int testNumerator = 2;
    Rational rational = new Rational(testNumerator);

    assertThat(
      "numerator is " + testNumerator,
      rational.getNumerator(),
      is(testNumerator)
    );
    assertThat("denominator is 1", rational.getDenominator(), is(1));
  }

  /**
   * Tests the constructor with two parameters for both numerator and denominator.
   */
  @Test
  public void TwoParamTest() {
    int testNumerator = 2;
    int testDenominator = 3;
    Rational rational = new Rational(testNumerator, testDenominator);

    assertThat(
      "numerator is " + testNumerator,
      rational.getNumerator(),
      is(testNumerator)
    );
    assertThat(
      "denominator is " + testDenominator,
      rational.getDenominator(),
      is(testDenominator)
    );
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating a Rational number with a zero denominator.
   */
  @Test
  public void shouldThrowExceptionForZeroDenominator() {
    assertThrows(IllegalArgumentException.class, () -> new Rational(1, 0));
  }

  /**
   * Tests creating a Rational number with a negative numerator.
   */
  @Test
  public void negativeNumeratorShouldWorkCorrectly() {
    Rational value = new Rational(-2, 3);
    assertThat(value.getNumerator(), is(-2));
    assertThat(value.getDenominator(), is(3));
  }

  /**
   * Tests creating a Rational number with a negative denominator.
   */
  @Test
  public void negativeDenominatorShouldWorkCorrectly() {
    Rational value = new Rational(2, -3);
    assertThat(value.getNumerator(), is(-2));
    assertThat(value.getDenominator(), is(3));
  }

  /**
   * Tests that a Rational number with both negative numerator and denominator is positive.
   */
  @Test
  public void bothNegativeShouldBePositive() {
    Rational value = new Rational(-2, -3);
    assertThat(value.getNumerator(), is(2));
    assertThat(value.getDenominator(), is(3));
  }

  /**
   * Tests creating a Rational number where the numerator is greater than the denominator.
   */
  @Test
  public void numeratorGreaterThanDenominator() {
    Rational value = new Rational(5, 3);
    assertThat(value.getNumerator(), is(5));
    assertThat(value.getDenominator(), is(3));
  }

  /**
   * Tests creating a Rational number where the numerator is less than the denominator.
   */
  @Test
  public void numeratorLessThanDenominator() {
    Rational value = new Rational(3, 5);
    assertThat(value.getNumerator(), is(3));
    assertThat(value.getDenominator(), is(5));
  }

  /**
   * Tests creating a Rational number where the numerator is equal to the denominator.
   */
  @Test
  public void numeratorEqualToDenominator() {
    Rational value = new Rational(3, 3);
    assertThat(value.getNumerator(), is(1));
    assertThat(value.getDenominator(), is(1));
  }

  /**
   * Tests the copy constructor of the Rational class.
   */
  @Test
  public void copyConstructorTest() {
    Rational original = new Rational(2, 3);
    Rational copy = new Rational(original);
    assertThat("The copy's numerator is 2", copy.getNumerator(), is(2));
    assertThat("The copy's denominator is 3", copy.getDenominator(), is(3));
  }

  // Tests for intValue
  /**
   * Verifies that {@code intValue()} returns the correct integer representation for whole numbers.
   */
  @Test
  public void intValueWithWholeNumber() {
    Rational rational = new Rational(5, 1); // Represents 5
    assertEquals(5, rational.intValue(), "intValue should return 5 for 5/1");
  }

  /**
   * Tests that {@code intValue()} correctly truncates towards zero for fractions.
   */
  @Test
  public void intValueWithFractionTruncatingTowardsZero() {
    Rational rational = new Rational(1, 2); // Represents 0.5
    assertEquals(
      0,
      rational.intValue(),
      "intValue should return 0 for 1/2, truncating towards zero"
    );
  }

  /**
   * Ensures that {@code intValue()} correctly handles negative whole numbers.
   */
  @Test
  public void intValueWithNegativeWholeNumber() {
    Rational rational = new Rational(-4, 1); // Represents -4
    assertEquals(-4, rational.intValue(), "intValue should return -4 for -4/1");
  }

  /**
   * Verifies that {@code intValue()} properly truncates negative fractions towards zero.
   */
  @Test
  public void intValueWithNegativeFractionTruncatingTowardsZero() {
    Rational rational = new Rational(-3, 2); // Represents -1.5
    assertEquals(
      -1,
      rational.intValue(),
      "intValue should return -1 for -3/2, truncating towards zero"
    );
  }

  /**
   * Tests that {@code intValue()} can handle large numerators correctly.
   */
  @Test
  public void intValueWithLargeNumerator() {
    Rational rational = new Rational(1000, 1); // Represents 1000
    assertEquals(
      1000,
      rational.intValue(),
      "intValue should return 1000 for 1000/1"
    );
  }

  /**
   * Ensures that {@code intValue()} returns zero for small fractions, implementing truncation towards zero.
   */
  @Test
  public void intValueWithSmallFraction() {
    Rational rational = new Rational(1, 1000); // Represents 0.001
    assertEquals(
      0,
      rational.intValue(),
      "intValue should return 0 for 1/1000, truncating towards zero"
    );
  }

  // Tests for longValue
  /**
   * Verifies that {@code longValue()} returns the correct long representation for whole numbers.
   */
  @Test
  public void longValueWithWholeNumber() {
    Rational rational = new Rational(5, 1); // Represents 5
    assertEquals(5L, rational.longValue(), "longValue should return 5 for 5/1");
  }

  /**
   * Tests that {@code longValue()} correctly truncates towards zero for fractions.
   */
  @Test
  public void longValueWithFractionTruncatingTowardsZero() {
    Rational rational = new Rational(1, 2); // Represents 0.5
    assertEquals(
      0L,
      rational.longValue(),
      "longValue should return 0 for 1/2, truncating towards zero"
    );
  }

  /**
   * Ensures that {@code longValue()} correctly handles negative whole numbers.
   */
  @Test
  public void longValueWithNegativeWholeNumber() {
    Rational rational = new Rational(-4, 1); // Represents -4
    assertEquals(
      -4L,
      rational.longValue(),
      "longValue should return -4 for -4/1"
    );
  }

  /**
   * Verifies that {@code longValue()} properly truncates negative fractions towards zero.
   */
  @Test
  public void longValueWithNegativeFractionTruncatingTowardsZero() {
    Rational rational = new Rational(-3, 2); // Represents -1.5
    assertEquals(
      -1L,
      rational.longValue(),
      "longValue should return -1 for -3/2, truncating towards zero"
    );
  }

  /**
   * Tests that {@code longValue()} can handle large numerators correctly and represent them as long values.
   */
  @Test
  public void longValueWithLargeNumerator() {
    Rational rational = new Rational(Integer.MAX_VALUE, 1); // Represents a large whole number
    assertEquals(
      (long) Integer.MAX_VALUE,
      rational.longValue(),
      "longValue should correctly handle large values"
    );
  }

  // Tests for floatValue
  /**
   * Tests the floatValue method with a whole number, expecting the exact float representation.
   */
  @Test
  public void floatValueWithWholeNumber() {
    Rational rational = new Rational(5, 1); // Represents 5
    assertEquals(
      5.0f,
      rational.floatValue(),
      0.0001f,
      "floatValue should return 5.0 for 5/1"
    );
  }

  /**
   * Tests the floatValue method with a simple fraction, expecting an accurate float approximation.
   */
  @Test
  public void floatValueWithFraction() {
    Rational rational = new Rational(1, 2); // Represents 0.5
    assertEquals(
      0.5f,
      rational.floatValue(),
      0.0001f,
      "floatValue should return 0.5 for 1/2"
    );
  }

  /**
   * Tests the floatValue method with a negative whole number, expecting the exact negative float representation.
   */
  @Test
  public void floatValueWithNegativeWholeNumber() {
    Rational rational = new Rational(-4, 1); // Represents -4
    assertEquals(
      -4.0f,
      rational.floatValue(),
      0.0001f,
      "floatValue should return -4.0 for -4/1"
    );
  }

  /**
   * Tests the floatValue method with a negative fraction, expecting an accurate negative float approximation.
   */
  @Test
  public void floatValueWithNegativeFraction() {
    Rational rational = new Rational(-3, 2); // Represents -1.5
    assertEquals(
      -1.5f,
      rational.floatValue(),
      0.0001f,
      "floatValue should return -1.5 for -3/2"
    );
  }

  /**
   * Tests the floatValue method with a very small fraction, expecting a positive float value close to zero.
   */
  @Test
  public void floatValueWithSmallFraction() {
    Rational rational = new Rational(1, Integer.MAX_VALUE); // Represents a very small fraction
    assertTrue(
      rational.floatValue() > 0,
      "floatValue should return a positive value for 1/Integer.MAX_VALUE"
    );
  }

  /**
   * Tests the floatValue method with large numerator and denominator values, expecting an approximation close to 1.0.
   */
  @Test
  public void floatValueWithVeryLargeNumeratorAndDenominator() {
    // Test with large values to check for precision
    Rational rational = new Rational(Integer.MAX_VALUE, Integer.MAX_VALUE - 1); // Represents a fraction close to 1
    assertEquals(
      1.0f,
      rational.floatValue(),
      0.01f,
      "floatValue should be approximately 1.0 for Integer.MAX_VALUE/(Integer.MAX_VALUE-1)"
    );
  }

  /**
   * Tests the floatValue method with an irreducible fraction, expecting an accurate approximation of PI.
   */
  @Test
  public void floatValueWithIrreducibleFraction() {
    Rational rational = new Rational(22, 7); // An approximation of PI
    assertEquals(
      22.0f / 7.0f,
      rational.floatValue(),
      0.0001f,
      "floatValue should return an approximation of PI for 22/7"
    );
  }

  /**
   * Tests the floatValue method with a large fraction, expecting a significant positive float value.
   */
  @Test
  public void floatValueWithLargeFraction() {
    Rational rational = new Rational(Integer.MAX_VALUE, 2); // Represents a large fraction
    assertTrue(
      rational.floatValue() > 0,
      "floatValue should return a large positive value for Integer.MAX_VALUE/2"
    );
  }

  // Tests for doubleValue
  /**
   * Tests the doubleValue method with a whole number, expecting the exact double representation.
   */
  @Test
  public void doubleValueWithWholeNumber() {
    Rational rational = new Rational(5, 1); // Represents 5
    assertEquals(
      5.0,
      rational.doubleValue(),
      0.0001,
      "doubleValue should return 5.0 for 5/1"
    );
  }

  /**
   * Tests the doubleValue method with a simple fraction, expecting an accurate double approximation.
   */
  @Test
  public void doubleValueWithFraction() {
    Rational rational = new Rational(1, 2); // Represents 0.5
    assertEquals(
      0.5,
      rational.doubleValue(),
      0.0001,
      "doubleValue should return 0.5 for 1/2"
    );
  }

  /**
   * Tests the doubleValue method with a negative whole number, expecting the exact negative double representation.
   */
  @Test
  public void doubleValueWithNegativeWholeNumber() {
    Rational rational = new Rational(-4, 1); // Represents -4
    assertEquals(
      -4.0,
      rational.doubleValue(),
      0.0001,
      "doubleValue should return -4.0 for -4/1"
    );
  }

  /**
   * Tests the doubleValue method with a negative fraction, expecting an accurate negative double approximation.
   */
  @Test
  public void doubleValueWithNegativeFraction() {
    Rational rational = new Rational(-3, 2); // Represents -1.5
    assertEquals(
      -1.5,
      rational.doubleValue(),
      0.0001,
      "doubleValue should return -1.5 for -3/2"
    );
  }

  /**
   * Tests the doubleValue method with a very small fraction, expecting a positive double value close to zero.
   */
  @Test
  public void doubleValueWithSmallFraction() {
    Rational rational = new Rational(1, Integer.MAX_VALUE); // Represents a very small fraction
    assertTrue(
      rational.doubleValue() > 0,
      "doubleValue should return a positive value for 1/Integer.MAX_VALUE"
    );
  }

  /**
   * Tests the doubleValue method with large numerator and denominator values, expecting an approximation close to 1.0.
   */
  @Test
  public void doubleValueWithVeryLargeNumeratorAndDenominator() {
    Rational rational = new Rational(Integer.MAX_VALUE, Integer.MAX_VALUE - 1); // Represents a fraction close to 1
    assertEquals(
      1.0,
      rational.doubleValue(),
      0.01,
      "doubleValue should be approximately 1.0 for Integer.MAX_VALUE/(Integer.MAX_VALUE-1)"
    );
  }

  /**
   * Tests the doubleValue method with an irreducible fraction, expecting an accurate approximation of PI.
   */
  @Test
  public void doubleValueWithIrreducibleFraction() {
    Rational rational = new Rational(22, 7); // An approximation of PI
    assertEquals(
      22.0 / 7.0,
      rational.doubleValue(),
      0.0001,
      "doubleValue should return an approximation of PI for 22/7"
    );
  }

  /**
   * Tests the doubleValue method with a very small fraction, expecting a positive double value close to zero.
   */
  @Test
  public void doubleValueWithVerySmallFraction() {
    Rational rational = new Rational(1, Integer.MAX_VALUE); // Represents a very small fraction
    assertTrue(
      rational.doubleValue() > 0,
      "doubleValue should return a very small positive value for 1/Integer.MAX_VALUE"
    );
  }

  /**
   * Tests the doubleValue method with a large fraction, expecting a significant positive double value.
   */
  @Test
  public void doubleValueWithLargeFraction() {
    Rational rational = new Rational(Integer.MAX_VALUE, 2); // Represents a large fraction
    assertTrue(
      rational.doubleValue() > 0,
      "doubleValue should return a large positive value for Integer.MAX_VALUE/2"
    );
  }

  // Tests for opposite
  /**
   * Tests the opposite method to ensure it correctly returns the additive inverse of a positive rational number.
   */
  @Test
  public void oppositeReturnsAdditiveInverseTest() {
    Rational value = new Rational(2, 3);
    Rational opposite = value.opposite();
    assertThat("the opposite of 2 is -2", opposite.getNumerator(), is(-2));
    assertThat("the denominator should be 3", opposite.getDenominator(), is(3));
  }

  /**
   * Tests the opposite method to ensure it correctly returns the additive inverse of a negative rational number.
   */
  @Test
  public void oppositeOfNegativeRationalNumber() {
    Rational negativeValue = new Rational(-5, 7);
    Rational opposite = negativeValue.opposite();
    assertThat("The opposite of -5 is 5", opposite.getNumerator(), is(5));
    assertThat(
      "The denominator should remain 7",
      opposite.getDenominator(),
      is(7)
    );
  }

  /**
   * Tests the opposite method to ensure that the opposite of zero is still zero.
   */
  @Test
  public void oppositeOfZero() {
    Rational zeroValue = new Rational(0, 10);
    Rational opposite = zeroValue.opposite();
    assertThat("The opposite of 0 is still 0", opposite.getNumerator(), is(0));
    // The denominator should be unaffected, but it's normalized to 1 in the Rational constructor
    assertThat(
      "The denominator should be normalized to 1",
      opposite.getDenominator(),
      is(1)
    );
  }

  // Tests for reciprocal
  /**
   * Happy Test Path
   * Verifies the functionality of the reciprocal method for a typical rational number.
   */
  @Test
  public void reciprocalOfRational() {
    Rational value = new Rational(2, 3);
    Rational reciprocal = value.reciprocal();
    assertThat("The numerator is 3", reciprocal.getNumerator(), is(3));
    assertThat("The denominator is 2", reciprocal.getDenominator(), is(2));
  }

  /**
   * Sad Test Path
   * Tests the reciprocal method to confirm it throws an exception when attempting to calculate the reciprocal of zero.
   */
  @Test
  public void reciprocalThrowsException() {
    Rational value = new Rational(0, 1);
    assertThrows(IllegalArgumentException.class, value::reciprocal);
  }

  /**
   * Tests the reciprocal method for a rational number less than one, ensuring correct calculation of the reciprocal.
   */
  @Test
  public void reciprocalOfRationalNumberLessThanOne() {
    Rational lessThanOne = new Rational(4, 9);
    Rational reciprocal = lessThanOne.reciprocal();
    assertThat(
      "The numerator should be 9 for the reciprocal of 4/9",
      reciprocal.getNumerator(),
      is(9)
    );
    assertThat(
      "The denominator should be 4 for the reciprocal of 4/9",
      reciprocal.getDenominator(),
      is(4)
    );
  }

  // Tests for times (multiplication)
  /**
   * Verifies that the times method correctly multiplies two rational numbers together.
   */
  @Test
  public void timesShouldMultiplyRationalsCorrectly() {
    // Given we have Rationals representing 2/3 and 5/7
    Rational p = new Rational(2, 3);
    Rational r = new Rational(5, 7);

    // When the program computes the value of 2/3 times 5/7
    Rational result = p.times(r);

    // Then the result should be 10/21
    assertThat("2 * 5 = 10", result.getNumerator(), is(10));
    assertThat("3 * 7 = 21", result.getDenominator(), is(21));
  }

  /**
   * Tests the times method with a factor of zero, expecting the result to be zero.
   */
  @Test
  public void timesWithZero() {
    Rational value = new Rational(3, 4);
    Rational zero = new Rational(0, 1);
    Rational result = value.times(zero);
    assertThat(
      "Multiplying by zero should result in zero",
      result.getNumerator(),
      is(0)
    );
    assertThat(
      "The denominator should be arbitrary non-zero",
      result.getDenominator(),
      is(not(0))
    );
  }

  /**
   * Tests the times method with a factor of one, expecting the original value to remain unchanged.
   */
  @Test
  public void timesByOne() {
    Rational value = new Rational(3, 7);
    Rational one = new Rational(1, 1);
    Rational result = value.times(one);
    assertThat(
      "Multiplying by one should not change the value",
      result.getNumerator(),
      is(3)
    );
    assertThat(
      "The denominator should remain unchanged",
      result.getDenominator(),
      is(7)
    );
  }

  /**
   * Tests the doubleValue method to ensure it returns the correct double approximation for a rational number.
   */
  @Test
  public void shouldCorrectlyConvertToDouble() {
    Rational rational = new Rational(1, 2); // 0.5
    assertThat(rational.doubleValue(), is(0.5));
  }

  // Tests for plus
  /**
   * Tests the addition of two rational numbers, expecting their correct summation.
   */
  @Test
  public void plusShouldSumRationalsCorrectly() {
    Rational a = new Rational(1, 2); // 1/2
    Rational b = new Rational(1, 3); // 1/3
    Rational sum = a.plus(b); // Expected: 5/6
    assertThat("Numerator of sum should be 5", sum.getNumerator(), is(5));
    assertThat("Denominator of sum should be 6", sum.getDenominator(), is(6));
  }

  /**
   * Tests that adding a number and its additive inverse results in zero.
   */
  @Test
  public void addingOppositeNumbersShouldResultInZero() {
    Rational number = new Rational(3, 4);
    Rational oppositeNumber = new Rational(-3, 4);
    Rational result = number.plus(oppositeNumber);
    assertThat(
      "Sum of a number and its opposite should be zero",
      result.getNumerator(),
      is(0)
    );
  }

  /**
   * Tests that adding zero to a rational number does not change its value.
   */
  @Test
  public void addingZeroHasNoEffect() {
    Rational number = new Rational(3, 4);
    Rational zero = new Rational(0, 1);
    Rational result = number.plus(zero);
    assertThat(
      "Adding zero should not change the numerator",
      result.getNumerator(),
      is(3)
    );
    assertThat(
      "Adding zero should not change the denominator",
      result.getDenominator(),
      is(4)
    );
  }

  /**
   * Tests the addition of two negative rational numbers.
   */
  @Test
  public void addingNegativeRationals() {
    Rational negativeOne = new Rational(-1, 4);
    Rational negativeTwo = new Rational(-1, 2);
    Rational result = negativeOne.plus(negativeTwo);
    assertThat("Sum of two negative rationals", result.getNumerator(), is(-3));
    assertThat(
      "The denominator after adding should be 4",
      result.getDenominator(),
      is(4)
    );
  }

  /**
   * Tests that the result of adding two rational numbers is correctly simplified.
   */
  @Test
  public void resultSimplification() {
    Rational a = new Rational(1, 4);
    Rational b = new Rational(3, 4);
    Rational result = a.plus(b);
    assertThat(
      "The numerator should be simplified to 1",
      result.getNumerator(),
      is(1)
    );
    assertThat(
      "The denominator should be simplified to 1",
      result.getDenominator(),
      is(1)
    );
  }

  // Tests for compareTo
  /**
   * Tests comparing a rational number with a double that has a greater value.
   */
  @Test
  public void compareToAnotherNumber() {
    Rational rational = new Rational(1, 2); // 0.5
    Double other = 0.7; // Another number
    assertTrue(rational.compareTo(other) < 0); // 0.5 is less than 0.7
  }

  /**
   * Tests comparing a rational number with another rational number that has a smaller value.
   */
  @Test
  public void compareToWithRationalGreater() {
    Rational rational = new Rational(3, 2); // 1.5
    Rational other = new Rational(1, 2); // 0.5
    assertTrue(
      rational.compareTo(other) > 0,
      "3/2 should be considered greater than 1/2"
    );
  }

  /**
   * Tests comparing a rational number with another rational number that has a greater value.
   */
  @Test
  public void compareToWithRationalLess() {
    Rational rational = new Rational(1, 4); // 0.25
    Rational other = new Rational(1, 2); // 0.5
    assertTrue(
      rational.compareTo(other) < 0,
      "1/4 should be considered less than 1/2"
    );
  }

  /**
   * Tests comparing two equal rational numbers.
   */
  @Test
  public void compareToWithRationalEqual() {
    Rational rational = new Rational(2, 3);
    Rational other = new Rational(2, 3);
    assertEquals(
      0,
      rational.compareTo(other),
      "2/3 should be considered equal to 2/3"
    );
  }

  /**
   * Tests comparing a rational number with an integer that has a smaller value.
   */
  @Test
  public void compareToWithIntegerGreater() {
    Rational rational = new Rational(5, 1); // 5
    Integer other = 4;
    assertTrue(
      rational.compareTo(other) > 0,
      "5 should be considered greater than 4"
    );
  }

  /**
   * Tests comparing a rational number with an integer that has a greater value.
   */
  @Test
  public void compareToWithIntegerLess() {
    Rational rational = new Rational(2, 1); // 2
    Integer other = 3;
    assertTrue(
      rational.compareTo(other) < 0,
      "2 should be considered less than 3"
    );
  }

  /**
   * Tests comparing a rational number with a double that has a smaller value.
   */
  @Test
  public void compareToWithDoubleGreater() {
    Rational rational = new Rational(7, 4); // 1.75
    Double other = 1.5;
    assertTrue(
      rational.compareTo(other) > 0,
      "7/4 should be considered greater than 1.5"
    );
  }

  /**
   * Tests comparing a rational number with a double that has a greater value.
   */
  @Test
  public void compareToWithDoubleLess() {
    Rational rational = new Rational(1, 2); // 0.5
    Double other = 0.75;
    assertTrue(
      rational.compareTo(other) < 0,
      "1/2 should be considered less than 0.75"
    );
  }

  /**
   * Tests comparing a rational number with a float that has an equal value.
   */
  @Test
  public void compareToWithFloatEqual() {
    Rational rational = new Rational(10, 1); // 10
    Float other = 10.0f;
    assertEquals(
      0,
      rational.compareTo(other),
      "10 should be considered equal to 10.0f"
    );
  }

  /**
   * Tests comparing a rational number with a long that has a smaller value.
   */
  @Test
  public void compareToWithLongGreater() {
    Rational rational = new Rational(100, 1); // 100
    Long other = 99L;
    assertTrue(
      rational.compareTo(other) > 0,
      "100 should be considered greater than 99"
    );
  }

  /**
   * Tests comparing a rational number with a long that has a greater value.
   */
  @Test
  public void compareToWithLongLess() {
    Rational rational = new Rational(50, 1); // 50
    Long other = 60L;
    assertTrue(
      rational.compareTo(other) < 0,
      "50 should be considered less than 60"
    );
  }

  // Tests for minus
  /**
   * Tests the subtraction of two rational numbers and checks if the result is correctly simplified.
   */
  @Test
  public void minusTest() {
    Rational a = new Rational(3, 4);
    Rational b = new Rational(1, 4);

    Rational result = a.minus(b);

    // Ensure that the expected result is correctly simplified.
    assertThat(
      "Numerator after subtraction should be 1",
      result.getNumerator(),
      is(1)
    ); // Assuming the result is simplified.
    assertThat(
      "Denominator after subtraction should be 2",
      result.getDenominator(),
      is(2)
    ); // Assuming the result is simplified.
  }

  /**
   * Tests that subtracting a number from itself results in zero.
   */
  @Test
  public void subtractingSameNumbersShouldResultInZero() {
    Rational number = new Rational(5, 6);
    Rational result = number.minus(number);
    assertThat(
      "Subtracting a number from itself should result in a zero numerator",
      result.getNumerator(),
      is(0)
    );
  }

  /**
   * Tests that the result of subtraction is correctly simplified.
   */
  @Test
  public void subtractionResultingInSimplification() {
    Rational a = new Rational(1, 2);
    Rational b = new Rational(1, 4);
    Rational result = a.minus(b);
    assertThat(
      "Numerator after subtraction should be simplified to 1",
      result.getNumerator(),
      is(1)
    );
    assertThat(
      "Denominator after subtraction should be simplified to 4",
      result.getDenominator(),
      is(4)
    );
  }

  // Test for dividesBy
  /**
   * Tests the division of one rational number by another and checks if the result is correctly calculated.
   */
  @Test
  public void dividesByTest() {
    // Given we have Rationals representing 1/2 and 1/4
    Rational a = new Rational(1, 2);
    Rational b = new Rational(1, 4);

    // When the program computes the value of 1/2 divided by 1/4
    Rational result = a.dividesBy(b);

    // Then the result should be 2 (or 2/1 in Rational form)
    assertThat(
      "Numerator after division should be 2",
      result.getNumerator(),
      is(2)
    );
    assertThat(
      "Denominator after division should be 1",
      result.getDenominator(),
      is(1)
    );
  }

  /**
   * Tests the division of a positive rational number by a negative rational number.
   */
  @Test
  public void divisionByNegativeRational() {
    Rational dividend = new Rational(1, 2);
    Rational divisor = new Rational(-1, 4);
    Rational result = dividend.dividesBy(divisor);
    assertThat(
      "Result of division by a negative should be negative",
      result.getNumerator(),
      is(-2)
    );
    assertThat(
      "Denominator after division should remain positive",
      result.getDenominator(),
      is(1)
    );
  }

  /**
   * Tests the division of two negative rational numbers.
   */
  @Test
  public void divisionOfTwoNegativeRationals() {
    Rational dividend = new Rational(-1, 3);
    Rational divisor = new Rational(-2, 6);
    Rational result = dividend.dividesBy(divisor);
    assertThat(
      "Division of two negatives should yield a positive numerator",
      result.getNumerator(),
      is(1)
    );
    assertThat(
      "Denominator should be simplified and positive",
      result.getDenominator(),
      is(1)
    );
  }

  /**
   * Tests the division by a zero rational number, expecting an exception.
   */
  @Test
  public void divisionByZeroRational() {
    Rational dividend = new Rational(1, 2);
    Rational zeroDivisor = new Rational(0, 1);
    assertThrows(
      IllegalArgumentException.class,
      () -> dividend.dividesBy(zeroDivisor),
      "Division by zero should throw IllegalArgumentException"
    );
  }

  // Tests for raisedToThePowerOf
  /**
   * Tests raising a rational number to a positive power.
   */
  @Test
  public void raisedToThePowerOfPositive() {
    // Given we have a Rational representing 2/3
    Rational a = new Rational(2, 3);

    // When the program computes the value of (2/3)^3
    Rational result = a.raisedToThePowerOf(3);

    // Then the result should be 8/27
    assertThat(
      "Numerator after raising to power should be 8",
      result.getNumerator(),
      is(8)
    );
    assertThat(
      "Denominator after raising to power should be 27",
      result.getDenominator(),
      is(27)
    );
  }

  /**
   * Tests raising a rational number to a negative power, which should return its reciprocal raised to the positive power.
   */
  @Test
  public void raisedToThePowerOfNegative() {
    // Given we have a Rational representing 2/3
    Rational a = new Rational(2, 3);

    // When the program computes the value of (2/3)^(-1)
    Rational result = a.raisedToThePowerOf(-1);

    // Then the result should be 3/2 (the reciprocal)
    assertThat(
      "Numerator after raising to negative power should be 3",
      result.getNumerator(),
      is(3)
    );
    assertThat(
      "Denominator after raising to negative power should be 2",
      result.getDenominator(),
      is(2)
    );
  }

  /**
   * Tests raising zero to a negative power, expecting an exception due to division by zero.
   */
  @Test
  public void raisedToThePowerOfZero() {
    // Given we have a Rational representing 0
    Rational a = new Rational(0, 1);
    assertThrows(
      IllegalArgumentException.class,
      () -> a.raisedToThePowerOf(-1)
    );
  }

  /**
   * Tests raising any rational number to the zero power, which should always result in 1.
   */
  @Test
  public void raisingAnyRationalToZeroPower() {
    Rational rational = new Rational(3, 4);
    Rational result = rational.raisedToThePowerOf(0);
    assertThat(
      "Any number raised to the power of 0 should have a numerator of 1",
      result.getNumerator(),
      is(1)
    );
    assertThat(
      "Any number raised to the power of 0 should have a denominator of 1",
      result.getDenominator(),
      is(1)
    );
  }

  /**
   * Tests raising a negative rational number to both even and odd powers.
   */
  @Test
  public void raisingNegativeRationalToPositivePower() {
    Rational negativeRational = new Rational(-2, 3);
    Rational evenPowerResult = negativeRational.raisedToThePowerOf(2);
    Rational oddPowerResult = negativeRational.raisedToThePowerOf(3);

    assertThat(
      "Negative rational raised to an even power should be positive",
      evenPowerResult.getNumerator(),
      is(4)
    );
    assertThat(
      "Negative rational raised to an odd power should be negative",
      oddPowerResult.getNumerator(),
      is(-8)
    );
  }

  /**
   * Tests raising a rational number to a large positive power.
   */
  @Test
  public void raisingToLargePositivePower() {
    Rational rational = new Rational(2, 3);
    Rational result = rational.raisedToThePowerOf(4); // Should be 16/81
    assertThat(
      "Numerator after raising to the 4th power",
      result.getNumerator(),
      is(16)
    );
    assertThat(
      "Denominator after raising to the 4th power",
      result.getDenominator(),
      is(81)
    );
  }

  /**
   * Tests raising a rational number to a large negative power.
   */
  @Test
  public void raisingToLargeNegativePower() {
    Rational rational = new Rational(2, 3);
    Rational result = rational.raisedToThePowerOf(-4); // Should be 81/16
    assertThat(
      "Numerator after raising to the -4th power should be the reciprocal",
      result.getNumerator(),
      is(81)
    );
    assertThat(
      "Denominator after raising to the -4th power should be the reciprocal",
      result.getDenominator(),
      is(16)
    );
  }

  // Tests for equals
  /**
   * Tests the equality of two identical rational numbers.
   */
  @Test
  public void equalsReturnsTrueRational() {
    Rational a = new Rational(2, 3);
    Rational b = new Rational(2, 3);
    assertTrue(a.equals(b));
  }

  /**
   * Tests the approximate equality between a rational number and a float value.
   */
  @Test
  public void equalsReturnsTrueFloat() {
    Rational a = new Rational(1, 2); // 0.5
    Float b = 0.5f;
    assertTrue(a.equals(b));
  }

  /**
   * Tests the approximate equality between a rational number and a double value.
   */
  @Test
  public void equalsReturnsTrueDouble() {
    Rational a = new Rational(1, 3); // Approximately 0.333333
    Double b = 1.0 / 3.0; // More precise approximation of 1/3
    assertTrue(a.equals(b));
  }

  /**
   * Tests the inequality between two different rational numbers.
   */
  @Test
  public void equalsReturnFalseRational() {
    Rational a = new Rational(1, 2); // 1/2
    Rational b = new Rational(1, 3); // 1/3
    assertFalse(
      a.equals(b),
      "Rationals 1/2 and 1/3 should not be considered equal."
    );
  }

  /**
   * Tests the inequality between a rational number and a float value.
   */
  @Test
  public void equalsReturnsFalseFloat() {
    Rational a = new Rational(1, 3);
    Float b = 0.5f;
    assertFalse(a.equals(b));
  }

  /**
   * Tests the inequality between a rational number and a double value.
   */
  @Test
  public void equalsReturnsFalseDouble() {
    Rational a = new Rational(1, 2); // 0.5
    Double b = 2.0 / 3.0; // Approximately 0.666666
    assertFalse(a.equals(b));
  }

  // Tests for greaterThan(number)
  /**
   * Tests if a rational number is greater than an integer value.
   */
  @Test
  public void greaterThanNumberWithInteger() {
    Rational rational = new Rational(5, 2); // 2.5
    Integer number = 2;
    assertTrue(rational.greaterThan(number), "5/2 should be greater than 2");
  }

  /**
   * Tests if a rational number is greater than a double value.
   */
  @Test
  public void greaterThanNumberWithDouble() {
    Rational rational = new Rational(3, 2); // 1.5
    Double number = 1.4;
    assertTrue(rational.greaterThan(number), "3/2 should be greater than 1.4");
  }

  /**
   * Tests if a rational number is greater than a smaller rational number.
   */
  @Test
  public void greaterThanNumberWithSmallerRational() {
    Rational rational = new Rational(3, 2); // 1.5
    Rational smallerRational = new Rational(1, 2); // 0.5
    assertTrue(
      rational.greaterThan(smallerRational),
      "3/2 should be greater than 1/2"
    );
  }

  /**
   * Tests if a rational number is not greater than a larger double value.
   */
  @Test
  public void greaterThanNumberWithGreaterDouble() {
    Rational rational = new Rational(1, 2); // 0.5
    Double number = 0.6;
    assertFalse(
      rational.greaterThan(number),
      "1/2 should not be greater than 0.6"
    );
  }

  // Tests for greaterThan(Rational)
  /**
   * Tests if one rational number is greater than another rational number.
   */
  @Test
  public void greaterThanReturnsTrue() {
    Rational rational = new Rational(3, 2); // 1.5
    assertTrue(
      rational.greaterThan(new Rational(1, 2)),
      "3/2 should be greater than 1/2"
    );
  }

  /**
   * Tests if a smaller rational number is not considered greater than a larger one.
   */
  @Test
  public void greaterThanReturnsFalse() {
    Rational rational = new Rational(1, 3); // About 0.333
    assertFalse(
      rational.greaterThan(new Rational(1, 2)),
      "1/3 should not be greater than 1/2"
    );
  }

  /**
   * Tests if the method correctly identifies a greater rational number.
   */
  @Test
  public void greaterThanReturnsTrueWhenCurrentIsGreater() {
    Rational current = new Rational(3, 2); // 3/2
    Rational other = new Rational(1, 2); // 1/2
    assertTrue(current.greaterThan(other), "3/2 should be greater than 1/2");
  }

  /**
   * Tests if the method correctly identifies that the current rational number is not greater.
   */
  @Test
  public void greaterThanReturnsFalseWhenCurrentIsNotGreater() {
    Rational current = new Rational(1, 3); // 1/3
    Rational other = new Rational(1, 2); // 1/2
    assertFalse(
      current.greaterThan(other),
      "1/3 should not be greater than 1/2"
    );
  }

  /**
   * Tests if equal rational numbers are correctly identified as not greater than each other.
   */
  @Test
  public void greaterThanReturnsFalseForEqualValues() {
    Rational current = new Rational(2, 3); // 2/3
    Rational other = new Rational(2, 3); // 2/3
    assertFalse(current.greaterThan(other), "The values are equal");
  }

  /**
   * Additional tests to verify `greaterThan` with various number types.
   */
  @Test
  public void greaterThanReturnsTrueWithInteger() {
    Rational rational = new Rational(5, 2); // 2.5
    assertTrue(rational.greaterThan(2), "5/2 should be greater than 2");
  }

  /**
   * Verifies that a rational number is not considered greater than an integer value greater than itself.
   */
  @Test
  public void greaterThanReturnsFalseWithInteger() {
    Rational rational = new Rational(3, 4); // 0.75
    assertFalse(rational.greaterThan(1), "3/4 should not be greater than 1");
  }

  /**
   * Tests if a rational number is correctly identified as greater than a float value.
   */
  @Test
  public void greaterThanReturnsTrueWithFloat() {
    Rational rational = new Rational(7, 4); // 1.75
    assertTrue(rational.greaterThan(1.5f), "7/4 should be greater than 1.5");
  }

  /**
   * Ensures a rational number is not considered greater than a larger float value.
   */
  @Test
  public void greaterThanReturnsFalseWithFloat() {
    Rational rational = new Rational(1, 2); // 0.5
    assertFalse(
      rational.greaterThan(0.75f),
      "1/2 should not be greater than 0.75"
    );
  }

  /**
   * Confirms a rational number is deemed greater than a double value when appropriate.
   */
  @Test
  public void greaterThanReturnsTrueWithDouble() {
    Rational rational = new Rational(9, 4); // 2.25
    assertTrue(rational.greaterThan(2.0), "9/4 should be greater than 2.0");
  }

  /**
   * Tests that a rational number is not viewed as greater than a larger double value.
   */
  @Test
  public void greaterThanReturnsFalseWithDouble() {
    Rational rational = new Rational(2, 5); // 0.4
    assertFalse(
      rational.greaterThan(0.5),
      "2/5 should not be greater than 0.5"
    );
  }

  /**
   * Examines the comparison of a rational number to zero, verifying correct behavior.
   */
  @Test
  public void greaterThanWithZero() {
    Rational rational = new Rational(0, 1); // 0
    assertFalse(rational.greaterThan(0), "0 should not be greater than 0");
    assertTrue(
      new Rational(1, 2).greaterThan(0),
      "1/2 should be greater than 0"
    );
  }

  /**
   * Checks the behavior of comparing a negative rational number to other negative and zero values.
   */
  @Test
  public void greaterThanWithNegativeNumber() {
    Rational rational = new Rational(-1, 2); // -0.5
    assertFalse(
      rational.greaterThan(-0.25),
      "-1/2 should not be greater than -0.25"
    );
    assertTrue(rational.greaterThan(-1), "-1/2 should be greater than -1");
  }

  // Tests for lessThan
  /**
   * Verifies that a smaller rational number is considered less than a larger rational number.
   */
  @Test
  public void lessThanWithCurrentValueLessThanR() {
    Rational currentValue = new Rational(1, 4);
    Rational comparedValue = new Rational(1, 2);
    assertTrue(currentValue.lessThan(comparedValue), "1/4 is less than 1/2");
  }

  /**
   * Checks that a larger rational number is not considered less than a smaller rational number.
   */
  @Test
  public void lessThanWithCurrentValueGreaterThanR() {
    Rational currentValue = new Rational(3, 4);
    Rational comparedValue = new Rational(1, 2);
    assertFalse(
      currentValue.lessThan(comparedValue),
      "3/4 is not less than 1/2"
    );
  }

  /**
   * Tests that equal rational numbers are not considered less than each other.
   */
  @Test
  public void lessThanWithEqualValues() {
    Rational currentValue = new Rational(2, 3);
    Rational comparedValue = new Rational(2, 3);
    assertFalse(
      currentValue.lessThan(comparedValue),
      "2/3 is not less than 2/3"
    );
  }

  /**
   * Tests comparison behavior when both rational numbers are negative and the current value is greater.
   */
  @Test
  public void lessThanWithBothValuesNegativeAndCurrentValueGreater() {
    Rational currentValue = new Rational(-1, 4); // -1/4
    Rational comparedValue = new Rational(-1, 2); // -1/2
    assertFalse(
      currentValue.lessThan(comparedValue),
      "-1/4 is not less than -1/2"
    );
  }

  /**
   * Verifies that zero is considered less than any positive rational number.
   */
  @Test
  public void lessThanWithZeroCurrentValue() {
    Rational currentValue = new Rational(0, 1); // 0
    Rational comparedValue = new Rational(1, 2); // 1/2
    assertTrue(
      currentValue.lessThan(comparedValue),
      "0 should be less than 1/2"
    );
  }

  /**
   * Tests that any positive rational number is not considered less than zero.
   */
  @Test
  public void lessThanWithZeroComparedValue() {
    Rational currentValue = new Rational(1, 2); // 1/2
    Rational comparedValue = new Rational(0, 1); // 0
    assertFalse(currentValue.lessThan(comparedValue), "1/2 is not less than 0");
  }

  // Tests for isZero
  /**
   * Confirms that a rational number representing zero is correctly identified as zero.
   */
  @Test
  public void isZeroWithZeroValue() {
    Rational zeroValue = new Rational(0, 1); // Represents 0
    assertTrue(zeroValue.isZero(), "0/1 should be considered as zero");
  }

  /**
   * Ensures that a positive rational number is not incorrectly identified as zero.
   */
  @Test
  public void isZeroWithPositiveNumerator() {
    Rational positiveValue = new Rational(1, 2); // Represents 1/2
    assertFalse(positiveValue.isZero(), "1/2 should not be considered as zero");
  }

  /**
   * Checks that a negative rational number is not mistakenly considered as zero.
   */
  @Test
  public void isZeroWithNegativeNumerator() {
    Rational negativeValue = new Rational(-1, 2); // Represents -1/2
    assertFalse(
      negativeValue.isZero(),
      "-1/2 should not be considered as zero"
    );
  }

  // isOne Tests
  /**
   * Verifies the identification of a rational number representing one.
   */
  @Test
  public void isOneWithCanonicalOneValue() {
    Rational oneValue = new Rational(1, 1); // Represents 1
    assertTrue(oneValue.isOne(), "1/1 should be considered as one");

    Rational alsoOneValue = new Rational(2, 2); // Another representation of 1
    assertTrue(alsoOneValue.isOne(), "2/2 should also be considered as one");

    Rational negativeOneValue = new Rational(-2, -2); // Negative representation of 1
    assertTrue(
      negativeOneValue.isOne(),
      "-2/-2 should also be considered as one"
    );
  }

  /**
   * Tests that zero is not incorrectly identified as one.
   */
  @Test
  public void isOneWithZeroValue() {
    Rational zeroValue = new Rational(0, 1); // Represents 0
    assertFalse(zeroValue.isOne(), "0/1 should not be considered as one");
  }

  /**
   * Confirms that rational numbers not equivalent to one are correctly not identified as one.
   */
  @Test
  public void isOneWithNonCanonicalOneValue() {
    Rational nonOneValue = new Rational(1, 2); // Represents 1/2
    assertFalse(nonOneValue.isOne(), "1/2 should not be considered as one");

    Rational anotherNonOneValue = new Rational(-1, 1); // Represents -1
    assertFalse(
      anotherNonOneValue.isOne(),
      "-1/1 should not be considered as one"
    );
  }

  // Tests for isMinus
  /**
   * Tests for correct identification of a rational number representing minus one.
   */
  @Test
  public void isMinusOneWithCanonicalMinusOneValue() {
    Rational minusOneValue = new Rational(-1, 1); // Represents -1
    assertTrue(
      minusOneValue.isMinusOne(),
      "-1/1 should be considered as minus one"
    );

    Rational anotherMinusOneValue = new Rational(2, -2); // Another representation of -1
    assertTrue(
      anotherMinusOneValue.isMinusOne(),
      "2/-2 should also be considered as minus one"
    );
  }

  /**
   * Ensures zero is not incorrectly identified as minus one.
   */
  @Test
  public void isMinusOneWithZeroValue() {
    Rational zeroValue = new Rational(0, 1); // Represents 0
    assertFalse(
      zeroValue.isMinusOne(),
      "0/1 should not be considered as minus one"
    );
  }

  /**
   * Checks that rational numbers not equivalent to minus one are not mistakenly identified as such.
   */
  @Test
  public void isMinusOneWithNonCanonicalMinusOneValue() {
    Rational nonMinusOneValue = new Rational(-1, 2); // Represents -1/2
    assertFalse(
      nonMinusOneValue.isMinusOne(),
      "-1/2 should not be considered as minus one"
    );

    Rational oneValue = new Rational(1, 1); // Represents 1
    assertFalse(
      oneValue.isMinusOne(),
      "1/1 should not be considered as minus one"
    );
  }

  // Tests for toString
  /**
   * Tests the string representation of a rational number as a whole number.
   */
  @Test
  public void toStringWithWholeNumber() {
    Rational wholeNumber = new Rational(7, 1);
    assertEquals(
      "7",
      wholeNumber.toString(),
      "7/1 should be represented as '7'"
    );
  }

  /**
   * Tests the string representation of a standard fractional rational number.
   */
  @Test
  public void toStringWithFraction() {
    Rational fractionalNumber = new Rational(1, 2);
    assertEquals(
      "1/2",
      fractionalNumber.toString(),
      "1/2 should be represented as '1/2'"
    );
  }

  /**
   * Verifies the string representation of a negative fractional rational number.
   */
  @Test
  public void toStringWithNegativeFraction() {
    Rational negativeFraction = new Rational(-1, 2);
    assertEquals(
      "-1/2",
      negativeFraction.toString(),
      "-1/2 should be represented as '-1/2'"
    );

    Rational positiveFromNegative = new Rational(-2, -3);
    assertEquals(
      "2/3",
      positiveFromNegative.toString(),
      "-2/-3 should be simplified to '2/3'"
    );
  }
}
