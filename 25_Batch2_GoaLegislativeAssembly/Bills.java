package JavaDoc;

// File: Bills.java

/**
 * The Bills class represents a bill discussed or passed in the Goa Legislative Assembly.
 * It stores the title, description, proposer, and date of introduction of the bill.
 */
class Bills {
    private String title;
    private String description;
    private String proposer;
    private String dateIntroduced;

    /**
     * Constructor for Bills class.
     *
     * @param title           the title of the bill
     * @param description     the description of the bill
     * @param proposer        the proposer of the bill
     * @param dateIntroduced  the date the bill was introduced
     */
    public Bills(String title, String description, String proposer, String dateIntroduced) {
        this.title = title;
        this.description = description;
        this.proposer = proposer;
        this.dateIntroduced = dateIntroduced;
    }

    /**
     * Displays the bill's details including title, description, proposer, and introduction date.
     */
    public void displayDetails() {
        System.out.println("BILL TITLE: " + title);
        System.out.println("DESCRIPTION: " + description);
        System.out.println("INTRODUCED BY: " + proposer);
        System.out.println("DATE INTRODUCED: " + dateIntroduced);
    }
}
