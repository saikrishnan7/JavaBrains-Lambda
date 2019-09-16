import java.util.*;

public class Unit1Exercise {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
                );
        people.sort(Comparator.comparing(Person::getLastName));
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        print(p -> true, people);
        print(p -> p.getLastName().startsWith("C"), people);
    }

    private static void print(Condition c, List<Person> people) {
        for(Person p : people) {
            if(c.test(p))
                System.out.println(p);
        }
    }
}

interface Condition {
    boolean test(Person p);
}