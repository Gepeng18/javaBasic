package jvm.TestJavassist;

import java.lang.reflect.Method;
import java.util.Arrays;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;

/**
 * ����javassist��API
 * @author ��ѧ�ø�� www.sxt.cn
 *
 */
public class Demo02 {
	/**
	 * ������Ļ����÷�
	 * @throws Exception 
	 */
	public static void test01() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.bjsxt.test.Emp");
		
		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		
		System.out.println(cc.getName()); //��ȡ����
		System.out.println(cc.getSimpleName()); //��ȡ��Ҫ����
		System.out.println(cc.getSuperclass()); //��ø���
		System.out.println(cc.getInterfaces()); //��ýӿ�
		
	}
	
	/**
	 * ���Բ����µķ���
	 * @throws Exception 
	 */
	public static void test02() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.bjsxt.test.Emp");
		
//		CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}", cc);
		
		CtMethod m = new CtMethod(CtClass.intType,"add",
				new CtClass[]{CtClass.intType,CtClass.intType},cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("{System.out.println(\"www.sxt.cn\");return $1+$2;}");
		
		cc.addMethod(m);
		
		//ͨ��������������ɵķ���
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();  //ͨ������Emp�޲ι������������µ�Emp����
		Method method = clazz.getDeclaredMethod("add", int.class,int.class);
		Object result = method.invoke(obj, 200,300);
		System.out.println(result);
	}
	
	/**
	 * �޸����еķ�������Ϣ���޸ķ����������
	 * @throws Exception
	 */
	public static void test03() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.bjsxt.test.Emp");
		
		CtMethod cm = cc.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
		cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
		cm.insertAt(9, "int b=3;System.out.println(\"b=\"+b);");
		cm.insertAfter("System.out.println(\"end!!!\");");
		
		//ͨ��������������ɵķ���
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();  //ͨ������Emp�޲ι������������µ�Emp����
		Method method = clazz.getDeclaredMethod("sayHello", int.class);
		method.invoke(obj, 300);
	}

	/**
	 * ���ԵĲ���
	 * @throws Exception
	 */
	public static void test04() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.bjsxt.test.Emp");
		
//		CtField f1 = CtField.make("private int empno;", cc);
		CtField f1 = new CtField(CtClass.intType,"salary",cc);
		f1.setModifiers(Modifier.PRIVATE);
		cc.addField(f1);
		
//		cc.getDeclaredField("ename");   //��ȡָ��������
		
		//������Ӧ��set��get����
		cc.addMethod(CtNewMethod.getter("getSalary", f1));;
		cc.addMethod(CtNewMethod.getter("setSalary", f1));;
		
	}
	
	/**
	 * ���췽���Ĳ���
	 * @throws Exception
	 */
	public static void test05() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.bjsxt.test.Emp");
		
		CtConstructor[] cs = cc.getConstructors();
		for (CtConstructor c : cs) {
			System.out.println(c.getLongName());
		}
	}
	
	
	public static void test06() throws Exception{
		 CtClass cc = ClassPool.getDefault().get("com.bjsxt.test.Emp"); 
		 Object[] all = cc.getAnnotations();
		 Author a = (Author)all[0]; 
		 String name = a.name();
		 int year = a.year();
		 System.out.println("name: " + name + ", year: " + year);

	}
	
	
	public static void main(String[] args) throws Exception {
		test06();
	}
}
