import java.util.ArrayList;

/**
 * class that represents an observer in the zoo
 */
public class ZooObserver {
    String name;

    /**
     * the classes constructor
     * initializes the observers name
     * @param nameInput name to initialize
     */
    ZooObserver(String nameInput){
        this.name = nameInput;
    }

    /**
     * @return the observers name
     */
    public String getName() {
        return name;
    }

    /**
     * notifies the observer with a given message
     * @param message message for the observer
     */
    public void update(String message){
        System.out.println("["+ getName() + "] " + message);
    }
}
