package numbers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class RationalTest
{
	// default constructor; no param
    @Test
    public void defaultConstructorShouldCreateZero() 
    {
        Rational rational = new Rational();
        assertThat(rational.getNumerator(), is(0));
        assertThat(rational.getDenominator(), is(1));
    }
    
    // one param test
    @Test
    public void numeratorAsSingleParamTest()
    {
    	int testNumerator = 2;
    	Rational rational = new Rational(testNumerator);
    	
        assertThat("numerator is " + testNumerator, rational.getNumerator(), is(testNumerator));
        assertThat("denominator is 1", rational.getDenominator(), is(1));
    }
    
    // Two param test
    @Test
    public void TwoParamTest()
    {
    	int testNumerator = 2;
    	int testDenominator = 3;
    	Rational rational = new Rational(testNumerator, testDenominator);
    	
        assertThat("numerator is " + testNumerator, rational.getNumerator(), is(testNumerator));
        assertThat("denominator is " + testDenominator, rational.getDenominator(), is(testDenominator));
    }
    
    // Test for zero denominator
    @Test
    public void shouldThrowExceptionForZeroDenominator() 
    {
        assertThrows(IllegalArgumentException.class, () -> new Rational(1, 0));
    }
    
    // Test for negative numerator
    @Test
    public void negativeNumeratorShouldWorkCorrectly() 
    {
        Rational value = new Rational(-2, 3);
        assertThat(value.getNumerator(), is(-2));
        assertThat(value.getDenominator(), is(3));
    }

    // Test for negative denominator
    @Test
    public void negativeDenominatorShouldWorkCorrectly() 
    {
        Rational value = new Rational(2, -3);
        assertThat(value.getNumerator(), is(-2));
        assertThat(value.getDenominator(), is(3));
    }
    
    // Test for both negative numerator and denominator
    @Test
    public void bothNegativeShouldBePositive() 
    {
        Rational value = new Rational(-2, -3);
        assertThat(value.getNumerator(), is(2));
        assertThat(value.getDenominator(), is(3));
    }
    
    // Test for numerator greater than denominator
    @Test
    public void numeratorGreaterThanDenominator() 
    {
        Rational value = new Rational(5, 3);
        assertThat(value.getNumerator(), is(5));
        assertThat(value.getDenominator(), is(3));
    }
    
    // Test for numerator less than denominator
    @Test
    public void numeratorLessThanDenominator() 
    {
        Rational value = new Rational(3, 5);
        assertThat(value.getNumerator(), is(3));
        assertThat(value.getDenominator(), is(5));
    }
    
    // Test for numerator equal to denominator
    @Test
    public void numeratorEqualToDenominator() 
    {
        Rational value = new Rational(3, 3);
        assertThat(value.getNumerator(), is(1));
        assertThat(value.getDenominator(), is(1));
    }
    
    @Test
    public void copyConstructorTest() 
    {
        Rational original = new Rational(2, 3);
        Rational copy = new Rational(original);
        assertThat("The copy's numerator is 2", copy.getNumerator(), is(2));
        assertThat("The copy's denominator is 3", copy.getDenominator(), is(3));
    }
    
    @Test
    public void oppositeReturnsAdditiveInverseTest()
    {
    	Rational value = new Rational(2,3);
    	Rational opposite = value.opposite();
    	assertThat("the opposite of 2 is -2", opposite.getNumerator(), is(-2));
    	assertThat("the denominator should be 3", opposite.getDenominator(), is(3));
    }
    
    // Happy Test Path
    @Test
    public void reciprocalOfRational()
    {
    	Rational value = new Rational(2,3);
    	Rational reciprocal = value.reciprocal();
    	assertThat("The numerator is 3", reciprocal.getNumerator(), is(3));
    	assertThat("The denominator is 2", reciprocal.getDenominator(), is(2));
    }
    
    // Sad Test Path
    @Test
    public void reciprocalThrowsException()
    {
    	Rational value = new Rational(0,1);
    	assertThrows(IllegalArgumentException.class, value::reciprocal);
    }
}
