package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Produit;
import com.example.demo.entities.Rayon;
import com.example.demo.entities.Stock;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.repository.RayonRepository;
import com.example.demo.repository.StockRepository;

@Service
public class ProduitService implements IProduit {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private RayonRepository rayonRepository;
	@Autowired
	private StockRepository stockRepository;

	@Override
	public Produit add(Produit produit) {
		return produitRepository.save(produit);

	}

	@Override
	public void delete(long id) {
		produitRepository.deleteById(id);
	}

	@Override
	public Produit findById(Long id) {
		return produitRepository.getById(id);
	}


/*@Override	
public List<Produit> findAll(String Keyword){
	if(Keyword !=null){
	return produitRepository.findAll(Keyword);
}
return produitRepository.findAll();
} */


	@Override
	public Produit update(Produit produit, Long id) {

		return produitRepository.save(produit);
	}


	@Override
	public List<Produit> findAll() {

		return produitRepository.findAll();
	}


	@Override

	public String affectProduitToStock(Long produitId, Long stockId) {
		Stock stockEntity = stockRepository.findById(stockId).get();
		Produit produitEntity = produitRepository.findById(produitId).get();
		produitEntity.setStock(stockEntity);
		produitRepository.save(produitEntity);
		return "product affected to stock";

	}

	@Override
	public String affectProduitToRayon(Long produitId, Long rayonId) {
		Rayon rayonEntity = rayonRepository.findById(rayonId).get();
		Produit produitEntity = produitRepository.findById(produitId).get();
		produitEntity.setRayon(rayonEntity);
		produitRepository.save(produitEntity);
		return "Product affected to rayon";

	}

	@Override
	public List<Produit> findAllByLibelle(String libelle) {
		List<Produit> recherche = produitRepository.findAllByLibelle(libelle);
		return recherche;
	}

	@Override
	public List<Produit> findByPrixGreaterThan(String prix){
		List<Produit> Filtre = produitRepository.findByPrixGreaterThan("200");
		return Filtre;

	}
//	@Override
//	public List<Produit> findByAndSort(String prix_unitaire) {
//		List<Produit> sort = produitRepository.findByAndSort(prix_unitaire);
//		return sort;
//	}


//	@Override
//	public String home( Model model,
//						@RequestParam(name="page",defaultValue="0")int p,
//						@RequestParam(name="size",defaultValue="5")int s,
//						@RequestParam(name="motCle",defaultValue="")String motCle) {
//
//		org.springframework.data.domain.Pageable paging = PageRequest.of(p, s);
//
//
//		Page<Produit>pageProduits = produitRepository.chercher("%"+motCle+"%", (java.awt.print.Pageable) paging);
//
//		//Page<Produit>pageProduits = produitRepository.findAll(paging);
//
//		// Note : la méthode getContent() var retourner une liste de Produits de taille s.
//
//		model.addAttribute("pageProduits",pageProduits.getContent());
//		int[] pages = new int[pageProduits.getTotalPages()];
//		model.addAttribute("pages",pages);
//		model.addAttribute("size",s);
//		model.addAttribute("pageCourante",p);
//		model.addAttribute("motCle", motCle);
//		return "produits";
//	}







//@Override
//public Iterable<Produit> getProduitByCode(String code) {
	//return produitRepository.findByCode(code);
//}


/*@Override
public String affecterProduitToStock(Long idProduit, Long idStock) {
	Stock Stock=StockRepository.findById(idStock).get();
	Produit Produit=produitRepository.findById(idProduit).get();
	
			Produit.setStock(Stock);
			produitRepository.save(Produit);
			return("fournisseur affécté à produit");
	
}*/

//@Override
	
  //  @Modifying
   // @Query(value = "insert into Stock (redirect,produit_id) VALUES (:insertLink,:id)", nativeQuery = true)
    //@Transactional
    
    //public void Affecter(@Param("insertLink") String insertLink, @Param("id") Long id) {
//}

	
}


//@Override
//public Produit findProduitByRayon() {

	//return produitRepository.findProduitByRayon();
//}



