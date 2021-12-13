package com.example.demo.controller;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Produit;
import com.example.demo.entities.Rayon;
import com.example.demo.service.IProduit;
import com.example.demo.service.IRayon;

@RestController
public class RayonRestController {
	

		@Autowired
		IRayon rayonService;
		@Autowired
		IProduit produitService;
		//couplage faible
		@GetMapping("/getAllRayon") //methode get
		@ResponseBody
		public List<Rayon> findAll(){
			
	    List<Rayon>listrayon= rayonService.findAll();
	    return listrayon;

		}
		@PostMapping("/add_rayon")
		@ResponseBody
		public Rayon add(@RequestBody Rayon c){
			Rayon rayon =rayonService.add(c);
			return rayon;
			
		}
		
		//http://localhost:numport/contextpath(springMVC)/path/ordre(get,post,put)
		//migration du format java au json serialisation 
		
		//localhost:8089/SpringMvc)/servlet/getAllclient
		
		@DeleteMapping("/remove-rayon/{rayon-id}")

		@ResponseBody

		public void delete(@RequestBody Rayon rayon) {

			rayonService.delete(rayon);

		}
		@PutMapping("/modify-rayon")

		@ResponseBody

		public Rayon update( @RequestBody Rayon u) {
			Rayon c= rayonService.update(u);
			
		return c;

		}

	@GetMapping(value = "/getRaonOrderByCateg")
	public List<Rayon> getRayonByCategorie() {

		return rayonService.findAllOrderByCategorieAsc();
	}


	@GetMapping(value = "/calculnombre/{categorie}")
	public Boolean Calcul(@RequestParam String CategorieRayon) {
		return rayonService.findByNombre(CategorieRayon);

	}

//	@GetMapping("sort/{libelle}/{ASC}")
//	@ResponseBody
//	public List<Rayon> Sort (@PathVariable("libelle")String libelle,@PathVariable("Sort")String sort){
//		return rayonService.SortByLibelle(libelle sort);
//	}


		//@GetMapping("/findAllProductByrayon/{idr}")
		//public List<Produit> findAllProduitByrayon(@PathVariable("idr")int idr)
		//{
			//return rayonService.findAllProduitByrayon(idr);
		//}
		

}
