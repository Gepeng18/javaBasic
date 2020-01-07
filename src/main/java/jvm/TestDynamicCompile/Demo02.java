package jvm.TestDynamicCompile;

import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

/**
 * ����java�еĽű��������javascript�ű�
 * 
 * @author ��ѧ�ø�� www.sxt.cn
 *
 */
public class Demo02 {
	public static void main(String[] args) throws Exception {
		//��ýű�����
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		//�������
		engine.put("msg", "gaoqi is a good man!");// ���������ж���һ������
		String str = "var user = {name:'gaoqi',age:18,schools:['�廪��ѧ','������ѧ��']}; ";
		str += "println(user.name);";
		//ִ�нű�
		engine.eval(str);
		engine.eval("msg='sxt is a good school';");
		System.out.println(engine.get("msg"));
		System.out.println("########################");
		
		// ���庯��
		engine.eval("function add (a, b) {var sum = a + b; return sum; }");
		// ȡ�õ��ýӿ�
		Invocable jsInvoke = (Invocable) engine;
		//ִ�нű��ж���ķ���
		Object result1 = jsInvoke.invokeFunction("add", new Object[] { 13, 20 });
		System.out.println(result1);

		// ��������java��,ʹ���������е�java��
		String jsCode = "importPackage(java.util); var list = Arrays.asList([\"������ѧ��\",\"�廪��ѧ\",\"������ѧ\"]); ";
		engine.eval(jsCode);
		List<String> list2 = (List<String>) engine.get("list");
		for (String temp : list2) {
			System.out.println(temp);
		}

		//ִ��һ��js�ļ�(���ǽ�a.js������Ŀ��src�¼���)
		URL is = Demo02.class.getClassLoader().getResource("a.js");
		Reader r = new FileReader(is.getPath());
		engine.eval(r);
		
	}
}
