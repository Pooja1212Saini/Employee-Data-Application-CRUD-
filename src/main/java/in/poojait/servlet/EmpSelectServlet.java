package in.poojait.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import in.poojait.dto.EmpDTO;
import inpoojait.dao.EmpDAO;

@WebServlet("/select")
public class EmpSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String gender = req.getParameter("gender");
        String dept = req.getParameter("dept");
        String exp = req.getParameter("exp");

        EmpDTO dto = new EmpDTO();
        dto.setEmp_gender(gender);
        dto.setEmp_department(dept);

        int experience = 0;
        if (!exp.equals("")) {
            experience = Integer.parseInt(exp);
        }
        dto.setEmp_experience(experience);

        EmpDAO dao = new EmpDAO();
        List<EmpDTO> emps = dao.getEmps(dto);

        req.setAttribute("emps", emps);
        req.getRequestDispatcher("/emp.jsp").forward(req, resp);
    }
}
