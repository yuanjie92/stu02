package com.sxt.student.service;

import java.util.List;

import com.sxt.model.Student;
import com.sxt.pagination.Pagination;
import com.sxt.pagination.SearchResult;

public interface StudentService {
	
	List<Student> findAll();

	void add(String name, String gander, String grade);

	void delete(String id);

	Student findStudentById(String id);

	void updateStudentById(String id, String name, String grade, String gander);

	List<Student> findStudentByPagination(int pageSize, String currentPage);

	int getAllCount(int pageSize);

	SearchResult<Student> findStudentByPagination2(Pagination page);
	
}
