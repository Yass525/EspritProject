package com.example.demo.controller;

import java.util.List;


import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entities.Produit;
import com.example.demo.repository.ProduitRepository;

import com.example.demo.service.IProduit;




@RestController

public class ProduitRestController {
@Autowired
	IProduit produitService;


@Autowired
	public ProduitRepository produitRepository;


	//couplage faible
	//http://localhost:8088/SpringMVC/servlet/add_produit
	@GetMapping("/getAllproduit") //methode get

	@ResponseBody
public List<Produit> findAll(){

		return produitService.findAll();
	}
    
	
//	@GetMapping("/getByCodeproduits") //methode get
//
//	@ResponseBody
//public List<Produit> getProduitByCode(String code){
//
//	    List<Produit>listProduit= (List<Produit>) ProduitService.getProduitByCode(code);
//	    return listProduit;
//	}
	
	
	@PostMapping("/add_produit")
	@ResponseBody
	public Produit add(@RequestBody Produit p){
		Produit produit;
		produit = produitService.add(p);
		return produit;}
	
	
	
	
		
	
    @DeleteMapping("/delete-produit/{produit-id}")

	@ResponseBody

	public void delete(@PathVariable("produit-id") Long id) {

    	produitService.delete(id);

	}
	@PutMapping("/modify-produit/{id}")

	@ResponseBody

	public Produit update( @PathVariable("id")Long id,@RequestBody Produit u) {
		Produit p;
		p = produitService.update(u, id);

		return p;

	}
	
	@PostMapping("/affectProductStock/{idProduct}/{stockId}") 
	@ResponseBody

	public void affectProduitToStock(@PathVariable("idProduct")Long idProduct,@PathVariable("stockId") Long stockId) {
    produitService.affectProduitToStock(idProduct, stockId);

	}


	@PostMapping("/affectProductRayon/{idProduct}/{rayonId}")
	@ResponseBody

	public void affectProduitToRayon(@PathVariable("idProduct")Long idProduct,@PathVariable("rayonId") Long rayonId) {
		produitService.affectProduitToRayon(idProduct, rayonId);

	}

	@GetMapping("recherche/{libelle}")
	@ResponseBody
	public List<Produit> getRecherche (@PathVariable("libelle")String libelle){
		return produitService.findAllByLibelle(libelle);
	}

	@GetMapping(value = "test/produits/{prixLimit}")
	public List<Produit> Filtre(@PathVariable String prixLimit) {
		return produitService.findByPrixGreaterThan("200");
	}

//	@GetMapping("sort/{price}")
//	@ResponseBody
//	public List<Produit> Sort (@PathVariable("prix_unitaire")String prix_unitaire){
//		return produitService.findByAndSort(prix_unitaire);
//	}

//	@RequestMapping(value = "/getProductsBylib/{idlib}" ,method = RequestMethod.GET)
//	public Page<Produit> listProducts(@RequestParam(name = "size",defaultValue = "6")int size,
//									  @RequestParam(name = "page",defaultValue = "0")int page,
//									  @RequestParam(name = "motCle",defaultValue ="")String motCle,
//									  @PathVariable("idCat") String idCat
//	){
//
//
//		Pageable pageable = PageRequest.of(page, size);
//		return produitService.listProductsByLib(idlib,motCle,pageable);
//	}


//	@GetMapping("/recherche/{id}")
//	public List<Produit>recherhe(@PathVariable(value="id") Long id,
//								 RedirectAttributes flash) {
//		//Invoice invoice = clientService.findInvoiceById(id);
//		List<Produit> produit = produitService.fetchByIdWithRayonWithProduitLine(id);
//		if(produit == null) {
//			flash.addFlashAttribute("error");
//
//		}
//
//		return produit;
//	}
	
	/*@PostMapping("affecterProduitToStock/{id_produit}/{id_stock}")
	@ResponseBody
	public void affecter(@PathVariable("id_produit") Long idProduit, @PathVariable ("id_stock")Long idStock) {
		ProduitService.affecterProduitToStock(idProduit, idStock);
	}*/
	
	//@PostMapping("addtostock/{id_produit}/{id_stock}")
	//@ResponseBody
	//public void affecter(Long id_Produit,Long id_Stock) {
	//}
	/*@RequestMapping("/")
	public String view(Model model){
		String keyword="LG";
		List<Produit>ListProduit=ProduitService.findAll(keyword);
		model.addAttribute("ListProduit",ListProduit);
		return "/getAllproduit";
		
	}*/
}

	
