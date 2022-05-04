package DataTypes;

public class Address {

    private final String streetAddress;
    private final String city;
    private final String zipCode;

    public Address(String streetAddress, String city, String zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }
    public String getCity() {
        return city;
    }
    public String getZipCode() {
        return zipCode;
    }
}