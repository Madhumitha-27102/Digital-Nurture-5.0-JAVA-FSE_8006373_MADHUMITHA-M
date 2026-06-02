import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class RecordExample {
    public static void main(String[] args) {

        Person p1 = new Person("Akshaya", 20);
        Person p2 = new Person("Shree", 18);
        Person p3 = new Person("Abinash", 22);

        System.out.println("Person Records:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        List<Person> persons = Arrays.asList(p1, p2, p3);

        List<Person> adults = persons.stream()
                                     .filter(person -> person.age() >= 20)
                                     .collect(Collectors.toList());

        System.out.println("\nPersons with age >= 20:");

        for (Person person : adults) {
            System.out.println(person);
        }
    }
}