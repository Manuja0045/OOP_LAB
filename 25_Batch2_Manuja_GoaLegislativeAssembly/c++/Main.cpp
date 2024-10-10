//Author:Manuja Nagvekar
//Roll No:25
//Title:Goa Legislative Assembly
//Description:This program is used to create a database of Goa Legislative Assembly and to perform various operations

#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Member {
protected:
    string name;
    string constituency;
    int age;
    string party;
    string contactInfo;

public:
    Member(string name, string constituency, int age, string party, string contactInfo)
        : name(name), constituency(constituency), age(age), party(party), contactInfo(contactInfo) {}

    virtual void DisplayInfo() const {
        cout << "NAME: " << name << endl;
        cout << "CONSTITUENCY: " << constituency << endl;
        cout << "AGE: " << age << endl;
        cout << "PARTY: " << party << endl;
        cout << "CONTACT INFO: " << contactInfo << endl;
    }
};

class Minister : public Member {
private:
    string portfolio;

public:
    Minister(string name, string constituency, int age, string party, string contactInfo, string portfolio)
        : Member(name, constituency, age, party, contactInfo), portfolio(portfolio) {}

    void DisplayInfo() const override {
        Member::DisplayInfo();
        cout << "PORTFOLIO: " << portfolio << endl;
    }
};

class Committee {
private:
    string name;
    vector<Member*> members;

public:
    Committee(string name) : name(name) {}

    void AddMember(Member* member) {
        members.push_back(member);
    }

    void DisplayCommittee() const {
        cout << "COMMITTEE NAME: " << name << endl;
        cout << "Members:" << endl;
        for (const auto& member : members) {
            member->DisplayInfo();
            cout << endl;
        }
    }
};

class Bills {
private:
    string title;
    string description;
    string proposer;
    string dateIntroduced;

public:
    Bills(string title, string description, string proposer, string dateIntroduced)
        : title(title), description(description), proposer(proposer), dateIntroduced(dateIntroduced) {}

    void DisplayDetails() const {
        cout << "BILL TITLE: " << title << endl;
        cout << "DESCRIPTION: " << description << endl;
        cout << "INTRODUCED BY: " << proposer << endl;
        cout << "DATE INTRODUCED: " << dateIntroduced << endl;
    }
};

class AssemblySession {
private:
    string name;
    string date;
    vector<Bills> legislationsDiscussed;

public:
    AssemblySession(string name, string date) : name(name), date(date) {}

    void AddLegislation(const Bills& legislation) {
        legislationsDiscussed.push_back(legislation);
    }

    void DisplaySession() const {
        cout << "SESSION NAME: " << name << endl;
        cout << "DATE: " << date << endl;
        cout << "LEGISLATIONS DISCUSSED:" << endl;
        for (const auto& legislation : legislationsDiscussed) {
            legislation.DisplayDetails();
            cout << endl;
        }
    }
};

class Class1 {
private:
    static vector<Committee> committees;
    static vector<Bills> bills;
    static vector<AssemblySession> sessions;
    static vector<Minister> ministers;
    static vector<Member> members;

    static void InitializeMembersAndLegislations() {
        members.emplace_back("Shri. Vijai Sardesai", "Fatorda", 45, "Goa Forward Party", "9773837210");
        members.emplace_back("Shri. Pramod Sawant", "Sanquelim", 40, "Bharatiya Janata Party", "7564543211");

        ministers.emplace_back("Shri. Nilkanth Halarnkar", "Tivim", 86, "Bharatiya Janata Party", "9876543214", "Fisheries");
        ministers.emplace_back("Shri. Govind Gaude", "Priol", 86, "Bharatiya Janata Party", "8845543215", "Art & Culture");

        bills.emplace_back("Agriculture", "The Goa Fruit and Ornamental Plant Nurseries (Regulation)(Amendment) Bill 2022", "Shri. Ravi Naik", "21 Jul 2022");
        bills.emplace_back("Town & Country Planning", "The Goa Electricity Duty (Amendment) Bill, 2008", "Shri. Aleixo Sequeira", "24 Mar 2008");
        bills.emplace_back("Health", "The Goa Public Health (Amendment) Bill, 2021", "Shri. Vishwajit Rane", "15 Aug 2021");
        bills.emplace_back("Education", "The Goa University (Amendment) Bill, 2020", "Shri. Rohan Khaunte", "12 Dec 2020");

        Committee financeCommittee("Business Advisory Committee");
        financeCommittee.AddMember(&members[0]);
        financeCommittee.AddMember(&members[1]);

        Committee healthCommittee("Public Accounts Committee");
        healthCommittee.AddMember(&ministers[0]);
        healthCommittee.AddMember(&members[1]);

        committees.push_back(financeCommittee);
        committees.push_back(healthCommittee);

        AssemblySession budgetSession("Budget Session", "2022-02-15");
        budgetSession.AddLegislation(bills[0]);
        budgetSession.AddLegislation(bills[2]);

        AssemblySession monsoonSession("Monsoon Session", "2022-07-10");
        monsoonSession.AddLegislation(bills[1]);
        monsoonSession.AddLegislation(bills[3]);

        sessions.push_back(budgetSession);
        sessions.push_back(monsoonSession);
    }

    static void DisplayMembers() {
        cout << "\n-----List of MLA's:-----" << endl;
        for (const auto& member : members) {
            member.DisplayInfo();
            cout << endl;
        }
    }

    static void DisplayMinisters() {
        cout << "\n-----List of Council of Ministers:-----" << endl;
        for (const auto& minister : ministers) {
            minister.DisplayInfo();
            cout << endl;
        }
    }

    static void DisplayBills() {
        cout << "\n-----List of Bills and their proposers:-----" << endl;
        for (const auto& legislation : bills) {
            legislation.DisplayDetails();
            cout << endl;
        }
    }

    static void DisplayCommittees() {
        cout << "\n-----List of Committees and their members:-----" << endl;
        for (const auto& committee : committees) {
            committee.DisplayCommittee();
            cout << endl;
        }
    }

    static void DisplaySessions() {
        cout << "\n-----List of Sessions and legislations discussed:-----" << endl;
        for (const auto& session : sessions) {
            session.DisplaySession();
            cout << endl;
        }
    }

public:
    static void Main() {
        InitializeMembersAndLegislations();

        int choice;
        do {
            cout << "\nGoa Legislative Assembly Menu:" << endl;
            cout << "1. List of Committees and their members" << endl;
            cout << "2. List of Bills and their proposers" << endl;
            cout << "3. List of Sessions and legislations discussed" << endl;
            cout << "4. List of Council of Ministers in Goa" << endl;
            cout << "5. List of MLA's of Goa" << endl;
            cout << "6. Exit" << endl;
            cout << "\nTo get the details of Goa Legislative Assembly select the option from Top List (1-6): ";
            cin >> choice;

            switch (choice) {
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
                    cout << "\nExiting..." << endl;
                    break;
                default:
                    cout << "\nInvalid choice! Please try again." << endl;
                    break;
            }
        } while (choice != 6);
    }
};

// Initialize static member variables
vector<Committee> Class1::committees;
vector<Bills> Class1::bills;
vector<AssemblySession> Class1::sessions;
vector<Minister> Class1::ministers;
vector<Member> Class1::members;

int main() {
    Class1::Main();
    return 0;
}
