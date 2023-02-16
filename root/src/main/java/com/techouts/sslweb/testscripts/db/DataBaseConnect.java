package com.techouts.sslweb.testscripts.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;

public class DataBaseConnect extends AbstractTest {

	public  Connection con;
	public  Statement stmt;
	public  ResultSet rs;
	public static final String URL = DBURL;

	public static final String DB_DRIVER = DBDRIVER;
	public static final String USERNAME = DB_USERNAME;
	public static final String PASSWORD = DB_PASSWORD;
	public  String otpValue;

	public String getOTP(String mobile) throws SQLException {

		registerDriver();
		connect();
		createStatement();
		executeQuery(mobile);
		try {
			while (rs.next()) {
				otpValue = rs.getString(1);
				System.out.println("OTP is " + otpValue);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ShoppersStopBusinessException("Failed to fetch data  " + e);
		} finally {
			con.close();
		}
		return otpValue;
	}

	private  void registerDriver() {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			throw new ShoppersStopBusinessException("Failed to register the driver class");
		}
	}

	private  void connect() {
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			throw new ShoppersStopBusinessException("Failed to connect to db");

		}
	}

	private  void createStatement() {
		try {
			stmt = con.createStatement();
		} catch (Exception e) {
			throw new ShoppersStopBusinessException("Failed to create statement");
		}
	}

	private  void executeQuery(String mobile) {
		try {
			rs = stmt.executeQuery("SELECT P_OTP FROM USEROTP where P_MOBILE='" + mobile + "'");
		} catch (Exception e) {
			throw new ShoppersStopBusinessException("Failed to execute query");
		}
	}

}
