package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber, type);
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {
    	
        int traditional = 0;
        int rechargeable = 0;

        for(int i = 0; i < MAX_BATTERIES; i++){
            if(batteries[i] != null){
                if(batteries[i] instanceof RechargeableBattery){
                    rechargeable++;
                }else{
                    traditional++;
                }
            }
        }

        return "Batteries: \n Traditional: " + traditional + "\n Rechargeable: " + rechargeable;

    }
    
    public String showBatteriesInfo() {
    	String str = "";

        for(int i = 0; i < MAX_BATTERIES; i++){
            if(batteries[i] != null){
                
                str += (batteries[i] instanceof RechargeableBattery) ? "Rechargeable Battery" : "Non-rechargeable Battery";
                str += "\n";
                str += batteries[i].getName() + "\n";
                str += "Useful life cost: ";
                str += (batteries[i] instanceof RechargeableBattery) ? ((RechargeableBattery)batteries[i]).calculateUsefullLifeCost() : "0";
                str += "\n";  
            }
        }

    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){
		double sum = 0;
        double rechargeableBatteries = 0;

        for(int i = 0; i < MAX_BATTERIES; i++){

            if(batteries[i] != null && batteries[i] instanceof RechargeableBattery){
                sum += ((RechargeableBattery)batteries[i]).calculateUsefullLifeCost();
                rechargeableBatteries++;
            }

        }

        return sum / rechargeableBatteries;

	}

}
