package hansung.designpatterns.observer;

import java.util.Date;

/**
 * Created by TeasunKim on 2016-09-07.
 */
public class TimedWeatherData extends WeatherData {
    private String measuredTime;


    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.measuredTime = new Date().toString();
        super.setMeasurements(temperature, humidity, pressure);

    }
    /*public void notifyObservers(Object arg) {
        if (changed) {
            for (Observer observer : observers) {
                observer.update(this,arg);
            }
            changed = false;
        }
    }*/
    public String getMeasuredTime() { return measuredTime; }
}
