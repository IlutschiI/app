package com.wickenhauser.lukas.refreshactivity;

/**
 * Created by Lukas on 1/31/2015.
 */
public class Supplierung {
    private String abwLehrer;
    private String verLehrer;
    private String fach1;
    private String fach2;
    private int lesson;
    private String suppTyp;

    public Supplierung(String abwLehrer, String verLehrer, String fach1, String fach2, int lesson, String suppTyp) {
        this.abwLehrer = abwLehrer;
        this.verLehrer = verLehrer;
        this.fach1 = fach1;
        this.fach2 = fach2;
        this.lesson = lesson;
        this.suppTyp = suppTyp;
    }

    public String getSuppTyp() {
        return suppTyp;
    }

    public String getAbwLehrer() {
        return abwLehrer;
    }

    public String getVerLehrer() {
        return verLehrer;
    }

    public String getFach1() {
        return fach1;
    }

    public String getFach2() {
        return fach2;
    }

    public int getLesson() {
        return lesson;
    }
}
