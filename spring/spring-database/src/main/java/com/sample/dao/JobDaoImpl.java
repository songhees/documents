package com.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sample.vo.Employee;
import com.sample.vo.Job;

public class JobDaoImpl implements JobDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insertJob(Job job) {
		String sql = "insert into jobs "
				+ "(job_id, job_title, min_salary, max_salary) "
				+ "values "
				+ "(?, ?, ?, ?) ";
		
		jdbcTemplate.update(sql, 
				job.getId(), 
				job.getTitle(), 
				job.getMinSalary(), 
				job.getMaxSalary());
	}

	@Override
	public void updateJob(Job job) {
		String sql = "update jobs "
				+ "set "
				+ "		min_salary = ?, "
				+ "		max_salary = ? "
				+ "where job_id = ? ";
		jdbcTemplate.update(sql, 
				job.getMinSalary(), 
				job.getMaxSalary(), 
				job.getId());
	}

	@Override
	public List<Job> getAllJobs() {
		String sql = "select * from jobs ";
		return jdbcTemplate.query(sql, new RowMapper<Job> () {
			@Override
			public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
				Job job = new Job();
				job.setId(rs.getString("job_id"));
				job.setTitle(rs.getString("job_title"));
				job.setMinSalary(rs.getInt("min_salary"));
				job.setMaxSalary(rs.getInt("max_salary"));
				return job;
			}
		});
	}

	@Override
	public Job getJobById(String id) {
		String sql = "select * from jobs "
				+ "where job_id = ? ";
		return jdbcTemplate.queryForObject(sql, (rs, rownum) -> {
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalary(rs.getInt("max_salary"));
			return job;
		}, id);
	}

	@Override
	public List<Job> getJobsBySalary(int minSalary, int maxSalary) {
		String sql = "select * from jobs "
				+ "where min_salary > ? "
				+ "and max_salary > ? ";
		return jdbcTemplate.query(sql, new JobRowMapper(), minSalary, maxSalary);
	}
	
	public class JobRowMapper implements RowMapper<Job> {
		
		@Override
		public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalary(rs.getInt("max_salary"));
			return job;
		}
	}

}
