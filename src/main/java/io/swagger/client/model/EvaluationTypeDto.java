package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets EvaluationTypeDto
 */
public enum EvaluationTypeDto {

  BBDSS("BBDSS"),

  PHQ9("PHQ9"),

  GLOBAL("GLOBAL"),

  MENTAL_STATUS("MENTAL_STATUS"),

  PSRS("PSRS"),

  SUBSTANCE_ABUSE("SUBSTANCE_ABUSE"),

  VITAL_SIGNS("VITAL_SIGNS"),

  PSYCHIATRIC("PSYCHIATRIC");

  private String value;

  EvaluationTypeDto(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static EvaluationTypeDto fromValue(String text) {
    for (EvaluationTypeDto b : EvaluationTypeDto.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

