package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    private final static String PATTERN_DATE = "yyyy-MM-dd";

    public static LocalDate parseDate(String date) {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern(PATTERN_DATE);
        return LocalDate.parse(date, formater);
    }
}
