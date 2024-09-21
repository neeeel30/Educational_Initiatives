public class UserProfile implements Cloneable {
    private String name;
    private String email;
    Address address;

    public UserProfile(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    @Override
    public UserProfile clone() {
        try {
            UserProfile clonedProfile = (UserProfile) super.clone();
            clonedProfile.address = this.address.clone(); // Deep clone of address
            return clonedProfile;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error while cloning UserProfile", e);
        }
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
    }
}
