package Z.com.anup.designPatterns.observer;

public interface Subject {
	public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();



}
