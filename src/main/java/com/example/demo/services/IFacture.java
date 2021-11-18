package com.example.demo.services;


	import java.util.List;

	import com.example.demo.entity.Facture;

	public interface IFacture {
		List <Facture>  retrieveAllFactures();

		Facture addFacture(Facture F);

		void deleteFacture(Long id);

		Facture updateFacture(Facture f);

		Facture retrieveFacture(Long id);


	


}
