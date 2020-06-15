package com.example.bdiverse.Obgects;

public class task {
    private String titel;
    private int id;
    private boolean draft;
    private String dateManthDay;
    private String beginningTime;
    private String finishingTime;
    private String nameAddressCompany;
    private String taskCharacteristics;

    public task(String titel,  boolean draft, int id, String dateManthDay, String beginningTime, String finishingTime, String nameAddressCompany, String taskCharacteristics) {
        this.titel = titel;
        this.id = id;
        this.draft = draft;
        this.dateManthDay = dateManthDay;
        this.beginningTime = beginningTime;
        this.finishingTime = finishingTime;
        this.nameAddressCompany = nameAddressCompany;
        this.taskCharacteristics = taskCharacteristics;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public String getDateManthDay() {
        return dateManthDay;
    }

    public void setDateManthDay(String dateManthDay) {
        this.dateManthDay = dateManthDay;
    }

    public String getBeginningTime() {
        return beginningTime;
    }

    public void setBeginningTime(String beginningTime) {
        this.beginningTime = beginningTime;
    }

    public String getFinishingTime() {
        return finishingTime;
    }

    public void setFinishingTime(String finishingTime) {
        this.finishingTime = finishingTime;
    }

    public String getNameAddressCompany() {
        return nameAddressCompany;
    }

    public void setNameAddressCompany(String nameAddressCompany) {
        this.nameAddressCompany = nameAddressCompany;
    }

    public String getTaskCharacteristics() {
        return taskCharacteristics;
    }

    public void setTaskCharacteristics(String taskCharacteristics) {
        this.taskCharacteristics = taskCharacteristics;
    }
}
