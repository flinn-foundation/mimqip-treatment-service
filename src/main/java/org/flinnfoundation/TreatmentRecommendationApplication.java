package org.flinnfoundation;

import org.flinnfoundation.api.mimqip.MimqipEvaluationApi;
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

	private Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("http://localhost:8080")
			.build();

	@Bean
	public MimqipPatientApi initializePatientApi() {

		return retrofit.create(MimqipPatientApi.class);
	}

	@Bean
	public MimqipEvaluationApi initializeEvaluationApi() {

		return retrofit.create(MimqipEvaluationApi.class);
	}
}
