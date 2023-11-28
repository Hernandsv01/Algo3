package org.fiuba.algotres.utils.enums;

public enum DefaultImageType {
    ESTADO(""),
    CLIMA(""),
    ITEM(""),
    POKEMON(""),
    OTRO("");

    private String defaultURL;
    DefaultImageType(String defaultURL){
        this.defaultURL = defaultURL;
    }

    public String getDefaultURL() {
        return defaultURL;
    }
}
