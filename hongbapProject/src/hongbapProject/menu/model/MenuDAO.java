package hongbapProject.menu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MenuDAO {
private DataSource ds;
	
	private MenuDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}//생성자 끝
	
	private static MenuDAO dao = new MenuDAO();
	
	public static MenuDAO getInstance() {
		return dao;
	}//getInstance 끝
	
	public int insertMenu(MenuVO menu) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql ="INSERT INTO resMenu (resId, menuName, menuBook, menuPrice) VALUES"
				+ "(?, ?, ?, ?)";
		
		try {
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, menu.getResId());
		pstmt.setString(2, menu.getMenuName());
		pstmt.setString(3, menu.getMenuBook());
		pstmt.setString(4, menu.getMenuPrice());
		pstmt.executeUpdate();
		
		return 1;
		
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				if(con!=null&!con.isClosed()) {
					con.close();
				}
				if(pstmt!=null&!pstmt.isClosed()) {
					pstmt.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		
	}//insertMenu 끝
	
	public MenuVO getMenu(int resId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MenuVO menu = new MenuVO();
		String sql = "SELECT * FROM resMenu WHERE resId=?";
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, resId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				menu.setBid(resId);
				menu.setMenuName(rs.getString("menuName"));
				menu.setMenuBook(rs.getString("menuBook"));
				menu.setMenuPrice(rs.getString("menuPrice"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				if(con!=null&&!con.isClosed()) {
					con.close();
				}
				if(pstmt!=null&&!pstmt.isClosed()) {
					con.close();
				}
				if(rs!=null&&!rs.isClosed()) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return menu;
	}
	
	public int menuDelete(int resId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM resMenu WHERE resId=?";
		int resultCode = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, resId);
			pstmt.executeUpdate();
			resultCode = 1;
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null&&!con.isClosed()) {
					con.close();
				}
				if(pstmt!=null&&!pstmt.isClosed()) {
					pstmt.close();
				}
		
			} catch(Exception e) {
				e.printStackTrace();
			}
			}
		return resultCode;
	}
	
}
