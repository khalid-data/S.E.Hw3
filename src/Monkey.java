/**
 * this class represents a monkey
 */
class Monkey extends Animal{
    @Override
    void eating() {
        System.out.println("The monkey is eating a banana...");
    }

    @Override
    void show() {
        System.out.println("The monkey is hanging on trees...");
    }
}