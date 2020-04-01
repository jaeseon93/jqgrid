package co.jessie.jqgrid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JqueryDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "jessie";
	private String password = "jessie";
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private String SELECT_ALL = "select * from jquery";
	
	public JqueryDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<JqgridVO> select() {
		ArrayList<JqgridVO> list = new ArrayList<JqgridVO>();
		JqgridVO vo;
		try {
			psmt = conn.prepareStatement(SELECT_ALL);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new JqgridVO();
				vo.setSeq(rs.getString("seq"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setEtcc(rs.getString("etcc"));
				vo.setGender(rs.getString("gender"));
				
				list.add(vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
