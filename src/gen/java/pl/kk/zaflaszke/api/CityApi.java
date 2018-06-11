/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen Do not edit the class manually.
 */
package pl.kk.zaflaszke.api;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pl.kk.zaflaszke.models.CityPO;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2018-06-11T17:21:18.143Z")

@Api(value = "city", description = "the city API")
public interface CityApi {

  @ApiOperation(value = "Finds all cities", nickname = "findAllCities", notes = "Finds all cities",
      response = CityPO.class, responseContainer = "List", tags = {"City",})
  @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation",
      response = CityPO.class, responseContainer = "List")})
  @RequestMapping(value = "/city", produces = {"application/json"}, method = RequestMethod.GET)
  ResponseEntity<List<CityPO>> findAllCities();


  @ApiOperation(value = "Add a new or updates city", nickname = "storeCity", notes = "",
      tags = {"City",})
  @ApiResponses(value = {@ApiResponse(code = 204, message = "Succesful operation")})
  @RequestMapping(value = "/city", produces = {"application/json"}, consumes = {"application/json"},
      method = RequestMethod.POST)
  ResponseEntity<Void> storeCity(
      @ApiParam(value = "City object to stored", required = true) @Valid @RequestBody CityPO body);

}