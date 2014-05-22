package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logger.SagimaraLogger;

import org.apache.log4j.Logger;

import dto.BaseModel;
import dto.Inquiry;
import dto.Location;
import dto.User;
import dto.Video;

public class DatabaseManager {
	Logger logger;
	
	public DatabaseManager() {
		logger = SagimaraLogger.logger;
	}

	public ResultSet select(Connection conn, BaseModel model, String id)
			throws SQLException {
		String sql, tableName;
		PreparedStatement pstmt;
		ResultSet rs;
		tableName = model.getTableName();
		logger.info("[DatabaseManager-Select] Table NAME : " + tableName);
		if (tableName.equals("USERPROFILE")) {
			sql = "select * from " + "USER_PROFILE" + " where phone_number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			return rs;
		} else if (tableName.equals("INQUIRY")) {
			sql = "select * from " + "USER_INQUIRY" + " where phone_number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			return rs;
		}
		
		return null;
	}

	public int add(Connection conn, BaseModel model) throws SQLException {
		String tableName = model.getTableName();

		PreparedStatement pstmt = null;
		int result;
		logger.info("[DatabaseManager-add] Table NAME : " + tableName);

		if (tableName.equals("USER")) {
			User user = (User) model;
			String sql = "INSERT INTO " + tableName + " VALUES (?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserPhone());
			pstmt.setString(2, user.getUserVerification());
			pstmt.setString(3, user.getUserStatus());
			pstmt.setString(4, user.getUserLocation());
		} 

		if (tableName.equals("INQUIRY")) {
			Inquiry inquiry = (Inquiry) model;

			String sql = "INSERT INTO " + tableName
					+ " (`USER_user_phone`,`inquiry_time`) VALUES (?, ?)";
			logger.info("[DatabaseManager] Inquiry :"
					+ inquiry.getInquiryTime() + " : "
					+ inquiry.getInquiryTime());
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inquiry.getInquiryId());
			pstmt.setString(2, inquiry.getInquiryTime());

		}
		
		if(tableName.equals("LOCATION")) {
			Location location = (Location) model;
			
			String sql = "INSERT INTO " + tableName + " VALUES (?, ?, ?)";
			logger.info("[DatabaseManager] Location :"
					+ location.getLocationId() + " : "
					+ location.getLocationTime() + " : " 
					+ location.getLocationCoordinate()); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location.getLocationId());
			pstmt.setString(2, location.getLocationTime());
			pstmt.setString(3, location.getLocationCoordinate());
		}
		
		if(tableName.equals("LOCATION")) {
			Location location = (Location) model;
			
			String sql = "INSERT INTO " + tableName + " VALUES (?, ?, ?)";
			logger.info("[DatabaseManager] Location :"
					+ location.getLocationId() + " : "
					+ location.getLocationTime() + " : " 
					+ location.getLocationCoordinate()); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location.getLocationId());
			pstmt.setString(2, location.getLocationTime());
			pstmt.setString(3, location.getLocationCoordinate());
		}
		
		if(tableName.equals("VIDEO")) {
			Video video = (Video) model;
			
			String sql = "INSERT INTO " + tableName + "(USER_user_phone,location_time,location_coordinate)" + " VALUES (?, ?, ?)";
			logger.info("[DatabaseManager] Video :"
					+ video.getVideoId() + " : "
					+ video.getVideoLink() + " : "
					+ video.getVideoDate()); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, video.getVideoId());
			pstmt.setString(2, video.getVideoLink());
			pstmt.setString(3, video.getVideoDate());
		}

		try {
			result = pstmt.executeUpdate();
			if (result == 1) {
				logger.info("[DatabaseManager] Add " + tableName + " : "
						+ model);
			} else {
				logger.info("[DatabaseManager] Fail Add " + tableName);
			}

			return result;
		} catch (Exception e) {
			logger.error("pDatabaseManager] add Error : " + e.getMessage());
		}
		return 0;
	}

	public ArrayList<String> getColumns(Connection conn, String table) {
		ArrayList<String> columns = new ArrayList<String>();

		String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA='sagimara' AND TABLE_NAME='"
				+ table + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				columns.add(rs.getString(1));
			}
			
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return columns;
	}
}
