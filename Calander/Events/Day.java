package Events;

public class Day extends Events {

  private int year;
  private int month;
  private int day;

  Day(int year, int month, int day, String description) {
    super(year, month, day, description);
    // TODO Auto-generated constructor stub
  }
  
  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }
  @Override
  void getDescription() {
    // TODO Auto-generated method stub
    
  }

  @Override
  String setDescription() {
    // TODO Auto-generated method stub
    return null;
  }

}
