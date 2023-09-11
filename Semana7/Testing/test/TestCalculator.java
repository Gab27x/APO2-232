import model.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculator {

    private Calculator calculator;

    public void setUp1(){
        calculator = new Calculator();
    }

    @Test
    public void testFactorialOfZeroValue(){
        // SetUp test
        setUp1();

        // Act
        int result = calculator.factorial(0);

        // assert
        assertEquals(1, result);
    }

    // Test type --> positive
    @Test
    public void testFactorialOfFiveValue(){
        // SetUp test
        setUp1();

        // Act
        int result = calculator.factorial(5);

        // assert
        assertEquals(120, result);
    }

    // test type --> Negative
    @Test
    public void testFactorialNegativeCase(){
        // SetUp test
        setUp1();

        // Act
        int result = calculator.factorial(4);

        // assert
        assertNotEquals(120, result);
        //
    }

}
