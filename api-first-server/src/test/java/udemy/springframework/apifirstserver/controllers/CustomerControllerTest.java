package udemy.springframework.apifirstserver.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CustomerControllerTest extends BaseTest {

    @DisplayName("Test List Customers")
    @Test
    void testListCustomers() throws Exception {
        mockMvc.perform(get(CustomerController.BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @DisplayName("Test Get Customer By Id")
    @Test
    void testGetCustomerById() throws Exception {
        mockMvc.perform(get(CustomerController.BASE_URL + "/{customerId}", testCustomer.getId())
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(testCustomer.getId().toString()));
    }
}