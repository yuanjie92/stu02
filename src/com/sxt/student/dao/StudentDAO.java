package com.sxt.student.dao;

import java.util.List;

import com.sxt.model.Student;
import com.sxt.pagination.Pagination;
import com.sxt.pagination.SearchResult;

public interface StudentDAO {
	public List<Student> queryAll();
	
	public boolean addStudent(Student student);
	
	public boolean deleteById(int id);
	
	public boolean updateById(Student student);

	Student queryStudentById(int stuId);

	public List<Student> queryByPagination(int currentPage, int pageSize);

	public int queryCount();

	public SearchResult<Student> queryByPagination2(Pagination page);
}
