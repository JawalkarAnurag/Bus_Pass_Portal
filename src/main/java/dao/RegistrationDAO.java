package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import connector.DataSource;
import model.AdminLogin;
import model.AdminRegistration;
import model.UserLogin;
import model.UserRegistration;

public class RegistrationDAO {

	Connection con;
	ResultSet rs;
	boolean b;
	
	
	public int register(List<UserRegistration> userList) {
		// TODO Auto-generated method stub

		UserRegistration user=null;
		user=userList.get(0);
		con=DataSource.getConnection();
		int i=0;
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into pmpml_u_accounts values(?,?,?,?)");
			ps.setString(1,user.getUserName());
			ps.setString(2, user.getUserMail());
			ps.setString(3, user.getUserMobile());
			ps.setString(4, user.getUserPassword());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	private List<UserRegistration> getAllData() {

		List<UserRegistration> regList=new LinkedList<UserRegistration>();
		if(con==null) {

			 con= DataSource.getConnection();
				
		}
		
		try {
			Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from pmpml_u_accounts");
			
			while(rs.next()) {
				
				UserRegistration user=new UserRegistration();
				user.setUserName(rs.getString(1));
				user.setUserMail(rs.getString(2));
				user.setUserMobile(rs.getString(3));
				user.setUserPassword(rs.getString(4));
				
				regList.add(user);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return regList;
	}
	
	public boolean validateUser(UserLogin user) {
		System.out.println("In validateUser");
		
		List<UserRegistration> regList =getAllData();
		System.out.println(user.getUserMobile());
		System.out.println(user.getUserPassword());
		
		
	 b=false;

		for (UserRegistration reg : regList) {
			
			if(reg.getUserMobile().equals( user.getUserMobile()))
			{
				System.out.println("mobile matched");
				if(reg.getUserPassword().equals(user.getUserPassword()))
				{
					b=true;
					break;
				}
			}
			
		}
		
		return b;
	}
	
	public int registerAdmin(List<AdminRegistration> adRegList) {
		
		int i=0;
		if (con==null) {
			con=DataSource.getConnection();
				
		}
		AdminRegistration adreg=null;
		adreg=adRegList.get(0);
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into pmpml_a_accounts values(?,?,?,?,?)");
			ps.setString(1,adreg.getAdminName());
			ps.setString(2,adreg.getAdminID());
			ps.setString(3, adreg.getAdminMobile());
			ps.setString(4, adreg.getAdminMail());
			ps.setString(5,adreg.getAdminPassword());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;

	}
	
	public boolean validateAdmin(AdminLogin admin) {
		
		List<AdminRegistration> adRegList =getAllAdminData();
		
	 b=false;

		for (AdminRegistration adreg : adRegList) {
			
			if(adreg.getAdminID().equals( admin.getAdminID()))
			{
				System.out.println("ID matched");
				if(adreg.getAdminPassword().equals(admin.getAdminPassword())) {
					
					System.out.println("password matched");
					b=true;
					break;
				}
			}
			
		}
		
		return b;
	}

	private List<AdminRegistration> getAllAdminData() {

		List<AdminRegistration> adRegList=new LinkedList<AdminRegistration>();
		if (con==null) {
			con=DataSource.getConnection();
		}
		
		try {
			Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs=s.executeQuery("select * from pmpml_a_accounts");
			
			while(rs.next()) 
			{
				AdminRegistration adreg=new AdminRegistration();
				adreg.setAdminName(rs.getString(1));
				adreg.setAdminID(rs.getString(2));
				adreg.setAdminMobile(rs.getString(3));
				adreg.setAdminMail(rs.getString(4));
				adreg.setAdminPassword(rs.getString(5));
				
				adRegList.add(adreg);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return adRegList;
	}

	public AdminRegistration getAdmin(AdminLogin adlog) {
		
		AdminRegistration admin=new AdminRegistration();

		List<AdminRegistration> adRegList =getAllAdminData();
		
for (AdminRegistration adreg : adRegList) {
			
			if(adreg.getAdminID().equals( adlog.getAdminID()))
			{
				System.out.println("ID matched");
				admin.setAdminID(adreg.getAdminID());
				admin.setAdminName(adreg.getAdminName());
				admin.setAdminMobile(adreg.getAdminMobile());
				admin.setAdminMail(adreg.getAdminMail());
				
			}
			
		}
		return admin;
	}
}
