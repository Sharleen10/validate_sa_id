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

    @Test
    void invalidMonthShouldReturnFalse() {
        assertFalse(ValidateSaId.isIdNumberValid("2013014800082")); // Month 13
        assertFalse(ValidateSaId.isIdNumberValid("2000014800087")); // Month 00
    }

    @Test
    void invalidDayShouldReturnFalse() {
        assertFalse(ValidateSaId.isIdNumberValid("2001324800088")); // Day 32 in January
        assertFalse(ValidateSaId.isIdNumberValid("2002304800087")); // Day 30 in February
        assertFalse(ValidateSaId.isIdNumberValid("2004310800081")); // Day 31 in April
    }



}
