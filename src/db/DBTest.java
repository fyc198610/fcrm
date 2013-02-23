package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	Statement state = null;
	public DBTest()
	{
		
		DerbyConnection.f_setConnect();
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 *derby数据库测试,创建表
	 */
	public void createTableTest()
	{
		try {
			state.execute("create table test(number char(10), name varchar(10))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 *derby数据库测试,插入数据，查询数据
	 */
	public void dbcs()
	{
		try {
			ResultSet rs = state.executeQuery("select * from employee");
			while(rs.next())
			{
				for(int i=1;i<13;i++)
				{
					if(rs.getString(i)!=null)
						System.out.print(rs.getString(i).trim()+"  ");
					else
						System.out.print("   null");
				}
				System.out.println();
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBTest dbt = new DBTest();
		dbt.dbcs();
	}

	public Statement getState() {
		return state;
	}

	public void setState(Statement state) {
		this.state = state;
	}

}
