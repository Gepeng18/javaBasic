import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class person{
    static int i=0;
    static {
        System.out.println("你是");
        i = 1;
    }
}
public class readFile implements resourcesConstant{
    public static void main(String[] args) throws Exception {
        System.out.println(person.i);


    }
}
