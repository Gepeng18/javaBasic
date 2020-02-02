import lombok.*;

import java.util.*;


public class Collections_Sort {
    public static void main(String[] args) {

        //静态内部类，只在本类中使用，不在外部使用，所以用静态内部类
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        @Setter
        @ToString
        class User {
            private int id;
            private String name;
            private int age;
        }

        User g = new User(0, "g", 0);
        User f = new User(1, "f", 1);
        User h = new User(2, "h", 2);
        List<User> users = Arrays.asList(g, f, h);
        /** 方案1 匿名内部类
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId()-o2.getId();
            }
        });
         方案2  lambda*/
         users.sort((o1, o2)->{return o1.getId()-o2.getId();});


        System.out.println(users);
    }
}
