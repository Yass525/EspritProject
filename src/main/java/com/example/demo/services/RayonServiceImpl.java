package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Rayon;
import com.example.demo.repositories.RayonRepository;
@Service
public class RayonServiceImpl implements IRayon {
	@Autowired 
	private RayonRepository rayonRepository;

	@Override
	public List<Rayon> retrieveAllRayon() {
		// TODO Auto-generated method stub
		List <Rayon> rayon=(List<Rayon>) rayonRepository.findAll();
		return rayon ;
	}

	@Override
	public Rayon addRayon(Rayon R) {
		// TODO Auto-generated method stub
		rayonRepository.save(R);
		return R;
	}

	@Override
	public void deleteRayon(Long id) {
		// TODO Auto-generated method stub
		rayonRepository.deleteById(id);
		
	}

	@Override
	public Rayon updateRayon(Rayon r) {
		// TODO Auto-generated method stub
		return rayonRepository.save(r);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		// TODO Auto-generated method stub
		Rayon rayon=rayonRepository.findById(id).orElse(null);
		return rayon;
	}

}
