import java.util.Date;

public class Start {
    public static void main(String[] args) {
        System.out.println("Hello, little world!!!");
        testDate();
    }

    private static void testDate(){
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println("> " + date);
        System.out.println("> " + sqlDate);

    }

}
