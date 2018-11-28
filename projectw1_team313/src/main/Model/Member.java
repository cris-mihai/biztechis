package main.Model;

public class Member extends AbstractMember {

    // A member has a name, year of study, list of events attended, and a unique memberID
    public Member(String name, int year, int eventsAttended, int memberID) {
        super(name, year, eventsAttended, memberID);
    }
}