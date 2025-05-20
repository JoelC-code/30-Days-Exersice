package Class.Workout;

import Class.Calender.*;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class WorkooutCalender extends CalenderBase{
    
    @Override
    public void setDate(Calendar calender) {
        this.day = calender.get(Calendar.DAY_OF_MONTH);
        this.week = calender.get(Calendar.WEEK_OF_YEAR);
        this.month = new DateFormatSymbols().getMonths()[calender.get(Calendar.MONTH)];
    }

    @Override
    public String getFormattedDate() {
        return "Today is: " + day + ", " + week;
    }
}
