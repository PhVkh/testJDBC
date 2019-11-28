public class Date {
    private int day;
    private int month;
    private int year;

    public Date(String date) {
        this.day = Integer.parseInt(date.substring(0, 2));
        this.month = Integer.parseInt(date.substring(3, 5));
        this.year = Integer.parseInt(date.substring(6));
    }
}
