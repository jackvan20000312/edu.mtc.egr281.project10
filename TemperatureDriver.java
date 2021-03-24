//****************************************************************************************
//Author: Jacob Vaught       Modified: 11/03/20
//
//EGR-281  Project 10  			  Due: 11/04/20
//****************************************************************************************
package project10;

public class TemperatureDriver {
	public static void main(String[] args) {

System.out.println("Celsius to Fahrenheit:");
		
		// Create an object named c2fObj1.
		Temperature celsiustofehrenheitObject1 = new Temperature();
		celsiustofehrenheitObject1.setTemperature(0);
		celsiustofehrenheitObject1.setScale(Scale.K);
		System.out.println(celsiustofehrenheitObject1.toString());
		System.out.println();

		// Create an object named c2fObj2.
		Temperature celsiustofahrenheitObject2 = new Temperature(Scale.C);
		celsiustofahrenheitObject2.setTemperature(-40);
		System.out.println(celsiustofahrenheitObject2.toString());
		System.out.println();
		
		// Create an object named c2fObj3.
		Temperature celsiustofahrenheitObject3 = new Temperature(100, Scale.C);
		System.out.println(celsiustofahrenheitObject3.toString());
		System.out.println();
		
		// Create an object named f2cObj1.
		System.out.println("\nFahrenheit to Celsius:");
		Temperature fahrenheittocelsiusObject4 = new Temperature(0);
		fahrenheittocelsiusObject4.setTemperature_And_Scale(56, Scale.K);
		System.out.println(fahrenheittocelsiusObject4.toString());
		System.out.println();
		
		// Display Comparision.
		System.out.println("\nComparision:");
		System.out.println("TEMP1 < TEMP2: " + celsiustofehrenheitObject1.isSmaller(celsiustofahrenheitObject2));
		System.out.println("TEMP2 = TEMP3: " + celsiustofehrenheitObject1.areEqual(celsiustofahrenheitObject3));
		System.out.println("TEMP3 > TEMP1: " + celsiustofahrenheitObject3.isLarger(fahrenheittocelsiusObject4));	
	}


	}

	
	
