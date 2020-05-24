package SORM.sorm2.sorm.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 封装表中一个字段的信息
 * @author gaoiqi www.sxt.cn
 * @version 0.8
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ColumnInfo {
	/**
	 * 字段名称
	 */
	private String name;
	
	/**
	 * 字段的数据类型
	 */
	private String dataType;
	
	/**
	 * 字段的键类型(0：普通键，1：主键 2：外键)
	 */
	private int keyType;


}
