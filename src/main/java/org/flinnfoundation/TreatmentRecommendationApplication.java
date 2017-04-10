package org.flinnfoundation;

import org.flinnfoundation.api.mimqip.MimqipPatientApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;

@SpringBootApplication
public class TreatmentRecommendationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreatmentRecommendationApplication.class, args);
	}

	@Bean
	public MimqipPatientApi initializeApi() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://localhost:8080")
				.build();

		return retrofit.create(MimqipPatientApi.class);
	}
}
