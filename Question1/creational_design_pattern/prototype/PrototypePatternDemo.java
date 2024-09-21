public class PrototypePatternDemo {
    public static void main(String[] args) {
        Address address = new Address("123 Main St", "Springfield");
        UserProfile originalProfile = new UserProfile("Neel Patel", "neel.p@example.com", address);

        System.out.println("Original UserProfile:");
        originalProfile.display();

        // Clone the user profile
        UserProfile clonedProfile = originalProfile.clone();
        clonedProfile.display();
        
        System.out.println("\nOriginal and cloned profiles are separate objects: " +
                (originalProfile != clonedProfile));
        System.out.println("Address objects are separate: " + (originalProfile.address != clonedProfile.address));
    }
}
