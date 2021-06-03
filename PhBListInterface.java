import java.util.*;

interface PhBListInterface {
  int size();
  void insert(int i, Person person);
  Person remove(int i);
  Person lookup(int i);
  Iterator<Person> getIterator();
}
