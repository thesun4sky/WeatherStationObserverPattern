package hansung.designpatterns.observer;

import java.util.*;

public class WeatherData implements Subject {
	protected ArrayList<Observer> observers;
	protected float temperature;
    protected float humidity;
    protected float pressure;
    protected boolean changed;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}

	public void notifyObservers(Object arg) {
		if (changed) {
			for (Observer observer : observers) {
				observer.update(this,arg);
			}
			changed = false;
		}
	}

    public void setChanged() {
        changed = true;
    }

	public void measurementsChanged() {
		setChanged();
        notifyObservers(this);
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}

}
