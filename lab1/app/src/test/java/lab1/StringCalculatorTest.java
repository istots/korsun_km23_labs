package lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    public StringCalculator stringCalculatorInstance = new StringCalculator();
    


    @Test 
    void emptyStringTest() throws Exception {
        assertEquals(stringCalculatorInstance.add(""), 0);
    }    

    // A single number returns the value
    @Test
    void singleNumberReturnItsValueTest() throws Exception {
        assertEquals(stringCalculatorInstance.add("2"), 2);
        assertEquals(stringCalculatorInstance.add("1"), 1);
    }
    //Two numbers, comma delimited, returns the sum
    @Test
    void twoNumbersCommaDelimitedReturnsTheSumTest() throws Exception {
        assertEquals(stringCalculatorInstance.add("0,2"), 2);
        assertEquals(stringCalculatorInstance.add("1,1"), 2);
        assertEquals(stringCalculatorInstance.add("1,2"), 3);
    }
    
    // Two numbers, newline delimited, returns the sum
    @Test
    void sameThatBeforeButNewLineDelimitedTest() throws Exception {
        assertEquals(stringCalculatorInstance.add("0\n2"), 2);
        assertEquals(stringCalculatorInstance.add("1\n1"), 2);
        assertEquals(stringCalculatorInstance.add("1\n2"), 3);
    }


}