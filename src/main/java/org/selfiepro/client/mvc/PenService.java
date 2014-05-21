package org.selfiepro.client.mvc;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class PenService {
	
	@Inject
	PenRepository penRepository;
	
	public Pen savePen(Pen pen) {
		Pen savedPen = penRepository.save(pen);
		return savedPen;
	}
	
	public List<Pen> getAllPens() {
		return (List<Pen>) penRepository.findAll();
	}
	
	public Pen getPen(long id) {
		return penRepository.findOne(id);
	}
	
}
