/**
 * this class represents a monkey factory
 */
class MonkeyFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Monkey();
    }
}