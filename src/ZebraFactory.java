/**
 * this class represents a zebra factory
 */
class ZebraFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Zebra();
    }
}