package org.flinnfoundation.api.mimqip;

import io.swagger.client.model.PatientDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MimqipPatientApi {

    @GET("patients/{patientId}")
    Call<PatientDto> getPatient(@Path("patientId") long patientId);
}
