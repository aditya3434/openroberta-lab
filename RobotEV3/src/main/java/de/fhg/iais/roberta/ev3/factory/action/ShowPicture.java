package de.fhg.iais.roberta.ev3.factory.action;

import de.fhg.iais.roberta.factory.IShowPicture;

public enum ShowPicture implements IShowPicture {
    OLDGLASSES( "BRILLE", "Brille" ),
    EYESOPEN( "AUGENOFFEN", "Augen Offen" ),
    EYESCLOSED( "AUGENZU", "AUGEN ZU" ),
    FLOWERS( "BLUMEN", "Blumen" ),
    TACHO( "Tacho" );

    private final String[] values;

    private ShowPicture(String... values) {
        this.values = values;
    }

    @Override
    public String[] getValues() {
        return this.values;
    }

}