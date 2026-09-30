public class Fish extends Animal implements Swimmable {

    private String waterType;
    private String breed;

    public Fish(String newName, int newAge, String newColour, double newWeight, String newWaterType, String newBreed) {
        super(newName, newAge, newColour, newWeight);
        this.waterType = newWaterType;
        this.breed = newBreed;
    }

    public void setWaterType(String newWaterType) {
        this.waterType = newWaterType;
    }

    public String getWaterType() {
        return this.waterType;
    }

    public void setBreed(String newBreed) {
        this.breed = newBreed;
    }

    public String getBreed() {
        return this.breed;
    }

    @Override
    public String makeSound() {
        return "Blub! I am " + getName() + ", a " + getAge() + " year old " + getColour() + " " + getBreed() + ".";
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming in " + this.waterType + " water.");
    }

    @Override
    public void checkFinHealth() {
        System.out.println(getName() + " is having a fin health check.");
    }

    @Override
    public void dailyCare() {
        super.dailyCare();
        checkFinHealth();
    }

    @Override
    public String toString() {
        return super.toString() + ", Water Type: " + this.waterType + ", Breed: " + this.breed;
    }

    @Override
    public String getType() {
        return "Fish";
    }
}
