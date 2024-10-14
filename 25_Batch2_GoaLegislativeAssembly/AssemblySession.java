package JavaDoc;

// File: AssemblySession.java

import java.util.ArrayList;
import java.util.List;

/**
 * The AssemblySession class represents a legislative session in the Goa Legislative Assembly.
 * It stores the session name, date, and the list of bills discussed.
 */
class AssemblySession {
    private String name;
    private String date;
    private List<Bills> legislationsDiscussed;

    /**
     * Constructor for AssemblySession class.
     *
     * @param name  the name of the session
     * @param date  the date of the session
     */
    public AssemblySession(String name, String date) {
        this.name = name;
        this.date = date;
        this.legislationsDiscussed = new ArrayList<>();
    }

    /**
     * Adds a bill to the list of legislations discussed in the session.
     *
     * @param legislation the bill to be added
     */
    public void addLegislation(Bills legislation) {
        legislationsDiscussed.add(legislation);
    }

    /**
     * Displays the session details including the name, date, and the bills discussed.
     */
    public void displaySession() {
        System.out.println("SESSION NAME: " + name);
        System.out.println("DATE: " + date);
        System.out.println("LEGISLATIONS DISCUSSED:");
        for (Bills legislation : legislationsDiscussed) {
            legislation.displayDetails();
            System.out.println();
        }
    }
}
