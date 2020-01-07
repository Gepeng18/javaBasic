package jvm.TestReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Ӧ�÷����API����ȡ�����Ϣ(������֡����ԡ���������������)
 * @author ��ѧ�ø��  www.sxt.cn
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "com.bjsxt.test.bean.User";
		
		try {
			Class clazz = Class.forName(path);
			
			//��ȡ�������
			System.out.println(clazz.getName());//��ð���+������com.bjsxt.test.bean.User
			System.out.println(clazz.getSimpleName());	//���������User
			
			//��ȡ������Ϣ
//			Field[] fields = clazz.getFields(); //ֻ�ܻ��public��field
			Field[] fields = clazz.getDeclaredFields();//������е�field
			Field f = clazz.getDeclaredField("uname");
			System.out.println(fields.length);
			for(Field temp:fields){
				System.out.println("���ԣ�"+temp);
			}
			//��ȡ������Ϣ
			Method[] methods = clazz.getDeclaredMethods();
			Method m01 = clazz.getDeclaredMethod("getUname", null);
			//��������вΣ�����봫�ݲ������Ͷ�Ӧ��class����
			Method m02 = clazz.getDeclaredMethod("setUname", String.class); 
			for(Method m:methods){
				System.out.println("������"+m);
			}
			
			//��ù�������Ϣ
			Constructor[] constructors = clazz.getDeclaredConstructors();
			Constructor c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println("��ù�������"+c);
			for(Constructor temp:constructors){
				System.out.println("��������"+temp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
