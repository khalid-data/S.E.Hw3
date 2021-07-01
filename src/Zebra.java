/**
 * this class represents a zebra
 */
class Zebra extends Animal{
    @Override
    void eating() {
        System.out.println("The zebra is eating grass...");
    }

    @Override
    void show() {
        System.out.println("The zebra is running...");
    }
}