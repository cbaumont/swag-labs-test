package utils;

import com.github.javafaker.Faker;

public class CustomerData {

    private Faker faker;
    private String firstName;
    private String lastName;
    private String postalCode;

    public CustomerData() {
        faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        postalCode = faker.numerify("#####");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
