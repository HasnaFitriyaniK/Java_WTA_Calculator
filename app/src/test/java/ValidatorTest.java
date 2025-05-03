import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @Test
    public void testMinimalRange(){
        // TC1
        // Path id: P1-1
        // Menguji input angka kurang dari minimal range yaitu -32768

        String input = "-33000";

        String expected = "Error: Input di luar jangkauan";
        String result = Validator.validateNumber(input);

        assertEquals(expected, result);
    }

    @Test
    public void testMaximalRange(){
        // TC2
        // Path id: P1-1
        // Menguji input angka melebihi maksimal range yaitu 32767
        
        String input = "32800";

        String expected = "Error: Input di luar jangkauan";
        String result = Validator.validateNumber(input);
        
        assertEquals(expected, result);
    }

    @Test
    public void testValidNumber(){
        // TC3
        // Path id: P2-1
        // Menguji input angka yang valid
        
        String input = "12345";

        String result = Validator.validateNumber(input);
        
        assertNull(result);
    }

    @Test
    public void testInvalidNumberAlphabet(){
        // TC4
        // Path id: P3-1
        // Menguji input bukan angka yaitu karakter abjad
        
        String input = "aioeu"; 

        String expected = "Error: Input harus angka";
        String result = Validator.validateNumber(input);
        
        assertEquals(expected, result);
    }

    @Test
    public void testInvalidNumberSymbol(){
        // TC5
        // Path id: P3-1
        // Menguji input bukan angka yaitu karakter simbol
        
        String input = "!"; 

        String expected = "Error: Input harus angka";
        String result = Validator.validateNumber(input);
        
        assertEquals(expected, result);
    }

    @Test
    public void testInvalidNumberEmpty(){
        // TC6
        // Path id: P3-1
        // Menguji input bukan angka yaitu inputan kosong
        
        String input = ""; 

        String expected = "Error: Input harus angka";
        String result = Validator.validateNumber(input);
        
        assertEquals(expected, result);
    }

    @Test
    public void testIsParsableAsDoubleValid() {
        // TC7
        // Path id: P1-2
        // Menguji input angka bertipe data double valid
        
        String input = "2.5"; 

        boolean result = Validator.isParsableAsDouble(input);
        
        assertTrue(result);
    }

    @Test
    public void testIsParsableAsDoubleInvalid() {
        // TC8
        // Path id: P2-2
        // Menguji input angka tidak valid, bukan bertipe data double
        
        String input = "numberone"; 

        boolean result = Validator.isParsableAsDouble(input);
        
        assertFalse(result);
    }

    @Test
    public void testIsWithinRange() {
        // TC9
        // Path id: P1-3
        // Menguji angka di dalam range
        
        double input = -32000; 

        boolean result = Validator.isWithinRange(input);
        
        assertTrue(result);
    }

    @Test
    public void testIsValidOperator() {
        // TC10
        // Path id: P1-4
        // Menguji operator valid
        
        String operator = "/"; 

        boolean result = Validator.isValidOperator(operator);
        
        assertTrue(result);
    }

    @Test
    public void testIsNonZeroDivisor() {
        // TC11
        // Path id: P1-5
        // Menguji angka pembagi bukan nol
        
        double divisor = 0.0; 

        boolean result = Validator.isNonZeroDivisor(divisor);
        
        assertFalse(result);
    }
}