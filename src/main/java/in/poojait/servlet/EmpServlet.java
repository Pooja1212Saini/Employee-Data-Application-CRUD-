package in.poojait.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.poojait.dto.EmpDTO;
import inpoojait.dao.EmpDAO;


@WebServlet("/insert")
public class EmpServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		// capturing the form data
		String name  = req.getParameter("name");
		String email = req.getParameter("email");
		String gender= req.getParameter("gender");
		String dept  = req.getParameter("dept");
		String exp   = req.getParameter("exp");
		
		// representing form data in object foms
		EmpDTO dto = new EmpDTO();
		dto.setEmp_name(name);
		dto.setEmp_email(email);
		dto.setEmp_gender(gender);
		dto.setEmp_department(dept);
	
		 int experience = 0;
		    try {
		        experience = Integer.parseInt(exp);
		    } catch (NumberFormatException e) {
		        e.printStackTrace(); 
		    }
		    dto.setEmp_experience(experience);

		
		//saving form data using dao method
		EmpDAO dao = new EmpDAO();
		boolean isSaved = dao.saveEmp(dto);
		   
		String msg = null;
		
		if(isSaved){
			
			msg = "Saved Successfully";
			
		}
		else {
			msg = " Failed To Save";
		}
		
		
		//send msg to sp page
		req.setAttribute("msg", msg);
		
		
		//redirect request to  same jsp page		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}







