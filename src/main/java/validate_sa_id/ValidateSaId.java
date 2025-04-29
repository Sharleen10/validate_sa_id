package validate_sa_id;

public class ValidateSaId {


    private static int daysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                // Leap year check
                return isLeapYear(year) ? 29 : 28;
            default:
                return 31;
        }
    }
    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }

    private static boolean validateLuhnChecksum(String idNumber) {
        // Luhn algorithm implementation
        int sum = 0;
        boolean alternate = false;

        // Start from the second-last digit and move left
        for (int i = idNumber.length() - 2; i >= 0; i--) {
            int digit = Character.getNumericValue(idNumber.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        // Calculate checksum
        int checksum = (10 - (sum % 10)) % 10;

        // Compare with the last digit
        return checksum == Character.getNumericValue(idNumber.charAt(idNumber.length() - 1));
    }

}
