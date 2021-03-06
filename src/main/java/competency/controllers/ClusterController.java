package competency.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import competency.dao.ClusterDao;
import competency.dao.CompetencyDao;
import competency.model.Competency;


@Controller
public class ClusterController {
	
	@Autowired
	ClusterDao clusterDao;
	@Autowired
	CompetencyDao competencyDao;

	@RequestMapping(value="cluster/view/{clusterid}",method = RequestMethod.GET)
	public ModelAndView getCompetency(@PathVariable int clusterid) {
		List<Competency> competencylist = clusterDao.getCompetency(clusterid);
		List<Competency> cluster_id = clusterDao.getClusterid(clusterid);
		ModelAndView mav = new ModelAndView("system-setup/child_competency_setup");
		mav.addObject("clusterid",cluster_id);
		mav.addObject("competencylist",competencylist);
		mav.addObject("competency", new Competency());
		return mav;
	}
	@RequestMapping(value="cluster/delete/{id}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		clusterDao.delete(id);
		return new ModelAndView("redirect:/cluster");
	}
	
	@RequestMapping(value="cluster/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("cluster") Competency competency) {
		clusterDao.save(competency);
		return new ModelAndView("redirect:/cluster");
	}
	
	@RequestMapping(value="cluster/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("cluster") Competency competency) {
		clusterDao.update(competency);
		return new ModelAndView("redirect:/cluster");
	}
}

	
	
