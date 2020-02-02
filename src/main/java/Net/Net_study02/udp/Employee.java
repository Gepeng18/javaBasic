package Net.Net_study02.udp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//javabean 封装数据
public class Employee implements java.io.Serializable{
	private transient String name; //该数据不需要序列化
	private double salary;

	
}