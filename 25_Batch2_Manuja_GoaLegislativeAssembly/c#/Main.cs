//Author:Manuja Nagvekar
//Roll No:25
//Title:Goa Legislative Assembly
//Description:This program is used to create a database of Goa Legislative Assembly and to perform various operations


using System;
using System.Collections.Generic;

class Member
{
    protected string name;
    protected string constituency;
    protected int age;
    protected string party;
    protected string contactInfo;

    public Member(string name, string constituency, int age, string party, string contactInfo)
    {
        this.name = name;
        this.constituency = constituency;
        this.age = age;
        this.party = party;
        this.contactInfo = contactInfo;
    }

    public virtual void DisplayInfo()
    {
        Console.WriteLine($"NAME: {name}");
        Console.WriteLine($"CONSTITUENCY: {constituency}");
        Console.WriteLine($"AGE: {age}");
        Console.WriteLine($"PARTY: {party}");
        Console.WriteLine($"CONTACT INFO: {contactInfo}");
    }
}

class Minister : Member
{
    private string portfolio;

    public Minister(string name, string constituency, int age, string party, string contactInfo, string portfolio)
        : base(name, constituency, age, party, contactInfo)
    {
        this.portfolio = portfolio;
    }

    public override void DisplayInfo()
    {
        base.DisplayInfo();
        Console.WriteLine($"PORTFOLIO: {portfolio}");
    }
}

class Committee
{
    private string name;
    private List<Member> members;

    public Committee(string name)
    {
        this.name = name;
        this.members = new List<Member>();
    }

    public void AddMember(Member member)
    {
        members.Add(member);
    }

    public void DisplayCommittee()
    {
        Console.WriteLine($"COMMITTEE NAME: {name}");
        Console.WriteLine("Members:");
        foreach (var member in members)
        {
            member.DisplayInfo();
            Console.WriteLine();
        }
    }
}

class Bills
{
    private string title;
    private string description;
    private string proposer;
    private string dateIntroduced;

    public Bills(string title, string description, string proposer, string dateIntroduced)
    {
        this.title = title;
        this.description = description;
        this.proposer = proposer;
        this.dateIntroduced = dateIntroduced;
    }

    public void DisplayDetails()
    {
        Console.WriteLine($"BILL TITLE: {title}");
        Console.WriteLine($"DESCRIPTION: {description}");
        Console.WriteLine($"INTRODUCED BY: {proposer}");
        Console.WriteLine($"DATE INTRODUCED: {dateIntroduced}");
    }
}

class AssemblySession
{
    private string name;
    private string date;
    private List<Bills> legislationsDiscussed;

    public AssemblySession(string name, string date)
    {
        this.name = name;
        this.date = date;
        this.legislationsDiscussed = new List<Bills>();
    }

    public void AddLegislation(Bills legislation)
    {
        legislationsDiscussed.Add(legislation);
    }

    public void DisplaySession()
    {
        Console.WriteLine($"SESSION NAME: {name}");
        Console.WriteLine($"DATE: {date}");
        Console.WriteLine("LEGISLATIONS DISCUSSED:");
        foreach (var legislation in legislationsDiscussed)
        {
            legislation.DisplayDetails();
            Console.WriteLine();
        }
    }
}

class Class1
{
    private static List<Committee> committees = new List<Committee>();
    private static List<Bills> bills = new List<Bills>();
    private static List<AssemblySession> sessions = new List<AssemblySession>();
    private static List<Minister> ministers = new List<Minister>();
    private static List<Member> members = new List<Member>();

