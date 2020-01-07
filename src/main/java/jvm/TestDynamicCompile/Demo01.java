package jvm.TestDynamicCompile;


import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * ����java�Ķ�̬����
 * @author ��ѧ�ø�� www.sxt.cn
 *
 */
public class Demo01 {
	public static void main(String[] args) throws Exception {
		
		//ͨ��IO�����������ַ����洢��һ����ʱ�ļ�(Hi.java)��Ȼ����ö�̬���뷽����
		String str = "public class Hi {public static void main(String[] args){System.out.println(\"HaHa,sxt!\");}}";
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, "c:/myjava/HelloWorld.java");
		System.out.println(result==0?"����ɹ�":"����ʧ��");
		
		
		//ͨ��Runtime����ִ����
//		Runtime run = Runtime.getRuntime();  
//        Process process = run.exec("java -cp  c:/myjava    HelloWorld");  
//		
//        InputStream in = process.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//		String info = "";
//		while((info=reader.readLine())!=null){
//			System.out.println(info);
//		}
		
		
		
		
		 try {
             URL[] urls = new URL[] {new URL("file:/"+"C:/myjava/")};
             URLClassLoader loader = new URLClassLoader(urls);
             Class c = loader.loadClass("HelloWorld");
             //���ü������main����
             Method m = c.getMethod("main",String[].class);
             m.invoke(null, (Object)new String[]{});
             //���ڿɱ������JDK5.0֮����С�
             //m.invoke(null, (Object)new String[]{});������:m.invoke(null,"aa","bb"),�ͷ����˲���������ƥ������⡣
             //��ˣ�����Ҫ����(Object)ת�ͣ�����������⡣
             //public static void main(String[] args)
             
         } catch (Exception e) {
             e.printStackTrace();
         }


		
	}
}
