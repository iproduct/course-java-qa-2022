package course.qa.formatter;

public class HelloFormatter {
    public String format(String name) {
        return String.format("$$$ Hi %s, from Experimental Formatter $$$", name.toUpperCase());
    }
}
