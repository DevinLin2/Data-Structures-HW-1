import java.util.*;

public class Demo {

  public static void main(String[] args) {
    PhBListInterface arrayPB = new PhBArrayList();
    PhBListInterface linkedListPB = new PhBLinkedList();
    Person bob = new Person("Bob", "123");
    Person ted = new Person("Ted", "1456");
    Person ned = new Person("Ned", "122");
    Person wendy = new Person("Wendy", "723");
    Person steve = new Person("Steve", "1299");
    Person joe = new Person("Joe", "9832");
    Person bill = new Person("Bill", "32423");

    /* For ArrayList implementation of phonebook, inserting to the back of the list allows for the fastest
    execution time as arrays have random index access. Adding the the end of the list ensures that we do not need
    to constantly shift elements, causing the O(n) runtime, and thus can get a relatively constant O(1) performace,
    only requiring a linear pass when the ArrayList runs out of space.
    */
    arrayPB.insert(arrayPB.size(), bob);
    arrayPB.insert(arrayPB.size(), ted);
    arrayPB.insert(arrayPB.size(), ned);
    arrayPB.insert(arrayPB.size(), wendy);
    arrayPB.insert(arrayPB.size(), steve);

    /* For LinkedList implementation of phonebook, inserting elements to the front of the list everytime allows for
    a constant O(1) runtime. This is because there is not a need to shift elements in a LinkedList as all that is
    required to add to the beginning of the list is to make the new node reference the previous first node as the next
    node. That can be done in a constant time. Adding to anywhere but the beginning of the list is suboptimal as traversal
    of the LinkedList will be required as they do not have random index access and can cause a worst case runtime of O(n) for insert.
    */
    linkedListPB.insert(0, bob);
    linkedListPB.insert(0, wendy);
    linkedListPB.insert(0, joe);
    linkedListPB.insert(0, bill);
    linkedListPB.insert(0, ted);

    Iterator<Person> arrayIter = arrayPB.getIterator();
    Iterator<Person> linkedListIter = linkedListPB.getIterator();

    // Printing out both phonebooks before removeDuplicates
    System.out.println("ArrayList Phonebook:");
    while (arrayIter.hasNext()) {
      Person current = arrayIter.next();
      System.out.println(current);
    }
    System.out.println("\nLinkedList Phonebook:");
    while (linkedListIter.hasNext()) {
      Person current = linkedListIter.next();
      System.out.println(current);
    }

    removeDuplicates(arrayPB, linkedListPB);

    arrayIter = arrayPB.getIterator();
    linkedListIter = linkedListPB.getIterator();

    // Printing out both phonebooks after removeDuplicates
    System.out.println("\nArrayList Phonebook after removeDuplicates:");
    while (arrayIter.hasNext()) {
      Person current = arrayIter.next();
      System.out.println(current);
    }
    System.out.println("\nLinkedList Phonebook after removeDuplicates:");
    while (linkedListIter.hasNext()) {
      Person current = linkedListIter.next();
      System.out.println(current);
    }
  }

  /* If we allow 'n' to represent the size of list1 and 'm' to represent the size of list2,
  The runtime of removeDuplicates will be O(nm) or in a general case O(n^2).
  This could be made faster by sorting the lists with something like quicksort and then iterating through
  the two lists which removes the necessity of retracing steps. That implementation would result in a O(nlogn) runtime.
  */
  public static void removeDuplicates(PhBListInterface list1, PhBListInterface list2) {
    Iterator<Person> list1Iter = list1.getIterator();
    Iterator<Person> list2Iter = list2.getIterator();
    while (list1Iter.hasNext()) {
      Person list1Current = list1Iter.next();
      list2Iter = list2.getIterator();
      while (list2Iter.hasNext()) {
        Person list2Current = list2Iter.next();
        if (list2Current.getName() == list1Current.getName() && list2Current.getNumber() == list1Current.getNumber()) {
          list2Iter.remove();
        }
      }
    }
  }
}
