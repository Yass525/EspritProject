package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DetailsFacture;
import com.example.demo.services.IDetailFacture;

@RestController
public class DetailFactureRestController {
	
@Autowired 
IDetailFacture detailfactureService;
//http://localhost:8081/SpringMVC/servlet/getAllDetails
	@GetMapping("/getAllDetails")
	@ResponseBody
	public List<DetailsFacture> getAllDetails(){
		List<DetailsFacture>listDetailsFacture=detailfactureService.retrieveAllDetailsFacture();
		return listDetailsFacture;
	}
	// http://localhost:8081/SpringMVC/servlet/add-detailsFacture

			@PostMapping("/add-detailsFacture")

			@ResponseBody

			public DetailsFacture addDetailsFacture(@RequestBody DetailsFacture df)

			{

				DetailsFacture detF = detailfactureService.addDetailsFacture(df);

			    return detF;

			}
			// http://localhost:8081/SpringMVC/servlet/retrieve-detailsFacture/1

			@GetMapping("/retrieve-detailsFacture/{detailsFacture-id}")

			@ResponseBody

			public DetailsFacture retrieveDetailsFacture(@PathVariable("detailsFacture-id") Long IdDetailsFacture ) {

			return detailfactureService.retrieveDetailsFacture(IdDetailsFacture);
			}
			// http://localhost:8089/SpringMVC/servlet/remove-detailsFacture/{detailsFacture-id}

			@DeleteMapping("/remove-detailsFacture/{detailsFacture-id}")

			@ResponseBody

			public void removedetailsFacture(@PathVariable("detailsFacture-id") Long IdDetailsFacture ) {

				detailfactureService.deleteDetailsFacture(IdDetailsFacture);

			}
	
}
