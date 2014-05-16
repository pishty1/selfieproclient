package org.selfiepro.client.mvc;

import javax.inject.Inject;


public class BrushService {

	@Inject
	BrushRepository brushRepository;
	
	public Brush addBrush(Brush brush) {
		return brushRepository.save(brush);
	}
	
	public Brush getBrush(long id){
		return brushRepository.findOne(id);
	}

}