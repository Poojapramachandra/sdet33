package GenericUtility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * This class contains all the Generic Methods of DataBase
 * @author POOJA P R
 *
 */
public class DataBaseUtility {
	
	 public static Connection connection;
	static ArrayList<String> List = new ArrayList<String>();
	
	/**
	 *This Method is used to establish the connection of the mySql Database
	 * @param dbUrl
	 * @param dbUn
	 * @param dbPwd
	 * @throws SQLException 
	 */
	public static void getMySqlDatabaseConnection(String dbUrl, String dbUn, String dbPwd) throws SQLException{
		Driver driver= new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection= DriverManager.getConnection(dbUrl, dbUn, dbPwd);
		}
	/**
	 * This Method is used to fectch the data from database on the ColumnNumber
	 * @param Query
	 * @param columnNumber
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> getDataFromDatabase(String Query, int columnNumber) throws SQLException{
		
		 Statement statement = connection.createStatement();
		 ResultSet result = statement.executeQuery(Query);
		 
		 while (result.next()) {
			List.add(result.getString(columnNumber));
		}
		 statement.close();
		return List;
		
	}
	
	public static ArrayList<String> getDataFromDatabase(String Query, String columnName) throws SQLException{
		
		 Statement statement = connection.createStatement();
		 ResultSet result = statement.executeQuery(Query);
		 
		 while (result.next()) {
			List.add(result.getString(columnName));
		}
		 statement.close();
		return List;
		
	}
	/**
	 * This method is used to fetch the data from database on the columnName
	 * @param Query
	 * @param columnNumber
	 * @return
	 * @throws SQLException
	 
	public static ArrayList<String> getDataFromDatabase(String Query, String columnNameOrcolumnNumber ) throws SQLException {
	
		String num="";
		for (int i = 0; i < columnNameOrcolumnNumber.length(); i++) {
			char ch=columnNameOrcolumnNumber.charAt(i);
			if (Character.isDigit(ch)) {
				num=num+columnNameOrcolumnNumber.charAt(i);
				}else{
					break;
				}
		}
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(Query);
		
		String columnName=null;
		
	    int columnNameOrcolumnNumber1;
		if (num.equalsIgnoreCase(columnNameOrcolumnNumber1)) {
			columnNameOrcolumnNumber1=Integer.parseInt(num);
			while(result.next()){
				List.add(result.getString(columnNameOrcolumnNumber1));
			}
		}else{
			columnName=columnNameOrcolumnNumber1;
			while (result.next()) {
				List.add(result.getString(columnNameOrcolumnNumber1));
			}
		}
		statement.close();
		return List;	
	}

	 * This method is used to update/write/Modify the data inside the database
	 * @param Query
	 * @throws SQLException
	 */
	public static void UpdateDataBase(String Query) throws SQLException{
		Statement statement = connection.createStatement();
		statement.executeUpdate(Query);
		System.out.println("Query Created Successfully");
		statement.close();
			
	}
	
	/**
	 * This method is Used to close the DataBaseConnection
	 * @throws SQLException
	 */
	public static void closeDataBaseConnection() throws SQLException{
		
		connection.close();	
	}
	
	
	
	/**
	 * This method is used to verify the data whether it is present in the database or Not 
	 * @param Query
	 * @param columnNameOrColumnNumber
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public static boolean verifyData(String Query, String columnNameOrColumnNumber, String expData) throws SQLException{
		
		ArrayList<String> ListData= getDataFromDatabase(Query,columnNameOrColumnNumber);
		
		boolean flag=false;
		
		for (String data:ListData) {
			if (data.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		return flag;
		
	}

}
