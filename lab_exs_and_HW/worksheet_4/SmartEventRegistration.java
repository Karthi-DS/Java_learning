package lab_exs_and_HW.worksheet_4;

import java.util.Arrays;

public class SmartEventRegistration {

    private String participantName;
    private String collegeName;
    private String[] eventPreferences;
    private String[] selectedSessions;
    private int[] feedbackRatings;

    private static int totalParticipants = 0;
    private static String festName = "TechNova 2026";

    public SmartEventRegistration() {
        this.participantName = "Unknown";
        this.collegeName = "Not Provided";
        this.eventPreferences = new String[3];
        this.selectedSessions = new String[3];
        this.feedbackRatings = new int[3];
        totalParticipants++;
    }

    public SmartEventRegistration(String name, String college, String[] preferences) {
        this.participantName = name;
        this.collegeName = college;
        this.eventPreferences = preferences;
        this.selectedSessions = new String[3];
        this.feedbackRatings = new int[3];
        totalParticipants++;
    }

    public SmartEventRegistration(SmartEventRegistration p) {
        this.participantName = p.participantName;
        this.collegeName = p.collegeName;
        this.eventPreferences = Arrays.copyOf(p.eventPreferences, p.eventPreferences.length);
        this.selectedSessions = Arrays.copyOf(p.selectedSessions, p.selectedSessions.length);
        this.feedbackRatings = Arrays.copyOf(p.feedbackRatings, p.feedbackRatings.length);
        totalParticipants++;
    }

    public void selectSession(int index, String sessionName) {
        if (index >= 0 && index < selectedSessions.length) {
            selectedSessions[index] = sessionName;
        }
    }

    public void giveFeedback(int index, int rating) {
        if (index >= 0 && index < feedbackRatings.length) {
            feedbackRatings[index] = rating;
        }
    }

    public void updateParticipantName(String newName) {
        this.participantName = newName.trim().toUpperCase();
    }

    public void updateCollegeName(String newCollege) {
        this.collegeName = newCollege.trim();
    }

    public double calculateAverageRating() {
        int sum = 0;
        int count = 0;
        for (int rating : feedbackRatings) {
            if (rating > 0) {
                sum += rating;
                count++;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }

    public void displayParticipantDetails() {
        System.out.println("Fest Name: " + festName);
        System.out.println("Participant: " + participantName);
        System.out.println("College: " + collegeName);
        System.out.println("Event Preferences: " + Arrays.toString(eventPreferences));
        System.out.println("Selected Sessions: " + Arrays.toString(selectedSessions));
        System.out.println("Average Feedback Rating: " + calculateAverageRating());
        System.out.println("--------------------------------------");
    }

    public static void displayFestInfo() {
        System.out.println("Welcome to " + festName);
        System.out.println("Total Registrations So Far: " + totalParticipants);
        System.out.println("======================================");
    }

    public static void main(String[] args) {

        SmartEventRegistration p1 = new SmartEventRegistration();
        p1.updateParticipantName("karthi");
        p1.updateCollegeName("ABC Engineering College");
        p1.selectSession(0, "AI Workshop");
        p1.giveFeedback(0, 5);

        String[] prefs = {"Hackathon", "Robotics", "Cyber Security"};
        SmartEventRegistration p2 = new SmartEventRegistration("Meena", "XYZ Institute", prefs);
        p2.selectSession(1, "Robotics Challenge");
        p2.giveFeedback(1, 4);

        SmartEventRegistration p3 = new SmartEventRegistration(p2);
        p3.updateParticipantName("Arun");
        p3.selectSession(2, "Cyber Security Seminar");
        p3.giveFeedback(2, 5);

        p1.displayParticipantDetails();
        p2.displayParticipantDetails();
        p3.displayParticipantDetails();

        SmartEventRegistration.displayFestInfo();
    }
}

