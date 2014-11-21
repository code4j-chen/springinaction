package com.code4j.springinaction.springidol;

/**
 * Created by code4j on 2014/11/21.
 */
public class Instrumentalist implements Performer {
    private String song;
    private String age;

    public Instrumentalist() {
    }

    @Override
    public void perform() throws PerformerException {
        System.out.print("Playing " + song + " : ");
        instrument.play();
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String screamSong() {
        return song;
    }

    private Instrument instrument;

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }
}
