package main.ui;

import main.Exceptions.NotCorrectEntryException;
import main.Model.ScannerOperations;

import java.io.IOException;

public class LightsOut {


    public static void main(String[] args) throws IOException, NotCorrectEntryException {
        ScannerOperations scannerOps = new ScannerOperations();
    }
}

/*
Class with low cohesion, ConsoleUI: Some methods like runScanner and AddMember do a lot of different things, can be simplified
Class with high cohesion: Events; each method does a very specific task
Areas of high coupling: Event and Member: Event has a lot of methods that take in a Member or fields of Member,
and either add them to an Event or alter them. This would break easily if Member were changed.
Also code duplication between Partner and Member exists.
Cohesion assessment for ScannerOperations was very low cohesion. Took half the methods and moved them to Member and Event; caused some errors.
Coupling assessment: Event uses many fields from Member and
 */
