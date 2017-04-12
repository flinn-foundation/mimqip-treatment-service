package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * EvaluationResponseDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-11T23:15:16.264-04:00")

public class EvaluationResponseDto   {
  @JsonProperty("prompt")
  private String prompt = null;

  @JsonProperty("answer")
  private String answer = null;

  public EvaluationResponseDto prompt(String prompt) {
    this.prompt = prompt;
    return this;
  }

   /**
   * Get prompt
   * @return prompt
  **/
  @ApiModelProperty(value = "")
  public String getPrompt() {
    return prompt;
  }

  public void setPrompt(String prompt) {
    this.prompt = prompt;
  }

  public EvaluationResponseDto answer(String answer) {
    this.answer = answer;
    return this;
  }

   /**
   * Get answer
   * @return answer
  **/
  @ApiModelProperty(value = "")
  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EvaluationResponseDto evaluationResponseDto = (EvaluationResponseDto) o;
    return Objects.equals(this.prompt, evaluationResponseDto.prompt) &&
        Objects.equals(this.answer, evaluationResponseDto.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prompt, answer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EvaluationResponseDto {\n");

    sb.append("    prompt: ").append(toIndentedString(prompt)).append("\n");
    sb.append("    answer: ").append(toIndentedString(answer)).append("\n");
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

