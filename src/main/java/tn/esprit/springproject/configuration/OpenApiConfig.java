package tn.esprit.springproject.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }
    public Info infoAPI() {
        return new Info().title("Project Title: University Hostel Management")
                .description("This project is a web-based enterprise application developed using the Spring Framework. It aims to simplify the room reservation process for students at university hostels.")
                .contact(contactAPI());
    }
    public Contact contactAPI() {
        Contact contact = new Contact().name("Youssef Farhat")
                .email("youssef.farhat@esprit.tn")
                .url("https://www.linkedin.com/in/youssef-farhat/");
        return contact;
    }
    @Bean
    public GroupedOpenApi blocPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Bloc Management API")
                                .pathsToMatch("/api/Blocs/**")
                                .pathsToExclude("**")
                                .build();

    }
    @Bean
    public GroupedOpenApi chambrePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Chambre Management API")
                .pathsToMatch("/api/Chambres/**")
                .pathsToExclude("**")
                .build();

    }
    @Bean
    public GroupedOpenApi etudiantPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Etudiant Management API")
                .pathsToMatch("/api/Etudiants/**")
                .pathsToExclude("**")
                .build();

    }
    @Bean
    public GroupedOpenApi foyerPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Foyer Management API")
                .pathsToMatch("/api/Foyer/**")
                .pathsToExclude("**")
                .build();

    }
    @Bean
    public GroupedOpenApi reservationPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Reservation Management API")
                .pathsToMatch("/api/Reservation/**")
                .pathsToExclude("**")
                .build();

    }
    @Bean
    public GroupedOpenApi universitePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Universite Management API")
                .pathsToMatch("/api/Universite/**")
                .pathsToExclude("**")
                .build();
    }
}