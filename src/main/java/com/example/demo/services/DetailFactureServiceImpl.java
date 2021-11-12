package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DetailsFacture;
import com.example.demo.repositories.DetailFactureRepository;

@Service
public class DetailFactureServiceImpl implements IDetailFacture {
@Autowired 
private DetailFactureRepository detailfactureRepository;

@Override
public List<DetailsFacture> retrieveAllDetailsFacture() {
	// TODO Auto-generated method stub
	List <DetailsFacture> detailf=detailfactureRepository.findAll();
	return detailf;
}

@Override
public DetailsFacture addDetailsFacture(DetailsFacture df) {
	// TODO Auto-generated method stub
	detailfactureRepository.save(df);
	return df;
}

@Override
public void deleteDetailsFacture(Long id) {
	// TODO Auto-generated method stub
	detailfactureRepository.deleteById(id);
	
}

@Override
public DetailsFacture updateDetailsFacture(DetailsFacture DF) {
	// TODO Auto-generated method stub
	detailfactureRepository.save(DF);
	return DF;
}

@Override
public DetailsFacture retrieveDetailsFacture(Long id) {
	// TODO Auto-generated method stub
	DetailsFacture detailff=detailfactureRepository.findById(id).orElse(null);
	return detailff;
}


}
