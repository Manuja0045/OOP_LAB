package JavaDoc;

// File: Committee.java

import java.util.ArrayList;
import java.util.List;

/**
 * The Committee class represents a committee in the Goa Legislative Assembly.
 * It stores the committee name and its members.
 */
class Committee {
    private String name;
    private List<Member> members;

    /**
     * Constructor for Committee class.
     *
     * @param name the name of the committee
     */
    public Committee(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    /**
     * Adds a member to the committee.
     *
     * @param member the member to be added
     */
    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * Displays the committee details including its name and the list of members.
     */
    public void displayCommittee() {
        System.out.println("COMMITTEE NAME: " + name);
        System.out.println("MEMBERS:");
        for (Member member : members) {
            member.displayInfo();
            System.out.println();
        }
    }
}
