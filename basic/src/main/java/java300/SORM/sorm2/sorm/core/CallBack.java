package java300.SORM.sorm2.sorm.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface CallBack {
	public Object doExecute(Connection conn,PreparedStatement ps,ResultSet rs);
}
