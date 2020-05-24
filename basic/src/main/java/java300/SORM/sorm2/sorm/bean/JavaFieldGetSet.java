package java300.SORM.sorm2.sorm.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 封装了java属性和get、set方法的源代码
 * @author gaoqi
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JavaFieldGetSet {
	/**
	 * 属性的源码信息。如：private int userId;
	 */
	private String fieldInfo;
	/**
	 * get方法的源码信息.如：public int getUserId(){}
	 */
	private String getInfo;
	/**
	 * set方法的源码信息.如：public void setUserId(int id){this.id = id;}
	 */
	private String setInfo;
	
	
	

}