    private static void InitializeMembersAndLegislations()
    {
        members.Add(new Member("Shri. Vijai Sardesai", "Fatorda", 45, "Goa Forward Party", "9773837210"));
        members.Add(new Member("Shri. Pramod Sawant", "Sanquelim", 40, "Bharatiya Janata Party", "7564543211"));

        ministers.Add(new Minister("Shri. Nilkanth Halarnkar", "Tivim", 86, "Bharatiya Janata Party", "9876543214", "Fisheries"));
        ministers.Add(new Minister("Shri. Govind Gaude", "Priol", 86, "Bharatiya Janata Party", "8845543215", "Art & Culture"));

        bills.Add(new Bills("Agriculture", "The Goa Fruit and Ornamental Plant Nurseries (Regulation)(Amendment) Bill 2022", "Shri. Ravi Naik", "21 Jul 2022"));
        bills.Add(new Bills("Town & Country Planning", "The Goa Electricity Duty (Amendment) Bill, 2008", "Shri. Aleixo Sequeira", "24 Mar 2008"));
        bills.Add(new Bills("Health", "The Goa Public Health (Amendment) Bill, 2021", "Shri. Vishwajit Rane", "15 Aug 2021"));
        bills.Add(new Bills("Education", "The Goa University (Amendment) Bill, 2020", "Shri. Rohan Khaunte", "12 Dec 2020"));

        var financeCommittee = new Committee("Business Advisory Committee");
        financeCommittee.AddMember(members[0]);
        financeCommittee.AddMember(members[1]);

        var healthCommittee = new Committee("Public Accounts Committee");
        healthCommittee.AddMember(ministers[0]);
        healthCommittee.AddMember(members[1]);

        committees.Add(financeCommittee);
        committees.Add(healthCommittee);

        var budgetSession = new AssemblySession("Budget Session", "2022-02-15");
        budgetSession.AddLegislation(bills[0]);
        budgetSession.AddLegislation(bills[2]);

        var monsoonSession = new AssemblySession("Monsoon Session", "2022-07-10");
        monsoonSession.AddLegislation(bills[1]);
        monsoonSession.AddLegislation(bills[3]);

        sessions.Add(budgetSession);
        sessions.Add(monsoonSession);
    }

    private static void DisplayMembers()
    {
        Console.WriteLine("\n-----List of MLA's:-----");
        foreach (var member in members)
        {
            member.DisplayInfo();
            Console.WriteLine();
        }
    }

    private static void DisplayMinisters()
    {
        Console.WriteLine("\n-----List of Council of Ministers:-----");
        foreach (var minister in ministers)
        {
            minister.DisplayInfo();
            Console.WriteLine();
        }
    }

    private static void DisplayBills()
    {
        Console.WriteLine("\n-----List of Bills and their proposers:-----");
        foreach (var legislation in bills)
        {

            legislation.DisplayDetails();
            Console.WriteLine();
        }
    }

    private static void DisplayCommittees()
    {
        Console.WriteLine("\n-----List of Committees and their members:-----");
        foreach (var committee in committees)
        {
            committee.DisplayCommittee();
            Console.WriteLine();
        }
    }

    private static void DisplaySessions()
    {
        Console.WriteLine("\n-----List of Sessions and legislations discussed:-----");
        foreach (var session in sessions)
        {
            session.DisplaySession();
            Console.WriteLine();
        }
    }

    static void Main()
    {
        InitializeMembersAndLegislations();

        int choice;
        do
        {
            Console.WriteLine("\nGoa Legislative Assembly Menu:");
            Console.WriteLine("1. List of Committees and their members");
            Console.WriteLine("2. List of Bills and their proposers");
            Console.WriteLine("3. List of Sessions and legislations discussed");
            Console.WriteLine("4. List of Council of Ministers in Goa");
            Console.WriteLine("5. List of MLA's of Goa");
            Console.WriteLine("6. Exit");
            Console.Write("\nTo get the details of Goa Legislative Assembly select the option from Top List (1-6): ");
            choice = int.Parse(Console.ReadLine());

            switch (choice)
            {
                case 1:
                    DisplayCommittees();
                    break;
                case 2:
                    DisplayBills();
                    break;
                case 3:
                    DisplaySessions();
                    break;
                case 4:
                    DisplayMinisters();
                    break;
                case 5:
                    DisplayMembers();
                    break;
                case 6:
                    Console.WriteLine("\nExiting...");
                    break;
                default:
                    Console.WriteLine("\nInvalid choice! Please try again.");
                    break;
            }
        } while (choice != 6);
    }
}


