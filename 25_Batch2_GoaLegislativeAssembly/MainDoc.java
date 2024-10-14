package JavaDoc;

// File: MainDoc.java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The MainDoc class is the entry point of the Goa Legislative Assembly database program.
 * It provides options to display information about committees, bills, sessions, ministers, and members.
 */
public class MainDoc {

    private static List<Committee> committees = new ArrayList<>();
    private static List<Bills> bills = new ArrayList<>();
    private static List<AssemblySession> sessions = new ArrayList<>();
    private static List<Minister> ministers = new ArrayList<>();
    private static List<Member> members = new ArrayList<>();

    /**
     * Initializes the members, ministers, committees, sessions, and bills.
     */
    private static void initializeMembersAndLegislations() {
        members.add(new Member("Shri. Vijai Sardesai", "Fatorda", 45, "Goa Forward Party", "9773837210"));
        members.add(new Member("Shri. Pramod Sawant", "Sanquelim", 40, "Bharatiya Janata Party", "7564543211"));

        ministers.add(new Minister("Shri. Nilkanth Halarnkar", "Tivim", 54, "Bharatiya Janata Party", "9876543214", "Fisheries"));
        ministers.add(new Minister("Shri. Govind Gaude", "Priol", 50, "Bharatiya Janata Party", "8845543215", "Art & Culture"));

        bills.add(new Bills("Agriculture", "The Goa Fruit and Ornamental Plant Nurseries (Regulation)(Amendment) Bill 2022.", "Shri. Ravi Naik", "21 Jul 2022"));
        bills.add(new Bills("Town & Country Planning", "The Goa Electricity Duty (Amendment) Bill, 2008.", "Shri. Aleixo Sequeira", "24 Mar 2008"));
        bills.add(new Bills("Health", "The Goa Public Health (Amendment) Bill, 2021.", "Shri. Vishwajit Rane", "15 Aug 2021"));
        bills.add(new Bills("Education", "The Goa University (Amendment) Bill, 2020.", "Shri. Rohan Khaunte", "12 Dec 2020"));

        Committee financeCommittee = new Committee("Business Advisory Committee");
        financeCommittee.addMember(members.get(0));
        financeCommittee.addMember(members.get(1));

        Committee healthCommittee = new Committee("Public Accounts Committee");
        healthCommittee.addMember(ministers.get(0));
        healthCommittee.addMember(members.get(1));

        committees.add(financeCommittee);
        committees.add(healthCommittee);

        AssemblySession budgetSession = new AssemblySession("Budget Session", "2022-02-15");
        budgetSession.addLegislation(bills.get(0));
        budgetSession.addLegislation(bills.get(2));

        AssemblySession monsoonSession = new AssemblySession("Monsoon Session", "2022-07-10");
        monsoonSession.addLegislation(bills.get(1));
        monsoonSession.addLegislation(bills.get(3));

        sessions.add(budgetSession);
        sessions.add(monsoonSession);
    }

    /**
     * Displays the list of members in the Goa Legislative Assembly.
     */
    private static void displayMembers() {
        System.out.println("\n***List of MLA's:***");
        for (Member member : members) {
            member.displayInfo();
            System.out.println();
        }
    }

    /**
     * Displays the list of ministers in the Goa Legislative Assembly.
     */
    private static void displayMinisters() {
        System.out.println("\n***List of Ministers:***");
        for (Minister minister : ministers) {
            minister.displayInfo();
            System.out.println();
        }
    }

    /**
     * Displays the list of committees in the Goa Legislative Assembly.
     */
    private static void displayCommittees() {
        System.out.println("\n***List of Committees:***");
        for (Committee committee : committees) {
            committee.displayCommittee();
            System.out.println();
        }
    }

    /**
     * Displays the list of bills discussed or passed in the Goa Legislative Assembly.
     */
    private static void displayBills() {
        System.out.println("\n***List of Bills:***");
        for (Bills bill : bills) {
            bill.displayDetails();
            System.out.println();
        }
    }

    /**
     * Displays the list of legislative sessions in the Goa Legislative Assembly.
     */
    private static void displaySessions() {
        System.out.println("\n***List of Sessions:***");
        for (AssemblySession session : sessions) {
            session.displaySession();
            System.out.println();
        }
    }

    /**
     * The main method is the entry point for the program.
     * It initializes the members and legislative data, and provides options for the user to display the data.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        initializeMembersAndLegislations();

        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input

        System.out.println("\nChoose an option:");
        System.out.println("1. Display Members");
        System.out.println("2. Display Ministers");
        System.out.println("3. Display Committees");
        System.out.println("4. Display Bills");
        System.out.println("5. Display Sessions");

        System.out.print("Enter your choice: ");
        int option = scanner.nextInt(); // Take user input

        switch (option) {
            case 1:
                displayMembers();
                break;
            case 2:
                displayMinisters();
                break;
            case 3:
                displayCommittees();
                break;
            case 4:
                displayBills();
                break;
            case 5:
                displaySessions();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }

        scanner.close(); // Close the scanner to avoid resource leakage
    }
}
