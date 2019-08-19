package Events;

abstract class Events {

  Events(int year, int month, int day, String description) {

  }
  

  abstract void getDescription();
  
  abstract String setDescription();

  
}
