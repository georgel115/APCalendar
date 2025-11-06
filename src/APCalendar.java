public class APCalendar
{
    /** Returns true if year is a leap year and false otherwise. */
    public static boolean isLeapYear(int year)
    {
        if (year % 4 == 0 && year % 100 != 0)
            return true;
        return year % 400 == 0;
    }
    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
     */
    public static int numberOfLeapYears(int year1, int year2)
    {
        int leapYears = 0;
        for (int year = year1; year <= year2; year++)
        {
            if (isLeapYear(year))
            {
                leapYears++;
            }
        }
        return leapYears;
    }
    /** Returns the value representing the day of the week for the first day of year,
     * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
     */
    public static int firstDayOfYear(int year)
    {
        int day = 3;
        if (year < 2025)
            for (int i = 2025; i >= year; i--)
            {
                if (isLeapYear(i))
                {
                    day += 12;
                }
                if (!isLeapYear(i))
                {
                    day += 6;
                }
            }
        if (year > 2025)
            for (int a = year; a > 2025; a-- )
            {
                if (isLeapYear(a - 1))
                {
                    day += 2;
                }
                if (!isLeapYear(a - 1))
                {
                    day++;
                }
            }
        return (day + 1) % 7;
    }
    /** Returns n, where month, day, and year specify the nth day of the year.
     * Returns 1 for January 1 (month = 1, day = 1) of any year.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    public static int dayOfYear(int month, int day, int year)
    {
        int[] daysSince = {0, 31 ,59 , 90, 120, 151, 181, 212, 243, 304, 334, 365};
        if (isLeapYear(year) && month > 2)
        {
            return daysSince[month - 1] + day + 1;
        }
        else
            return daysSince[month - 1] + day;
    }
    /** Returns the value representing the day of the week for the given date
     * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
     * and 6 denotes Saturday.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    public static int dayOfWeek(int month, int day, int year)
    {
        return ((firstDayOfYear(year) + dayOfYear(month, day, year) - 1) % 7);
    }
}
