package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DetailsProduit;
import com.example.demo.repositories.DetailsProduitRepository;

@Service
public class DetailProduitServiceImpl implements IDetailProduit {
@Autowired
private DetailsProduitRepository detailproduitRepository;

@Override
public List<DetailsProduit> retrieveAllDetailsProduit() {
	// TODO Auto-generated method stub
	List<DetailsProduit> detail= detailproduitRepository.findAll();
	return detail;
}

@Override
public DetailsProduit addDetailsProduit(DetailsProduit dp) {
	// TODO Auto-generated method stub
	detailproduitRepository.save(dp);
	return dp;
}

@Override
public void deleteDetailsProduit(Long id) {
	// TODO Auto-generated method stub
	detailproduitRepository.deleteById(id);
}

@Override
public DetailsProduit updateDetailsProduit(DetailsProduit DP) {
	// TODO Auto-generated method stub
	detailproduitRepository.save(DP);
	return DP;
}

@Override
public DetailsProduit retrieveDetailsProduit(Long id) {
	// TODO Auto-generated method stub
	DetailsProduit detail=detailproduitRepository.findById(id).orElse(null);
	return detail;
}

}
