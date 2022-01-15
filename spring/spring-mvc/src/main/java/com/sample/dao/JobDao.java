package com.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Job;

@Mapper
public interface JobDao {

	List<Job> getAllJobs();
	List<Integer> getMinSalary();
	List<Integer> getMaxSalary();
	Job getJobById(String id);
	void insertJob(Job job);
	void updateJob(Job job);
	
}
