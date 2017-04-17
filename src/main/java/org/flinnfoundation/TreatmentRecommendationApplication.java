package org.flinnfoundation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.flinnfoundation.api.mimqip.MimqipDiagnosisApi;
import org.flinnfoundation.api.mimqip.MimqipEvaluationApi;
import org.flinnfoundation.api.mimqip.MimqipPatientApi;
import org.flinnfoundation.api.mimqip.MimqipPatientMedicationApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@SpringBootApplication
public class TreatmentRecommendationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreatmentRecommendationApplication.class, args);
    }

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8080")
            .addConverterFactory(JacksonConverterFactory.create(objectMapper()))
            .build();

    private ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        return mapper;
    }

    @Bean
    public MimqipPatientApi initializePatientApi() {
        return retrofit.create(MimqipPatientApi.class);
    }

    @Bean
    public MimqipEvaluationApi initializeEvaluationApi() {
        return retrofit.create(MimqipEvaluationApi.class);
    }

    @Bean
    public MimqipDiagnosisApi initializeDiagnosisApi() {
        return retrofit.create(MimqipDiagnosisApi.class);
    }

    @Bean
    public MimqipPatientMedicationApi initializeMedicationApi() {
        return retrofit.create(MimqipPatientMedicationApi.class);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }

}
