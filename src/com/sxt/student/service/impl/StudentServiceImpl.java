package com.sxt.student.service.impl;

import java.util.Date;
import java.util.List;

import com.sxt.model.Student;
import com.sxt.pagination.Pagination;
import com.sxt.pagination.SearchResult;
import com.sxt.student.dao.StudentDAO;
import com.sxt.student.dao.impl.StudentDAOImpl;
import com.sxt.student.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDao;
	
	public StudentServiceImpl(){
		studentDao = new StudentDAOImpl();
	}
	@Override
	public List<Student> findAll() {
		System.out.println("service findAll method start...");
		List<Student> list = studentDao.queryAll();
		System.out.println("service findAll method end...");
		return list;
	}
	@Override
	public void add(String name, String gander, String grade) {
		Student s = new Student();
		s.setName(name);
		s.setGander(Integer.parseInt(gander));
		s.setGrade(grade);
		s.setBirthday(new Date());
		studentDao.addStudent(s);
	}
	@Override
	public void delete(String id) {
		int stuId = Integer.parseInt(id);
		studentDao.deleteById(stuId);
	}
	@Override
	public Student findStudentById(String id) {
		int stuId = Integer.parseInt(id);
		Student stu = studentDao.queryStudentById(stuId);
		return stu;
	}
	@Override
	public void updateStudentById(String id, String name, String grade, String gander) {
		Student s = new Student();
		s.setId(Integer.parseInt(id));
		s.setName(name);
		s.setGander(Integer.parseInt(gander));
		s.setGrade(grade);
		studentDao.updateById(s);
	}
	@Override
	public List<Student> findStudentByPagination(int pageSize, String currentPageString) {
		int currentPage = Integer.parseInt(currentPageString);
		List<Student> list = studentDao.queryByPagination(currentPage,pageSize);
		return list;
	}
	@Override
	public int getAllCount(int pageSize) {
		int count = studentDao.queryCount();
		return (count % pageSize == 0)?(count /pageSize):(count/pageSize + 1);
	}
	@Override
	public SearchResult<Student> findStudentByPagination2(Pagination page) {
		SearchResult<Student> list = studentDao.queryByPagination2(page);
		return list;
	}

}
