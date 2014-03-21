package com.etyme.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.etyme.dao.CandidatesDao;
import com.etyme.dao.JobsDao;
import com.etyme.dao.UserDao;
import com.etyme.model.Candidates;
import com.etyme.model.Jobs;

@Repository("candidatesDao")
public class CandidatesDaoImpl implements CandidatesDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Candidates> listCandidates() {
		return (List<Candidates>)sessionFactory.getCurrentSession().createQuery("from Candidates").list();
	}

	@Override
	public void saveCandidate(Candidates can) {
		sessionFactory.getCurrentSession().saveOrUpdate(can);
		
	}

	@Override
	public Candidates getCandidateById(int candidateId) {
		return (Candidates)sessionFactory.getCurrentSession().createQuery(
				"from Candidates where id=:id").setInteger("id",
				candidateId).list().get(0);
	}

}
