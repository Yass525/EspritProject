package com.example.demo;

import com.example.demo.services.IClient;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.SpringVersion;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Date;

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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("*").allowedHeaders("*");
            }
        };
    }

        @Override
        public void run(String... args) throws Exception {

            System.out.println("Hibernate version : " + org.hibernate.Version.getVersionString());
            System.out.println("java version : "+  JavaVersion.getJavaVersion().toString());
            System.out.println("Spring boot version : "+  SpringVersion.getVersion());
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
