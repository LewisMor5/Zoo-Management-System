import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        // Create the zoo with name hard coded
        Zoo zoo = new Zoo("Belfast City Zoo");

        // Load any previously saved data on startup
        zoo.loadFromFile();

        int choice = 0;

        while (choice != 9) {

            // Display menu
            System.out.println("\n=== Belfast City Zoo Menu ===");
            System.out.println("1. Add an animal");
            System.out.println("2. Remove an animal");
            System.out.println("3. Modify an animal");
            System.out.println("4. View all animals");
            System.out.println("5. Search by name");
            System.out.println("6. Search by colour");
            System.out.println("7. Perform daily care");
            System.out.println("8. Generate zoo report");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = keyboard.nextInt();
            keyboard.nextLine();

            if (choice == 1) {
                addAnimal(zoo, keyboard);
            } else if (choice == 2) {
                System.out.print("Enter animal name to remove: ");
                String name = keyboard.nextLine();
                zoo.removeAnimal(name);
            } else if (choice == 3) {
            System.out.print("Enter animal name to modify: ");
            String name = keyboard.nextLine();

            if (!zoo.animalExists(name)) {
                System.out.println("Animal not found.");
            } else {
                // Validate colour
                String colour = "";
                while (colour.isEmpty()) {
                    System.out.print("Enter new colour: ");
                    colour = keyboard.nextLine();
                    if (colour.isEmpty()) {
                        System.out.println("Colour cannot be blank. Please try again.");
                    } else {
                        boolean validColour = true;
                        for (int i = 0; i < colour.length(); i++) {
                            if (!Character.isLetter(colour.charAt(i)) && colour.charAt(i) != ' ') {
                                validColour = false;
                                break;
                            }
                        }
                        if (!validColour) {
                            System.out.println("Colour must contain letters only. Please try again.");
                            colour = "";
                        }
                    }
                }

                // Validate weight
                double weight = -1;
                while (weight < 0) {
                    System.out.print("Enter new weight (kg): ");
                    if (keyboard.hasNextDouble()) {
                        weight = keyboard.nextDouble();
                        keyboard.nextLine();
                        if (weight < 0) {
                            System.out.println("Weight cannot be negative. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid weight. Please enter a number.");
                        keyboard.nextLine();
                    }
                }

                zoo.modifyAnimal(name, colour, weight);
            }

            } else if (choice == 4) {
                zoo.viewAllAnimals();
            } else if (choice == 5) {
                System.out.print("Enter animal name to search: ");
                String name = keyboard.nextLine();
                zoo.searchByName(name);
            } else if (choice == 6) {
                System.out.print("Enter colour to search: ");
                String colour = keyboard.nextLine();
                zoo.searchByColour(colour);
            } else if (choice == 7) {
                zoo.performDailyCare();
            } else if (choice == 8) {
                zoo.generateReport();
            } else if (choice == 9) {
                // Save to file on exit
                zoo.saveToFile();
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice, please enter a number between 1 and 9.");
            }

        } // end while

        keyboard.close();

    } // end main

    // ADD ANIMAL METHOD

    public static void addAnimal(Zoo zoo, Scanner keyboard) {

        System.out.println("\nWhat type of animal?");
        System.out.println("1. Bird");
        System.out.println("2. Fish");
        System.out.println("3. Lion");
        System.out.print("Enter choice: ");

        while (!keyboard.hasNextInt()) {
            System.out.println("Invalid choice. Please enter 1, 2 or 3.");
            keyboard.nextLine();
        }
        int typeChoice = keyboard.nextInt();
        keyboard.nextLine();

        if (typeChoice != 1 && typeChoice != 2 && typeChoice != 3) {
            System.out.println("Invalid animal type. Please enter 1, 2 or 3.");
            return;
        }

        // Validate name - cannot be blank or contain numbers
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter name: ");
            name = keyboard.nextLine();
            if (name.isEmpty()) {
                System.out.println("Name cannot be blank. Please try again.");
            } else {
                boolean validName = true;
                for (int i = 0; i < name.length(); i++) {
                    if (!Character.isLetter(name.charAt(i)) && name.charAt(i) != ' ') {
                        validName = false;
                        break;
                    }
                }
                if (!validName) {
                    System.out.println("Name must contain letters only. Please try again.");
                    name = "";
                }
            }
        }

        // Validate age - must be a positive whole number
        int age = -1;
        while (age < 0) {
            System.out.print("Enter age: ");
            if (keyboard.hasNextInt()) {
                age = keyboard.nextInt();
                keyboard.nextLine();
                if (age < 0) {
                    System.out.println("Age cannot be negative. Please try again.");
                }
            } else {
                System.out.println("Invalid age. Please enter a whole number.");
                keyboard.nextLine();
            }
        }

        // Validate colour - cannot be blank or contain numbers
        String colour = "";
        while (colour.isEmpty()) {
            System.out.print("Enter colour: ");
            colour = keyboard.nextLine();
            if (colour.isEmpty()) {
                System.out.println("Colour cannot be blank. Please try again.");
            } else {
                boolean validColour = true;
                for (int i = 0; i < colour.length(); i++) {
                    if (!Character.isLetter(colour.charAt(i)) && colour.charAt(i) != ' ') {
                        validColour = false;
                        break;
                    }
                }
                if (!validColour) {
                    System.out.println("Colour must contain letters only. Please try again.");
                    colour = "";
                }
            }
        }

        // Validate weight - must be a positive number
        double weight = -1;
        while (weight < 0) {
            System.out.print("Enter weight (kg): ");
            if (keyboard.hasNextDouble()) {
                weight = keyboard.nextDouble();
                keyboard.nextLine();
                if (weight < 0) {
                    System.out.println("Weight cannot be negative. Please try again.");
                }
            } else {
                System.out.println("Invalid weight. Please enter a number.");
                keyboard.nextLine();
            }
        }

        // Create the correct type of animal
        if (typeChoice == 1) {

            // Validate wingspan
            double wingSpan = -1;
            while (wingSpan < 0) {
                System.out.print("Enter wingspan (cm): ");
                if (keyboard.hasNextDouble()) {
                    wingSpan = keyboard.nextDouble();
                    keyboard.nextLine();
                    if (wingSpan < 0) {
                        System.out.println("Wingspan cannot be negative. Please try again.");
                    }
                } else {
                    System.out.println("Invalid wingspan. Please enter a number.");
                    keyboard.nextLine();
                }
            }

            // Validate breed
            String breed = "";
            while (breed.isEmpty()) {
                System.out.print("Enter breed (e.g. Parrot, Eagle): ");
                breed = keyboard.nextLine();
                if (breed.isEmpty()) {
                    System.out.println("Breed cannot be blank. Please try again.");
                } else {
                    boolean validBreed = true;
                    for (int i = 0; i < breed.length(); i++) {
                        if (!Character.isLetter(breed.charAt(i)) && breed.charAt(i) != ' ') {
                            validBreed = false;
                            break;
                        }
                    }
                    if (!validBreed) {
                        System.out.println("Breed must contain letters only. Please try again.");
                        breed = "";
                    }
                }
            }

            Bird b = new Bird(name, age, colour, weight, wingSpan, breed);
            zoo.addAnimal(b);

        } else if (typeChoice == 2) {

            // Validate water type
            String waterType = "";
            while (!waterType.equals("Freshwater") && !waterType.equals("Saltwater")) {
                System.out.print("Enter water type (Freshwater/Saltwater): ");
                waterType = keyboard.nextLine();
                if (!waterType.equals("Freshwater") && !waterType.equals("Saltwater")) {
                    System.out.println("Invalid water type. Please enter Freshwater or Saltwater.");
                }
            }

            // Validate breed
            String breed = "";
            while (breed.isEmpty()) {
                System.out.print("Enter breed (e.g. Goldfish, Salmon): ");
                breed = keyboard.nextLine();
                if (breed.isEmpty()) {
                    System.out.println("Breed cannot be blank. Please try again.");
                } else {
                    boolean validBreed = true;
                    for (int i = 0; i < breed.length(); i++) {
                        if (!Character.isLetter(breed.charAt(i)) && breed.charAt(i) != ' ') {
                            validBreed = false;
                            break;
                        }
                    }
                    if (!validBreed) {
                        System.out.println("Breed must contain letters only. Please try again.");
                        breed = "";
                    }
                }
            }

            Fish f = new Fish(name, age, colour, weight, waterType, breed);
            zoo.addAnimal(f);

        } else if (typeChoice == 3) {

            // Validate mane length
            double maneLength = -1;
            while (maneLength < 0) {
                System.out.print("Enter mane length (cm): ");
                if (keyboard.hasNextDouble()) {
                    maneLength = keyboard.nextDouble();
                    keyboard.nextLine();
                    if (maneLength < 0) {
                        System.out.println("Mane length cannot be negative. Please try again.");
                    }
                } else {
                    System.out.println("Invalid mane length. Please enter a number.");
                    keyboard.nextLine();
                }
            }

            Lion l = new Lion(name, age, colour, weight, maneLength);
            zoo.addAnimal(l);

        }

    }
}