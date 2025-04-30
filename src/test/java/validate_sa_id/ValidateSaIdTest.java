package validate_sa_id;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateSaIdTest {

    @Test
    void validIdNumbersShouldReturnTrue() {

        assertTrue(ValidateSaId.isIdNumberValid("8001015009087"));
        // Valid male born 15 Mar 2005
        assertTrue(ValidateSaId.isIdNumberValid("0503155009083"));
        // Valid female born 1 Feb 1990
        assertTrue(ValidateSaId.isIdNumberValid("9002014000088"));

    }

    @Test
    void invalidIdNumbersShouldReturnFalse() {
        // Invalid length
        assertFalse(ValidateSaId.isIdNumberValid("800101500908"));

        // Invalid month
        assertFalse(ValidateSaId.isIdNumberValid("8013015009087"));

        // Invalid day
        assertFalse(ValidateSaId.isIdNumberValid("8001325009087"));

        // Invalid checksum
        assertFalse(ValidateSaId.isIdNumberValid("8001015009088"));
    }

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
        assertTrue(ValidateSaId.isIdNumberValid("9602295009088")); // Day 29 in Feb of leap year (1996)
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

    @Test
    void invalidChecksumShouldReturnFalse() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800087"));
        assertFalse(ValidateSaId.isIdNumberValid("2909035800084"));
    }



}
