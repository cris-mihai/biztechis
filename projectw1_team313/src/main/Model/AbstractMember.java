package main.Model;

import java.util.Objects;
import java.util.Observable;

public abstract class AbstractMember {

    protected String name;
    protected int year;
    protected int eventsAttended;
    protected int memberID;

    public AbstractMember(String name, int year, int eventsAttended, int memberID) {
        this.name = name;
        this.year = year;
        this.eventsAttended = eventsAttended;
        this.memberID = memberID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractMember that = (AbstractMember) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    // REQUIRES: An event
    // MODIFIES: A member
    // EFFECTS: Adds an event to the member's list of events attended if they attended
    public void addEvent(){
        this.eventsAttended = eventsAttended++;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getEventsAttended() {
        return eventsAttended;
    }

    public void setEventsAttended(int eventsAttended) {
        this.eventsAttended = eventsAttended;
    }

    public int getMemberID() {
        return memberID;
    }
}
