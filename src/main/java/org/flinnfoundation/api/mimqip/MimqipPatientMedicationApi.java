package org.flinnfoundation.api.mimqip;

import io.swagger.client.model.PatientMedicationDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface MimqipPatientMedicationApi {

    @GET("patients/{patientId}/medications")
    Call<List<PatientMedicationDto>> getPatientMedications(@Path("patientId") long patientId);
}
