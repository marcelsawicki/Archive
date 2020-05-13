
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PukPukProtocol {

    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;

    private static final int NUMJOKES = 5;

    private int state = WAITING;
    private int currentJoke = 0;

    private String[] clues = { "Rzepa", "Starsza Pani", "Student", "Kto",
                               "Kto" };

    public static String now(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
    }

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Puk! Puk!";
            state = SENTKNOCKKNOCK;
        } else if (state == SENTKNOCKKNOCK) {
            if (theInput.equalsIgnoreCase("Kto tam?")) {
                theOutput = clues[currentJoke];
                state = SENTCLUE;
            } else {
                theOutput = "Zapytaj \"Kto tam?\"! "
                            + "Spr�buj jeszcze raz. Puk! Puk!";
            }
        } else if (state == SENTCLUE) {
            if (theInput.equalsIgnoreCase("Jaka " + clues[currentJoke] + "?")) {
                theOutput = "Jest godzina " + PukPukProtocol.now("H:mm:ss:SSS") + " . Chcesz inna (t/n)?";
                state = ANOTHER;
            } else {
                theOutput = "Oczekiwalem ze odpowiesz: \"Jaka " + clues[currentJoke]
                            + "?\"" + "! Spr�buj jeszcze raz. Puk! Puk!";
                state = SENTKNOCKKNOCK;
            }
        } else if (state == ANOTHER) {
            if (theInput.equalsIgnoreCase("t")) {
                theOutput = "Puk! Puk!";
                if (currentJoke == (NUMJOKES - 1)) {
                    currentJoke = 0;
                } else {
                    currentJoke++;
                }
                state = SENTKNOCKKNOCK;
            } else {
                theOutput = "PaPa!";
                state = WAITING;
            }
        }
        return theOutput;
    }
}
