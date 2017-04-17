package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DiagnosisDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-14T10:56:36.931-04:00")

public class DiagnosisDto   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("patientId")
  private Long patientId = null;

  /**
   * Gets or Sets diagnosisType
   */
  public enum DiagnosisTypeEnum {
    SCHIZOPHRENIC_P("SCHIZOPHRENIC_P"),

    SCHIZOPHRENIC_D("SCHIZOPHRENIC_D"),

    SCHIZOPHRENIC_C("SCHIZOPHRENIC_C"),

    SCHIZOPHRENIC_U("SCHIZOPHRENIC_U"),

    SCHIZOPHRENIC_R("SCHIZOPHRENIC_R"),

    BIPOLAR_SM1("BIPOLAR_SM1"),

    BIPOLAR_SM2("BIPOLAR_SM2"),

    BIPOLAR_SM3("BIPOLAR_SM3"),

    BIPOLAR_SM4("BIPOLAR_SM4"),

    BIPOLAR_MRMH("BIPOLAR_MRMH"),

    BIPOLAR_MRM1("BIPOLAR_MRM1"),

    BIPOLAR_MRM2("BIPOLAR_MRM2"),

    BIPOLAR_MRM3("BIPOLAR_MRM3"),

    BIPOLAR_MRM4("BIPOLAR_MRM4"),

    BIPOLAR_MRD1("BIPOLAR_MRD1"),

    BIPOLAR_MRD2("BIPOLAR_MRD2"),

    BIPOLAR_MRD3("BIPOLAR_MRD3"),

    BIPOLAR_MRD4("BIPOLAR_MRD4"),

    MDD_S1("MDD_S1"),

    MDD_S2("MDD_S2"),

    MDD_S3("MDD_S3"),

    MDD_S4("MDD_S4"),

    MDD_R1("MDD_R1"),

    MDD_R2("MDD_R2"),

    MDD_R3("MDD_R3"),

    MDD_R4("MDD_R4");

    private String value;

    DiagnosisTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DiagnosisTypeEnum fromValue(String text) {
      for (DiagnosisTypeEnum b : DiagnosisTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("diagnosisType")
  private DiagnosisTypeEnum diagnosisType = null;

  @JsonProperty("secondaryDiagnosis")
  private String secondaryDiagnosis = null;

  @JsonProperty("stage")
  private Integer stage = null;

  @JsonProperty("createdTimestamp")
  private OffsetDateTime createdTimestamp = null;

  public DiagnosisDto id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DiagnosisDto patientId(Long patientId) {
    this.patientId = patientId;
    return this;
  }

   /**
   * Get patientId
   * @return patientId
  **/
  @ApiModelProperty(value = "")
  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  public DiagnosisDto diagnosisType(DiagnosisTypeEnum diagnosisType) {
    this.diagnosisType = diagnosisType;
    return this;
  }

   /**
   * Get diagnosisType
   * @return diagnosisType
  **/
  @ApiModelProperty(value = "")
  public DiagnosisTypeEnum getDiagnosisType() {
    return diagnosisType;
  }

  public void setDiagnosisType(DiagnosisTypeEnum diagnosisType) {
    this.diagnosisType = diagnosisType;
  }

  public DiagnosisDto secondaryDiagnosis(String secondaryDiagnosis) {
    this.secondaryDiagnosis = secondaryDiagnosis;
    return this;
  }

   /**
   * Get secondaryDiagnosis
   * @return secondaryDiagnosis
  **/
  @ApiModelProperty(value = "")
  public String getSecondaryDiagnosis() {
    return secondaryDiagnosis;
  }

  public void setSecondaryDiagnosis(String secondaryDiagnosis) {
    this.secondaryDiagnosis = secondaryDiagnosis;
  }

  public DiagnosisDto stage(Integer stage) {
    this.stage = stage;
    return this;
  }

   /**
   * Get stage
   * @return stage
  **/
  @ApiModelProperty(value = "")
  public Integer getStage() {
    return stage;
  }

  public void setStage(Integer stage) {
    this.stage = stage;
  }

  public DiagnosisDto createdTimestamp(OffsetDateTime createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
    return this;
  }

   /**
   * Get createdTimestamp
   * @return createdTimestamp
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getCreatedTimestamp() {
    return createdTimestamp;
  }

  public void setCreatedTimestamp(OffsetDateTime createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiagnosisDto diagnosisDto = (DiagnosisDto) o;
    return Objects.equals(this.id, diagnosisDto.id) &&
        Objects.equals(this.patientId, diagnosisDto.patientId) &&
        Objects.equals(this.diagnosisType, diagnosisDto.diagnosisType) &&
        Objects.equals(this.secondaryDiagnosis, diagnosisDto.secondaryDiagnosis) &&
        Objects.equals(this.stage, diagnosisDto.stage) &&
        Objects.equals(this.createdTimestamp, diagnosisDto.createdTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, patientId, diagnosisType, secondaryDiagnosis, stage, createdTimestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiagnosisDto {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    patientId: ").append(toIndentedString(patientId)).append("\n");
    sb.append("    diagnosisType: ").append(toIndentedString(diagnosisType)).append("\n");
    sb.append("    secondaryDiagnosis: ").append(toIndentedString(secondaryDiagnosis)).append("\n");
    sb.append("    stage: ").append(toIndentedString(stage)).append("\n");
    sb.append("    createdTimestamp: ").append(toIndentedString(createdTimestamp)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

