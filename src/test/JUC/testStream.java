package JUC;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class testStream {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class User{
        public int id;
        public String name;


        public int compareTo(User o1) {
            return id-o1.id;
        }
    }

    public static void main(String[] args) {
        User user1 = new User(0, "0");
        User user2 = new User(1, "1");
        User user3 = new User(2, "2");
        User user4 = new User(3, "3");
        User user5 = new User(4, "4");

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);
//        users.stream().filter(u->{return (u.getId()>1 && u.getId()<4);})
//                .sorted((o1, o2) -> {return o2.compareTo(o1);})
//                .map(User::getName)
//                .limit(1)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        users.stream().filter(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return false;
            }
        }).collect(Collectors.toList()).forEach(u->{
            System.out.println(u.getId()+" "+ u.getName());
        });
    }
}
