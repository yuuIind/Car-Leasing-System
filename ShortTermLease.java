public class ShortTermLease extends Lease {
    public ShortTermLease(){
        super();
    }

    public ShortTermLease(Car car, int leaseStart, int leaseEnd, int monthlyCost, String leaseId ){
        super(car,leaseStart,leaseEnd,monthlyCost,leaseId);
    }

    public ShortTermLease(String carBrandModel, int carModelYear, int leaseStart, int leaseEnd, int monthlyCost, String leaseId ){
        super(carBrandModel,carModelYear,leaseStart,leaseEnd,monthlyCost,leaseId);
    }

    @Override
    public void displayInfo(){
        String s = "Lease of " + getCar().getCarBrandModel()
                + " for the " + getCar().getCarModelYear() + " model year starts at "
                + getLeaseStart() + ". day ends at " + getLeaseEnd() + ". day with cost "
                + calculateTotalPrice();
        if(super.getExtraServices() != null){
            s += "\nLease also has Extra Service type " + super.getExtraServices().getType()
                    + " with cost " + super.getExtraServices().getCost();
        }
        System.out.println(s+"\n");
    }

    @Override
    public double calculateTotalPrice(){
        return super.calculateTotalPrice()/20;
    }

    @Override
    public double makeInsurance() {
        return calculateTotalPrice()*((double) 15/100);
    }
}
