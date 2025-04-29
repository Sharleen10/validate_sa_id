package validate_sa_id;

public class ValidateSaId {

    public static boolean isIdNumberValid(String idNumber) {
        // Check if the ID number is exactly 13 digits
        if (idNumber.length() != 13) {
            return false;
        }

        // Check if the ID number contains only numeric characters
        if (!idNumber.matches("\\d+")) {
            return false;
        }

        // Extract components
        String year = idNumber.substring(0, 2);
        String month = idNumber.substring(2, 4);
        String day = idNumber.substring(4, 6);
        String genderCode = idNumber.substring(6, 10);
        String citizenshipCode = idNumber.substring(10, 11);
        String checksumDigit = idNumber.substring(12);

        // Validate month (01-12)
        int monthInt = Integer.parseInt(month);
        if (monthInt < 1 || monthInt > 12) {
            return false;
        }

        // Validate day based on month
        int dayInt = Integer.parseInt(day);
        if (dayInt < 1 || dayInt > daysInMonth(monthInt, Integer.parseInt(year))) {
            return false;
        }

        // Validate gender code (0000-4999 for females, 5000-9999 for males)
        int genderInt = Integer.parseInt(genderCode);
        if (genderInt < 0 || genderInt > 9999) {
            return false;
        }

        // Validate citizenship (0 or 1)
        int citizenshipInt = Integer.parseInt(citizenshipCode);
        if (citizenshipInt != 0 && citizenshipInt != 1) {
            return false;
        }

        // Validate checksum using Luhn algorithm
        return validateLuhnChecksum(idNumber);
    }

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
