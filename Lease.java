public class Lease {
    private Car car;
    private int leaseStart;
    private int leaseEnd;
    private int monthlyCost;
    
    public Lease(){
        car = new Car();
        setLeaseStart(1);
        setLeaseEnd(12);
        setMonthlyCost(0);
    }

    public Lease(int carModelYear){
        car = new Car();
        setLeaseStart(1);
        setLeaseEnd(12);
        setMonthlyCost(0);
        getCar().setCarModelYear(carModelYear);
    }

    public void displayInfo(){
        String s = "Lease of " + getCar().getCarBrandModel();

        if(getCar().getCarModelYear() != 0){
            s = s + " for the " + getCar().getCarModelYear() + " model year";
        }

        s += " starts at " + getLeaseStart() + ". Month ends at " + getLeaseEnd();

        if(getLeaseEnd() < getLeaseStart()){ // check calculateTotalPrice()
            s = s + ". Month of next year with cost " + calculateTotalPrice();
        }

        s += ". Month with cost " + calculateTotalPrice();
        System.out.println(s+"\n\n");
    }
    public int calculateTotalPrice(){
        if(getLeaseEnd() < getLeaseStart()){ 
            //if the end date is less than the start date, assuming the end date is meant the next year, 
            //lease period can still go up to 12 month at max. However calculateTotalPrice needs this little tweak
            return getMonthlyCost()*(getLeaseEnd() - getLeaseStart() + 13);
        }
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
        //if a correct month is not entered, start date will be assigned as january (1st month) by default
        this.leaseStart = ((leaseStart > 0 && leaseStart < 13) ? leaseStart : 1); 
    }

    public int getLeaseStart(){
        return leaseStart;
    }

    public void setLeaseEnd(int leaseEnd){
        //if a correct month is not entered, end date will be assigned as december (12th month) by default
        this.leaseEnd = ((leaseEnd > 0 && leaseEnd < 13) ? leaseEnd : 12);
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
}