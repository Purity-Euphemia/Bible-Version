public class Information {
    private String title;
    private String subject;
    private String description;
    private String publisher;
    private String date;
    private String type;
    private String format;
    private String identifier;
    private String source;
    private String language;
    private String coverage;

    public Information(String title, String subject, String description, String publisher, String date, String type, String format, String identifier, String source, String language, String coverage) {
        this.title = title;
        this.subject = subject;
        this.description = description;
        this.publisher = publisher;
        this.date = date;
        this.type = type;
        this.format = format;
        this.identifier = identifier;
        this.source = source;
        this.language = language;
        this.coverage = coverage;
    }
    public String getTitle() {
        return title;
    }
    public String getSubject() {
        return subject;
    }
    public String getDescription() {
        return description;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getDate() {
        return date;
    }
    public String getType() {
        return type;
    }
    public String getFormat() {
        return format;
    }
    public String getIdentifier() {
        return identifier;
    }
    public String getSource() {
        return source;
    }
    public String getLanguage() {
        return language;
    }
    public String getCoverage() {
        return coverage;
    }
}
