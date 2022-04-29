package model;

public class Battery {
    
    private String name;
    private double voltage;
    private double cost;
    private double capacity;
    
    public Battery(String name, double voltage, double cost, double capacity) {
        this.name = name;
        this.voltage = voltage;
        this.cost = cost;
        this.capacity = capacity;
    }
    
    public String getName() {
        return name;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getCost() {
        return cost;
    }

    public double getCapacity() {
        return capacity;
    }

}
