package validate_sa_id;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateSaIdTest {

    @Test
    void idNumberTooShortShouldReturnFalse() {
        assertFalse(ValidateSaId.isIdNumberValid("20010148000"));
    }
    @Test
    void idNumberTooLongShouldReturnFalse() {
        assertFalse(ValidateSaId.isIdNumberValid("20010148000861"));
    }
    @Test
    void idNumberWithNonNumericCharactersShouldReturnFalse() {
        assertFalse(ValidateSaId.isIdNumberValid("20010A4800086"));
    }



}
