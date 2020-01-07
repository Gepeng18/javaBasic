package jvm.TestRhino;

import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * ���Խű�����ִ��javascript����
 * @author ��ѧ�ø�� www.sxt.cn
 *
 */
public class Demo01 {
	public static void main(String[] args) throws Exception {
		//��ýű��������
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//�������,�洢��������������
		engine.put("msg", "gaoqi is a good man!");
		String str = "var user = {name:'gaoqi',age:18,schools:['�廪��ѧ','������ѧ��']};";
		str += "println(user.name);";
		
		//ִ�нű�
		engine.eval(str);
		engine.eval("msg = 'sxt is a good school';");
		System.out.println(engine.get("msg"));
		System.out.println("###########################");
		
		//���庯��
		engine.eval("function add(a,b){var sum = a + b; return sum;}");
		//ȡ�õ��ýӿ�
		Invocable jsInvoke = (Invocable) engine;
		//ִ�нű��ж���ķ���
		Object result1 = jsInvoke.invokeFunction("add", new Object[]{13,20});
		System.out.println(result1);
		
		//��������java����ʹ���������е�java��.����Ҫ�����˽�ϸ�ڣ�������ϸѧϰRhino���﷨
		String jsCode = "importPackage(java.util); var list=Arrays.asList([\"������ѧ��\",\"�廪��ѧ\",\"������ѧ\"]);";
		engine.eval(jsCode);
		
		List<String> list2 = (List<String>)engine.get("list");
		for (String temp : list2) {
			System.out.println(temp);
		}
		
		//ִ��һ��js�ļ�(���ǽ�a.js������Ŀ��src�¼���)
		URL url = Demo01.class.getClassLoader().getResource("a.js");
		FileReader fr = new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();   //����ֻ�ǲ��ԣ��Ͳ���ô�淶�ˡ����ʵ����ʱҪʹ��try catch finally��
		
	}
}
