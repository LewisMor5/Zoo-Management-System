public class Lion extends Animal {

    private double maneLength;

    public Lion (String newName, int newAge, String newColour, double newWeight, double newManeLength) {
        super(newName, newAge, newColour, newWeight);
        this.maneLength = newManeLength;
    }

    public void setManeLength(double newManeLength) {
        this.maneLength = newManeLength;
    }

    public double getManeLength() {
        return this.maneLength;
    }

    @Override
    public String makeSound() {
        return "ROAR! I am " + getName() + ", a " + getAge() + " year old " + getColour() + " lion.";
    }

    @Override
    public void dailyCare() {
        super.dailyCare();
        System.out.println(getName() + " is having a mane grooming session.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Mane Length: " + this.maneLength + "cm";
    }

    @Override
    public String getType() {
        return "Lion";
    }
}
