/**
 * this class represents a unicorn
 */
class Unicorn extends Animal{
    @Override
    void eating() {
        System.out.println("The unicorn is eating rainbow cakes...");
    }

    @Override
    void show() {
        System.out.println("The unicorn is flying...");
    }
}