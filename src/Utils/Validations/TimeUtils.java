package Utils.Validations;

import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    public static Date addSecondstoDate(Date d, Long s) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.SECOND, Math.toIntExact(s));
        return calendar.getTime();
    }
}
