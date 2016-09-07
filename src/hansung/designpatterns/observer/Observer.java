package hansung.designpatterns.observer;

public interface Observer {
	public void update(float temp, float humidity, float pressure);


	void update(Subject obs, Object arg);

}
