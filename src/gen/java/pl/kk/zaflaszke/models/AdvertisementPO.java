package pl.kk.zaflaszke.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * AdvertisementPO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2018-06-10T19:43:55.192Z")

public class AdvertisementPO {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("categories")
  @Valid
  private List<CategoryPO> categories = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("price")
  private Integer price = null;

  @JsonProperty("creationDate")
  private String creationDate = null;

  @JsonProperty("city")
  private CityPO city = null;

  public AdvertisementPO id(Long id) {
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

  public AdvertisementPO categories(List<CategoryPO> categories) {
    this.categories = categories;
    return this;
  }

  public AdvertisementPO addCategoriesItem(CategoryPO categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<CategoryPO>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * Get categories
   * 
   * @return categories
   **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CategoryPO> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryPO> categories) {
    this.categories = categories;
  }

  public AdvertisementPO title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * 
   * @return title
   **/
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public AdvertisementPO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * 
   * @return description
   **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AdvertisementPO price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * 
   * @return price
   **/
  @ApiModelProperty(value = "")


  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public AdvertisementPO creationDate(String creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Get creationDate
   * 
   * @return creationDate
   **/
  @ApiModelProperty(value = "")


  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public AdvertisementPO city(CityPO city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * 
   * @return city
   **/
  @ApiModelProperty(value = "")

  @Valid

  public CityPO getCity() {
    return city;
  }

  public void setCity(CityPO city) {
    this.city = city;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdvertisementPO advertisementPO = (AdvertisementPO) o;
    return Objects.equals(this.id, advertisementPO.id)
        && Objects.equals(this.categories, advertisementPO.categories)
        && Objects.equals(this.title, advertisementPO.title)
        && Objects.equals(this.description, advertisementPO.description)
        && Objects.equals(this.price, advertisementPO.price)
        && Objects.equals(this.creationDate, advertisementPO.creationDate)
        && Objects.equals(this.city, advertisementPO.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, categories, title, description, price, creationDate, city);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdvertisementPO {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
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

