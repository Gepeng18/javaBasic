
package jvm.TestDynamicCompile;


import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.UUID;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class OnlineExec {
    public static void main(String[] args) throws Exception {

        //通过IO流操作，将字符串存储成一个临时文件(Hi.java)，然后调用动态编译方法！
        String Content = "public class Hi {public static void main(String[] args){System.out.println(\"111\");}}";
        String fileName = "a" + UUID.randomUUID().toString().replace("-", "");

        String newFileContent = Content.replaceAll("class\\s+([$_a-zA-Z][$_a-zA-Z0-9]*)\\s*", "class " + fileName + " ");
//		System.out.println(newFileContent);

        File file = new File("f:/tmp/" + fileName + ".java");
        FileOutputStream javaSource = new FileOutputStream(file);
        javaSource.write(newFileContent.getBytes());
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "f:/tmp/" + fileName + ".java");
        System.out.println(result == 0 ? "编译成功" : "编译失败");
//

        //通过Runtime调用执行类
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp  f:/tmp    " + fileName);

        InputStream in = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String info = "";
        System.out.println("现在开始");

        while ((info = reader.readLine()) != null) {
            System.out.println(info);
        }

        try {
            if (null != javaSource) {
                javaSource.close();
            }
            file.delete();
            File classFile = new File("f:/tmp/" + fileName + ".class");
            classFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
