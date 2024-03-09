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
}
