import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class CountWorkingDays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Calendar startDate = DateFormatted(scan.nextLine(), format);
        Calendar endDate = DateFormatted(scan.nextLine(), format);

        int[][] holidays = {
                { 1, 1 },
                { 3, 3 },
                { 1, 5 },
                { 6, 5 },
                { 24, 5 },
                { 6, 9 },
                { 22, 9 },
                { 1, 11 },
                { 24, 12 },
                { 25, 12 },
                { 26, 12 }
        };

        SimpleDateFormat formatDayNumber = new SimpleDateFormat("dd", Locale.ENGLISH);
        SimpleDateFormat formatMonthNumber = new SimpleDateFormat("MM", Locale.ENGLISH);
        SimpleDateFormat formatDayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH);

        int workingDays = 0;
        boolean lastLoop = false;

        while (true) {
            if (lastLoop){
                break;
            }

            if (startDate.compareTo(endDate) == 0){
                lastLoop = true;
            }

            if (IsWorkingDay(startDate, holidays, formatDayNumber,
                    formatMonthNumber, formatDayOfWeek)){
                workingDays++;
            }

            startDate.add(Calendar.DATE, 1);
        }
        System.out.println(workingDays);
    }

    private static boolean IsWorkingDay(Calendar date,
                                        int[][] holidays,
                                        SimpleDateFormat formatDayNumber,
                                        SimpleDateFormat formatMonthNumber,
                                        SimpleDateFormat formatDayOfWeek) {
        int t = date.get(Calendar.DAY_OF_WEEK);
        if (t == 1 || t == 7){
            return false;
        }

        for (int i = 0; i < holidays.length; i++) {
            int day = date.get(Calendar.DAY_OF_MONTH);
            int month = date.get(Calendar.MONTH);
            if (day == holidays[i][0] && month == holidays[i][1] + 1){
                return false;
            }
        }

        return true;
    }

    private static Calendar DateFormatted(String input, SimpleDateFormat format) {
        Calendar date = Calendar.getInstance();
        try {
            date.setTime(format.parse(input));
        } catch (ParseException e){
            e.printStackTrace();
        }

        return date;
    }
}
