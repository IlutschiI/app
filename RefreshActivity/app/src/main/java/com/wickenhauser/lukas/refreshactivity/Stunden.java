package com.wickenhauser.lukas.refreshactivity;

/**
 * Created by Lukas on 2/1/2015.
 */
public class Stunden {
    String fach;
    String Lehrer;
    String raum;

    public Stunden(String fach, String lehrer, String raum) {
        this.fach = fach;
        Lehrer = lehrer;
        this.raum = raum;
    }

    public String getFach() {
        return fach;
    }

    public String getLehrer() {
        return Lehrer;
    }

    public String getRaum() {
        return raum;
    }
}
