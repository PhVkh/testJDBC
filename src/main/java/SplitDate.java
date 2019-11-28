public class SplitDate {
    private int day;
    private int month;
    private int year;

    public SplitDate(String date) {
        this.day = Integer.parseInt(date.substring(0, 2));
        this.month = Integer.parseInt(date.substring(3, 5));
        this.year = Integer.parseInt(date.substring(6));
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
