package Enums;

public enum Gender {
    Male(""), Female("а"), Neuther("о"), All("");
    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}