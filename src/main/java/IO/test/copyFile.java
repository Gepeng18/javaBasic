package IO.test;

import java.io.*;

public class copyFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream(new File("originalFile"));
             FileOutputStream out = new FileOutputStream(new File("copyFile"));
        ) {
            byte[] buffer = new byte[1024];
            int index = 0;
            while ((index = in.read(buffer)) != -1) {
                out.write(buffer, 0, index);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
