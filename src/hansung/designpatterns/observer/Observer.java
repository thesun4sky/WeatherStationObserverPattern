package hansung.designpatterns.observer;

public interface Observer {
	public void update(float temp, float humidity, float pressure);


	void update(TimedWeatherData weatherData, Object arg);
	void update(WeatherData weatherData, Object arg);

}
