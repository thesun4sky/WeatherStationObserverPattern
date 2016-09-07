package hansung.designpatterns.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private String measuredTime;
	private Subject timedweatherData;
	
	public CurrentConditionsDisplay(Subject TimedweatherData) {
		this.timedweatherData = TimedweatherData;
		timedweatherData.registerObserver(this);
	}

	@Override
	public void update(TimedWeatherData obs, Object arg) {
		if (obs instanceof TimedWeatherData) {
			TimedWeatherData timedweatherData = (TimedWeatherData)obs;
			this.measuredTime = timedweatherData.getMeasuredTime();
			this.temperature = timedweatherData.getTemperature();
			this.humidity = timedweatherData.getHumidity();
			display();
		}
	}

	@Override
	public void update(WeatherData weatherData, Object arg) {

	}

	public void update(float temperature, float humidity, float pressure) {
		this.measuredTime = measuredTime;
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}


	public void display() {
		System.out.println("[Time: " +  measuredTime  +" ] Current conditions: " + temperature
			+ "F degrees and " + humidity + "% humidity");
	}
}
