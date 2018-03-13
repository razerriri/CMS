package competency.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import competency.dao.EJCDao;
import competency.dao.EmployeeDao;
import competency.model.Competency;


@Controller

public class EJCqueryController {
	
	@Autowired
	EJCDao ejcDao;	
	@RequestMapping(value="employee/search", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("competency") Competency competency) {
		List<Competency> employeejobcompetencylist = ejcDao.getEmployeeJobCompetency(competency);
		List<Competency> employeelist = ejcDao.getEmployee();
		List<Competency> joblist = ejcDao.getJob();
		ModelAndView mav = new ModelAndView("employee_job_competency_query");
		mav.addObject("employeelist",employeelist);
		mav.addObject("joblist",joblist);
		mav.addObject("employeejobcompetencylist",employeejobcompetencylist);
		mav.addObject("competency", new Competency());
		return mav;
	}
	
	
	
}

	
	
