package ua.ithillel.homework.lesson17;

public enum Configuration {
    PATH("FILE"),
    LEVEL("LEVEL"),
    SIZE("MAX-SIZE"),
    FORMAT("FORMAT");

    private String title;

    Configuration(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
