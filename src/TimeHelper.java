import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gil Peretz on 02/06/2016.
 */
public class TimeHelper {


    private static String addZero(int timeToAdd) {
        String result = String.valueOf(timeToAdd);
        if (timeToAdd < 10)
            result = "0" + result;

        return result;
    }

    public static String getTimeFromCalendar(Calendar calendar) {
        return String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ':' + addZero(calendar.get(Calendar.MINUTE));
    }

    public static String getTimeFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getTimeFromCalendar(calendar);
    }

    public static String getCurrentTime() {
        return getTimeFromCalendar(Calendar.getInstance());
    }

    public static String getHourFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
    }

    public static String getTimeFromDate(Date date, TimeZone tz) {
        Calendar calendar = Calendar.getInstance(tz);
        calendar.setTime(date);
        return getTimeFromCalendar(calendar);
    }

    public static String getTimeWithSecFromCalendar(Calendar calendar) {
        return String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ':' + addZero(calendar.get(Calendar.MINUTE)) + ':' + addZero(calendar.get(Calendar.SECOND));
    }

    public static String getTimeWithSecFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getTimeWithSecFromCalendar(calendar);
    }

    public static String getTimeWithSecFromDate(Date date, TimeZone tz) {
        Calendar calendar = Calendar.getInstance(tz);
        calendar.setTime(date);
        return getTimeWithSecFromCalendar(calendar);
    }

    public static Date addSeconds(long timeTo, int intervalSec) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeTo);
        calendar.add(Calendar.SECOND, intervalSec);
        return calendar.getTime();
    }

    public static Date getLocalTime(Date sourceDate, TimeZone sourceTimeZone) {
        long time = sourceDate.getTime();
        return getLocalTime(time, sourceTimeZone);
    }

    public static Date getLocalTime(long time, TimeZone sourceTimeZone) {
        return new Date(getLocalTimeLong(time, sourceTimeZone));
    }

    public static long getLocalTimeLong(long time, TimeZone sourceTimeZone) {
        int timezoneOffsetMillis = sourceTimeZone.getOffset(time) - TimeZone.getDefault().getOffset(time);
        return time + timezoneOffsetMillis;
    }

    public static Date getUTCTime(Date timeTo, TimeZone fromTimeZone) {
        int offset = fromTimeZone.getOffset(timeTo.getTime());
        return new Date(timeTo.getTime() - offset);
    }

    public static long getUTCTime(long timeTo, TimeZone fromTimeZone) {
        int offset = fromTimeZone.getOffset(timeTo);
        return timeTo - offset;
    }

    public static long getTimeInterval(Date from, Date to) {
        return to.getTime() - from.getTime();
    }

    public static long getUTCTimeMillis(Date time, TimeZone fromTimeZone) {
        int offset = fromTimeZone.getOffset(time.getTime());
        return time.getTime() - offset;
    }

    public static Timestamp asTimestamp(Date date) {
        Timestamp result = null;
        if (date != null)
            result = new Timestamp(date.getTime());

        return result;
    }

    public static java.sql.Date asSqlDate(Date date) {
        java.sql.Date result = null;
        if (date != null)
            result = new java.sql.Date(date.getTime());

        return result;
    }

    public static Date getToday() {
        return Calendar.getInstance().getTime();
    }

    public static int getSecondsFromMidnight(Date date) {
        long now = date.getTime();
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long millisecondsPassed = now - c.getTimeInMillis();
        return (int) TimeUnit.MILLISECONDS.toSeconds(millisecondsPassed);
    }

    public static int secondsFromMidnightOfEpochDay(Date date, int epochDay) {
        int dateDay = (int) TimeUnit.MILLISECONDS.toDays(date.getTime());

        if (dateDay < epochDay) {
            throw new IllegalArgumentException("secondsFromMidnightOfEpochDay date " + date + " is before " + epochDay);
        } else if (dateDay == epochDay) {
            return secondsFromMidNightKeepDateTimeZone(date);
        } else {
            return ((int) TimeUnit.DAYS.toSeconds(dateDay - epochDay)) + secondsFromMidNightKeepDateTimeZone(date);
        }
    }

    public static int secondsFromMidNightKeepDateTimeZone(Date date)
    {
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date
        int hh = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        int m = calendar.get(Calendar.MINUTE);        // gets hour in 12h format
        int sec = calendar.get(Calendar.SECOND);

        return (int)(TimeUnit.HOURS.toSeconds(hh) + TimeUnit.MINUTES.toSeconds(m) + sec);
    }
}
