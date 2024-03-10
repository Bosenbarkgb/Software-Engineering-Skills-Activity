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
    	int testNumerator = 5;
    	Rational rational = new Rational(testNumerator);
    	
        assertThat(rational.getNumerator(), is(testNumerator));
        assertThat(rational.getDenominator(), is(1));
    }
}
