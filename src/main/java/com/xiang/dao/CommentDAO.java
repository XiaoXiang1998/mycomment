package com.xiang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.xiang.Util.DatabaseUtil;
import com.xiang.bean.CommentBean;

public class CommentDAO {
	public void insertComment(CommentBean com) {
		String sql = "INSERT INTO Comments(UserID, Username, UserType, CommentContent, rate) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, com.getUserID());
			stmt.setString(2, com.getUsername());
			stmt.setString(3, com.getUserType());
			stmt.setString(4, com.getCommentContent());
			stmt.setInt(5, com.getRate());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(stmt);
			DatabaseUtil.closeConnection(conn);
		}
	}

	public CommentBean getCommentByUserID(int userID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CommentBean bean = null;
		try {
			conn = DatabaseUtil.getConnection();
			String sql = "SELECT * FROM Comments WHERE userID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userID);
			rs = stmt.executeQuery();

			if (rs.next()) {
				bean = new CommentBean();
				bean.setUserID(rs.getInt("userID"));
				bean.setUsername(rs.getString("Username"));
				bean.setUserType(rs.getString("UserType"));
				bean.setCommentContent(rs.getString("CommentContent"));
				bean.setCommentTime(rs.getTimestamp("CommentTime").getTime());
				bean.setLastmodifiedtime(rs.getTimestamp("lastmodifiedtime").getTime());
				bean.setRate(rs.getInt("rate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(stmt);
			DatabaseUtil.closeConnection(conn);
		}
		return bean;

	}

	public List<CommentBean> getAllComments() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<CommentBean> beans = new ArrayList<>();

		try {
			conn = DatabaseUtil.getConnection();
			String sql = "SELECT * FROM Comments order by CommentTime desc ";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				CommentBean bean = new CommentBean();
				bean.setUserID(rs.getInt("userID"));
				bean.setUsername(rs.getString("Username"));
				bean.setUserType(rs.getString("UserType"));
				bean.setCommentContent(rs.getString("CommentContent"));
				bean.setCommentTime(rs.getTimestamp("CommentTime").getTime());
				bean.setLastmodifiedtime(rs.getTimestamp("lastmodifiedtime").getTime());
				bean.setRate(rs.getInt("rate"));
				beans.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(stmt);
			DatabaseUtil.closeConnection(conn);
		}

		return beans;
	}

	public void updateComment(CommentBean com) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DatabaseUtil.getConnection();
			String sql = "UPDATE Comments SET CommentContent=?,lastmodifiedtime=? WHERE UserID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, com.getCommentContent());
			stmt.setTimestamp(2, new java.sql.Timestamp(com.getLastmodifiedtime()));
			stmt.setInt(3, com.getUserID());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(stmt);
			DatabaseUtil.closeConnection(conn);
		}
	}

	public void deleteComment(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DatabaseUtil.getConnection();
			String sql = "DELETE  FROM Comments WHERE userID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(stmt);
			DatabaseUtil.closeConnection(conn);
		}
	}
	
	public List<CommentBean> getCommentsByUserInput(String userInput) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<CommentBean> beans = new ArrayList<>();

		try {
			conn = DatabaseUtil.getConnection();
			String sql = "SELECT * FROM Comments WHERE CommentContent LIKE ?";
			stmt = conn.prepareStatement(sql);
	        stmt.setString(1, "%" + userInput + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				CommentBean bean = new CommentBean();
				bean.setUserID(rs.getInt("userID"));
				bean.setUsername(rs.getString("Username"));
				bean.setUserType(rs.getString("UserType"));
				bean.setCommentContent(rs.getString("CommentContent"));
				bean.setCommentTime(rs.getTimestamp("CommentTime").getTime());
				bean.setLastmodifiedtime(rs.getTimestamp("lastmodifiedtime").getTime());
				bean.setRate(rs.getInt("rate"));
				beans.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(stmt);
			DatabaseUtil.closeConnection(conn);
		}

		return beans;
	}
	
	public void ReplyContent (CommentBean com) {
		String sql = "INSERT INTO Comments(UserID, Username, UserType, ReplyContent, rate ) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, com.getUserID());
			stmt.setString(2, com.getUsername());
			stmt.setString(3, com.getUserType());
			stmt.setString(4, com.getReplyContent());
			stmt.setInt(5, com.getRate());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(stmt);
			DatabaseUtil.closeConnection(conn);
		}
	}
	 public boolean isUserIDExists(String userID) {
	        Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = DatabaseUtil.getConnection();
	            
	            
	            String sql = "SELECT COUNT(*) FROM Comments WHERE UserID = ?";
	            statement = connection.prepareStatement(sql);
	            statement.setString(1, userID);
	            resultSet = statement.executeQuery();
	            
	            if (resultSet.next()) {
	                int count = resultSet.getInt(1);
	                return count > 0;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            DatabaseUtil.closeConnection(connection);
	            DatabaseUtil.closePreparedStatement(statement);
	            DatabaseUtil.closeResultSet(resultSet);
	        }

	        return false;
	    }

}
