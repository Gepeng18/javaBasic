package juc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
class User
{
    private Integer id;
    private String  userName;
    private int     age;

}


/**

 * 题目：请按照给出数据，找出同时满足以下条件的用户,也即以下条件全部满足
 *      偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序
 *      只输出一个用户名字
 */
public class StreamDemo {
    public static void main(String[] args)
    {
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);
        /*List list1 = new ArrayList();
        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
        for (int i = 0; i < 5 ; i++) {
            if (list.get(i).getId() % 2 == 0){
                if (list.get(i).getAge() > 24){
                    list1.add(list.get(i).getUserName().toUpperCase());

                }
            }
        }
        System.out.println(list1.get(1));*/

        /*List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
        for (User user:list) {
            if (user.getId() % 2 == 0 && user.getAge() > 24){
                user.setUserName(user.getUserName().toUpperCase());
            }
        }
        Collections.reverse(list);//反转集合
        System.out.println(list.get(0).getUserName());*/

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        list.stream().filter(user1 -> {return user1.getId() % 2 == 0;})
                .filter(user1 -> {return user1.getAge() > 24;})
                .map(user1 -> {return user1.getUserName().toUpperCase();})
                .sorted((o1, o2) -> {return o2.compareTo(o1);})
                .limit(1).collect(Collectors.toList()).forEach(System.out :: println);
    }
}




