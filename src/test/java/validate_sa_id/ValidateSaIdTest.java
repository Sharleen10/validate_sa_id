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
    @Test
    void validDaysInFebruaryShouldBeCheckedCorrectly() {
        assertTrue(ValidateSaId.isIdNumberValid("1998294800082")); // Day 29 in Feb of leap year
        assertFalse(ValidateSaId.isIdNumberValid("2101294800089")); // Day 29 in Feb of non-leap year
    }
    @Test
    void invalidGenderCodeShouldReturnTrue() {
        // All gender codes between 0000-9999 are valid, so we don't need to test this
    }

    @Test
    void invalidCitizenshipCodeShouldReturnFalse() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800286")); // Citizenship code 2
    }



}
