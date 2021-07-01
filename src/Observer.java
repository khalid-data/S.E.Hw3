/**
 * an interface to be implemented in Zoo
 */
interface Observer {
    void addObserver(ZooObserver observer);
    void removeObserver(ZooObserver observer);
}