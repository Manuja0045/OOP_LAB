package JavaDoc;

// File: Member.java

/**
 * The Member class represents a Member of the Legislative Assembly (MLA) in Goa.
 */
class Member {
    protected String name;
    protected String constituency;
    protected int age;
    protected String party;
    protected String contactInfo;

    /**
     * Constructor for Member class.
     *
     * @param name         the name of the MLA
     * @param constituency the constituency represented by the MLA
     * @param age          the age of the MLA
     * @param party        the political party of the MLA
     * @param contactInfo  the contact information of the MLA
     */
    public Member(String name, String constituency, int age, String party, String contactInfo) {
        this.name = name;
        this.constituency = constituency;
        this.age = age;
        this.party = party;
        this.contactInfo = contactInfo;
    }

    /**
     * Displays the MLA's details including name, constituency, age, party, and contact information.
     */
    public void displayInfo() {
        System.out.println("NAME: " + name);
        System.out.println("CONSTITUENCY: " + constituency);
        System.out.println("AGE: " + age);
        System.out.println("PARTY: " + party);
        System.out.println("CONTACT INFO: " + contactInfo);
    }
}
