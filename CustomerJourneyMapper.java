import java.util.ArrayList;
import java.util.Scanner;

// Class representing a stage in the customer journey
class JourneyStage {
    private String stageName;
    private String description;
    private String touchpoint;

    public JourneyStage(String stageName, String description, String touchpoint) {
        this.stageName = stageName;
        this.description = description;
        this.touchpoint = touchpoint;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTouchpoint() {
        return touchpoint;
    }

    public void setTouchpoint(String touchpoint) {
        this.touchpoint = touchpoint;
    }

    @Override
    public String toString() {
        return "Stage: " + stageName +
                "\nDescription: " + description +
                "\nTouchpoint: " + touchpoint + "\n";
    }
}

// Main class for customizable journey mapper
public class CustomerJourneyMapper {
    private static ArrayList<JourneyStage> journeyMap = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Customer Journey Mapper ---");
            System.out.println("1. Add a new stage");
            System.out.println("2. View all stages");
            System.out.println("3. Edit a stage");
            System.out.println("4. Delete a stage");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStage();
                    break;
                case 2:
                    viewStages();
                    break;
                case 3:
                    editStage();
                    break;
                case 4:
                    deleteStage();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 5);
    }

    // Add a new stage
    private static void addStage() {
        System.out.print("Enter Stage Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Description: ");
        String desc = sc.nextLine();

        System.out.print("Enter Customer Touchpoint: ");
        String touch = sc.nextLine();

        journeyMap.add(new JourneyStage(name, desc, touch));
        System.out.println("✅ Stage added successfully!");
    }

    // View all stages
    private static void viewStages() {
        if (journeyMap.isEmpty()) {
            System.out.println("No stages in the journey yet.");
            return;
        }

        System.out.println("\nCustomer Journey Map:");
        for (int i = 0; i < journeyMap.size(); i++) {
            System.out.println("Stage " + (i + 1) + ":");
            System.out.println(journeyMap.get(i));
        }
    }

    // Edit a stage
    private static void editStage() {
        if (journeyMap.isEmpty()) {
            System.out.println("No stages available to edit.");
            return;
        }

        viewStages();
        System.out.print("Enter stage number to edit: ");
        int num = sc.nextInt();
        sc.nextLine(); // consume newline

        if (num < 1 || num > journeyMap.size()) {
            System.out.println("Invalid stage number!");
            return;
        }

        JourneyStage stage = journeyMap.get(num - 1);

        System.out.print("Enter new Stage Name (" + stage.getStageName() + "): ");
        String name = sc.nextLine();
        if (!name.isEmpty()) stage.setStageName(name);

        System.out.print("Enter new Description (" + stage.getDescription() + "): ");
        String desc = sc.nextLine();
        if (!desc.isEmpty()) stage.setDescription(desc);

        System.out.print("Enter new Touchpoint (" + stage.getTouchpoint() + "): ");
        String touch = sc.nextLine();
        if (!touch.isEmpty()) stage.setTouchpoint(touch);

        System.out.println("✅ Stage updated successfully!");
    }

    // Delete a stage
    private static void deleteStage() {
        if (journeyMap.isEmpty()) {
            System.out.println("No stages to delete.");
            return;
        }

        viewStages();
        System.out.print("Enter stage number to delete: ");
        int num = sc.nextInt();
        sc.nextLine();

        if (num < 1 || num > journeyMap.size()) {
            System.out.println("Invalid stage number!");
            return;
        }

        journeyMap.remove(num - 1);
        System.out.println("🗑 Stage deleted successfully!");
    }
}