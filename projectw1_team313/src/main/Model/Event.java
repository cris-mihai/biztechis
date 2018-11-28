package main.Model;

import main.Exceptions.EventIsFullException;
import main.observer.RegisteredMember;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

public class Event extends Observable {

    private List<Member> registeredMembers;
    private List<Member> checkedInMembers = new ArrayList<>();
    private String name;
    private int capacity;
    private String date; //MM/DD/YY

    public Event(String name, int capacity, String date, List<Member> registeredMembers) {
        this.name = name;
        this.capacity = capacity;
        this.date = date;
        this.registeredMembers = registeredMembers;
        addObserver(new RegisteredMember());
    }

    //EFFECTS: Member is added to the list of registered members and observer counts them
    //MODIFIES: this
    public void eventRegistration(Member m) {
        setChanged();
        notifyObservers(m);
        registeredMembers.add(m);
        System.out.println(m.getName()+" has been registered!");
    }

    //EFFECTS: Member is added to the list of checked members and Member attended events goes up by one
    //MODIFIES: this
    public void memberCheckin(Member m) throws EventIsFullException {
        if (checkedInMembers.size()>=capacity) {
            throw new EventIsFullException();
        }
        else if (registeredMembers.contains(m)) {
            checkedInMembers.add(m);
            registeredMembers.remove(m);
            m.setEventsAttended(m.getEventsAttended()+1);
            System.out.println(m.name + " has been checked-in");
        } else if (!registeredMembers.contains(m)&!checkedInMembers.contains(m)) {
            checkedInMembers.add(m);
            System.out.println(m.getName()+" was not registered but has now been checked in.");
        } else {
            System.out.println(m.getName()+" is already checked in.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(registeredMembers, event.registeredMembers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(registeredMembers);
    }
}