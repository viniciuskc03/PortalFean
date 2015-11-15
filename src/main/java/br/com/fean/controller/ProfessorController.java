package br.com.fean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fean.entity.Professor;
import br.com.fean.service.ProfessorService;

@Controller
public class ProfessorController {

	private ProfessorService professorService;
	
	@Autowired(required=true)
	@Qualifier(value="professorService")
	public void setProfessorService(ProfessorService ps){
		this.professorService = ps;
	}
	
	@RequestMapping(value = "/professores" , method = RequestMethod.GET)
	public String listarProfessores(Model model) {
		model.addAttribute("professor", new Professor());
		model.addAttribute("listarProfessores", this.professorService.listarProfessores());
		return "professor";
	}
	
	@RequestMapping(value= "/professores/add", method = RequestMethod.POST)
	public String adicionaProfessor(@ModelAttribute("professor") Professor p){
		if(p.getMatricula()== 0){
			this.professorService.adicionaProfessor(p);
		}else{
			this.professorService.atualizaProfessor(p);
		}
		return "redirect:/professores";
	}
	
	@RequestMapping("/remove/{matricula}")
    public String removeProfessor(@PathVariable("matricula") int matricula){
        this.professorService.removeProfessor(matricula);
        return "redirect:/professores";
    }
 
    @RequestMapping("/editar/{matricula}")
    public String atualizaProfessor(@PathVariable("matricula") int matricula, Model model){
        model.addAttribute("professor", this.professorService.pegaProfessorPelaMatricula(matricula));
        model.addAttribute("listarProfessores", this.professorService.listarProfessores());
        return "professor";
    }
}
