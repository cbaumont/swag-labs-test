package utils;

import com.github.javafaker.Faker;

public class CustomerData {

    private CustomerData() {
    }

    private static Faker faker = new Faker();
    private static String firstName = faker.name().firstName();
    private static String lastName = faker.name().lastName();
    private static String postalCode = faker.numerify("#####");

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getPostalCode() {
        return postalCode;
    }
}
