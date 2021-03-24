//****************************************************************************************
//Author: Jacob Vaught       Modified: 11/03/20
//
//EGR-281  Project 10  			  Due: 11/04/20
//****************************************************************************************
package project10;

public class Temperature {
   private float temperature;
   Scale scale;
private static float ROUNDTOTENTH=10;
private static float FAHRENHEITFREEZE=32;
private static float CELSIUSFREEZE=0;
private static double C_TO_F_CONSTANT=1.8;
private static double KELVIN_CONSTANT=273.2;
//4 Constructors
   //stores temperature, sets Scale to default 'C'
   public Temperature(float temperature) {
      this.temperature = temperature;
      scale = Scale.C;
   }
   //sets temperature to default 'CELSIUSFREEZE', stores scale
   public Temperature(Scale scale) {
      this.scale = scale;
      temperature = CELSIUSFREEZE;
   }
   //stores Temperature & Scale
   public Temperature(float temperature, Scale scale) {
      this.temperature = temperature;
      this.scale = scale;
   }
   //sets temperature to default 'CELSIUSFREEZE', sets Scale to default 'C'
   public Temperature() {
      temperature = CELSIUSFREEZE;
      scale = Scale.C;
   }
  
   
//3 Booleans
//boolean to check if equal 
	public boolean areEqual(Object object)
	{
		if (object instanceof Temperature)
		{
			Temperature temp = (Temperature) object;
			return getKelvin() == temp.getKelvin();
		}
		return false;
	}
	
	// Create a boolean to test whether one temperature is greater than another.
	public boolean isSmaller(Object object)
	{
		if (object instanceof Temperature)
		{
			Temperature temp = (Temperature) object;
			return getKelvin() > temp.getKelvin();
		}
		return false;
	}
	
	// Create a boolean to test whether one temperature is less than another.
	public boolean isLarger(Object object)
	{
		if (object instanceof Temperature)
		{
			Temperature temp = (Temperature) object;
			return getKelvin() < temp.getKelvin();
		}
		return false;
	}

	
//An accessor to return the degrees Celsius
public float getCelsius() {
	switch (scale) {
	case F: 
		temperature = ((float) (Math.round(((temperature-FAHRENHEITFREEZE)/C_TO_F_CONSTANT)*ROUNDTOTENTH))/ROUNDTOTENTH);
		break;
	case C: 
		break;
	case K: 
		temperature = ((float) (Math.round(((temperature-KELVIN_CONSTANT)*ROUNDTOTENTH)/ROUNDTOTENTH)));
		break;
	default:
		break;
	}
	scale = Scale.C;
	return temperature;
}

//An accessor to return the degrees Fahrenheit
public float getFahrenheit()
{
	switch (scale) {
	case F: 
		break;
	case C: 
		temperature = ((float) (Math.round(((C_TO_F_CONSTANT*temperature+FAHRENHEITFREEZE)*ROUNDTOTENTH)/ROUNDTOTENTH)));
		break;
	case K: 
		temperature = ((float) (Math.round(((C_TO_F_CONSTANT*(temperature-KELVIN_CONSTANT)+FAHRENHEITFREEZE)*ROUNDTOTENTH)/ROUNDTOTENTH)));
		break;
	default:
		break;
	}
	scale = Scale.F;
	return temperature;
	
}
public float getKelvin() {
	switch (scale) {
	case F: 
		temperature = ((float) (Math.round(((temperature-FAHRENHEITFREEZE)/C_TO_F_CONSTANT+KELVIN_CONSTANT)*ROUNDTOTENTH))/ROUNDTOTENTH);
		//the rounding is here^^ and ^^
	break;
	
	case C: 
		temperature = ((float) (Math.round((temperature+KELVIN_CONSTANT)*ROUNDTOTENTH))/ROUNDTOTENTH);
	case K: 
		return temperature;
	default:
		break;
	}
	scale = Scale.K;
	return temperature;
}


	//A mutator to set the temperature.
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
		
	//A mutator to set the scale
	public void setScale(Scale scale) {
		this.scale = scale;
	}
		
	//A mutator to set both
	public void setTemperature_And_Scale(float temperature, Scale scale) {
		this.temperature = temperature;
		this.scale = scale;
	}
	
	public String toString()
	{
		switch (scale) {
		case C:
			return String.format("%.1f degrees C = %.1f degrees F = %.1f degrees K ", temperature, getFahrenheit(), getKelvin());
		case F:
			return String.format("%.1f degrees F = %.1f degrees C = %.1f degrees K ", temperature, getCelsius(), getKelvin());
		case K:
			return String.format("%.1f degrees K = %.1f degrees F = %.1f degrees C ", temperature, getFahrenheit(), getCelsius());
		default:
			return ("ERROR");
		}//bracket for switch(scale)
		
	}//bracket for toString
	
}// bracket for Temperature


