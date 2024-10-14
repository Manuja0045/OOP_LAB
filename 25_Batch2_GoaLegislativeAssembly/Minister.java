package JavaDoc;

// File: Minister.java

/**
 * The Minister class represents a Minister in the Goa Legislative Assembly.
 * It extends the Member class by adding the portfolio information.
 */
class Minister extends Member {
    private String portfolio;

    /**
     * Constructor for Minister class.
     *
     * @param name         the name of the Minister
     * @param constituency the constituency represented by the Minister
     * @param age          the age of the Minister
     * @param party        the political party of the Minister
     * @param contactInfo  the contact information of the Minister
     * @param portfolio    the portfolio held by the Minister
     */
    public Minister(String name, String constituency, int age, String party, String contactInfo, String portfolio) {
        super(name, constituency, age, party, contactInfo);
        this.portfolio = portfolio;
    }

    /**
     * Displays the Minister's details, including portfolio information.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("PORTFOLIO: " + portfolio);
    }
}
