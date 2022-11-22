public class Lease implements Insurance{
    private Car car;
    private int leaseStart;
    private int leaseEnd;
    private int monthlyCost;
    private String leaseId;

    private ExtraServices extraServices;
    
    public Lease(){
        car = new Car();
        setLeaseStart(1);
        setLeaseEnd(12);
        setMonthlyCost(0);
        getCar().setCarModelYear(0);
        setLeaseId(null);
    }

    public Lease(Car car, int leaseStart, int leaseEnd, int monthlyCost, String leaseId ){
        setCar(car);
        setLeaseStart(leaseStart);
        setLeaseEnd(leaseEnd);
        setMonthlyCost(monthlyCost);
        setLeaseId(leaseId);
    }

    public Lease(String carBrandModel, int carModelYear, int leaseStart, int leaseEnd, int monthlyCost, String leaseId ){
        setCar(carBrandModel, carModelYear);
        setLeaseStart(leaseStart);
        setLeaseEnd(leaseEnd);
        setMonthlyCost(monthlyCost);
        setLeaseId(leaseId);
    }

    public void displayInfo(){
        String s = "Lease of " + getCar().getCarBrandModel()
                + " for the " + getCar().getCarModelYear() + " model year starts at "
                + getLeaseStart() + ". Month ends at " + getLeaseEnd() + ". Month with cost "
                + calculateTotalPrice();
        if(extraServices != null){
            s += "\nLease also has Extra Service type " + extraServices.getType()
                    + " with cost " + extraServices.getCost();
        }
        System.out.println(s+"\n");
    }
    public double calculateTotalPrice(){
        return getMonthlyCost()*(getLeaseEnd() - getLeaseStart() + 1);
    }

    public void setCar(Car car){
        this.car = car;
    }

    public void setCar(String carBrandModel, int carModelYear){
        this.car.setCarBrandModel(carBrandModel);
        this.car.setCarModelYear(carModelYear);
    }

    public void setCar(String carBrandModel){  
        this.car.setCarBrandModel(carBrandModel);
    }

    public void setCar(int carModelYear){
        this.car.setCarModelYear(carModelYear);
    }

    public Car getCar(){
        return car;
    }

    public void setLeaseStart(int leaseStart){
        this.leaseStart = leaseStart;
    }

    public int getLeaseStart(){
        return leaseStart;
    }

    public void setLeaseEnd(int leaseEnd){
        this.leaseEnd = leaseEnd;
    }

    public int getLeaseEnd(){
        return leaseEnd;
    }

    public void setMonthlyCost(int monthlyCost){
        this.monthlyCost = ((monthlyCost >= 0) ? monthlyCost : -1);
    }

    public int getMonthlyCost(){
        return monthlyCost;
    }

    public void setLeaseId(String leaseId){
        this.leaseId = leaseId;
    }

    public String getLeaseId(){
        return leaseId;
    }

    public void setExtraServices(ExtraServices extraServices) {
        this.extraServices = extraServices;
    }

    public ExtraServices getExtraServices() {
        return extraServices;
    }

    @Override
    public double makeInsurance() {
        return calculateTotalPrice()*((double) 25/100);
    }
}