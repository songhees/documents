package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.JobDao;
import com.sample.vo.Job;

@Service
public class JobService {

	@Autowired
	JobDao jobDao;
	
	public List<Job> getAllJobs() {
		return jobDao.getAllJobs();
	}
	
	public List<Integer> getMinSalary() {
		return jobDao.getMinSalary();
	}
	public List<Integer> getMaxSalary() {
		return jobDao.getMaxSalary();
	}
	
	public Job getJob(String id) {
		return jobDao.getJobById(id);
	}
	public void addJob(Job job) {
		jobDao.insertJob(job);
	}
	public void updateJob(Job job) {
		jobDao.updateJob(job);
	}
}
