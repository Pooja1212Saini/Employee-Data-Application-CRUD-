package inpoojait.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.poojait.dto.EmpDTO;
import in.poojait.util.ConnectionFactory;

public class EmpDAO {

	
	private static final String INSERT =
			"INSERT INTO EMP_DETAILS(EMP_NAME,EMP_EMAIL,EMP_GENDER,EMP_DEPARTMENT,EMP_EXPERIENCE) VALUES (?,?,?,?,?)";
	
	public boolean saveEmp(EmpDTO empDto) {
		
		int count = 0;
		
		try{
			
		Connection con	= ConnectionFactory.getConnection();
		PreparedStatement psmt =con.prepareStatement(INSERT);
		psmt.setString(1, empDto.getEmp_name());
		psmt.setString(2, empDto.getEmp_email());
		psmt.setString(3, empDto.getEmp_gender());
		psmt.setString(4, empDto.getEmp_department());
		psmt.setInt(5, empDto.getEmp_experience());
		
		
		count = psmt.executeUpdate();
		
		
		}catch(Exception e) {
			 System.out.println("❌ DB Error: " + e.getMessage());	
			e.printStackTrace();
		}	
		return count > 0;
	}
	//=======================
	public List<EmpDTO> getEmps(EmpDTO empDto){	
	StringBuilder sql = new StringBuilder("select * from emp_details where 1 = 1");
	List<EmpDTO> emps = new ArrayList<EmpDTO>();
	
	try {
		
	if(empDto.getEmp_department()!=null && !empDto.getEmp_department().equals("")) {
			sql.append(" and emp_department = ?");
		}
		
	
	if(empDto.getEmp_gender()!=null && !empDto.getEmp_gender().equals("")) {
	    
		sql.append(" and emp_gender = ? ");	
	}
	
	if(empDto.getEmp_experience()!=null) {
		sql.append(" and emp_experience = ?");
	}
	
	
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement psmt = con.prepareStatement(sql.toString());
	int index = 1;
	
	if(empDto.getEmp_department()!=null && !empDto.getEmp_department().equals("")) {
		psmt.setString(index, empDto.getEmp_department());
		index ++;
	}
	

   if(empDto.getEmp_gender()!=null && !empDto.getEmp_gender().equals("")) {
    psmt.setString(index, empDto.getEmp_gender());
    index++;
   }

    if(empDto.getEmp_experience()!=null) {
	psmt.setInt(index, empDto.getEmp_experience());
	
   }
 	
	
	ResultSet rs = psmt.executeQuery();
	 while(rs.next()) {
		EmpDTO dto = new EmpDTO();
		dto.setEmp_id(rs.getInt("emp_id"));
		dto.setEmp_name(rs.getString("EMP_NAME"));
		dto.setEmp_email(rs.getString("EMP_EMAIL"));
		dto.setEmp_gender(rs.getString("EMP_GENDER"));
	    dto.setEmp_experience(rs.getInt("EMP_EXPERIENCE"));
	    
	    emps.add(dto);
	 }
	 
	}catch(Exception e) {
		e.printStackTrace();
	}
	return emps;
	
	}	
}







