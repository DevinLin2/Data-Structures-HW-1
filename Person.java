public class Person {

  private String personID;
  private String phoneNum;

  public Person(String name, String number) {
    personID = name;
    phoneNum = number;
  }

  // Simple getter method with O(1) runtime
  public String getName() {
    return personID;
  }

  // Simple getter method with O(1) runtime
  public String getNumber() {
    return phoneNum;
  }

  // This is used to print out the contents of this tuple class in a readable format
  // O(1) performance
  public String toString() {
    return getName() + ": " + getNumber();
  }
}
