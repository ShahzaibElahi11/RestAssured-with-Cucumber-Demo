package stepDefinitions;

import com.model.Employee;
import io.cucumber.java.en.Given;
import utilities.BaseTest;

public class EmployeesStepsDefinitions extends BaseTest {
    @Given("Request payload is created for employee")
    public void request_payload_is_created_for_employee() {
        Employee employee = Employee.builder()
                .name(faker.name().fullName())
                .salary(Integer.parseInt(faker.number().digits(7)))
                .age((faker.number().numberBetween(20, 70)))
                .image("")
                .build();
        reqSpec.body(employee);
    }

    @Given("Update newly created employee record")
    public void update_newly_created_employee_record() {
        Employee employee = Employee.builder()
                .name("Updated " + faker.name().fullName())
                .salary((faker.number().numberBetween(1000, 99999)))
                .age((faker.number().numberBetween(20, 70)))
                .image("https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg")
                .build();
        reqSpec.body(employee);
    }
}
