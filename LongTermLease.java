public class LongTermLease extends Lease{
    public LongTermLease(){
        super();
    }

    public LongTermLease(Car car, int leaseStart, int leaseEnd, int monthlyCost, String leaseId ){
        super(car,leaseStart,leaseEnd,monthlyCost,leaseId);
    }

    public LongTermLease(String carBrandModel, int carModelYear, int leaseStart, int leaseEnd, int monthlyCost, String leaseId ){
        super(carBrandModel,carModelYear,leaseStart,leaseEnd,monthlyCost,leaseId);
    }

    @Override
    public void displayInfo(){
        String s = "Lease of " + getCar().getCarBrandModel()
                + " for the " + getCar().getCarModelYear() + " model year starts at year "
                + getLeaseStart() + " ends at year " + getLeaseEnd() + " with cost "
                + calculateTotalPrice();
        if(super.getExtraServices() != null){
            s += "\nLease also has Extra Service type " + super.getExtraServices().getType()
                    + " with cost " + super.getExtraServices().getCost();
        }
        System.out.println(s+"\n");
    }

    @Override
    public double calculateTotalPrice(){
        return super.calculateTotalPrice()*10;
    }

    @Override
    public double makeInsurance() {
        return calculateTotalPrice()*((double) 35/100);
    }
}
