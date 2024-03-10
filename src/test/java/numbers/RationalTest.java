package numbers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class RationalTest
{
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
}
