package model;

public class RechargeableBattery extends Battery implements Rechargeable {
    
    public static final char BATTERY_LITIO = 'l';
    public static final char BATTERY_NIQUEL_CADIO = 'n';
    public static final double FACTOR_LITIO = 0.92;
    public static final double FACTOR_NIQUEL_CADIO = 0.80;

    private int chargerNumber;
    private char type;

    public RechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        super(name, voltage, cost, capacity);
        this.chargerNumber = chargerNumber;
        this.type = type;
    }


    @Override
    public double calculateUsefullLifeCost() {
        double factorUsage = (type == BATTERY_LITIO) ? FACTOR_LITIO : FACTOR_NIQUEL_CADIO;

        return (super.getCost() * super.getVoltage() * super.getCapacity()) / (1000 * factorUsage * chargerNumber);
    }
   
}
