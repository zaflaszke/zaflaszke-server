package pl.kk.zaflaszke.models;

import java.util.Objects;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * CategoryPO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2018-06-10T19:09:03.245Z")

public class CategoryPO {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  public CategoryPO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * 
   * @return id
   **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CategoryPO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * 
   * @return name
   **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryPO categoryPO = (CategoryPO) o;
    return Objects.equals(this.id, categoryPO.id) && Objects.equals(this.name, categoryPO.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryPO {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

