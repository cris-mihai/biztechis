package main.Model;

import main.Exceptions.EventIsFullException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class ScannerOperations extends JFrame{

    private Set<Member> memberSet = new HashSet<>();
    private Scanner scanner;
    private String operation = "";
    private List<Event> eventList = new ArrayList<>();
    private List<Member> bpList = new ArrayList<>();
    private List<Member> ccoList = new ArrayList<>();

    private Event CCO = new Event("Cracking Open a Code One", 100, "09/10/18", ccoList);
    private Event CFN = new Event("Coding for Noobs", 80, "11/13/18", null);
    private Event TIC = new Event("Tech in Careers Night", 150, "11/01/18", null);
    private Event BP = new Event("Blueprint", 250, "11/24/18", bpList);
    private Event WOG = new Event("World of Gaming", 80, "01/15/19", null);

    private Member Kevin = new Member("Kevin", 4, 3, 5);
    private Member Stef = new Member("Stef", 2, 10, 6);
    private Member Karina = new Member("Karina", 3, 5, 7);
    private Member Sakiko = new Member("Sakiko", 3, 5, 8);
    private Member Sanjay = new Member("Sanjay", 2, 4, 9);
    private Member Ramish = new Member("Ramish", 2, 0, 10);

    private String name;
    private int year;
    private int eventsAttended;

    private JFrame f;
    private JButton registerEnter = new JButton("Enter");
    private JButton checkinEnter = new JButton("Enter");
    private JPanel homePanel;
    private JTextField textField;
    private JButton registerButton;
    private JButton checkInButton;
    private JButton addNewEntity;
    private JButton saveButton;
    private String input;
    private JPanel registrationPanel = new JPanel();
    private JPanel checkinPanel = new JPanel();
    private JPanel registrationMemberPanel = new JPanel();
    private JPanel checkinMemberPanel = new JPanel();
    private JPanel addNewPanel = new JPanel();
    private JPanel addNewPanel2 = new JPanel();
    private JPanel addNewPanel3 = new JPanel();
    private JPanel addNewPanelFinal = new JPanel();
    private JPanel addNewPartnerPanel = new JPanel();
    private JLabel registrationLabel = new JLabel();
    private JLabel checkinLabel = new JLabel();
    private JLabel addNewLabel = new JLabel();
    private JLabel addNewLabel2 = new JLabel();
    private JLabel addNewLabel3 = new JLabel();
    private JLabel addNewLabelFinal = new JLabel();
    private JPanel mainPanel = new JPanel();
    private CardLayout cardLayout = new CardLayout();
    private JLabel registrationMemberLabel = new JLabel();
    private JLabel checkinMemberLabel = new JLabel();
    private JLabel addNewPartnerLable = new JLabel();
    private JButton enterRegisterMember = new JButton("Enter");
    private JButton addNewPartnerButton = new JButton("Enter");
    private JButton addNewEnter = new JButton("Enter");
    private JButton addNewEnter2 = new JButton("Enter");
    private JButton addNewEnter3 = new JButton("Enter");
    private JButton enterCheckinMember = new JButton("Enter");
    private Event selectedEvent;
    private JButton exitButton = new JButton("Exit");
    private JButton exitButton2 = new JButton("Exit");
    private JButton exitButton3 = new JButton("Exit");
    //private ImageIcon image = new ImageIcon(getClass().getResource("/main/images/biztech 2018.png"));
    private JLabel imageLabel = new JLabel();
    private JTextField addTextBox = new JTextField(10);
    private JTextField addTextBox2 = new JTextField(10);
    private JTextField addTextBox3 = new JTextField(10);
    private JTextField registrationTextField = new JTextField(10);

    public ScannerOperations() throws IOException {

        try {
            createFrame();
            load();
            eventList();
            bpList();
            ccoList();
        /*} catch (NotCorrectEntryException e) {
            System.out.println("You entered the wrong info, please try again");
            scanner = new Scanner(System.in);*/
        } catch (IOException e) {
            System.out.println("IOException, check something's wrong and try again");
        } finally {
            System.out.println("That's all folks!");
            //save();
            //System.out.println("Thank you, goodbye!");
        }
    }

    /*public void runScanner() throws NotCorrectEntryException {

        while (true) {
            if (operation.equals("Add new")) {
                //*System.out.println("Is it a Partner or Member?");
                operation = scanner.nextLine();
                if (operation.equals("Partner")) {
                    AddPartner();
                } else {
                    AddMember();
                }
            } else if (operation.equals("Check-in")) {
                //NOTHING
            } else if (operation.equals("Register")) {
                //NOTHING
            } else if (operation.equals("Exit")) {
                System.out.println("You're exiting the system");
                break;
            } else {
                throw new NotCorrectEntryException();
            }
        }
    }*/

    public void exitPanel(){
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Home Panel");
            }
        });
        exitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Home Panel");
            }
        });
        exitButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Home Panel");
            }
        });
    }

    private void createFrame() {
        f = new JFrame("BizTech IS");
        f.add(mainPanel);
        addPanel();
        f.setVisible(true);
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textAction();
        imageLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/biztech 2018.png")).getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH)));
    }

    private void addPanel() {
        homePanel = new JPanel();
        mainPanel.setLayout(cardLayout);
        homePanel.setBackground(Color.lightGray);
        addLabel();
        addButton();
        mainPanel.add(homePanel, "Home Panel");
        registrationPanel();
        checkinPanel();
        addNewPanel();
        registrationMemberPanel();
        checkinMemberPanel();
        homePanel.add(imageLabel);
        //addNewEntryPartner();
    }

    private void registrationPanel(){
        mainPanel.add(registrationPanel, "Registration Panel");
        registrationLabel.setText("What event are you registering them for?");
        registrationPanel.add(registrationLabel);
        registrationPanel.add(registrationTextField);
        registrationPanel.add(registerEnter);

        registerEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = registrationTextField.getText();
                selectedEvent = matchEvent();
                cardLayout.show(mainPanel, "Member Registration Panel");
            }
        });
    }

    private void checkinPanel(){
        mainPanel.add(checkinPanel, "Checkin Panel");
        checkinLabel.setText("What event are you checking them in for?");
        checkinPanel.add(checkinLabel);
        textField = new JTextField(10);
        checkinPanel.add(textField);
        checkinPanel.add(checkinEnter);

        checkinEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = textField.getText();
                selectedEvent = matchEvent();
                cardLayout.show(mainPanel, "Member Checkin Panel");
            }
        });
    }

    private void addNewPanel(){
        mainPanel.add(addNewPanel, "Add New Panel");
        addNewPanel.add(addNewLabel);
        addNewPanel.add(addTextBox);
        addNewPanel.add(addNewEnter);
        AddMember();
        addNewPanel.add(imageLabel);
        addNewPanel2();
    }

    private void addNewPanel2(){
        mainPanel.add(addNewPanel2, "Add New Panel2");
        addNewPanel2.add(addNewLabel2);
        addNewPanel2.add(addTextBox2);
        addNewPanel2.add(addNewEnter2);
        addNewPanel2.add(imageLabel);
        addNewPanel3();
    }

    private void addNewPanel3(){
        mainPanel.add(addNewPanel3, "Add New Panel3");
        addNewPanel3.add(addNewLabel3);
        addNewPanel3.add(addTextBox3);
        addNewPanel3.add(addNewEnter3);
        addNewPanel3.add(imageLabel);
        addNewPanelFinal();
    }

    private void addNewPanelFinal(){
        mainPanel.add(addNewPanelFinal, "Add New Panel Final");
        addNewPanelFinal.add(addNewLabelFinal);
        addNewPanelFinal.add(imageLabel);
    }

    private void registrationMemberPanel(){
        mainPanel.add(registrationMemberPanel, "Member Registration Panel");
        JTextField newTextBox = new JTextField(10);
        saveButton = new JButton("Save");
        registrationMemberPanel.add(registrationMemberLabel);
        registrationMemberPanel.add(newTextBox);
        registrationMemberPanel.add(enterRegisterMember);
        registrationMemberPanel.add(saveButton);
        registrationMemberLabel.setText("Which member would you like to register?");
        registrationMemberPanel.add(exitButton);
        exitPanel();

        enterRegisterMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = newTextBox.getText();
                selectedEvent.eventRegistration(selectMember());
                registrationMemberLabel.setText(input+" is now registered!");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    save();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void checkinMemberPanel(){
        mainPanel.add(checkinMemberPanel, "Member Checkin Panel");
        JTextField newTextBox2 = new JTextField(10);
        saveButton = new JButton("Save");
        checkinMemberPanel.add(checkinMemberLabel);
        checkinMemberPanel.add(newTextBox2);
        checkinMemberPanel.add(enterCheckinMember);
        checkinMemberPanel.add(saveButton);
        checkinMemberLabel.setText("Which member would you like to check-in?");
        checkinMemberPanel.add(exitButton2);
        exitPanel();

        enterCheckinMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = newTextBox2.getText();
                try {
                    selectedEvent.memberCheckin(selectMember());
                    checkinMemberLabel.setText(input+" is checked in!");
                } catch (EventIsFullException e1) {
                    e1.printStackTrace();
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    save();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

   /* private void addNewEntryPartner(){
        mainPanel.add(addNewPartnerPanel, "Add New Partner Panel");
        JTextField newTextBox3 = new JTextField(10);
        saveButton = new JButton("Save");
        addNewPartnerPanel.add(addNewLabel);
        addNewPartnerPanel.add(newTextBox3);
        addNewPartnerPanel.add(addNewPartnerButton);
        addNewPartnerPanel.add(saveButton);
        addNewPartnerLable.setText("Which member would you like to check-in?");
        addNewPartnerPanel.add(exitButton);
        exitPanel();

        addNewPartnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPartner();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    save();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }*/

    private void addButton() {
        registerButton = new JButton("Register");
        homePanel.add(registerButton);
        checkInButton = new JButton("Check-In");
        homePanel.add(checkInButton);
        addNewEntity = new JButton("Add New");
        homePanel.add(addNewEntity);
    }

    private void addLabel() {
        JLabel firstSelection = new JLabel("Please choose from the following options.");
        homePanel.add(firstSelection);
    }

    private void textAction() {
        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Registration Panel");
            }
        });

        checkInButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Checkin Panel");
            }
        });

        addNewEntity.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Add New Panel");
            }
        });
    }

    //EFFECTS: Finds the member by first name and returns them
    private Member selectMember() {
        for (Member m : memberSet) {
            if (input.equals(m.name)) {
                return m;
            }
        }
        return null;
    }

    public String returnString() {
        return textField.getText();
    }

    //EFFECTS: Finds the event by event code and returns it
    private Event matchEvent() {
        for (Event e : eventList) {
            if (input.equals(e.getName())) {
                return e;
            }
        }
        return null;
    }

    //REQUIRES: String with name of an event
    //EFFECTS: Returns the event object for the inputted name string
    public Event eventNameSearch(String eventName) {
        for (Event e : eventList) {
            if (e.getName().equals(eventName)) {
                return e;
            }
        }
        return null;
    }

    public Set<Member> getMemberSet() {
        return memberSet;
    }

    // MODIFIES: this
    // EFFECTS: Creates a new driver with information the user inputs, and adds them to the DriverList
    private void AddMember() {
        addNewLabel.setText("Please add the member's first name");
        addNewEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = addTextBox.getText();
                askYear();
            }
        });
    }

    public void askYear(){
        cardLayout.show(mainPanel, "Add New Panel2");
        addNewLabel2.setText("Please add the member's year");
        addNewEnter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                year = Integer.parseInt(addTextBox2.getText());
                askEventsAttended();
            }
        });
    }

    public void askEventsAttended(){
        cardLayout.show(mainPanel, "Add New Panel3");
        addNewLabel3.setText("How many events have they been to?");
        addNewEnter3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventsAttended = Integer.parseInt(addTextBox3.getText());
                finalizeMember();
            }
        });
    }

    public void finalizeMember(){
        cardLayout.show(mainPanel, "Add New Panel Final");
        int memberID = generateNewID();
        addNewLabelFinal.setText("Member has been created.");
        addNewPanelFinal.add(exitButton3);
        exitPanel();
        Member userGenerated = new Member(name, year, eventsAttended, memberID);
        memberSet.add(userGenerated);
    }


    // MODIFIES: this
    // EFFECTS: Creates a new exec with information the user inputs, and adds them to the ExecList
    private void AddPartner() {
        addNewLabel.setText("Please add the partner's name");
        String name = textField.getText();
        addNewLabel.setText("Please add the number of years they've been with us");
        int year = Integer.valueOf(textField.getText());
        addNewLabel.setText("How many events are we partnered for?");
        int eventsAttended = Integer.valueOf(textField.getText());
        int memberID = generateNewID();
        addNewLabel.setText("Your partner has been added.");
        Member userGenerated = new Member(name, year, eventsAttended, memberID);
        memberSet.add(userGenerated);
    }

    // EFFECTS: Checks list of members to see what the last added memberID was
    //          then returns one higher than the last memberID
    private int generateNewID() {
        int lastLargeNumber = 0;
        for (AbstractMember m : memberSet) {
            if (m.getMemberID() > lastLargeNumber) {
                lastLargeNumber = m.getMemberID() + 1;
            }
        }
        return lastLargeNumber;
    }

    private void eventList() {
        eventList.add(CCO);
        eventList.add(CFN);
        eventList.add(TIC);
        eventList.add(BP);
        eventList.add(WOG);
    }

    private void bpList() {
        bpList.add(Stef);
        bpList.add(Kevin);
        bpList.add(Karina);
    }

    private void ccoList() {
        ccoList.add(Sanjay);
        ccoList.add(Sakiko);
        ccoList.add(Ramish);
    }

    private void load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        lines.add("Pranav 3 5 4");
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            Member newMember = new Member(partsOfLine.get(0), Integer.parseInt(partsOfLine.get(1)), Integer.parseInt(partsOfLine.get(2)), Integer.parseInt(partsOfLine.get(3)));
            memberSet.add(newMember);
            writer.println(line);
        }
        writer.close(); //note -- if you miss this, the file will not be written at all.
    }

    private void save() throws IOException {
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        clearTheFile();
        for (AbstractMember d : memberSet) {
            writer.println(d.getName() + " " + d.getYear() + " " + d.getEventsAttended() + " " + d.getMemberID());
        }
        writer.close();
    }

    private static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    //EFFECTS: clears the text file
    private static void clearTheFile() throws IOException {
        FileWriter fw0b = new FileWriter("file.txt", true);
        PrintWriter pw0b = new PrintWriter(fw0b, false);
        pw0b.flush();
        pw0b.close();
        fw0b.close();
    }

}