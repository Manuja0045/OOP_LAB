# Author: Manuja Nagvekar
# Roll No: 25
# Title: Goa Legislative Assembly
# Description: This program is used to create a database of Goa Legislative Assembly and to perform various operations

class AssemblySession:
    def __init__(self, name, date):
        self.name = name
        self.date = date
        self.legislations_discussed = []

    def add_legislation(self, legislation):
        self.legislations_discussed.append(legislation)

    def display_session(self):
        print(f"SESSION NAME: {self.name}")
        print(f"DATE: {self.date}")
        print("LEGISLATIONS DISCUSSED:")
        for legislation in self.legislations_discussed:
            legislation.display_details()
            print()

class Member:
    def __init__(self, name, constituency, age, party, contact_info):
        self.name = name
        self.constituency = constituency
        self.age = age
        self.party = party
        self.contact_info = contact_info

    def display_info(self):
        print(f"NAME: {self.name}")
        print(f"CONSTITUENCY: {self.constituency}")
        print(f"AGE: {self.age}")
        print(f"PARTY: {self.party}")
        print(f"CONTACT INFO: {self.contact_info}")

class Minister(Member):
    def __init__(self, name, constituency, age, party, contact_info, portfolio):
        super().__init__(name, constituency, age, party, contact_info)
        self.portfolio = portfolio

    def display_info(self):
        super().display_info()
        print(f"PORTFOLIO: {self.portfolio}")

class Committee:
    def __init__(self, name):
        self.name = name
        self.members = []

    def add_member(self, member):
        self.members.append(member)

    def display_committee(self):
        print(f"COMMITTEE NAME: {self.name}")
        print("Members:")
        for member in self.members:
            member.display_info()
            print()

class Bills:
    def __init__(self, title, description, proposer, date_introduced):
        self.title = title
        self.description = description
        self.proposer = proposer
        self.date_introduced = date_introduced

    def display_details(self):
        print(f"BILL TITLE: {self.title}")
        print(f"DESCRIPTION: {self.description}")
        print(f"INTRODUCED BY: {self.proposer}")
        print(f"DATE INTRODUCED: {self.date_introduced}")

def initialize_members_and_legislations():
    members.append(Member("Shri. Vijai Sardesai", "Fatorda", 45, "Goa Forward Party", "9773837210"))
    members.append(Member("Shri. Pramod Sawant", "Sanquelim", 40, "Bharatiya Janata Party", "7564543211"))

    ministers.append(Minister("Shri. Nilkanth Halarnkar", "Tivim", 54, "Bharatiya Janata Party", "9876543214", "Fisheries"))
    ministers.append(Minister("Shri. Govind Gaude", "Priol", 50, "Bharatiya Janata Party", "8845543215", "Art & Culture"))

    bills.append(Bills("Agriculture", "The Goa Fruit and Ornamental Plant Nurseries (Regulation)(Amendment) Bill 2022.", "Shri. Ravi Naik", "21 Jul 2022"))
    bills.append(Bills("Town & Country Planning", "The Goa Electricity Duty (Amendment) Bill, 2008.", "Shri. Aleixo Sequeira", "24 Mar 2008"))
    bills.append(Bills("Health", "The Goa Public Health (Amendment) Bill, 2021.", "Shri. Vishwajit Rane", "15 Aug 2021"))
    bills.append(Bills("Education", "The Goa University (Amendment) Bill, 2020.", "Shri. Rohan Khaunte", "12 Dec 2020"))

    finance_committee = Committee("Business Advisory Committee")
    finance_committee.add_member(members[0])
    finance_committee.add_member(members[1])

    health_committee = Committee("Public Accounts Committee")
    health_committee.add_member(ministers[0])
    health_committee.add_member(members[1])

    committees.append(finance_committee)
    committees.append(health_committee)

    budget_session = AssemblySession("Budget Session", "2022-02-15")
    budget_session.add_legislation(bills[0])
    budget_session.add_legislation(bills[2])

    monsoon_session = AssemblySession("Monsoon Session", "2022-07-10")
    monsoon_session.add_legislation(bills[1])
    monsoon_session.add_legislation(bills[3])

    sessions.append(budget_session)
    sessions.append(monsoon_session)

def display_members():
    print("\n***List of MLA's:***")
    for member in members:
        member.display_info()
        print()

def display_ministers():
    print("\n***List of Council of Ministers:***")
    print("Select the Minister:\n1.Shri. Nilkanth Halarnkar\n2.Shri. Govind Gaude")
    for minister in ministers:
        minister.display_info()
        print()

def display_bills():
    print("\n***List of Bills and their proposers:***")
    for legislation in bills:
        legislation.display_details()
        print()

def display_committees():
    print("\n***List of Committees and their members:***")
    for committee in committees:
        committee.display_committee()
        print()

def display_sessions():
    print("\n***List of Sessions and legislations discussed:***")
    for session in sessions:
        session.display_session()
        print()

if __name__ == "__main__":
    members = []
    ministers = []
    bills = []
    committees = []
    sessions = []

    initialize_members_and_legislations()

    while True:
        print("\nGoa Legislative Assembly Menu:")
        print("1. List of Committees and their members")
        print("2. List of Bills and their proposers")
        print("3. List of Sessions and legislations discussed")
        print("4. List of Council of Ministers in Goa")
        print("5. List of MLA's of Goa")
        print("6. Exit")
        choice = int(input("\nTo get the details of Goa Legislative Assembly select the option from Top List (1-6): "))

        if choice == 1:
            display_committees()
        elif choice == 2:
            display_bills()
        elif choice == 3:
            display_sessions()
        elif choice == 4:
            display_ministers()
        elif choice == 5:
            display_members()
        elif choice == 6:
            print("\nExiting...")
            break
        else:
            print("\nInvalid choice! Please try again.")

