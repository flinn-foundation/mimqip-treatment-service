package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PatientDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-09T20:56:30.452-04:00")

public class PatientDto {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  /**
   * Gets or Sets sex
   */
  public enum SexEnum {
    MALE("MALE"),

    FEMALE("FEMALE");

    private String value;

    SexEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SexEnum fromValue(String text) {
      for (SexEnum b : SexEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("sex")
  private SexEnum sex = null;

  @JsonProperty("dateOfBirth")
  private LocalDate dateOfBirth = null;

  @JsonProperty("valid")
  private Boolean valid = null;

  @JsonProperty("zipCode")
  private String zipCode = null;

  /**
   * Gets or Sets race
   */
  public enum RaceEnum {
    WHITE("WHITE"),

    BLACK("BLACK"),

    INDIAN_AMERICAN("INDIAN_AMERICAN"),

    ASIAN("ASIAN"),

    PACIFIC_ISLANDER("PACIFIC_ISLANDER"),

    NO_RESPONSE("NO_RESPONSE");

    private String value;

    RaceEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RaceEnum fromValue(String text) {
      for (RaceEnum b : RaceEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("race")
  private List<RaceEnum> race = new ArrayList<RaceEnum>();

  /**
   * Gets or Sets ethnicity
   */
  public enum EthnicityEnum {
    HISPANIC("HISPANIC"),

    NON_HISPANIC("NON_HISPANIC"),

    NO_RESPONSE("NO_RESPONSE");

    private String value;

    EthnicityEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EthnicityEnum fromValue(String text) {
      for (EthnicityEnum b : EthnicityEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("ethnicity")
  private EthnicityEnum ethnicity = null;

  /**
   * Gets or Sets marital
   */
  public enum MaritalEnum {
    MARRIED("MARRIED"),

    SINGLE("SINGLE"),

    SEPARATED("SEPARATED"),

    DIVORCED("DIVORCED"),

    WIDOWED("WIDOWED");

    private String value;

    MaritalEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MaritalEnum fromValue(String text) {
      for (MaritalEnum b : MaritalEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("marital")
  private MaritalEnum marital = null;

  /**
   * Gets or Sets living
   */
  public enum LivingEnum {
    ALONE("ALONE"),

    WITH_ROOMMATES("WITH_ROOMMATES"),

    WITH_SPOUSE("WITH_SPOUSE"),

    WITH_SPOUSE_AND_CHILDREN("WITH_SPOUSE_AND_CHILDREN"),

    WITH_PARENTS("WITH_PARENTS"),

    GROUP_HOME("GROUP_HOME");

    private String value;

    LivingEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LivingEnum fromValue(String text) {
      for (LivingEnum b : LivingEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("living")
  private LivingEnum living = null;

  /**
   * Gets or Sets employment
   */
  public enum EmploymentEnum {
    UNEMPLOYED("UNEMPLOYED"),

    FULL_TIME_SALARIED("FULL TIME_SALARIED"),

    PART_TIME_SALARIED("PART_TIME_SALARIED"),

    FULL_TIME_NON_SALARIED("FULL_TIME_NON_SALARIED"),

    PART_TIME_NON_SALARIED("PART_TIME_NON_SALARIED"),

    SELF_EMPLOYED("SELF_EMPLOYED");

    private String value;

    EmploymentEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EmploymentEnum fromValue(String text) {
      for (EmploymentEnum b : EmploymentEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("employment")
  private EmploymentEnum employment = null;

  @JsonProperty("primaryCarePhysicianName")
  private String primaryCarePhysicianName = null;

  @JsonProperty("primaryCarePhysicianEmail")
  private String primaryCarePhysicianEmail = null;

  @JsonProperty("startDate")
  private OffsetDateTime startDate = null;

  public PatientDto id(Long id) {
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

  public PatientDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public PatientDto lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public PatientDto sex(SexEnum sex) {
    this.sex = sex;
    return this;
  }

   /**
   * Get sex
   * @return sex
  **/
  @ApiModelProperty(value = "")
  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public PatientDto dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

   /**
   * Get dateOfBirth
   * @return dateOfBirth
  **/
  @ApiModelProperty(value = "")
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public PatientDto valid(Boolean valid) {
    this.valid = valid;
    return this;
  }

   /**
   * Get valid
   * @return valid
  **/
  @ApiModelProperty(value = "")
  public Boolean getValid() {
    return valid;
  }

  public void setValid(Boolean valid) {
    this.valid = valid;
  }

  public PatientDto zipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

   /**
   * Get zipCode
   * @return zipCode
  **/
  @ApiModelProperty(value = "")
  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public PatientDto race(List<RaceEnum> race) {
    this.race = race;
    return this;
  }

  public PatientDto addRaceItem(RaceEnum raceItem) {
    this.race.add(raceItem);
    return this;
  }

   /**
   * Get race
   * @return race
  **/
  @ApiModelProperty(value = "")
  public List<RaceEnum> getRace() {
    return race;
  }

  public void setRace(List<RaceEnum> race) {
    this.race = race;
  }

  public PatientDto ethnicity(EthnicityEnum ethnicity) {
    this.ethnicity = ethnicity;
    return this;
  }

   /**
   * Get ethnicity
   * @return ethnicity
  **/
  @ApiModelProperty(value = "")
  public EthnicityEnum getEthnicity() {
    return ethnicity;
  }

  public void setEthnicity(EthnicityEnum ethnicity) {
    this.ethnicity = ethnicity;
  }

  public PatientDto marital(MaritalEnum marital) {
    this.marital = marital;
    return this;
  }

   /**
   * Get marital
   * @return marital
  **/
  @ApiModelProperty(value = "")
  public MaritalEnum getMarital() {
    return marital;
  }

  public void setMarital(MaritalEnum marital) {
    this.marital = marital;
  }

  public PatientDto living(LivingEnum living) {
    this.living = living;
    return this;
  }

   /**
   * Get living
   * @return living
  **/
  @ApiModelProperty(value = "")
  public LivingEnum getLiving() {
    return living;
  }

  public void setLiving(LivingEnum living) {
    this.living = living;
  }

  public PatientDto employment(EmploymentEnum employment) {
    this.employment = employment;
    return this;
  }

   /**
   * Get employment
   * @return employment
  **/
  @ApiModelProperty(value = "")
  public EmploymentEnum getEmployment() {
    return employment;
  }

  public void setEmployment(EmploymentEnum employment) {
    this.employment = employment;
  }

  public PatientDto primaryCarePhysicianName(String primaryCarePhysicianName) {
    this.primaryCarePhysicianName = primaryCarePhysicianName;
    return this;
  }

   /**
   * Get primaryCarePhysicianName
   * @return primaryCarePhysicianName
  **/
  @ApiModelProperty(value = "")
  public String getPrimaryCarePhysicianName() {
    return primaryCarePhysicianName;
  }

  public void setPrimaryCarePhysicianName(String primaryCarePhysicianName) {
    this.primaryCarePhysicianName = primaryCarePhysicianName;
  }

  public PatientDto primaryCarePhysicianEmail(String primaryCarePhysicianEmail) {
    this.primaryCarePhysicianEmail = primaryCarePhysicianEmail;
    return this;
  }

   /**
   * Get primaryCarePhysicianEmail
   * @return primaryCarePhysicianEmail
  **/
  @ApiModelProperty(value = "")
  public String getPrimaryCarePhysicianEmail() {
    return primaryCarePhysicianEmail;
  }

  public void setPrimaryCarePhysicianEmail(String primaryCarePhysicianEmail) {
    this.primaryCarePhysicianEmail = primaryCarePhysicianEmail;
  }

  public PatientDto startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientDto patientDto = (PatientDto) o;
    return Objects.equals(this.id, patientDto.id) &&
        Objects.equals(this.firstName, patientDto.firstName) &&
        Objects.equals(this.lastName, patientDto.lastName) &&
        Objects.equals(this.sex, patientDto.sex) &&
        Objects.equals(this.dateOfBirth, patientDto.dateOfBirth) &&
        Objects.equals(this.valid, patientDto.valid) &&
        Objects.equals(this.zipCode, patientDto.zipCode) &&
        Objects.equals(this.race, patientDto.race) &&
        Objects.equals(this.ethnicity, patientDto.ethnicity) &&
        Objects.equals(this.marital, patientDto.marital) &&
        Objects.equals(this.living, patientDto.living) &&
        Objects.equals(this.employment, patientDto.employment) &&
        Objects.equals(this.primaryCarePhysicianName, patientDto.primaryCarePhysicianName) &&
        Objects.equals(this.primaryCarePhysicianEmail, patientDto.primaryCarePhysicianEmail) &&
        Objects.equals(this.startDate, patientDto.startDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, sex, dateOfBirth, valid, zipCode, race, ethnicity, marital, living, employment, primaryCarePhysicianName, primaryCarePhysicianEmail, startDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientDto {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    valid: ").append(toIndentedString(valid)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    race: ").append(toIndentedString(race)).append("\n");
    sb.append("    ethnicity: ").append(toIndentedString(ethnicity)).append("\n");
    sb.append("    marital: ").append(toIndentedString(marital)).append("\n");
    sb.append("    living: ").append(toIndentedString(living)).append("\n");
    sb.append("    employment: ").append(toIndentedString(employment)).append("\n");
    sb.append("    primaryCarePhysicianName: ").append(toIndentedString(primaryCarePhysicianName)).append("\n");
    sb.append("    primaryCarePhysicianEmail: ").append(toIndentedString(primaryCarePhysicianEmail)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
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

