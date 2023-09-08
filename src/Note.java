public class Note {
    private String title;  // creating main variables which describe title of note
    private String content; // creating main variables which describe content of note

    public Note(String title, String content) {  //creating constructor for generation note
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {   //override method toString for correct input data
        return "Tirle: " + title + "\nContent: " + content;
    }
}
