package org.flinnfoundation.api.mimqip;

import io.swagger.client.model.PatientDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface MimqipPatientApi {

    @GET("users/{patientId}")
    Call<PatientDto> getPatient(@Path("patientId") long patientId);

    @GET("users/{patientId}/medications")
    Call<List<PatientMedicationDto>> getPatientMedications(@Path("patientId") long patientId);
}
