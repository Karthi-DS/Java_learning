package lab_exs_and_HW.worksheet_4;

import java.util.Arrays;

public class TravelPlanner {

    private String travelerName;
    private String tripName;
    private String[] destinations;
    private double[] expenses;
    private StringBuilder tripNotes;

    private static int totalTrips = 0;
    private static double totalRevenue = 0;
    private static String agencyName = "GlobeTrek Travel Agency";

    public TravelPlanner() {
        this.travelerName = "Unknown";
        this.tripName = "General Trip";
        this.destinations = new String[5];
        this.expenses = new double[5];
        this.tripNotes = new StringBuilder();
        totalTrips++;
    }

    public TravelPlanner(String travelerName, String tripName, int capacity) {
        this.travelerName = travelerName;
        this.tripName = tripName;
        this.destinations = new String[capacity];
        this.expenses = new double[capacity];
        this.tripNotes = new StringBuilder();
        totalTrips++;
    }

    public TravelPlanner(TravelPlanner t) {
        this.travelerName = t.travelerName;
        this.tripName = t.tripName;
        this.destinations = Arrays.copyOf(t.destinations, t.destinations.length);
        this.expenses = Arrays.copyOf(t.expenses, t.expenses.length);
        this.tripNotes = new StringBuilder(t.tripNotes.toString());
        totalTrips++;
    }

    public void addDestination(int index, String place, double expense) {
        if (index >= 0 && index < destinations.length) {
            destinations[index] = place.trim();
            expenses[index] = expense;
            totalRevenue += expense;
        }
    }

    public void updateTravelerName(String newName) {
        this.travelerName = newName.trim().toUpperCase();
    }

    public void appendTripNote(String note) {
        tripNotes.append(note).append(" ");
    }

    public double calculateTotalExpense() {
        double sum = 0;
        for (double e : expenses) {
            sum += e;
        }
        return sum;
    }

    public void displayTripDetails() {
        System.out.println("Agency: " + agencyName);
        System.out.println("Traveler: " + travelerName);
        System.out.println("Trip: " + tripName);
        System.out.println("Destinations: " + Arrays.toString(destinations));
        System.out.println("Total Expense: ₹" + calculateTotalExpense());
        System.out.println("Trip Notes: " + tripNotes.toString());
        System.out.println("--------------------------------------");
    }

    public static void displayAgencyStatistics() {
        System.out.println("Agency Name: " + agencyName);
        System.out.println("Total Trips Planned: " + totalTrips);
        System.out.println("Overall Revenue: ₹" + totalRevenue);
        System.out.println("======================================");
    }

    public static void main(String[] args) {

        TravelPlanner trip1 = new TravelPlanner("Karthi", "Goa Vacation", 3);
        trip1.addDestination(0, "Baga Beach", 5000);
        trip1.addDestination(1, "Fort Aguada", 2000);
        trip1.appendTripNote("Carry sunscreen.");
        trip1.displayTripDetails();

        TravelPlanner trip2 = new TravelPlanner("Meena", "Kerala Tour", 4);
        trip2.addDestination(0, "Munnar", 7000);
        trip2.addDestination(1, "Alleppey", 6000);
        trip2.appendTripNote("Book houseboat in advance.");
        trip2.updateTravelerName("meena r");
        trip2.displayTripDetails();

        TravelPlanner trip3 = new TravelPlanner(trip2);
        trip3.updateTravelerName("Arun");
        trip3.appendTripNote("Add wildlife safari.");
        trip3.displayTripDetails();

        TravelPlanner.displayAgencyStatistics();
    }
}

