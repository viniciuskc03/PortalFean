package br.com.fean.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.fean.entity.Professor;

@Repository
public class ProfessorDAOImpl implements ProfessorDAO {

	private SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(ProfessorDAOImpl.class);
	
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void adicionaProfessor(Professor p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Professor salvo com sucesso, Professor Details="+p);
	}	

	@Override
	public void atualizaProfessor(Professor p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Professor atualizado com sucesso, Detalhes do Professor ="+p);
	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> listarProfessores() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Professor> professorLista = session.createQuery("from Professor").list();
		for(Professor p : professorLista){
			logger.info("Professor Lista::"+p);
		}
		return professorLista;
	}

	@Override
	public Professor pegaProfessorPelaMatricula(int matricula) {
		Session session = this.sessionFactory.getCurrentSession();		
		Professor p = (Professor) session.load(Professor.class, new Integer(matricula));
		logger.info("Professor carregado com sucesso, Professor detalhes="+p);
		return p;	
	}

	@Override
	public void removeProfessor(int matricula) {
		Session session = this.sessionFactory.getCurrentSession();
		Professor p= (Professor) session.load(Professor.class, new Integer(matricula));
		if(null != p){
			session.delete(p);
		}
		logger.info("Professor deletado com sucesso, detalhes do professor="+p);
	}
	}	
