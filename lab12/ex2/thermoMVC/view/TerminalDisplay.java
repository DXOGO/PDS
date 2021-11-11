package lab12.ex2.thermoMVC.view;

import mvc.thermoMVC.model.Thermometer;
import mvc.thermoMVC.model.ThermometerListener;

/**
 * A thermometer that displays on the console.
 */
public class TerminalDisplay implements ThermometerListener {
	
	// The Unicode symbol for degrees
	private static final char DEGREE_SYMBOL = '\u00B0';
	
	/** The thermometer whose temperature is being displayed */
	protected Thermometer thermometer;
	
	/**
	 * Creates a digital thermometer
	 * @param t the thermometer whose temperature is displayed
	 */
	public DigitalDisplay(Thermometer t) {
		thermometer = t;
	}

	/**
	 * Create the string to display in the thermometer
	 * @return the string to display in the thermometer
	 */
	private String getDisplayString() {
		return "" + thermometer.getTemperature() + DEGREE_SYMBOL + "F";
	}
	
	/**
	 * Change the temperature displayed
	 */
	@Override
	public void temperatureChanged() {
		System.out.println(getDisplayString());
	}
}