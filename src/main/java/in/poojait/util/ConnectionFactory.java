package in.poojait.util;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
	private  static DataSource ds;
	
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			
			FileInputStream fis = new FileInputStream("D:\\NewAdvance\\EmpDataApplication\\src\\db.properties");
			Properties p = new Properties();
			p.load(fis);
			
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(p.getProperty("db.url")); 
            config.setUsername(p.getProperty("db.username"));
            config.setPassword(p.getProperty("db.password"));
            config.setDriverClassName(p.getProperty("db.driver")); 
			
			
			ds = new HikariDataSource(config);
			con= ds.getConnection();
			
			System.out.println(" Connected to DB: " + con);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}

}
