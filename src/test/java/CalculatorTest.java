import org.example.OOPCalculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void CalculatorSumTest() {
        System.out.println("Test for sum");
        Calculator calculator = new Calculator(4);
        calculator.setFirst(10);
        calculator.setSecond(12);
        calculator.executeOperation("+");
        Assert.assertEquals("Wrong sum",22, calculator.getResult(),0);
        System.out.println("Test for sum: successful");
    }
    @Test
    public void CalculatorSubTest() {
        System.out.println("Test for sub");
        Calculator calculator = new Calculator(4);
        calculator.setFirst(10);
        calculator.setSecond(12);
        calculator.executeOperation("-");
        Assert.assertEquals("Wrong sub",-2, calculator.getResult(),0);
        System.out.println("Test for sub: successful");
    }
    @Test
    public void CalculatorPowTest() {
        System.out.println("Test for pow");
        Calculator calculator = new Calculator(4);
        calculator.setFirst(10);
        calculator.setSecond(12);
        calculator.executeOperation("*");
        Assert.assertEquals("Wrong pow",120, calculator.getResult(),0);
        System.out.println("Test for pow: successful");
    }
    @Test
    public void CalculatorDivTest() {
        System.out.println("Test for div");
        Calculator calculator = new Calculator(4);
        calculator.setFirst(10);
        calculator.setSecond(12);
        calculator.executeOperation("/");
        Assert.assertEquals("Wrong div",0.8333333333333334, calculator.getResult(),0);
        System.out.println("Test for div: successful");
    }
    @Test
    public void CalculatorDivZeroTest() {
        System.out.println("Test for zero div");
        Calculator calculator = new Calculator(4);
        calculator.setFirst(10);
        calculator.setSecond(0);
        calculator.executeOperation("/");
        Assert.assertEquals("Wrong div",0, calculator.getResult(),0);
        System.out.println("Test for zero div: successful");
    }
}
