public class Bird extends Animal implements Flyable {

    private double wingSpan;
    private String breed;

    public Bird(String newName, int newAge, String newColour, double newWeight, double newWingSpan, String newBreed) {
        super(newName, newAge, newColour, newWeight);
        this.wingSpan = newWingSpan;
        this.breed = newBreed;
    }

    public void setWingSpan(double newWingSpan) {
        this.wingSpan = newWingSpan;
    }

    public double getWingSpan(){
        return this.wingSpan;
    }

    public void setBreed(String newBreed) {
        this.breed = newBreed;
    }

    public String getBreed() {
        return this.breed;
    }

    @Override
    public String makeSound() {
        return "Tweet! I am " + getName() + ", a " + getAge() + " year old " + getColour() + " " + getBreed() + ".";
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying with a wingspan of " + this.wingSpan + "cm.");
    }

    @Override
    public void checkWingHealth(){
        System.out.println(getName() + " is having a wing health check.");
    }

    @Override
    public void dailyCare(){
        super.dailyCare();
        checkWingHealth();
    }

    @Override
    public String toString() {
        return super.toString() + ", Wingspan: " + this.wingSpan + "cm, Breed: " + this.breed;
    }

    @Override
    public String getType() {
        return "Bird";
    }

}
