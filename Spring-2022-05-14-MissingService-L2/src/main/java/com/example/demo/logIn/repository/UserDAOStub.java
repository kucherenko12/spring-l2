package com.example.demo.logIn.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.logIn.service.User;

@Repository
public class UserDAOStub implements UserDAO {

	@Override
	public User getUser(String name, String password)
	{
		
	    //String jdbcURL = "jdbc:mysql://localhost:3306/bookshop";
	    //String dbUser = "root";
	    //String dbPassword = "password";
	    //Class.forName("com.mysql.jdbc.Driver");
	    //Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
	    //String sql = "SELECT * FROM users WHERE email = ? and password = ?";
	    //PreparedStatement statement = connection.prepareStatement(sql);
	    //statement.setString(1, email);
	    //statement.setString(2, password);
	
	    //ResultSet result = statement.executeQuery();
	
	    //ResultSet result = statement.executeQuery();
    
	    //User user = null;
	
	    //if (result.next())
	    //{
	    //    user = new User();
	    //    user.setFullname(result.getString("fullname"));
	    //    user.setEmail(email);
	    //}
	
	    //connection.close();
	    
	    User user = new User("admin", "admin");
	    
	    if(true) {return (user);}
	    else {return(null);}
	}
}
