package jvm.TestReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.bjsxt.test.bean.User;

/**
 * ͨ������API��̬�Ĳ�����������������������
 * @author ��ѧ�ø�� www.sxt.cn
 *
 */
public class Demo03 {
	public static void main(String[] args) {

		String path = "com.bjsxt.test.bean.User";
		
		try {
			Class<User> clazz = (Class<User>) Class.forName(path);
			
			//ͨ������API���ù��췽�����������
			User u = clazz.newInstance();	//��ʵ�ǵ�����User���޲ι��췽��
			System.out.println(u);
			
			Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			User u2 = c.newInstance(1001,18,"��俶�");
			System.out.println(u2.getUname());
			
			//ͨ������API������ͨ����
			User u3 = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("setUname", String.class);
			method.invoke(u3, "�����");   //u3.setUname("�����");
			System.out.println(u3.getUname());
			
			//ͨ������API��������
			User u4 = clazz.newInstance();
			Field f = clazz.getDeclaredField("uname");
			f.setAccessible(true); //������Բ���Ҫ����ȫ����ˣ�����ֱ�ӷ���
			f.set(u4, "�����");		//ͨ������ֱ��д����
			System.out.println(u4.getUname());	//ͨ������ֱ�Ӷ����Ե�ֵ
			System.out.println(f.get(u4));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
}
