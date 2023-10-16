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

    // Two numbers, comma delimited, returns the sum
    @Test
    void twoNumbersCommaDelimitedReturnsTheSumTest() throws Exception {
        assertEquals(stringCalculatorInstance.add("0,2"), 2);
        assertEquals(stringCalculatorInstance.add("1,1"), 2);
        assertEquals(stringCalculatorInstance.add("1,2"), 3);
    }
    
    // Two numbers, newline delimited, returns the sum
    @Test
    void sameThatBeforeButNewLineDelimitedTest() throws Exception {
        assertEquals(stringCalculatorInstance.add("0\\n2"), 2);
        assertEquals(stringCalculatorInstance.add("1\\n1"), 2);
        assertEquals(stringCalculatorInstance.add("1\\n2"), 3);
    }

    // Numbers more than 1000 should be ignored
    @Test
    void NumbersMoreThanThousandTest() throws Exception {
        assertEquals(stringCalculatorInstance.add("1001,1000,900"), 1900);
        assertEquals(stringCalculatorInstance.add("2000,1000,1000"), 2000);
    }

    // Negatives are not allowed
     @Test
    void NegativeNumbersTest() throws Exception {
        assertEquals(stringCalculatorInstance.add("-1"), null);
        assertEquals(stringCalculatorInstance.add("0,-5,100"), null);
        assertEquals(stringCalculatorInstance.add("-10,-10,200"), null);
    }

    // Only numbers allowed 
    @Test
    void NotANumberTest() throws Exception {
        assertEquals(stringCalculatorInstance.add("f"), null);
        assertEquals(stringCalculatorInstance.add("29,l"), null);
    }

    // User's separator of arbitrary length
    @Test
    void DelimeterByUserButArbitraryLengthTest() throws Exception {
        assertEquals(stringCalculatorInstance.add("//[*]\\n0**2"), 2);
        assertEquals(stringCalculatorInstance.add("//[$]\\n1$$1,2"), 4);
        assertEquals(stringCalculatorInstance.add("//[*]\\n1,2\\n2****3"), 8);
    }
}

