package br.com.fean.dao;

import java.util.List;

import br.com.fean.entity.Professor;



public interface ProfessorDAO {

	public void adicionaProfessor(Professor p);
	public void atualizaProfessor(Professor p);
	public List<Professor> listarProfessores();
	public Professor pegaProfessorPelaMatricula(int matricula);
	public void removeProfessor(int matricula);
}
