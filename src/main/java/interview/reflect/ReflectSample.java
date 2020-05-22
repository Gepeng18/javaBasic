package interview.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws Exception {
//        demo();
        Mytest1();
    }

    private static void Mytest1() throws Exception {

        Class c = Class.forName("interview.reflect.Robot");
        Constructor constructor = c.getConstructor();
        Robot robot2 = (Robot) constructor.newInstance();
        Field nameField = c.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(robot2,"Gepeng18");
        Method printNameMethod = c.getDeclaredMethod("printName",null);
        printNameMethod.setAccessible(true);
        printNameMethod.invoke(robot2,null);
    }

    private static void demo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class rc = Class.forName("interview.reflect.Robot");
        Robot r = (Robot) rc.newInstance();
        System.out.println("Class name is " + rc.getName());
        Method getHello = rc.getDeclaredMethod("throwHello", String.class);
        getHello.setAccessible(true);
        Object str = getHello.invoke(r, "Bob");
        System.out.println("getHello result is " + str);
        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(r, "Welcome");
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r, "Alice");
        sayHi.invoke(r, "Welcome");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
