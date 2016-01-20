package interfaces;

public interface Subject {
	public void RegisterObserver(PaintObserver o);
	public void RemoveObserver(PaintObserver o);
	public void NotifyObservers();
}
