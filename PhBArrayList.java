import java.util.*;

public class PhBArrayList implements PhBListInterface{

  private ArrayList<Person> phoneBook;

  public PhBArrayList() {
    phoneBook = new ArrayList<Person>();
  }

  /* O(1)
  Gets the size of the phoneBook using the built in size function of ArrayList.
  */
  public int size() {
    return phoneBook.size();
  }

  /* O(n)
  Uses ArrayList built in add function to insert elements into phoneBook.
  Runtime is linear in the worst case which is inserting to the beginning of the array
  causing the rest of the list to be shifted down, or the resizing of the array which is also
  a linear operation.
  */
  public void insert(int i, Person person) {
    if (i < 0) {
      System.out.println("Enter a Valid Index.");
    } else if (i >= size()) {
      phoneBook.add(person);
    } else {
      phoneBook.add(i, person);
    }
  }

  /* O(n)
  Uses the built in remove function of ArrayList which has a worst case linear runtime of removing from the beginning
  of the list which will require all subsequent elements to be shifted up.
  */
  public Person remove(int i) {
    if (i < 0) {
      System.out.println("Enter a Valid Index.");
    } else if (i >= size()) {
      return null;
    } else {
      return phoneBook.remove(i);
    }
    return null;
  }

  /* O(1)
  Uses the built in get function of ArrayList which always has a constant O(1) runtime as arrays have random index access.
  */
  public Person lookup(int i) {
    if (i >= size() || i < 0) {
      System.out.println("Enter a Valid Index.");
      return null;
    }
    return phoneBook.get(i);
  }

  // Simple getter method for an iterator which has an O(1) runtime.
  public Iterator<Person> getIterator() {
    Iterator<Person> iterator = phoneBook.iterator();
    return iterator;
  }
}
