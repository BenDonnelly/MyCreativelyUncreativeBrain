package mcub.helpers;

import javax.swing.Timer;

public class TemperatureHandler
{

	private Timer timer;
	public static int currentTemp = 0;
	public static int maxTemp = 100;
	public static int secondsElapsed = 0;

	public TemperatureHandler()
	{
	}

	public static int getTemp()
	{
		return currentTemp;
	}

	public static void alterTemperature(int tempN)
	{
		if(currentTemp > maxTemp ) currentTemp = tempN;
	}

	public static void resetTempOnDeath()
	{
		currentTemp = 50;
	}

	public static void tempTimer(int startTime, int maxTime, int tempN)
	{
		if(secondsElapsed == 1)
		{
			startTime++;
		}
		System.out.println("Tick Counter: " + startTime);
		if(startTime == maxTime)
		{
			currentTemp = tempN;
			startTime = 0;
		}
	}
}
