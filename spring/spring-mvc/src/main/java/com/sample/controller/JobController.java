package com.sample.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.JobService;
import com.sample.vo.Job;

@Controller
@RequestMapping("/job")
public class JobController {
	
	@Autowired
	JobService jobService;

	@GetMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("jobs", jobService.getAllJobs());
		return "job/list.jsp";
	}
	
	@GetMapping("/insert.do")
	public String form() {
		return "job/form.jsp";
	}
	
	@PostMapping("/insert.do")
	public String insert(Job job) {
		jobService.addJob(job);
		return "redirect:list.do";
	}
	
	@GetMapping("/modify.do")
	public String formForm(Model model, String id) {
		model.addAttribute("job", jobService.getJob(id));
		
		List<Job> jobs = jobService.getAllJobs();
		List<Integer> minSalaryList = jobs.stream()	// 스트림 생성			  List<Job> 	  -> Stream<Job>
				.map(job -> job.getMinSalary())		// 스트림 중간연산(변환)  Stream<Job> 	  -> Stream<Integer>
				.distinct()							// 스트림 중간연산(필터링) Stream<Integer> -> Stream<Integer>
				.sorted()							// 스트림 중간연산(정렬)	  Stream<Integer> -> Stream<Integer>
				.collect(Collectors.toList());		// 스트림 최종연산		  Stream<Integer> -> List<Integer>
		// 중복 제거, 정렬, 리스트 // stream 배열을 반복처리 해준다.(ex_ for)
		model.addAttribute("mins", jobService.getMinSalary());
		model.addAttribute("maxs", jobService.getMaxSalary());
		return "job/modifyform.jsp";
	}
	
	@PostMapping("/modify.do")
	public String modify(Job job) {
		jobService.updateJob(job);
		return "redirect:list.do";
	}
	
}
