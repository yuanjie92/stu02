package com.sxt.servlet;

import java.io.IOException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.model.Student;
import com.sxt.pagination.Pagination;
import com.sxt.pagination.SearchResult;
import com.sxt.student.service.StudentService;
import com.sxt.student.service.impl.StudentServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	
	private StudentService service;
	
	@Override
	public void init() throws ServletException {
		service = new StudentServiceImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String option = req.getParameter("option");
		
		if(option == null || option.equals("")){
			show(req,resp);
		}
		
		if("add".equals(option)){
			add(req,resp);
		}
		
		if("del".equals(option)){
			del(req,resp);
		}
		
		if("showStu".equals(option)){
			showStu(req,resp);
		}
		
		if("update".equals(option)){
			update(req,resp);
		}
	}
	
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String grade = req.getParameter("grade");
		String gander = req.getParameter("gander");
		service.updateStudentById(id,name,grade,gander);
		req.getRequestDispatcher("student?option=").forward(req, resp);
	}
	private void showStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Student stu = service.findStudentById(id);
		req.setAttribute("stu", stu);
		req.getRequestDispatcher("edit.jsp").forward(req, resp);
	}
	private void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		service.delete(id);
		req.getRequestDispatcher("student?option=").forward(req, resp);
	}
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("name");
		String gander= req.getParameter("gander");
		String grade= req.getParameter("grade");
		service.add(name,gander,grade);
		
		req.getRequestDispatcher("student?option=").forward(req, resp);
	}
	
	private void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int pageSize = 5;
//		String currentPage = req.getParameter("currentPage");
//		if(currentPage == null || "".equals(currentPage)){
//			currentPage = "1";
//		}
//		req.setAttribute("currentPage", Integer.parseInt(currentPage));
//		List<Student> lists = service.findStudentByPagination(pageSize,currentPage);
//		int totalPage = service.getAllCount(pageSize);
//		
//		//List<Student> students = service.findAll();
//		req.setAttribute("totalPage", totalPage);
//		req.setAttribute("students", lists);
		
		String currentPage = req.getParameter("currentPage");
		if(currentPage == null || "".equals(currentPage)){
			currentPage = "1";
		}
		Pagination page = new Pagination();
		page.setCurrentPage(Integer.parseInt(currentPage));
		page.setPageSize(5);
		SearchResult<Student> searchResults = service.findStudentByPagination2(page);
		req.setAttribute("searchResults", searchResults);
		req.getRequestDispatcher("list2.jsp").forward(req, resp);		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
