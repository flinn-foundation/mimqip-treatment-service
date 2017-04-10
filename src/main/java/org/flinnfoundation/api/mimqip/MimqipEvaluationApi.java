package org.flinnfoundation.api.mimqip;

import io.swagger.client.model.EvaluationDto;
import org.flinnfoundation.model.evaluation.EvaluationType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface MimqipEvaluationApi {

    @GET("evaluations")
    Call<List<EvaluationDto>> getEvaluations(@Query("patientId") long patientId, @Query("evaluationType") EvaluationType evaluationTypeDto);

}
