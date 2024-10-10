//Author:Manuja Nagvekar
//Roll No:25
//Title:Goa Legislative Assembly
//Description:This program is used to create a database of Goa Legislative Assembly and to perform various operations

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoaLegislativeAssembly {

    public static List<Committee> committees = new ArrayList<>();
    public static List<Bills> bills = new ArrayList<>();
    public static List<AssemblySession> assemblySessions = new ArrayList<>();
    public static List<Member> members = new ArrayList<>();
    public static List<Minister> ministers = new ArrayList<>();
    public static List<Secretary> secretaries = new ArrayList<>();

    private static void initializeMembersAndLegislations() {
        members.add(new Member("Shri. Vijai Sardesai", "Fatorda", 45, "Goa Forward Party", "9773837210"));
        members.add(new Member("Shri. Pramod Sawant", "Sanquelim", 40, "Bharatiya Janata Party", "7564543211"));

        ministers.add(new Minister("Shri. Nilkanth Halarnkar", "Tivim", 54, "Bharatiya Janata Party", "9876543214", "Fisheries"));
        ministers.add(new Minister("Shri. Govind Gaude", "Priol", 50, "Bharatiya Janata Party", "8845543215", "Art & Culture"));

        ChiefMinister cm = new ChiefMinister("Shri. Pramod Sawant", "Sanquelim", 48, "Bharatiya Janata Party", "7465453211", "Chief Minister", "Goa");
        members.add(cm);  // Add Chief Minister to members list

        Speaker speaker = new Speaker("Shri. Rajesh Patnekar", "Bicholim", 60, "Bharatiya Janata Party", "8876554321");
        members.add(speaker);  // Add Speaker to members list

        Secretary sec = new Secretary("Shri. Ramesh Sharma", "9876543210", "Administrative Department");
        secretaries.add(sec);  // Add Secretary to secretaries list

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

        assemblySessions.add(budgetSession);
        assemblySessions.add(monsoonSession);
    }

    private static void displayMembers() {
        System.out.println("\n***List of MLA's:***");
        for (Member member : members) {
            member.displayInfo();
            System.out.println();
        }
    }

    private static void displayMinisters() {
        System.out.println("\n***List of Ministers:***");
        for (Minister minister : ministers) {
            // ... (previous code)

            minister.displayInfo();
            System.out.println();
        }
    }

    private static void displayBills() {
        System.out.println("\n***List of Bills Passed:***");
        for (Bills bill : bills) {
            bill.displayDetails();
            System.out.println();
        }
    }

    private static void displayCommittees() {
        System.out.println("\n***Committees:***");
        for (Committee committee : committees) {
            committee.displayCommittee();
            System.out.println();
        }
    }

    private static void displaySessions() {
        System.out.println("\n***Assembly Sessions:***");
        for (AssemblySession session : assemblySessions) {
            session.displaySession();
            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("\n---Menu---");
        System.out.println("1. Display Members");
        System.out.println("2. Display Ministers");
        System.out.println("3. Display Bills");
        System.out.println("4. Display Committees");
        System.out.println("5. Display Sessions");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeMembersAndLegislations();

        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayMembers();
                    break;
                case 2:
                    displayMinisters();
                    break;
                case 3:
                    displayBills();
                    break;
                case 4:
                    displayCommittees();
                    break;
                case 5:
                    displaySessions();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }

        scanner.close();
    }
}

class Committee {
    private String name;
    private List<LegislativeMember> members;

    public Committee(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(LegislativeMember member) {
        members.add(member);
    }

    public void displayCommittee() {
        System.out.println("Committee Name: " + name);
        System.out.println("Members:");
        for (LegislativeMember member : members) {
            member.displayInfo();
            System.out.println();
        }
    }
}

class Bills {
    private String title;
    private String description;
    private String proposer;
    private String dateIntroduced;

    public Bills(String title, String description, String proper, String dateIntroduced) {
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

class AssemblySession {
    private String name;
    private String date;
    private List<Bills> legislationDiscussed;

    public AssemblySession(String name, String date) {
        this.name = name;
        this.date = date;
        this.legislationDiscussed = new ArrayList<>();
    }

    public void addLegislation(Bills legislation) {
        legislationDiscussed.add(legislation);
    }

    public void displaySession() {
        System.out.println("SESSION NAME: " + name);
        System.out.println("DATE: " + date);
        System.out.println("LEGISLATIONS DISCUSSED:");
        for (Bills legislation : legislationDiscussed) {
            legislation.displayDetails();
            System.out.println();
        }
    }
}

abstract class Person {
    protected String name;
    protected String contactInfo;

    public Person(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public abstract void displayInfo();
}

interface LegislativeMember {
    void displayInfo();
}

class Member extends Person implements LegislativeMember {
    protected String constituency;
    protected int age;
    protected String party;

    public Member(String name, String constituency, int age, String party, String contactInfo) {
        super(name, contactInfo);
        this.constituency = constituency;
        this.age = age;
        this.party = party;
    }

    @Override
    public void displayInfo() {
        System.out.println("NAME: " + name);
        System.out.println("CONSTITUENCY: " + constituency);
        System.out.println("AGE: " + age);
        System.out.println("PARTY: " + party);
        System.out.println("CONTACT INFO: " + contactInfo);
    }
}

class Minister extends Member {
    protected String portfolio;

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

class ChiefMinister extends Minister {
    private String state;

    public ChiefMinister(String name, String constituency, int age, String party, String contactInfo, String portfolio, String state) {
        super(name, constituency, age, party, contactInfo, portfolio);
        this.state = state;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("STATE: " + state);
    }
}

class Speaker extends Member {
    public Speaker(String name, String constituency, int age, String party, String contactInfo) {
        super(name, constituency, age, party, contactInfo);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("ROLE: Speaker of the House");
    }
}

interface Administrative {
    void manageAssembly();
}

class Secretary extends Person implements Administrative, LegislativeMember {
    private String department;

    public Secretary(String name, String contactInfo, String department) {
        super(name, contactInfo);
        this.department = department;
    }

    @Override
    public void displayInfo() {
        System.out.println("NAME: " + name);
        System.out.println("DEPARTMENT: " + department);
        System.out.println("CONTACT INFO: " + contactInfo);
    }

    @Override
    public void manageAssembly() {
        System.out.println(name + " is managing the Assembly affairs.");
    }
}

