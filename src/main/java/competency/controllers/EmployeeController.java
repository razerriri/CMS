package competency.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import competency.dao.EmployeeDao;
import competency.model.Competency;


@Controller
@RequestMapping(value="employee/view")
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;

	
	@RequestMapping(value="employee/delete/{id}/{employeeid}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id,@PathVariable int employeeid) {
		employeeDao.delete(id);
		return new ModelAndView("redirect:/employee/view/"+employeeid+"");
	}
	@RequestMapping(value="employee/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("competency") Competency competency) {
		employeeDao.save(competency);
		return new ModelAndView("redirect:/employee/view/"+competency.getEmployee_id()+"");
	}
	
	@RequestMapping(value="employee/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("competency") Competency competency) {
		employeeDao.update(competency);
		return new ModelAndView("redirect:/employee/view/"+competency.getEmployee_id()+"");
	}
	
	
}

	
	
