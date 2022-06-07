import java.util.Scanner;
import java.lang.Math;

public class life {

	//Verify if the user entered a valid number
	public static double isNumber(String userInput) {
		double number;
		
		try {
			number = Double.parseDouble(userInput);
		} catch (Exception e) {
			number = -1;
		}
		return number;
	}
	
	public static void solve() {
		Scanner data = new Scanner(System.in);
		int day_hours = 24, year_days = 365;
		double data_return = 0;
		
		String[] input_data = new String[6];
		double[] verified_data = new double[6];
		
		do {
			System.out.print("1 - Enter your age: ");
			input_data[0] = data.nextLine();
			
			System.out.print("2 - How many years do you want to live: ");
			input_data[1] = data.nextLine();
			
			System.out.print("3 - How many years have you been working: ");
			input_data[2] = data.nextLine();
			
			System.out.print("4 - Daily hours worked: ");
			input_data[3] = data.nextLine();
			
			System.out.print("5 - Daily hours sleeping: ");
			input_data[4] = data.nextLine();
			
			System.out.print("6 - What age do you want to retire: ");
			input_data[5] = data.nextLine();
			
			System.out.println();
			
			//Loop to verify if the user entered valid number
			for (int i = 0; i < input_data.length; i++) {
				verified_data[i] = isNumber(input_data[i]);
				if (verified_data[i] < 0) {
					String message = String.format("Item %s is not a valid number!", i);
					System.out.println(message);
					data_return = verified_data[i];
				}
			}
			
			//Restart or Exit if the user enter a invalid number
			if (data_return < 0) {
				System.exit(0);
			}
			
		} while (data_return < 0);
		
		//Variables to do all calculations
		double years_remaining; //How many years of life are left

		//Life in hours
		double lived_until_now; //How many hours have you lived since birth
		double enjoyed_until_now; //How many hours have you liked so far
		double hours_still_have; //How many hours of lives are left

		//Sum
		double sleeped_until_now; //Sum of hours slept so far
		double worked_until_now; //Sum of hours worked so far

		//Total hours spent during life
		double life_hours_sleeped; //Hours of sleep during life
		double life_hours_enjoyed; //Hours of fun during life
		double life_hours_total; //All life in hours
		double life_hours_worked; //Hours worked during life
		
        //Do all calculations
        years_remaining = verified_data[1] - verified_data[0]; //How many years of life are left

        worked_until_now = (verified_data[3] * year_days) * verified_data[2]; //Sum of hours worked so far
        sleeped_until_now = (verified_data[4] * year_days) * verified_data[0]; //Sum of hours slept so far

        lived_until_now = (verified_data[0] * year_days) * day_hours; //How many hours have you lived since birth
        enjoyed_until_now = lived_until_now - (sleeped_until_now + worked_until_now);//How many hours have you liked so far
        hours_still_have = (years_remaining * year_days) * day_hours; //How many hours of lives are left

        life_hours_sleeped = (verified_data[4] * year_days) * verified_data[1];  //Hours of sleep during life
        life_hours_enjoyed = (((verified_data[1] - verified_data[5]) + (verified_data[0] - verified_data[2])) *
            year_days) * day_hours; //Hours of fun during life
        life_hours_total = (verified_data[1] * year_days) * day_hours; //All life in hours
        life_hours_worked = life_hours_total - (life_hours_enjoyed + life_hours_sleeped); //Hours worked during life
        
        System.out.println("LIFE IN HOURS/DAYS UNTIL NOW:\n");
        System.out.printf("Hours worked so far: %s hours, or " + String.format("%.02f", worked_until_now / day_hours) + " days.\n", worked_until_now);
        System.out.printf("Sleep hours so far: %s hours, or " + String.format("%.02f", sleeped_until_now / day_hours) + " days.\n", sleeped_until_now);
        System.out.printf("Hours lived so far: %s hours, or " + String.format("%.02f", lived_until_now / day_hours) + " days.\n", lived_until_now);
        System.out.printf("Enjoying hours so far: %s hours, or " + String.format("%.02f", enjoyed_until_now / day_hours) + " days.\n", enjoyed_until_now);
        System.out.println();

        System.out.printf("WILL LIVE IN HOURS/DAYS:\n\n");
        System.out.printf("Total hours you will live: %s hours, or " + String.format("%.02f", life_hours_total / day_hours) + " days.\n\n", life_hours_total);
        System.out.printf("Sleep during your lifetime: %s hours, or " + String.format("%.02f", life_hours_sleeped / day_hours) + " days.\n", life_hours_sleeped);
        System.out.printf("Enjoy during your lifetime: %s hours, or " + String.format("%.02f", life_hours_enjoyed / day_hours) + " days.\n", life_hours_enjoyed);
        System.out.printf("Work during your lifetime: %s hours, or " + String.format("%.02f", life_hours_worked / day_hours) + " days.\n\n", life_hours_worked);
        System.out.printf("Total hours remaining: %s hours, or " + String.format("%.02f", hours_still_have / day_hours) + " days.\n", hours_still_have);
        System.out.println();      
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve();
	}

}
