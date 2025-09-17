import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


class Container {
    private String id;
    private String description;
    private String weight;

    public Container(String id, String description, String weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return id + " | " + description + " | " + weight;
    }
}


class Ship {
    private String name;
    private String captain;

    public Ship(String name, String captain) {
        this.name = name;
        this.captain = captain;
    }

    @Override
    public String toString() {
        return name + " | Capt. " + captain;
    }
}


public class PortContainerManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // LIFO
        Deque<Container> containerStack = new ArrayDeque<>();
        // FIFO
        Deque<Ship> shipQueue = new ArrayDeque<>();

        int choice;
        do {
            System.out.println("\n=== Port Container Management System ===");
            System.out.println("[1] Store container (push)");
            System.out.println("[2] View port containers");
            System.out.println("[3] Register arriving ship (enqueue)");
            System.out.println("[4] View waiting ships");
            System.out.println("[5] Load next ship (pop container + poll ship)");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = getInt(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter Container ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine().trim();
                    System.out.print("Enter Weight (e.g., 500kg): ");
                    String wt = sc.nextLine().trim();
                    Container c = new Container(id, desc, wt);
                    containerStack.push(c);
                    System.out.println("\nStored: " + c);
                    break;

                case 2:
                    System.out.println("\nTOP →");
                    if (containerStack.isEmpty()) {
                        System.out.println("[No containers]");
                    } else {
                        for (Container con : containerStack) {
                            System.out.println(con);
                        }
                    }
                    System.out.println("← BOTTOM");
                    break;

                case 3:
                    System.out.print("Enter Ship Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Captain Name: ");
                    String cap = sc.nextLine().trim();
                    Ship s = new Ship(name, cap);
                    shipQueue.add(s);
                    System.out.println("\nRegistered: " + s);
                    break;

                case 4:
                    System.out.println("\nFRONT →");
                    if (shipQueue.isEmpty()) {
                        System.out.println("[No ships waiting]");
                    } else {
                        for (Ship ship : shipQueue) {
                            System.out.println(ship);
                        }
                    }
                    System.out.println("← REAR");
                    break;

                case 5:
                    if (containerStack.isEmpty()) {
                        System.out.println("\nNo containers available to load!");
                    } else if (shipQueue.isEmpty()) {
                        System.out.println("\nNo ships waiting to be loaded!");
                    } else {
                        Container topContainer = containerStack.pop();
                        Ship frontShip = shipQueue.poll();
                        System.out.println("\nLoaded: " + topContainer + " → " + frontShip);
                        System.out.println("Remaining containers: " + containerStack.size());
                        System.out.println("Remaining ships waiting: " + shipQueue.size());
                    }
                    break;

                case 0:
                    System.out.println("\nExiting system. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    
    private static int getInt(Scanner sc) {
        while (true) {
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
