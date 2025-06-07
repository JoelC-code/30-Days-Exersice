package Class.Workout;

import Class.Calender.*;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class WorkoutCalender extends CalenderBase {

    private int year;
    private int monthIndex;

    @Override
    public void setDate(Calendar calendar) {
        Calendar now = Calendar.getInstance(); 
        this.day = now.get(Calendar.DAY_OF_MONTH);
        this.week = now.get(Calendar.WEEK_OF_YEAR);
        this.monthIndex = now.get(Calendar.MONTH);
        this.month = new DateFormatSymbols().getMonths()[monthIndex];
        this.year = now.get(Calendar.YEAR);
    }

    @Override
    public String getFormattedDate() {
        return "Today is: " + day + ", Week: " + week + ", Month: " + month;
    }

    public void displayDaysInMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, monthIndex);
        cal.set(Calendar.YEAR, year);

        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("Days in " + month + " " + year + ":");
        for (int i = 1; i <= daysInMonth; i++) {
            if(i % 7 != 0) {
                System.out.print(i);
            } else {
                System.out.println();
            }
        }
    }
}
