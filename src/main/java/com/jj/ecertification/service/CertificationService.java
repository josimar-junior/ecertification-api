package com.jj.ecertification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jj.ecertification.model.Certification;
import com.jj.ecertification.model.Detail;
import com.jj.ecertification.model.dto.CertificationDTO;
import com.jj.ecertification.model.filter.CertificationFilter;
import com.jj.ecertification.repository.CertificationRepository;

@Service
public class CertificationService {

	@Autowired
	private CertificationRepository certifications;
	
	public List<CertificationDTO> list(CertificationFilter filter) {
		return certifications.list(filter);
	}
	
	public Certification findById(Long id) {
		return certifications.findById(id).get();
	}
	
	public Certification save(Certification certification) {
		 addCertificationInDetail(certification);
		return certifications.save(certification);
	}
	
	public List<Detail> details(Long idCertification) {
		return certifications.details(idCertification);
	}
	
	public void update(Certification certification, Long id) {
		Certification certificationSaved = findById(id);
		certificationSaved = removeDetails(certification, certificationSaved);
		certificationSaved = addCertificationInDetail(certification);
		certification.setId(id);
		certifications.save(certificationSaved);
	}
	
	public void delete(Long id) {
		certifications.deleteById(id);
	}

	private Certification addCertificationInDetail(Certification certification) {
		if(!certification.getDetails().isEmpty()) {
			certification.getDetails().forEach(det -> {
				det.setCertification(certification);
			});
		}
		
		return certification;
	}
	
	private Certification removeDetails(Certification certification, Certification certificationSave) {
		if(certificationSave.getDetails() != null && !certificationSave.getDetails().isEmpty()) {
			certificationSave.getDetails().removeIf(t -> !certification.getDetails().contains(t));
		}
		
		return certificationSave;
	}
}
