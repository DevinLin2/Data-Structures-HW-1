import java.util.*;

public class PhBLinkedList implements PhBListInterface{

  private LinkedList<Person> phoneBook;

  public PhBLinkedList() {
    phoneBook = new LinkedList<Person>();
  }

  /* O(1)
  Gets the size of the phoneBook using the built in size function of LinkedList.
  */
  public int size() {
    return phoneBook.size();
  }

  /* O(n)
  Uses LinkedList built in add function to insert elements into phoneBook.
  Runtime is linear in the worst case which is inserting to the end of the list
  which needs a linear traversal of the list. On average this is better than Arraylist insert
  because it does not require the list to resize and/or shift elements.
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
  Uses the built in remove function of LinkedList which has a worst case linear runtime of removing from the end
  of the list which will require a linear traversal of the list. On average this also runs faster than remove from
  ArrayList because there is no shifting of elements required.
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

  /* O(n)
  Uses LinkedList built in get method which has a linear runtime because a LinkedList does not have
  random index access and a lookup requires a linear traversal of the list.
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
