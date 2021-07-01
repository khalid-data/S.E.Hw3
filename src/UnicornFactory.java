/**
 * this class represents a unicorn factory
 */
class UnicornFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Unicorn();
    }
}