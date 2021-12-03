package com.example.demo;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.services.IClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringProjectApplication implements CommandLineRunner {
    @Autowired
    IClient clientService;
    private Date dates;

    public static void main(String[] args) {

        SpringApplication.run(SpringProjectApplication.class, args);
    }
        @Override
        public void run(String... args) throws Exception {

            System.out.println("Hibernate version : " + org.hibernate.Version.getVersionString());

            //detailfactureService.addDetailsFacture(new DetailsFacture (1L,245,67F,5,15));
            //dates = new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01");

            //clientService.addClient(new Client (1L,"yass2","tr",dates,"asma@yahoo.fr","ghgjh",CategoryClient.Fidele,Profession.Cadre, null));

            //System.out.println("***************************");

            //detailfactureService.retrieveAllDetailsFacture().forEach(r->{
            //System.out.println(r.toString());
            //});
            //System.out.println("***************************");
            //DetailsFacture det = detailfactureService.retrieveDetailsFacture(1L);
            //System.out.println(det.getIdDetailsFacture());
            //System.out.println("***************************");

    //		clientService.retrieveAllClients().forEach(r->{
            //System.out.println(r.toString());
            //});
            /*System.out.println("***************************");
            Client cl = clientService.retrieveClient(1L);
            System.out.println(cl.getNom());

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String dateToString = df.format(cl.getDateNaissance());

            System.out.println(dateToString);
            System.out.println("***************************");  */
        }
}
