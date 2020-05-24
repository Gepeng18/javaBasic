package IO;

import java.io.*;

public class copyFile {
    public static void main(String[] args) {
//        simpleCopy();
        bufferCopy();
//        stringCopy();

    }

    private static void stringCopy() {
        try {
            BufferedReader src = new BufferedReader(new FileReader(new File("src\\test\\IO", "originalFile")));
            BufferedWriter dst = new BufferedWriter(new FileWriter(new File("src\\test\\IO", "copyFile3")));
            char [] buf = new char[1024];
            int index = 0;
            while ((index = src.read(buf))!=-1){
                dst.write(buf,0,index);
                dst.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void bufferCopy() {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File("src\\test\\IO", "originalFile")));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("src\\test\\IO", "copyFile2")));) {
            byte[] buffer = new byte[1024];
            int index = 0;
            while((index = in.read(buffer))!=-1){
                out.write(buffer,0,index);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void simpleCopy() {
        System.out.println(System.getProperty("user.dir"));
        try (FileInputStream in = new FileInputStream(new File("src\\test\\IO", "originalFile"));
             FileOutputStream out = new FileOutputStream(new File("src\\test\\IO", "copyFile1"));
        ) {
            byte[] buffer = new byte[1024];
            int index = 0;
            while ((index = in.read(buffer)) != -1) {
                out.write(buffer, 0, index);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
