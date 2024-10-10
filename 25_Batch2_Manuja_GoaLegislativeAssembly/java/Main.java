//Author:Manuja Nagvekar
//Roll No:25
//Title:Goa Legislative Assembly
//Description:This program is used to create a database of Goa Legislative Assembly and to perform various operations

import java.util.ArrayList;
import java.util.List;



//Displays the Session type and what bills were passed during that session
class AssemblySession {
    private String name;
    private String date;
    private List<Bills> legislationsDiscussed;

    public AssemblySession(String name, String date) {
        this.name = name;
        this.date = date;
        this.legislationsDiscussed = new ArrayList<>();
    }

    public void addLegislation(Bills legislation) {
        legislationsDiscussed.add(legislation);
    }

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


//Displays the list of MLA's in Goa Legislative Assembly
class Member {
    protected String name;
    protected String constituency;
    protected int age;
    protected String party;
    protected String contactInfo;

    public Member(String name, String constituency, int age, String party, String contactInfo) {
        this.name = name;
        this.constituency = constituency;
        this.age = age;
        this.party = party;
        this.contactInfo = contactInfo;
    }

    public void displayInfo() {
        System.out.println("NAME: " + name);
        System.out.println("CONSTITUENCY: " + constituency);
        System.out.println("AGE: " + age);
        System.out.println("PARTY: " + party);
        System.out.println("CONTACT INFO: " + contactInfo);
    }
}





//This class extracts the data of members from the member class by extending the class
class Minister extends Member {
    private String portfolio;

    public Minister(String name, String constituency, int age, String party, String contactInfo, String portfolio) {
        super(name, constituency, age, party, contactInfo);
        this.portfolio = portfolio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("PORTFOLIO: " + portfolio);
    }
}





//It displays the name of the committee and which members are there in it
class Committee {
    private String name;
    private List<Member> members;

    public Committee(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void displayCommittee() {
        System.out.println("COMMITTEE NAME: " + name);
        System.out.println("Members:");
        for (Member member : members) {
            member.displayInfo();
            System.out.println();
        }
    }
}





//Displays the list of bills passed 
class Bills {
    private String title;
    private String description;
    private String proposer;
    private String dateIntroduced;

    public Bills(String title, String description, String proposer, String dateIntroduced) {
        this.title = title;
        this.description = description;
        this.proposer = proposer;
        this.dateIntroduced = dateIntroduced;
    }

    public void displayDetails() {
        System.out.println("BILL TITLE: " + title);
        System.out.println("DESCRIPTION: " + description);
        System.out.println("INTRODUCED BY: " + proposer);
        System.out.println("DATE INTRODUCED: " + dateIntroduced);
    }
}



public class Main { 
    private static List<Committee> committees = new ArrayList<>();
    private static List<Bills> bills = new ArrayList<>();
    private static List<AssemblySession> sessions = new ArrayList<>();
    private static List<Minister> ministers = new ArrayList<>();
    private static List<Member> members = new ArrayList<>();

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

    private static void displayMembers() {
        System.out.println("\n***List of MLA's:***");
    
        for (Member member : members) {
            member.displayInfo();
            System.out.println();
        }
    }

    private static void displayMinisters() {
        System.out.println("\n***List of Council of Ministers:***");
        System.out.println("Select the Minister:\n1.Shri. Nilkanth Halarnkar\n2.Shri. Govind Gaude");
        for (Minister minister : ministers) {
            minister.displayInfo();
            System.out.println();
        }
    }

    private static void displayBills() {
        System.out.println("\n***List of Bills and their proposers:***");
        for (Bills legislation : bills) {
            legislation.displayDetails();
            System.out.println();
        }
    }

    private static void displayCommittees() {
        System.out.println("\n***List of Committees and their members:***");
        for (Committee committee : committees) {
            committee.displayCommittee();
            System.out.println();
        }
    }

    private static void displaySessions() {
        System.out.println("\n***List of Sessions and legislations discussed:***");
        for (AssemblySession session : sessions) {
            session.displaySession();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        initializeMembersAndLegislations();

        int choice;
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        do {
            System.out.println("\nGoa Legislative Assembly Menu:");
            System.out.println("1. List of Committees and their members");
            System.out.println("2. List of Bills and their proposers");
            System.out.println("3. List of Sessions and legislations discussed");
            System.out.println("4. List of Council of Ministers in Goa");
            System.out.println("5. List of MLA's of Goa");
            System.out.println("6. Exit");
            System.out.print("\nTo get the details of Goa Legislative Assembly select the option from Top List (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                displayCommittees();      
                    break;
                case 2:
                displayBills();
                    break;
                case 3:
                displaySessions();
                    break;
                case 4:
                displayMinisters();
                    break;
                case 5:
                displayMembers();  
                    break;
                case 6:
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

