package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.DetailsProduit;


public interface IDetailProduit {
	List <DetailsProduit>  retrieveAllDetailsProduit();

	DetailsProduit addDetailsProduit(DetailsProduit dp);

	void deleteDetailsProduit(Long id);

	DetailsProduit updateDetailsProduit(DetailsProduit DP);

	DetailsProduit retrieveDetailsProduit(Long id);


}
