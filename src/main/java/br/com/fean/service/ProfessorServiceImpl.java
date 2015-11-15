package br.com.fean.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fean.dao.ProfessorDAO;
import br.com.fean.entity.Professor;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	private ProfessorDAO professorDAO;
	
	public void setProfessorDAO(ProfessorDAO professorDAO) {
		this.professorDAO = professorDAO;
	}
	
	@Override
	@Transactional
	public void adicionaProfessor(Professor p) {
		this.professorDAO.adicionaProfessor(p);
	}

	@Override
	@Transactional
	public void atualizaProfessor(Professor p) {
		this.professorDAO.atualizaProfessor(p);
	}

	@Override
	@Transactional
	public List<Professor> listarProfessores() {
		return this.professorDAO.listarProfessores();
	}

	@Override
	@Transactional
	public Professor pegaProfessorPelaMatricula(int matricula) {
		return this.professorDAO.pegaProfessorPelaMatricula(matricula);
	}

	@Override
	@Transactional
	public void removeProfessor(int matricula) {
		this.professorDAO.removeProfessor(matricula);
	}

	
}
