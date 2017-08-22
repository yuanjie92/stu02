package com.sxt.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import com.sxt.connection.ConnectionDB;
import com.sxt.model.Student;
import com.sxt.pagination.Pagination;
import com.sxt.pagination.SearchResult;
import com.sxt.student.dao.StudentDAO;

public class StudentDAOImpl implements StudentDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public StudentDAOImpl() {
		ConnectionDB db = new ConnectionDB();
		conn = db.getConnection();
	}

	@Override
	public List<Student> queryAll() {
		String sql = "SELECT * FROM TB_STUDENT";
		List<Student> list = new ArrayList<Student>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setGander(rs.getInt("gander"));
				s.setGrade(rs.getString("grade"));
				s.setBirthday(rs.getTimestamp("birthday"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public boolean addStudent(Student student) {
		boolean flag = false;
		String sql = "INSERT INTO tb_student (name,grade,birthday,gander) VALUES(?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getGrade());
			ps.setTimestamp(3, new Timestamp(student.getBirthday().getTime()));
			ps.setInt(4, student.getGander());
			int rs = ps.executeUpdate();
			if (rs > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteById(int id) {
		boolean flag = false;
		String sql = "DELETE FROM tb_student WHERE id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateById(Student student) {
		boolean flag=false;
		String sql = "update tb_student set name=?,grade=?,gander=? where id=? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,student.getName());
			ps.setString(2, student.getGrade());
			ps.setInt(3, student.getGander());
			ps.setInt(4, student.getId());
			int rs=ps.executeUpdate();
			if(rs>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

//	public static void main(String[] args) {
//		StudentDAO dao = new StudentDAOImpl();
//
//		for(int i=0;i<100;i++){
//			int x = (int)((Math.random()*(5-1)) + 1);
//			int x2 = (int)((Math.random()*5) + 1);
//			//System.out.println(x + ","+x2);
//		}
		
		
		//System.out.println(dao.queryCount());
		// 删除测试
		// System.out.println(dao.deleteById(23));

		// 查询测试
//		List<Student> list = dao.queryAll();
//		for (Student s : list) {
//			//System.out.println(s);
//		}
		//修改测试
		/*Student stu=new Student();
		stu.setName("hh");
		stu.setId(24);
		System.out.println(dao.updateById(stu));*/
		
		// System.out.println(System.currentTimeMillis());//获取当前时间戳

//	}

	@Override
	public Student queryStudentById(int stuId) {
		String sql = "SELECT * FROM TB_STUDENT where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stuId);
			rs = ps.executeQuery();
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setGander(rs.getInt("gander"));
				s.setGrade(rs.getString("grade"));
				s.setBirthday(rs.getDate("birthday"));
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public List<Student> queryByPagination(int currentPage, int pageSize) {
		String sql = "SELECT * FROM TB_STUDENT limit ?,?";
		List<Student> list = new ArrayList<Student>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,(currentPage - 1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setGander(rs.getInt("gander"));
				s.setGrade(rs.getString("grade"));
				s.setBirthday(rs.getDate("birthday"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public int queryCount() {
		String sql = "SELECT count(1) FROM TB_STUDENT";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs == null) {
				return 0;
			}
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public SearchResult<Student> queryByPagination2(Pagination page) {
		String sql = "SELECT * FROM TB_STUDENT limit ?,?";
		String sql2 = "SELECT count(1) FROM TB_STUDENT";
		SearchResult<Student> searchResult = new SearchResult<Student>();
		List<Student> list = new ArrayList<Student>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,(page.getCurrentPage() - 1)*page.getPageSize());
			ps.setInt(2, page.getPageSize());
			rs = ps.executeQuery();
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setGander(rs.getInt("gander"));
				s.setGrade(rs.getString("grade"));
				s.setBirthday(rs.getDate("birthday"));
				list.add(s);
			}
			
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			if (rs == null) {
			}
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			page.setTotalCount(count);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		searchResult.setPage(page);
		searchResult.setResults(list);
		
		return searchResult;
	}
	
	

}
