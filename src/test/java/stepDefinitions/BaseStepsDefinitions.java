package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.BaseTest;

public class BaseStepsDefinitions extends BaseTest {
    @Given("^Valid Request is prepared$")
    public void valid_Request_is_prepared() {
        createRequestSpec();
    }

    @When("Get request is send to server for end point {string}")
    public void get_request_is_send_to_server_for_end_point(String endpoint) {
        response = reqSpec.when().get(endpoint);
    }

    @When("Post request is send to server for end point {string}")
    public void post_request_is_send_to_server_for_end_point(String endpoint) {
        response = reqSpec.when().post(endpoint);
    }

    @When("Put request is send to server for end point {string}")
    public void put_request_is_send_to_server_for_end_point(String endpoint) {
        if (endpoint.contains("/api/") && endpoint.endsWith("update/")) {
            endpoint = endpoint + newEmployeeId;
        }
        response = reqSpec.when().put(endpoint);
    }

    @When("Delete request is send to server for end point {string}")
    public void delete_request_is_send_to_server_for_end_point(String endpoint) {
        if (endpoint.contains("/api/") && endpoint.endsWith("delete/")) {
            endpoint = endpoint + newEmployeeId;
        }
        response = reqSpec.when().delete(endpoint);
    }

    @Then("^response is matches with response specification$")
    public void response_is_matches_with_response_specification() {
        createResponseSpec();
    }

    @Then("^Value at json path \"([^\"]*)\" is equals to \"([^\"]*)\"$")
    public void value_at_json_path_is_equals_to(String jsonPath, String expectedValue) {
        Assert.assertEquals(expectedValue, response.body().jsonPath().get(jsonPath).toString(), "Value for JSON is not matched");
    }

    @Then("Extract Employee id from json path")
    public void extract_employee_id_from_json_path() {
        newEmployeeId = response.body().jsonPath().get("data.id");
        System.out.println("New Employee ID: " + newEmployeeId);
    }
}
