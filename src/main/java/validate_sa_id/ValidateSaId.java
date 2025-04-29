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
        return year % 4 == 0;
    }

}
