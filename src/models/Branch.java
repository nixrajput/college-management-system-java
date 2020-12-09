package models;

/**
 *
 * @author nixrajput
 */
public class Branch {

    private final String course;
    private final String title;
    private final String init;

    public String getCourse() {
        return course;
    }

    public String getTitle() {
        return title;
    }

    public String getInit() {
        return init;
    }

    public Branch(String course, String title, String init) {
        this.course = course;
        this.title = title;
        this.init = init;
    }
}
