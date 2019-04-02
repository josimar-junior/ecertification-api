package com.jj.ecertification.repository.certification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.StringUtils;

import com.jj.ecertification.model.Detail;
import com.jj.ecertification.model.dto.CertificationDTO;
import com.jj.ecertification.model.filter.CertificationFilter;

public class CertificationRepositoryImpl implements CertificationRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CertificationDTO> list(CertificationFilter filter) {
		StringBuilder jpql = new StringBuilder("select new com.jj.ecertification.model.dto.CertificationDTO(c.id, c.name, c.exam, c.percentage) from Certification c where 1=1 ");
		Map<String, Object> parameters = new HashMap<>();
		
		setParametersIfRequired(filter, jpql, parameters);
		
		Query query = manager.createQuery(jpql.toString(), CertificationDTO.class);
		
		setParametersQuery(parameters, query);
		
		return query.getResultList();
	}
	
	private void setParametersQuery(Map<String, Object> parameters, Query query) {
		parameters.forEach((k, v) -> {
			query.setParameter(k, v);
		});
	}

	private void setParametersIfRequired(CertificationFilter filter, StringBuilder jpql, Map<String, Object> parameters) {
		if(StringUtils.hasText(filter.getName())) {
			jpql.append("and lower(c.name) like :name ");
			parameters.put("name", "%" + filter.getName().toLowerCase() + "%");
		}
		
		if(StringUtils.hasText(filter.getExam())) {
			jpql.append("and lower(c.exam) = :exam ");
			parameters.put("exam", filter.getExam().toLowerCase());
		}
		
		if(filter.getIdOrganization() != null) {
			jpql.append("and c.organization.id = :idOrganization");
			parameters.put("idOrganization", filter.getIdOrganization());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Detail> details(Long idCertification) {
		
		StringBuilder jpql = new StringBuilder("select d from Detail d where d.certification.id = :idCertification");
		
		Query query = manager.createQuery(jpql.toString(), Detail.class);
		
		query.setParameter("idCertification", idCertification);
		
		return query.getResultList();
	}

}
