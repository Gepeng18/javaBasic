package java300.SORM.sorm2.sorm.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 管理配置信息
 * @author gaoqi www.sxt.cn
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Configuration {
	/**
	 * 驱动类
	 */
	private String driver; 
	/**
	 * jdbc的url
	 */
	private String url;
	/**
	 * 数据库的用户名
	 */
	private String user;
	/**
	 * 数据库的密码
	 */
	private String pwd;
	/**
	 * 正在使用哪个数据库
	 */
	private String usingDB;
	/**
	 * 项目的源码路径
	 */
	private String srcPath;
	/**
	 * 扫描生成java类的包(po的意思是：Persistence object持久化对象)
	 */
	private String poPackage;
	
	/**
	 * 项目使用的查询类是哪一个类
	 */
	private String queryClass;
	
	/**
	 * 连接池中最小的连接数
	 */
	private int poolMinSize;
	/**
	 * 连接池中最大的连接数
	 */
	private int poolMaxSize;
	
	

	

}
