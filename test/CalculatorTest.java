
/*
 * Naomi Serkez
 * April 15th, 2024
 */

import com.example.calculator.CalculatorController;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//I tested the result() method, makes sure my math works as expected
public class CalculatorTest{
    @Test
    public void Test1() {
        CalculatorController calc = new CalculatorController();
        calc.setNumber1(10);
        calc.setNumber2(5);
        calc.setCurrOperation("+");
        Double expected = 15.0;
        Double actual = calc.result();
        assertEquals(expected, actual);
    }
    @Test
    public void Test2() {
        CalculatorController calc = new CalculatorController();
        calc.setNumber1(10);
        calc.setNumber2(5);
        calc.setCurrOperation("-");
        Double expected = 5.0;
        Double actual = calc.result();
        assertEquals(expected, actual);
    }
    @Test
    public void Test3() {
        CalculatorController calc = new CalculatorController();
        calc.setNumber1(10.34);
        calc.setNumber2(5);
        calc.setCurrOperation("+");
        Double expected = 15.34;
        Double actual = calc.result();
        assertEquals(expected, actual);
    }
    @Test
    public void Test4() {
        CalculatorController calc = new CalculatorController();
        calc.setNumber1(25);
        calc.setNumber2(5);
        calc.setCurrOperation("÷");
        Double expected = 5.0;
        Double actual = calc.result();
        assertEquals(expected, actual);
    }
    @Test
    public void Test5() {
        CalculatorController calc = new CalculatorController();
        calc.setNumber1(2);
        calc.setNumber2(5);
        calc.setCurrOperation("×");
        Double expected = 10.0;
        Double actual = calc.result();
        assertEquals(expected, actual);
    }
    @Test
    public void Test6() {
        CalculatorController calc = new CalculatorController();
        calc.setNumber1(2.5);
        calc.setNumber2(5);
        calc.setCurrOperation("×");
        Double expected = 12.5;
        Double actual = calc.result();
        assertEquals(expected, actual);
    }
}
