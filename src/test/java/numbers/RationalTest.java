package numbers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
}
