import java.util.ArrayList;
import java.util.List;


public class Zoo implements Observer{
    //zoo observers
    public ArrayList<ZooObserver> observers = new ArrayList<ZooObserver>();

    //animals in the zoo
    public ArrayList<Animal> animals = new ArrayList<Animal>();

    private static final int initial_happiness = 2;
    private static final int initial_hunger = 3;

    private static Zoo instance = null;
    
    private int numOfUnicorn = 0;
    private int numOfZebra = 0;
    private int numOfMonkey = 0;

    public int happiness;
    public int hunger;


    /**
     * classes constructor
     */
    public Zoo (){
        System.out.println("Creating zoo...");
        this.happiness = initial_happiness;
        this.hunger = initial_hunger;
    }

    /**
     * this method checks if we initialized a zoo before (singletone)
     * if we have we return it and print accordingly
     * @return zoo if initialized before, and null else
     */
    public static Zoo getInstance(){
        if(instance == null){
            instance = new Zoo();
        }
        else {
            System.out.println("The zoo already exists...");
        }
        return instance;
    }

    
    /**
     * overrides a method from implemented interface
     * adds observers to the list of observers in the Zoo
     * @param observer new observer to add
     */
    @Override
    public void addObserver(ZooObserver observer) {
        this.observers.add(observer);
    }


    /**
     * overrides a method from implemented interface
     * removes observers from the list of observers in the Zoo
     * @param observer given observer to remove
     */
    @Override
    public void removeObserver(ZooObserver observer) {
        this.observers.remove(observer);
    }


    /**
     * this method adds a new animal to the Zoo and notifies the observers witch animal was added
     * @param animal new animal to be added
     */
    void addAnimal(Animal animal){
        if(animal instanceof Unicorn){
            numOfUnicorn += 1;
        }
        else if (animal instanceof Zebra){
            numOfZebra += 1;
        }
        else if (animal instanceof Monkey){
            numOfMonkey += 1;
        }
        notifyObservers(animal.getClass().getSimpleName() + " has been added to the zoo!");
        this.animals.add(animal);
    }


    /**
     * a method used in addAnimal method
     * it helps notifying the observers
     * @param notifying message for the observers
     */
    public void notifyObservers(String notifying){
        System.out.println("Notifying observers:");

        for(ZooObserver obserber : this.observers){
            obserber.update(notifying);
        }
    }


    /**
     * this method represents feeding the animals
     * we print what each animal eats and decrease the hunger level
     * and we notify the observers
     */
    public void feedAnimals() {
        for(Animal animal : animals){
            animal.eating();
        }
        notifyObservers("The animals are being fed");

        if(this.hunger > 1){
            this.hunger -= 1;
        }

    }


    /**
     * this method represents the making of a show
     * each animal in zoo makes a show
     * the observers are notified
     * after every show the animals happiness and hunger increases by one each
     */
    public void watchAnimals(){
        for(Animal animal : animals){
                animal.show();
        }
        notifyObservers("The animals are being watched");
        if(this.happiness < 5){
            this.happiness += 1;
        }
        if(this.hunger < 5){
            this.hunger += 1;
        }


    }


    /**
     * this method is used in showAnimalsInfo method
     * this method prints the happiness level and tells us wither we should make more show
     */
    public void happyInfo(){
        System.out.println("Happiness level: " + this.happiness);
        if(this.happiness < 3){
            System.out.println("The animals are not happy, you should watch them...");
        }
        else {
            System.out.println("The animals are very happy, keep working hard...");
        }
    }


    /**
     * this method is used in showAnimalsInfo method
     * it prints the hunger level and tells us wither we should feed the animals
     */
    public void hungerInfo(){
        System.out.println("Hunger level: " + this.hunger);
        if(this.hunger > 3){
            System.out.println("The animals are hungry, you should feed them...");
        }
    }


    /**
     * prints info about the animals in the zoo
     */
    public void showAnimalsInfo(){
        System.out.println("The zoo contains total of " + this.animals.size() + " animals:");
        System.out.println("- Zebra: " + numOfZebra);
        System.out.println("- Unicorn: " + numOfUnicorn);
        System.out.println("- Monkey: " + numOfMonkey);

        happyInfo();
        hungerInfo();
    }
}
