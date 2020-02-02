

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class User{
    private int id;
    private String name ;
    private int age ;

}

//select id from uses where id between 3 and 5 and age between 10 and 18 order by age （前包后不包）
public class select {
    public static void main(String[] args) {
        User gp = new User(1, "gp", 18);
        User fyy = new User(2, "fyy", 10);
        User xdd = new User(3, "xdd", 0);
        User fhy = new User(4, "fhy", 19);
        User gpp = new User(5, "gpp", 10);

        List<User> users = Arrays.asList(gp, fyy, xdd,fhy,gpp);
        System.out.println(select(users));

    }
    public static List<Integer> select(List<User> list){
        List<Integer> result = list.stream()
                .filter(u -> {
                    return ((u.getId() >= 3) && (u.getId() <= 5));
                })
                .filter(u -> {
                    return ((u.getAge() >= 10) && (u.getAge() <= 18));
                })
                .sorted((o1, o2) -> {
                    return o1.getAge() - o2.getAge();
                })
                .map(u -> {
                    return u.getId();
                })
                .collect(Collectors.toList());
        return result;
    }
}
