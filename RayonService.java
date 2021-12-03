package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Produit;
import lombok.var;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Rayon;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.repository.RayonRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RayonService implements IRayon {

	

	@Autowired
	private RayonRepository rayonRepository;


	@Autowired
	private ProduitRepository produitRepository;
	
	@Override
	public Rayon add(Rayon rayon) {
		return rayonRepository.save(rayon);
	}

	@Override
	public void delete(Rayon rayon) {

		rayonRepository.delete(rayon);
	}
	@Override
	public Rayon update(Rayon rayon) {
		
		return rayonRepository.save(rayon);
	}

	@Override
	public Rayon findById(long id) {
	
		return rayonRepository.getById(id);
	}

	@Override
	public List<Rayon> findAll() {
		return rayonRepository.findAll();
	}

	@Override
	public List<Rayon> findByNombre(String Ctegorie) {
		return null;
	}


	@Override
	public List<Rayon> findAllOrderByCategorieAsc() {
		return rayonRepository.findAllOrderByCategorieAsc();
	}
//
//	@Override
//	public List<Rayon> findByNombre(String Categorie){return rayonRepository.findByNombre(Categorie);}
//	@Override
//	public String<Rayon>Gain(String categorie, Long idProduit){
//		Rayon rayonEntity = rayonRepository.findByCategorie.get(categorie);
//		Produit produitEntity = produitRepository.findById(idProduit).get();
//
//		int nbrProduit=0;
//
//		for (Produit Produit : produitEntity) {
//			nbrProduit++ ;
//		}
//		produitEntity.setRayon(rayonEntity);
//		 Number nbr=produitRepository.count(produitEntity.getPrix_unitaire());
//			String gain= nbrProduit*nbr;
//		}


//	@Override
//	public List<Rayon> SortByLibelle(String libelle, Sort sort) {
//		List<Rayon> list =rayonRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "seatNumber")));
//		return list;
//	}


	/*@Override
	public List<Produit> findAllProduitByrayon(int idr) {
		List<Produit> produits= new ArrayList<Produit>();
		List<Long> produitID =rayonRepository.findAllProduitByrayon(idr);
		 for (int i = 0; i < produitID.size(); i++) {
		      System.out.println(produitID.get(i));
		     long p= produitID.get(i);
		     Produit produit =produitRepository.findById(p).get();
		      
		     produits.add(produit);
		      
		    }
		return produits;
	}*/

	//@GetMapping("/findByrayon/{id}")
	//public Rayon findByrayon(@PathVariable("id")int id)
	//{
		//return (Rayon) rayonRepository.findAllProduitByrayon(id);
	//}
	

}
