package hansung.designpatterns.observer;

import java.util.Timer;
import java.util.TimerTask;

public class WeatherStation {
	static WeatherData weatherData;
	static TimedWeatherData timedWeatherData;
	static float temperature=80.0f;
	static float lastTemperature=80.0f;
	static float humidity=65.0f;
	static float pressure=30.0f;


	public static void main(String[] args) {
		timedWeatherData = new TimedWeatherData();
		CurrentConditionsDisplay currentDisplay =
				new CurrentConditionsDisplay(timedWeatherData);
		StatisticsDisplay statisticsDisplay = new
				StatisticsDisplay(timedWeatherData);
		ForecastDisplay forecastDisplay = new
				ForecastDisplay(timedWeatherData);
		HeatIndexDisplay heatIndexDisplay = new
				HeatIndexDisplay(timedWeatherData);

		Timer jobScheduler = new Timer();
		TimerTask task = new TimerTask() {
			public void run() { //각 측정값은 0~0.1 만큼 증가
				temperature = (float)(temperature+ Math.random()*0.1);
				humidity = (float)(humidity+ Math.random()*0.1);
				pressure = (float)(pressure+ Math.random()*0.1);
				//weatherData.setMeasurements(temperature, humidity,pressure);
				timedWeatherData.setMeasurements(temperature, humidity,pressure);
			}
		};
		// 1초마다 온도,습도,압력 측정
		jobScheduler.schedule(task, 0, 1000);

		/*WeatherData weatherData = new WeatherData();
	
		CurrentConditionsDisplay currentDisplay = 
			new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);*/


	}
}
