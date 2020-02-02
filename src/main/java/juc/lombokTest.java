package juc;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class lombokTest {
    private int id;
    private String name;

    public static void main(String[] args) {
        lombokTest lombokTest1 = new lombokTest(1, "我爱你");
        lombokTest lombokTest2 = new lombokTest();
        System.out.println(lombokTest2.getId());
        System.out.println(lombokTest2.getName());

        System.out.println(lombokTest1.getId());
        System.out.println(lombokTest1.getName());

    }
}


