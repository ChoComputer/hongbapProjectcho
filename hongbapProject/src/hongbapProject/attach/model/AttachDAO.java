package hongbapProject.attach.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class AttachDAO {
	
		private DataSource ds;
		
		private AttachDAO() {
			try {
				Context ct = new InitialContext();
				ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}//�깮�꽦�옄 �걹
		
		private static AttachDAO dao = new AttachDAO();
		
		public static AttachDAO getInstance() {
			return dao;
		}//getInstance �걹
		
	public int attachWrite(AttachVO attach) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int resultCode = 0;
		
		String sql = "INSERT INTO resAttach (acheck, acontent, assessment, resId, awriter) VALUES ("
				+ "?, ?, ?, ?, ?)";
		
		
		
		try { 
			
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, attach.getAcheck());
			pstmt.setString(2, attach.getAcontent());
			pstmt.setInt(3, attach.getAssessment());
			pstmt.setInt(4, attach.getResId());
			pstmt.setString(5, attach.getAwriter());
			
			pstmt.executeUpdate();
			
			resultCode = 1;
			
		} catch(Exception e) {
			e.printStackTrace();
			resultCode = 0;
		} finally {
			try {
				if(con!=null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultCode;
	}// write 끝
		
	public ArrayList<AttachVO> getAllAttachByResId(int resId, int pageNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<AttachVO> attachListByResId = new ArrayList<>();
		
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM resAttach WHERE resId=? ORDER BY aid DESC limit ?, 10";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, resId);
			pstmt.setInt(2, pageNum);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int aid = rs.getInt("aid");
				String acheck = rs.getString("acheck");
				String acontent = rs.getString("acontent");
				int assessment = rs.getInt("assessment");
				int resid = rs.getInt("resId");
				String awriter = rs.getString("awriter");
				
				AttachVO attach = new AttachVO();
				attach.setAid(aid);
				attach.setAcheck(acheck);
				attach.setAcontent(acontent);
				attach.setAssessment(assessment);
				attach.setResId(resid);
				attach.setAwriter(awriter);
				
				attachListByResId.add(attach);
				
			}
			
			} catch(SQLException e) {
				System.out.println("�삁�쇅 : "+e);
			} finally {
				try {
					if(con != null && !con.isClosed()) {
						con.close();
					}
					if(pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}	
			return attachListByResId;
			
		}//attachList 끝

	public int getCountAttach(int resId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int countAttach = 0 ;
		
		String sql = "SELECT COUNT(*) FROM resAttach where resId=?";
		
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, resId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
			countAttach = rs.getInt(1);
			}
			
					
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
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
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return countAttach;
	} //getCountAttach 끝
	
	public double getAvgAssessment (int resId) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql = "SELECT avg(assessment) FROM resAttach WHERE resId=?";
		double avgA = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, resId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				avgA = rs.getDouble("avg(assessment)");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null&&!con.isClosed()) {
					con.close();
				}
				if(pstmt!=null&&!pstmt.isClosed()) {
					pstmt.close();
				}
				if(rs!=null&&!rs.isClosed()) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return avgA;
	}  // getAvgAssessment 종료

	
	public int attachDelete (String awriter) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM resAttach WHERE awriter = ?";
		
		int resultCode = 0;
		try {
			con = ds.getConnection();
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, awriter);
			
			pstmt.executeUpdate();
			resultCode =1;
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(con!=null&&!con.isClosed()) {
					con.close();
				}
				if(pstmt!=null&&!pstmt.isClosed()) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultCode;
	} // attachDelete 끝
	
	public int attachDeleteAll (int resId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM resAttach WHERE resId=?";
		
		int resultCode = 0;
		try {
			con = ds.getConnection();
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, resId);
			pstmt.executeUpdate();
			resultCode =1;
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(con!=null&&!con.isClosed()) {
					con.close();
				}
				if(pstmt!=null&&!pstmt.isClosed()) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultCode;
	} // attachDeleteAll 끝
}
