package utilities;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class BaseTest {


    protected static String BASE_ENDPOINT = ApplicationConfiguration.getBaseURL();


    /**
     * Common objects used across the step definition
     */
    public static RequestSpecification reqSpec;
    public static Response response;
    public static int newEmployeeId;

    /**
     * Random Data Generation
     */
    public static Faker faker = new Faker();

    /*******************************************************
     * Create a static RequestSpecification for Demo Application :
     * - Set the Request Base URL
     * - Set the Request URL Port
     * - Set the Request content Type is JSON
     ******************************************************/
    public static void createRequestSpec() {
        reqSpec = RestAssured.given()
                .baseUri(BASE_ENDPOINT)
                .contentType(ContentType.JSON)
                .accept("*/*")
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());
    }

    public static void createResponseSpec() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code is not matched :");
        Assert.assertTrue(response.getContentType().contains("application/json"), "Content Type is not Matched :-" + response.getContentType());
        Assert.assertEquals(response.body().jsonPath().get("status").toString(), "success", "Status message is not success :");
        Assert.assertTrue(response.getTime() < 20000L, "Response time is not in the range");
    }


}
