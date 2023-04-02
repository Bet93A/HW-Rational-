import org.junit.*;
import static org.junit.Assert.*;

public class Tests {
    Rational Positive = new Rational(1,2); // положительная дробь
    Rational Negative = new Rational(1,-2); // отрицательная дробь
    Rational Standard = new Rational(); // по сути 0 (0/1), т.к. знаменатель не может быть = 0
    @Test
    public void testStandardConstructor() {
        assertEquals("Standard constructor returns wrong numerator", 0, Standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, Standard.getDenominator());
    }

    @Test(expected = ArithmeticException.class)
    public void testDenominator0() {
        new Rational(5, 0);
    }

    @Test
    public void testSimplifyMinuses() {
        assertEquals("minus is not in the numerator",Negative,new Rational(-1,2));
        assertEquals("minus + minus != plus", new Rational(-1,-2),Positive);
        assertEquals("numerator = -0", new Rational(-0,1),Standard);
    }

    @Test
    public void testReduce() {
        Rational Reduce = new Rational(-10,-20);
        assertEquals("The fraction is not reduced", Reduce, Positive);
    }

    @Test
    public void testPlus() {
        assertEquals("(1/2) + (1/2) != 1/1",Positive.plus(Positive), new Rational(1,1));
        assertEquals("(-1/2) + (1/2) != 0",Negative.plus(Positive), Standard);
        assertEquals("(-1/2) + (-1/2) != -1/1",Negative.plus(Negative), new Rational(-1,1));
        assertEquals("(1/2) + 0 != 1/2",Negative.plus(Standard), Negative);
        assertEquals("0 + 0 != 0",Standard.plus(Standard), Standard);
    }

    @Test
    public void testMinus() {
        assertEquals("(1/2) - (1/2) != 0",Positive.minus(Positive), Standard);
        assertEquals("(-1/2) - (1/2) != -1/1",Negative.minus(Positive), new Rational(-1,1));
        assertEquals("(1/2) - (-1/2) != 1/1",Positive.minus(Negative), new Rational(1,1));
        assertEquals("(-1/2) - (-1/2) != 1/1",Negative.minus(Negative), Standard);
        assertEquals("(-1/2) - 0 != -1/2",Negative.minus(Standard), Negative);
        assertEquals("0 - 0 != 0",Standard.minus(Standard), Standard);
    }

    @Test
    public void testMultiply() {
        assertEquals("(1/2) * (1/2) != 1/4",Positive.multiply(Positive), new Rational(1,4));
        assertEquals("(-1/2) * (1/2) != -1/4",Negative.multiply(Positive), new Rational(-1,4));
        assertEquals("(-1/2) * (-1/2) != 1/4",Negative.multiply(Negative), new Rational(1,4));
        assertEquals("(1/2) * 0 != 0",Positive.multiply(Standard), Standard);
        assertEquals("(-1/2) * 0 != 0",Negative.multiply(Standard), Standard);
        assertEquals("0 + 0 != 0",Standard.multiply(Standard), Standard);
    }

    @Test
    public void testDividePositive() {
        assertEquals("(1/2) / (1/2) != 1/1",Positive.divide(Positive), new Rational(1,1));
        assertEquals("(-1/2) / (1/2) != -1/1",Negative.divide(Positive), new Rational(-1,1));
        assertEquals("(-1/2) / (-1/2) != 1/1",Negative.divide(Negative), new Rational(1,1));
        assertEquals("(1/2) / (-1/2) != -1/1",Positive.divide(Negative), new Rational(-1,1));
        assertEquals("0 / (1/2) != 0",Standard.divide(Positive), Standard);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideNegative() {
        Positive.divide(Standard);
    }

    @Test
    public void testLess(){
        assertTrue("(-1/2) > (1/2)",Negative.less(Positive));
        assertFalse("(1/2) > (-1/2)",Positive.less(Negative));
        assertTrue("(-1/2) > 0", Negative.less(Standard));
        assertFalse("(1/2) < 0", Positive.less(Standard));
    }

    @Test
    public void testLessOrEqual(){
        assertTrue("Positive != Positive",Positive.lessOrEqual(Positive));
        assertFalse("Negative = Positive",Positive.lessOrEqual(Negative));
        assertTrue("Negative != Negative",Negative.lessOrEqual(Negative));
        assertTrue("Standart != Standart",Standard.lessOrEqual(Standard));
    }

    @Test
    public void testEqual() {
        assertTrue("(1/2) != (1/2)", Positive.equals(Positive));
        assertTrue("(-1/2) != (-1/2)", Negative.equals(Negative));
        assertTrue("0 != 0", Standard.equals(Standard));
        assertFalse("(-1/2) = (1/2)", Negative.equals(Positive));
    }
}