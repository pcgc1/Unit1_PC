import java.util.Locale;
import java.util.Scanner;

public class As3_ParallelSort {

    public static Scanner input = new Scanner(System.in);

    //loading data arrays
    public static String[] allAirports = MyFiles.loadStringArr("IntelliJ_DataSet/BusiestAirports/Airport.txt");
    public static String[] allCountries = MyFiles.loadStringArr("IntelliJ_DataSet/BusiestAirports/Country.txt");
    public static int[] allPassengers = MyFiles.loadIntArr("IntelliJ_DataSet/BusiestAirports/Passengers.txt");
    public static int[] allYears = MyFiles.loadIntArr("IntelliJ_DataSet/BusiestAirports/Year.txt");

    public static void run(){

        while(true){

            System.out.println("Press 1 for sort by country\nPress 2 to for sort by year\nPress 3 for filter by airport\nPress 4 countif/sumif\nPress 5 to exit.");


            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                //sort by country
                sortByCountry();

                for (int i = 0; i < allCountries.length; i++) {
                    System.out.println("In " + allYears[i] + " " + allAirports[i] + " in " + allCountries[i] + " had " + allPassengers[i] + " passengers");
                }

            }
            if (choice == 2) {
                //sort by year
                sortByYear();

                for (int i = 0; i < allYears.length; i++) {
                    System.out.println("In " + allYears[i] + " " + allAirports[i] + " in " + allCountries[i] + " had " + allPassengers[i] + " passengers");
                }
            }
            if (choice == 3) {
                //filter by airport
                System.out.println("What airport do you want to filter by");

                String airport = input.nextLine();

                airportSearch(airport);
            }
            if (choice == 4){
                //sumif or countif
                System.out.println("Sum");
            }
            if (choice == 5) {
                break;
            }
            System.out.println();

        }//while loop

    }//run



    public static void sortByCountry(){
        for(int i=0; i<allCountries.length-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<allCountries.length; j++){
                if( allCountries[j].compareToIgnoreCase(allCountries[lowestIndex]) < 0 ){
                    lowestIndex = j;
                }
            }

            String temp = allCountries[i];
            allCountries[i] = allCountries[lowestIndex];
            allCountries[lowestIndex] = temp;

            String temp2 = allAirports[i];
            allAirports[i] = allAirports[lowestIndex];
            allAirports[lowestIndex] = temp2;

            int temp3 = allPassengers[i];
            allPassengers[i] = allPassengers[lowestIndex];
            allPassengers[lowestIndex] = temp3;

            int temp4 = allYears[i];
            allYears[i] = allYears[lowestIndex];
            allYears[lowestIndex] = temp4;

        }//for i

    }//sort by country



    public static void sortByYear(){
        for (int i = 0; i < allYears.length-1; i++) {
            int lowestIndex = i;
            for (int j = i+1; j < allYears.length; j++) {
                if(allYears[j] < allYears[lowestIndex]){
                    lowestIndex = j;
                }
            }

            String temp1 = allCountries[i];
            allCountries[i] = allCountries[lowestIndex];
            allCountries[lowestIndex] = temp1;

            String temp2 = allAirports[i];
            allAirports[i] = allAirports[lowestIndex];
            allAirports[lowestIndex] = temp2;

            int temp3 = allPassengers[i];
            allPassengers[i] = allPassengers[lowestIndex];
            allPassengers[lowestIndex] = temp3;

            int temp4 = allYears[i];
            allYears[i] = allYears[lowestIndex];
            allYears[lowestIndex] = temp4;

        }//for i


    }//sort by year



    public static void airportSearch( String query){
        for (int i = 0; i < allAirports.length; i++) {
            if(allAirports[i].toLowerCase().contains(query)){
                System.out.println("In " + allYears[i] + " " + allAirports[i] + " in " + allCountries[i] + " had " + allPassengers[i] + " passengers");
            }
        }//for i
    }//filter by airport

}//class