package SORM.sorm2.sorm.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 存储表结构的信息
 * @author gaoqi 
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TableInfo {
	/**
	 * 表名
	 */
	private String tname;  
	
	/**
	 * 所有字段的信息
	 */
	private Map<String,ColumnInfo> columns;
	
	/**
	 * 唯一主键(目前我们只能处理表中有且只有一个主键的情况)
	 */
	private ColumnInfo  onlyPriKey;
	
	
	/**
	 * 如果联合主键，则在这里存储
	 */
	private List<ColumnInfo> priKeys;   
	
	

	public TableInfo(String tname, Map<String, ColumnInfo> columns,
			ColumnInfo onlyPriKey) {
		this(tname,columns,onlyPriKey,null);
	}

	public TableInfo(String tname,List<ColumnInfo> priKeys, Map<String, ColumnInfo> columns
			) {
		this(tname,columns,null,priKeys);
	}

}
