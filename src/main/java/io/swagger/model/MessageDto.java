package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
/**
 * MessageDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-17T15:18:43.957-04:00")

public class MessageDto   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("priority")
  private Integer priority = null;

  @JsonProperty("messageTag")
  private String messageTag = null;

  @JsonProperty("text")
  private String text = null;

  public MessageDto id(Long id) {
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

  public MessageDto priority(Integer priority) {
    this.priority = priority;
    return this;
  }

   /**
   * Get priority
   * @return priority
  **/
  @ApiModelProperty(value = "")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public MessageDto messageTag(String messageTag) {
    this.messageTag = messageTag;
    return this;
  }

   /**
   * Get messageTag
   * @return messageTag
  **/
  @ApiModelProperty(value = "")
  public String getMessageTag() {
    return messageTag;
  }

  public void setMessageTag(String messageTag) {
    this.messageTag = messageTag;
  }

  public MessageDto text(String text) {
    this.text = text;
    return this;
  }

   /**
   * Get text
   * @return text
  **/
  @ApiModelProperty(value = "")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageDto messageDto = (MessageDto) o;
    return Objects.equals(this.id, messageDto.id) &&
        Objects.equals(this.priority, messageDto.priority) &&
        Objects.equals(this.messageTag, messageDto.messageTag) &&
        Objects.equals(this.text, messageDto.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, priority, messageTag, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    messageTag: ").append(toIndentedString(messageTag)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

