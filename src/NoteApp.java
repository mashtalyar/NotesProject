import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteApp {
    private List<Note> notes; //creating list for storing notes
    private Scanner scanner;  //creating scanner for reading input data

    public NoteApp() {
        notes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void createNote() {  //method which creating note and save them in list
        System.out.println("Enter note title: ");
        String title = scanner.nextLine();

        System.out.println("Enter note content: ");
        String content = scanner.nextLine();

        Note note = new Note(title, content);
        notes.add(note);

        System.out.println("Note created!");
    }

    public void displayNotes() {  //method for display notes or error message if notes is missing
        if (notes.isEmpty()) {
            System.out.println("No notes available");
            return;
        }

        System.out.println("-------Notes-------");
        for (Note note : notes) {
            System.out.println(note);
        }


    }

    public void saveNoteToFile(String fileName) {  //method for saving notes to file and checking exception
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Note note : notes) {
                writer.println(note.getTitle());
                writer.println(note.getContent());
            }
            System.out.println("Notes saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error while saving notes to file " + e.getMessage());
        }
    }

    public void loadNotesFromFile(String fileName) {  //method for loading notes from file and loaded them to app
        notes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String title = line;
                String content = reader.readLine();
                Note note = new Note(title, content);
                notes.add(note);
            }
            System.out.println("Notes loaded form file " + fileName);

        } catch (IOException e) {
            System.out.println("Error while loading notes from file" + e.getMessage());
        }
    }

    public void run() {  //method which play role of main menu and give a choice to user and serves as the main loop
        while (true) {
            System.out.println("1. Create a note");
            System.out.println("2. Display notes");
            System.out.println("3. Save notes to file");
            System.out.println("4. Load notes from file");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");
            int choise = scanner.nextInt();
            scanner.nextLine();


            switch (choise) {
                case 1:
                    createNote();
                    break;
                case 2:
                    displayNotes();
                    break;
                case 3:
                    System.out.println("Enter file name to save notes: ");
                    String saveFileName = scanner.nextLine();
                    saveNoteToFile(saveFileName);
                    break;
                case 4:
                    System.out.println("Enter file name to load notes from: ");
                    String loadFileName = scanner.nextLine();
                    loadNotesFromFile(loadFileName);
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }
}
