package com.fahmialfareza.initialDemo.Entity;

public class Todo {

    private Long UserID;
    private Long ID;
    private String Title;
    private boolean Completed;

    public Todo() {
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isCompleted() {
        return Completed;
    }

    public void setCompleted(boolean completed) {
        Completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "UserID=" + UserID +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Completed=" + Completed +
                '}';
    }
}
