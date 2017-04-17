package org.flinnfoundation.api.mimqip;

import io.swagger.client.model.DiagnosisDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface MimqipDiagnosisApi {

    @GET("patients/{patientId}/diagnoses")
    Call<List<DiagnosisDto>> getDiagnoses(@Path("patientId") long patientId);

    @GET("patients/{patientId}/diagnoses/latest")
    Call<DiagnosisDto> getLatestDiagnosis(@Path("patientId") long patientId);
}
