package db;

import java.sql.SQLException;
import java.sql.Statement;

public class DBCreation {
	Statement state ;
	public DBCreation()
	{
		DerbyConnection.f_setConnect();
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void TableCreation()
	{
		try {
			/*
			 * 创建员工数据表
			 */
			state.execute("create table employee (number char(10) primary key, name char(10) not null, gender char(2) not null, " +
					"age int,study char(10),mobilephone char(11),telephone char(20),business char(10)," +
					"address char(100),description varchar(400),joindate date,password char(10))");
			
			/*
			 * 创建客户数据表
			 */
			state.execute("create table client (number char(10) primary key, name char(100) not null, principal char(10), " +
					"vocation char(20), zhucezijin int, kaihuhang char(100), zhanghao char(30), shuihao char(30)," +
					"nianyingyee int, jihuayuwosinianjiaoyie int, yiwanchengjiaoyie int, wangzhi char(100)," +
					"linkman char(10) , mobilephone char(11), telephone char(20), fax char(20), creditlevel char(1)," +
					"creditdes varchar(1000), staffer char(10) , address char(100), joindate date, lastchange date," +
					"jiezhiriqi date, qiankuan int, active smallint)");
			
			/*
			 * 创建联系人数据表
			 */
			 state.execute("create table linkman (company char(100) not null,name char(10) not null, gender char(2) , age int, business char(10)," +
			 		" mobilephone char(11), telephone char(20), fax char(20), description varchar(1000), joindate date, lastchange date, active smallint)");
		 
			 /*
			  * 创建交易额数据表
			  */
			 state.execute("create table tradeamount (tradedate date not null, company char(100) not null,amount int not null,active smallint)");
		
			 /*
			  * 创建客户发展计划表
			  */
			 state.execute("create table deveplan (company char(100) not null, planname char(50), startdate date, enddate date, content varchar(1000), aim varchar(1000), " +
			 		"accomplish smallint, active smallint)");
			 
			 /*
			  * 创建客户满意度表
			  */
			 state.execute("create table satisfaction (filldate date not null, company char(100) not null, number1 smallint not null, number2 smallint not null, number3 smallint not null," +
			 		"number4 smallint not null, number5 smallint not null, number6 smallint not null, number7 smallint not null, number8 smallint not null, number9 smallint not null, number10 smallint not null, number11 smallint not null, number12 smallint not null,active smallint)");
			 
			 /*
			  * 创建客户类型表
			  */
			 state.execute("create table kind (kindnumber char(20) primary key, kindname char(20) not null,parentkind char(20) )");
		
			 /*
			  * 创建客户类型关系表
			  */
			 state.execute("create table kindclient (kindnumber char(20) references kind(kindnumber) not null, clientnumber char(10) references client(number) not null, empnumber char(10) references employee(number) not null, active smallint)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DBCreation dbc = new DBCreation();
		dbc.TableCreation();
	}
}
