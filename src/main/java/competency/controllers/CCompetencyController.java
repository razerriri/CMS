package competency.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import competency.dao.CompetencyDao;
import competency.model.Competency;


@Controller
@RequestMapping(value="cluster/view")
public class CCompetencyController {
	
	@Autowired
	CompetencyDao competencyDao;

	/*@RequestMapping(value="competency/view/{competencyid}",method = RequestMethod.GET)
	public ModelAndView getCompetency(@PathVariable int competencyid) {
		ModelAndView mav = new ModelAndView("child_competency_level");
		return mav;
	}*/
	
	@RequestMapping(value="competency/delete/{id}/{clusterid}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id,@PathVariable int clusterid) {
		competencyDao.delete(id);
		return new ModelAndView("redirect:/cluster/view/"+clusterid+"");
	}
	
	@RequestMapping(value="competency/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("competency") Competency competency) {
		competencyDao.save(competency);
		return new ModelAndView("redirect:/cluster/view/"+competency.getCluster_id()+"");
	}
	
	@RequestMapping(value="competency/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("competency") Competency competency) {
		competencyDao.update(competency);
		return new ModelAndView("redirect:/cluster/view/"+competency.getCluster_id()+"");
	}
	
}

	
	
