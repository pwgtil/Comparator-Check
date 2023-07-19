import messages.Message;
import messages.MessageAuthorComparator;
import messages.MessageDateComparator;
import messages.MessageLenghtComparator;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Mike"));
        users.add(new User("Ginger"));
        users.add(new User("Alice"));
        users.add(new User("Bob"));

        users.sort(new UserComparator());
        users.forEach(System.out::println);

        users.clear();

        users.add(new User("microprogrammer"));
        users.add(new User("Moses"));
        users.add(new User("Chloe"));
        users.add(new User("user"));

        users.sort(new UserComparator());
        users.forEach(System.out::println);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("ab");
        list.sort(Comparator.naturalOrder());
        list.forEach(System.out::println);

        list.sort(Comparator.reverseOrder());
        list.forEach(System.out::println);


        List<Message> messages = new ArrayList<>();

        messages.add(new Message("Alien", "Hello humans!", 32, "2034-03-25"));
        messages.add(new Message("Pirate", "All hands on deck!", -2, "2034-01-05"));
        messages.add(new Message("User765214", "Bump!", 1, "2033-02-17"));
        messages.add(new Message("Unregistered", "This message was marked as spam", -18, "2033-01-14"));

        messages.sort(new MessageDateComparator());
        messages.forEach(System.out::println);
        System.out.println();
        messages.sort(new MessageLenghtComparator());
        messages.forEach(System.out::println);
        System.out.println();
        messages.sort(new MessageAuthorComparator());
        messages.forEach(System.out::println);

        System.out.println();
        messages.sort(Comparator.comparing(Message::getCreated));
        messages.sort(Comparator.comparing(Message::getCreated).reversed().thenComparing(Message::getContent));
        messages.sort((m1, m2) -> m1.getCreated().compareTo(m2.getCreated()));

    }



}


class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {

        return user1.getName().substring(0, 1).compareTo(user2.getName().substring(0, 1));
    }
}