package Events;

public class Holiday extends Day {

  Holiday(int year, int month, int day, String description) {
    super(year, month, day, description);
    // TODO Auto-generated constructor stub
  }
  
  public enum Holidays {
    
 // commented are holidays that move around and need to work on
    NEWYEARS("New Years Day", 1, 1), 
//    MLK("Martin Luther King Day"), 
//    PRESIDENTS("President's Day"), 
//    EASTER("Easter Sunday"), 
//    MEMORIALOBS("Memorial Day Obs"), 
    MEMORIAL("Memorial Day", 5 , 29), 
    INDEPENDENCE("Independence Day", 7, 4),
    // LABOR("Labor Day"),
    // COLUMBUS("Columbus Day*"),
    VETERANS("Veteran's Day", 11, 10),
    // THANKSGIVING("Thanksgiving"),
    CHRISTMASEVE("Christmas Eve", 12, 24), 
    CHRISTMAS("Christmas Day", 12, 25), 
    NEWYEARSEVE("New Year's Eve", 12, 31 );

    private String holidayName;
    
    Holidays holidays;

    Holidays(String holidayName, int month, int day) {
      this.setHolidayName(holidayName);
    }

    public String getHolidayName() {
      return holidayName;
    }

    public void setHolidayName(String holidayName) {
      this.holidayName = holidayName;
    }
    

    public String getHoliday(int year, int month, int day, int week, int dayofweek) {

      if (month == 1 && day == 0) {
        holidays = NEWYEARS;
        return holidays.getHolidayName();
      }
     
      if (month == 5 && day == 29) {
        holidays = MEMORIAL;
        return holidays.getHolidayName();
      }

      if (month == 7 && day == 3) {
        holidays = INDEPENDENCE;
        return holidays.getHolidayName();
      }

      if (month == 11 && day == 10) {
        holidays = VETERANS;
        return holidays.getHolidayName();
      }

      if (month == 12 && day == 23) {
        holidays = CHRISTMASEVE;
        return holidays.getHolidayName();
      }

      if (month == 12 && day == 24) {
        holidays = CHRISTMAS;
        return holidays.getHolidayName();
      }

      if (month == 12 && day == 30) {
        holidays = NEWYEARSEVE;
        return holidays.getHolidayName();
      }

      return "";
    }

    public int findEasterDay(int year) {

      int c = year / 100;
      int n = year - 19 * (year / 19);
      int k = (c - 17) / 25;
      int i = c - c / 4 - (c - k) / 3 + 19 * n + 15;
      i = i - 30 * (i / 30);
      i = i - (i / 28) * (1 - (i / 28) * (29 / (i + 1)) * ((21 - n) / 11));
      int j = year + year / 4 + i + 2 - c + c / 4;
      j = j - 7 * (j / 7);
      int l = i - j;
      int m = 3 + (l + 40) / 44;
      int d = l + 28 - 31 * (m / 4);
      return d;
    }

    public int findEasterMonth(int year) {

      int c = year / 100;
      int n = year - 19 * (year / 19);
      int k = (c - 17) / 25;
      int i = c - c / 4 - (c - k) / 3 + 19 * n + 15;
      i = i - 30 * (i / 30);
      i = i - (i / 28) * (1 - (i / 28) * (29 / (i + 1)) * ((21 - n) / 11));
      int j = year + year / 4 + i + 2 - c + c / 4;
      j = j - 7 * (j / 7);
      int l = i - j;
      int m = 3 + (l + 40) / 44;
      return m;
    }
  }
  
  Holidays holidays;
  
  Holidays grabHolidays(Holidays holidays) {
    
    switch(holidays) {
      case NEWYEARS:
        this.holidays = holidays;
        break;
      
      default:
        break;
        
    }
    
    return holidays;
    
  }
  
}
