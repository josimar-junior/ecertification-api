package com.jj.ecertification.repository.certification;

import java.util.List;

import com.jj.ecertification.model.Detail;
import com.jj.ecertification.model.dto.CertificationDTO;
import com.jj.ecertification.model.filter.CertificationFilter;

public interface CertificationRepositoryQuery {

	List<CertificationDTO> list(CertificationFilter filter);
	List<Detail> details(Long idCertification);
}
