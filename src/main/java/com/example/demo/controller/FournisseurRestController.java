package com.example.demo.controller;

import com.example.demo.entity.Fournisseur;
import com.example.demo.model.Mail;
import com.example.demo.repositories.FournisseurRepository;
import com.example.demo.services.IFournisseur;
import com.example.demo.services.IMail;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import java.util.*;
import static java.time.LocalDateTime.now;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fournisseurs")
public class FournisseurRestController {

    private final IFournisseur fournisseurService;
    private final IMail mailService;
    private final FournisseurRepository fournisseurRepository;


    // http://localhost:8080/SpringMVC/servlet/fournisseurs/get-all
    @GetMapping("/get-all")
    @ResponseBody
    public List<Fournisseur> getFournisseurs() {

//        Map<String, List<Fournisseur>> mydata = new HashMap<String, List<Fournisseur>>(){{
//            put("Fournisseurs", fournisseurService.retrieveAllFournisseurs());
//        }};
//        return ResponseEntity.ok(
//                Response.builder()
//                        .timeStamp(now())
//                        .data(mydata)
//                        .message("Fournisseurs retrived")
//                        .status(OK)
//                        .statusCode(OK.value())
//                        .build()
//        );
        return fournisseurService.retrieveAllFournisseurs();
    }

    // http://localhost:8080/SpringMVC/servlet/fournisseurs/get-fournisseur/{fournisseur-id}
    @GetMapping("/get-fournisseur/{fournisseur-id}")
    @ResponseBody
    public Fournisseur getFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
//        Map<String, Fournisseur> mydata = new HashMap<String, Fournisseur>(){{
//            put("Fournisseur", fournisseurService.retrieveFournisseur(fournisseurId));
//        }};
//        return ResponseEntity.ok(
//                Response.builder()
//                        .timeStamp(now())
//                        .data(mydata)
//                        .message("Fournisseur with id: "+fournisseurId+" retrieved")
//                        .status(OK)
//                        .statusCode(OK.value())
//                        .build()
//        );
        return fournisseurService.retrieveFournisseur(fournisseurId);
    }

    // http://localhost:8080/SpringMVC/servlet/fournisseurs/add
    @PostMapping("/add")
    @ResponseBody
    public Fournisseur addFournisseur(@RequestBody Fournisseur f) {
//        Map<String, Fournisseur> mydata = new HashMap<String, Fournisseur>() {{
//            put("Fournisseurs", fournisseurService.addFournisseur(f));
//        }};
//        return ResponseEntity.ok(
//                Response.builder()
//                        .timeStamp(now())
//                        .data(mydata)
//                        .message("Fournisseur created")
//                        .status(CREATED)
//                        .statusCode(CREATED.value())
//                        .build()
//        );
        return fournisseurService.addFournisseur(f);
    }

    // http://localhost:8080/SpringMVC/servlet/fournisseurs/remove/{fournisseur-id}
    @DeleteMapping("/remove/{fournisseur-id}")
    @ResponseBody
    public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {

        if (fournisseurService.checkIfExist(fournisseurId)) {
            fournisseurService.deleteFournisseur(fournisseurId);
//            return ResponseEntity.ok(
//                    Response.builder()
//                            .timeStamp(now())
//                            .message("Fournisseur with id:"+fournisseurId+" deleted")
//                            .status(OK)
//                            .statusCode(OK.value())
//                            .build()
//            );
        } else {
//            return ResponseEntity.ok(
//                    Response.builder()
//                            .timeStamp(now())
//                            .message("Fournisseur with id:"+fournisseurId+" does not exist")
//                            .status(NOT_FOUND)
//                            .statusCode(NOT_FOUND.value())
//                            .build()
//            );
            throw new IllegalArgumentException("Id fournisseur invalide");
        }

    }

    // http://localhost:8080/SpringMVC/servlet/fournisseurs/remove-all
    @DeleteMapping("/remove-all")
    @ResponseBody
    public void removeAllFournisseurs() {
//        Map<String, Boolean> mydata = new HashMap<String, Boolean>(){{
//            put("Is Deleted: ", fournisseurService.deleteAllFournisseurs());
//        }};
//        return ResponseEntity.ok(
//                Response.builder()
//                        .timeStamp(now())
//                        .data(mydata)
//                        .message("Fournisseurs deleted")
//                        .status(OK)
//                        .statusCode(OK.value())
//                        .build()
//        );
        fournisseurService.deleteAllFournisseurs();
    }

    // http://localhost:8080/SpringMVC/servlet/fournisseurs/modify
    @PutMapping("/modify")
    @ResponseBody
    public Fournisseur modifyFournisseur(@RequestBody Fournisseur f) {
//        Map<String, Fournisseur> mydata = new HashMap<String, Fournisseur>() {{
//            put("Fournisseurs: ", fournisseurService.updateFournisseur(f));
//        }};
//        return ResponseEntity.ok(
//                Response.builder()
//                        .timeStamp(now())
//                        .data(mydata)
//                        .message("Fournisseur updated")
//                        .status(OK)
//                        .statusCode(OK.value())
//                        .build()
//        );
        if (fournisseurService.checkIfExist(f.getIdFournisseur())) {
            return fournisseurService.updateFournisseur(f);
        } else {
            throw new IllegalArgumentException("Id fournisseur invalide");
        }
    }

    // http://localhost:8080/SpringMVC/servlet/fournisseurs/get/{libelle}
    @GetMapping("/get/{libelle}")
    @ResponseBody
    public Fournisseur findFournisseurByLibelle(@PathVariable("libelle") String libelleFournisseur) {
//        Map<String, Fournisseur> mydata = new HashMap<String, Fournisseur>() {{
//            put("Fournisseur: ", fournisseurService.findFournisseurBylibelle(libelleFournisseur));
//        }};
//        return ResponseEntity.ok(
//                Response.builder()
//                        .timeStamp(now())
//                        .data(mydata)
//                        .message("Fournisseur retrieved")
//                        .status(OK)
//                        .statusCode(OK.value())
//                        .build()
//        );
        return fournisseurService.findFournisseurBylibelle(libelleFournisseur);
    }

    // http://localhost:8080/SpringMVC/servlet/fournisseurs/email
    @PostMapping("/email")
    @ResponseBody
    public ResponseEntity<Mail> sendEmail(@RequestBody Mail mail) {
        try {
            mailService.sendMail(mail);
            return new ResponseEntity<>(mail,  HttpStatus.OK);
        } catch(MailException | MessagingException e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // http://localhost:8080/SpringMVC/servlet/fournisseurs/{idP}/{idF}
    @PostMapping("/associate/{idP}/{idF}")
    @ResponseBody
    public Set<Fournisseur> addProduitFournit(@PathVariable("idP") Long idP,@PathVariable("idF") Long idF) {

        return fournisseurService.addProduitFournit(idP,idF);
    }

    // http://localhost:8080/SpringMVC/servlet/fournisseurs/get-list-fournisseurs

    @GetMapping("/get-list-fournisseurs")
    @ResponseBody
    public Map<String, Set<Fournisseur>> getFournisseursParProduits() {
        return fournisseurService.getFournisseursParProduits();
    }

    // http://localhost:8080/SpringMVC/servlet/fournisseurs/get-nbr-fournisseurs
    @GetMapping("/get-nbr-fournisseurs")
    @ResponseBody
    public Map<String, Long> getNbrProduitsParFournisseurs() {
        return fournisseurService.getNbrProduitsParFournisseurs();
    }

    // http://localhost:8080/SpringMVC/servlet/fournisseurs/get-list
    @GetMapping("/get-list")
    @ResponseBody
    public List<Fournisseur> getFournisseursPagedAndSorted(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(required = false) String field) {

//        try {
            Page<Fournisseur> fournisseurPage;
            Pageable paging = PageRequest.of(offset,pageSize);
            List<Fournisseur> fournisseurList = new ArrayList<Fournisseur>();

            if (field == null) {
                fournisseurPage = fournisseurService.getFournisseursPaged(paging);
            } else {
                fournisseurPage = fournisseurService.getFournisseursPagedAndSorted(offset, pageSize, field);
            }

            fournisseurList = fournisseurPage.getContent();
//            Map<String, List<Fournisseur>> response = new HashMap<>();
//            response.put("fournisseurs",fournisseurList);
//            response.put("currentPage",fournisseurPage.getNumber());
//            response.put("totalItems",fournisseurPage.getTotalElements());
//            response.put("totalPages",fournisseurPage.getTotalPages());
//            return new ResponseEntity<>(response, OK);
            return fournisseurList;
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, INTERNAL_SERVER_ERROR);
//        }

    }

}
