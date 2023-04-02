import org.junit.*;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }
    @Test(expected = ArithmeticException.class)
    public void testDenominator0() {
        new Rational(5, 0);
    }
    @Test
    public void testSimplifyMinuses() {
        assertEquals("minus is not in the numerator",new Rational(1,-5),new Rational(-1,5));
        assertEquals("minus + minus != plus", new Rational(-1,-5),new Rational(1,5));
        assertEquals("numerator = -0", new Rational(-0,1),new Rational());
    }
}