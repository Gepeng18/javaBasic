package jvm.TestAnnotation;


/**
 * �����Զ���ע���ʹ��
 *
 */
@SxtAnnotation01
public class Demo02 {
	
	@SxtAnnotation01(age=19,studentName="�ϸ�",id=1001,
			schools={"������ѧ","�������պ����ѧ"})
	public void test(){
	}
	
	@SxtAnnotation02("aaaa")
	public void test2(){
	}
	
}