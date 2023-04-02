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

    @Test
    public void testReduce() {
        Rational Reduce =new Rational(-15,-20);
        assertEquals("The fraction is not reduced", Reduce, new Rational(3,4));
    }

    @Test
    public void testPlus() {
        Rational Positive = new Rational(1,2);
        Rational Negative = new Rational(1,-2);
        Rational Standart = new Rational();
        assertEquals("Positive + Positive",Positive.plus(Positive), new Rational(1,1));
        assertEquals("Negative + Positive",Negative.plus(Positive), Standart);
        assertEquals("Negative + Negative",Negative.plus(Negative), new Rational(-1,1));
        assertEquals("Negative + Standart",Negative.plus(Standart), Negative);
        assertEquals("Standart + Standart",Standart.plus(Standart), Standart);
    }

    @Test
    public void testMinus() {
        Rational Positive = new Rational(1,2);
        Rational Negative = new Rational(1,-2);
        Rational Standart = new Rational();
        assertEquals("Positive - Positive",Positive.minus(Positive), Standart);
        assertEquals("Negative - Positive",Negative.minus(Positive), new Rational(-1,1));
        assertEquals("Positive - Negative",Positive.minus(Negative), new Rational(1,1));
        assertEquals("Negative - Negative",Negative.minus(Negative), Standart);
        assertEquals("Negative - Standart",Negative.minus(Standart), Negative);
        assertEquals("Standart - Standart",Standart.minus(Standart), Standart);
    }

    @Test
    public void testMultiply() {
        Rational Positive = new Rational(1,2);
        Rational Negative = new Rational(1,-2);
        Rational Standart = new Rational();
        assertEquals("Positive * Positive",Positive.multiply(Positive), new Rational(1,4));
        assertEquals("Negative * Positive",Negative.multiply(Positive), new Rational(-1,4));
        assertEquals("Negative * Negative",Negative.multiply(Negative), new Rational(1,4));
        assertEquals("Positive * Standart",Positive.multiply(Standart), Standart);
        assertEquals("Negative * Standart",Negative.multiply(Standart), Standart);
        assertEquals("Standart * Standart",Standart.multiply(Standart), Standart);
    }

    @Test
    public void testDividePositive() {
        Rational Positive = new Rational(2,3);
        Rational Negative = new Rational(1,-3);
        Rational Standart = new Rational();
        assertEquals("Positive / Positive",Positive.divide(Positive), new Rational(1,1));
        assertEquals("Negative / Positive",Negative.divide(Positive), new Rational(-1,2));
        assertEquals("Negative / Negative",Negative.divide(Negative), new Rational(1,1));
        assertEquals("Positive / Negative",Positive.divide(Negative), new Rational(-2,1));
        assertEquals("Standart / Positve",Standart.divide(Positive), Standart);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideNegative() {
        Rational Positive = new Rational(2,3);
        Rational Standart = new Rational();
        Positive.divide(Standart);
    }

    @Test
    public void testLess(){
        Rational Positive = new Rational(1,2);
        Rational Negative = new Rational(1,-2);
        assertTrue("Negative > Positive",Negative.less(Positive));
        assertFalse("Negative > Positive",Positive.less(Negative));
    }

    @Test
    public void testLessOrEqual(){
        Rational Positive = new Rational(1,2);
        Rational Negative = new Rational(1,-2);
        Rational Standart = new Rational();
        assertTrue("Positive != Positive",Positive.lessOrEqual(Positive));
        assertFalse("Negative = Positive",Positive.lessOrEqual(Negative));
        assertTrue("Negative != Negative",Negative.lessOrEqual(Negative));
        assertTrue("Standart != Standart",Standart.lessOrEqual(Standart));
    }
}