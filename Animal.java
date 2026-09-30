public abstract class Animal {

    // Private instance variables
    private String name;
    private int age;
    private String colour;
    private double weight;

    // Constructor
    public Animal(String newName, int newAge, String newColour, double newWeight){
        this.name = newName;
        this.age = newAge;
        this.colour = newColour;
        this.weight = newWeight;
    }

    //Setter methods
    public void setName(String newName) {
        this.name = newName;
    }
    public void setAge(int newAge) {
        this.age = newAge;
    }
    public void setColour(String newColour) {
        this.colour = newColour;
    }
    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }

    //Getter methods
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getColour() {
        return this.colour;
    }
    public double getWeight() {
        return this.weight;
    }

    //Abstract method to be overwritten by each subclass method
    public abstract String makeSound();

    //Abstract method to return the type of animal
    public abstract String getType();

    //Daily care method
    public void dailyCare() {
        System.out.println(this.name + " has been fed and checked");
    }

    // Display and file writing
    @Override
    public String toString() {
        return "Name: " + this.name +
                ", Age: " + this.age +
                ", Colour: " + this.colour +
                ", Weight: " + this.weight + "kg";
    }
} // end Animal
