package com.code4j.springinaction.springidol;

import java.util.Collection;

/**
 * Created by code4j on 2014/11/21.
 */
public class OnemanBand implements Performer {
    private Collection<Instrument> instruments;
    @Override
    public void perform() throws PerformerException {
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }

    public void setInstruments(Collection<Instrument> instruments) {
        this.instruments = instruments;
    }
}
