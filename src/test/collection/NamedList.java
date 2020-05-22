package collection;

import sun.misc.PostVMInitHook;

import java.util.ArrayList;

public class NamedList<E> extends ArrayList<E> {
    private String name = null;
    public NamedList(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString()+ " {" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        NamedList<Integer> list = new NamedList<>("这是我们的第一个list");
        list.add(2);
        System.out.println(list.getName());
        System.out.println(list);
    }
}
