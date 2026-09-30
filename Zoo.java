import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zoo {

    // Instance variables
    private String zooName;
    private ArrayList<Animal> animals;

    // Constructor
    public Zoo(String newZooName) {
        this.zooName = newZooName;
        this.animals = new ArrayList<Animal>();
    }

    // Getter
    public String getZooName() {
        return this.zooName;
    }

    // ADD, REMOVE, MODIFY

    public void addAnimal(Animal newAnimal) {
        this.animals.add(newAnimal);
        System.out.println(newAnimal.getName() + " has been added to the zoo.");
    }

    public void removeAnimal(String name) {
        for (int i = 0; i < this.animals.size(); i++) {
            if (this.animals.get(i).getName().equals(name)) {
                System.out.println(this.animals.get(i).getName() + " has been removed from the zoo.");
                this.animals.remove(i);
                return;
            }
        }
        System.out.println("Animal not found.");
    }

    public void modifyAnimal(String name, String newColour, double newWeight) {
        for (int i = 0; i < this.animals.size(); i++) {
            if (this.animals.get(i).getName().equals(name)) {
                this.animals.get(i).setColour(newColour);
                this.animals.get(i).setWeight(newWeight);
                System.out.println(name + " has been updated.");
                return;
            }
        }
        System.out.println("Animal not found.");
    }

    // Check if an animal exists by name
    public boolean animalExists(String name) {
        for (Animal a : this.animals) {
            if (a.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // VIEW ALL ANIMALS

    public void viewAllAnimals() {
        if (this.animals.isEmpty()) {
            System.out.println("No animals currently in the zoo.");
            return;
        }
        System.out.println("\n--- Animals in " + this.zooName + " ---");
        for (Animal a : this.animals) {
            System.out.println(a.toString());
            System.out.println(a.makeSound());
        }
    }

    // SEARCH

    public void searchByName(String name) {
        boolean found = false;
        for (Animal a : this.animals) {
            if (a.getName().equals(name)) {
                System.out.println(a.toString());
                System.out.println(a.makeSound());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No animal found with name: " + name);
        }
    }

    public void searchByColour(String colour) {
        boolean found = false;
        for (Animal a : this.animals) {
            if (a.getColour().equals(colour)) {
                System.out.println(a.toString());
                System.out.println(a.makeSound());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No animals found with colour: " + colour);
        }
    }

    // DAILY CARE

    public void performDailyCare() {
        System.out.println("\n--- Daily Care for all animals ---");
        for (Animal a : this.animals) {
            a.dailyCare();
        }
    }

    // REPORT

    public void generateReport() {
        int birdCount = 0;
        int fishCount = 0;
        int lionCount = 0;

        ArrayList<String> colours = new ArrayList<String>();

        for (Animal a : this.animals) {
            String animalType = a.getType();

            if (animalType.equals("Bird")) {
                birdCount++;
            } else if (animalType.equals("Fish")) {
                fishCount++;
            } else if (animalType.equals("Lion")) {
                lionCount++;
            }

            colours.add(a.getColour());
        }

        // Find dominant colour
        String dominantColour = "none";
        int maxCount = 0;
        for (int i = 0; i < colours.size(); i++) {
            int count = 0;
            for (int j = 0; j < colours.size(); j++) {
                if (colours.get(i).equals(colours.get(j))) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                dominantColour = colours.get(i);
            }
        }

        System.out.println("\n--- Zoo Report: " + this.zooName + " ---");
        System.out.println("Total Birds: " + birdCount);
        System.out.println("Total Fish: " + fishCount);
        System.out.println("Total Lions: " + lionCount);
        System.out.println("Dominant Colour: " + dominantColour);
    }

    // FILE I/O

    public void saveToFile() {
        try {
            // Save zoo details
            PrintWriter zooWriter = new PrintWriter("ZooDetails.txt");
            zooWriter.println(this.zooName);
            zooWriter.close();

            // Save animal details
            PrintWriter animalWriter = new PrintWriter("AnimalDetails.txt");
            for (Animal a : this.animals) {
                // Only save if name and colour are not blank
                if (!a.getName().isEmpty() && !a.getColour().isEmpty()) {
                    String animalType = a.getType();
                    if (animalType.equals("Bird")) {
                        Bird b = (Bird) a;
                        animalWriter.println("Bird," + a.getName() + "," + a.getAge() + "," + a.getColour() + "," + a.getWeight() + "," + b.getWingSpan() + "," + b.getBreed());
                    } else if (animalType.equals("Fish")) {
                        Fish f = (Fish) a;
                        animalWriter.println("Fish," + a.getName() + "," + a.getAge() + "," + a.getColour() + "," + a.getWeight() + "," + f.getWaterType() + "," + f.getBreed());
                    } else if (animalType.equals("Lion")) {
                        Lion l = (Lion) a;
                        animalWriter.println("Lion," + a.getName() + "," + a.getAge() + "," + a.getColour() + "," + a.getWeight() + "," + l.getManeLength());
                    }
                }
            }
            animalWriter.close();
            System.out.println("Zoo data saved successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        // Load zoo name
        try {
            Scanner zooScanner = new Scanner(new File("ZooDetails.txt"));
            if (zooScanner.hasNextLine()) {
                this.zooName = zooScanner.nextLine();
            }
            zooScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No zoo details file found, starting fresh.");
        }

        // Load animals
        try {
            Scanner animalScanner = new Scanner(new File("AnimalDetails.txt"));
            while (animalScanner.hasNextLine()) {
                String line = animalScanner.nextLine();
                String[] parts = line.split(",");

                if (parts[0].equals("Bird")) {
                    Bird b = new Bird(parts[1], Integer.parseInt(parts[2]), parts[3], Double.parseDouble(parts[4]), Double.parseDouble(parts[5]), parts[6]);
                    this.animals.add(b);
                } else if (parts[0].equals("Fish")) {
                    Fish f = new Fish(parts[1], Integer.parseInt(parts[2]), parts[3], Double.parseDouble(parts[4]), parts[5], parts[6]);
                    this.animals.add(f);
                } else if (parts[0].equals("Lion")) {
                    Lion l = new Lion(parts[1], Integer.parseInt(parts[2]), parts[3], Double.parseDouble(parts[4]), Double.parseDouble(parts[5]));
                    this.animals.add(l);
                }
            }
            animalScanner.close();
            System.out.println("Zoo data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No animal details file found, starting fresh.");
        }
    }

} // end Zoo
