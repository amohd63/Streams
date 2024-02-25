package models;

import java.time.LocalDate;

public class Card {
    private String id;
    private String fingerPrint;
    private LocalDate expiryDate;

    public Card(String id, String fingerPrint, LocalDate expiryDate) {
        this.id = id;
        this.fingerPrint = fingerPrint;
        this.expiryDate = expiryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
