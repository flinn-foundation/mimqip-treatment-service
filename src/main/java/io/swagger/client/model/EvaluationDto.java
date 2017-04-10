package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EvaluationDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-10T12:47:45.331-04:00")

public class EvaluationDto   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("patientId")
  private Long patientId = null;

  @JsonProperty("questions")
  private List<QuestionDto> questions = new ArrayList<QuestionDto>();

  @JsonProperty("created")
  private OffsetDateTime created = null;

  @JsonProperty("evaluationType")
  private String evaluationType = null;

  public EvaluationDto id(Long id) {
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

  public EvaluationDto patientId(Long patientId) {
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

  public EvaluationDto questions(List<QuestionDto> questions) {
    this.questions = questions;
    return this;
  }

  public EvaluationDto addQuestionsItem(QuestionDto questionsItem) {
    this.questions.add(questionsItem);
    return this;
  }

   /**
   * Get questions
   * @return questions
  **/
  @ApiModelProperty(value = "")
  public List<QuestionDto> getQuestions() {
    return questions;
  }

  public void setQuestions(List<QuestionDto> questions) {
    this.questions = questions;
  }

  public EvaluationDto created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public EvaluationDto evaluationType(String evaluationType) {
    this.evaluationType = evaluationType;
    return this;
  }

   /**
   * Get evaluationType
   * @return evaluationType
  **/
  @ApiModelProperty(value = "")
  public String getEvaluationType() {
    return evaluationType;
  }

  public void setEvaluationType(String evaluationType) {
    this.evaluationType = evaluationType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EvaluationDto evaluationDto = (EvaluationDto) o;
    return Objects.equals(this.id, evaluationDto.id) &&
        Objects.equals(this.patientId, evaluationDto.patientId) &&
        Objects.equals(this.questions, evaluationDto.questions) &&
        Objects.equals(this.created, evaluationDto.created) &&
        Objects.equals(this.evaluationType, evaluationDto.evaluationType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, patientId, questions, created, evaluationType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EvaluationDto {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    patientId: ").append(toIndentedString(patientId)).append("\n");
    sb.append("    questions: ").append(toIndentedString(questions)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    evaluationType: ").append(toIndentedString(evaluationType)).append("\n");
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

