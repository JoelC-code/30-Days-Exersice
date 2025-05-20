package Class.Calender;

import java.util.Calendar;

public abstract class CalenderBase {
    protected int day;
    protected int week;
    protected String month;

    public abstract void setDate(Calendar calendar);
    public abstract String getFormattedDate();
}
