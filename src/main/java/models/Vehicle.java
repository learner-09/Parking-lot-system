package models;

public class Vehicle {
    private Type type;
    private String color;
    private String registrationNumber;

    public Vehicle(Type type, String color, String registrationNumber) {
        this.type = type;
        this.color = color;
        this.registrationNumber = registrationNumber;
    }

    public Vehicle() {
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
