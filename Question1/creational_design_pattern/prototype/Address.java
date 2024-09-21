public class Address implements Cloneable {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error while cloning Address", e);
        }
    }

    @Override
    public String toString() {
        return street + ", " + city;
    }
}
