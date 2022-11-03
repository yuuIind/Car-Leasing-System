public class Lease {
    private Car car;
    private int leaseStart;
    private int leaseEnd;
    private int monthlyCost;
    
    public Lease(Car car, int leaseStart, int leaseEnd, int monthlyCost){
        setCar(car);
        setLeaseStart(leaseStart);
        setLeaseEnd(leaseEnd);
        setMonthlyCost(monthlyCost);
    }

    public Lease(int leaseStart, int leaseEnd, int monthlyCost){
        this("Generic Car Model", leaseStart, leaseEnd, monthlyCost);
    }

    public Lease(String carBrandMode, int leaseStart, int leaseEnd){
        this(carBrandMode, leaseStart, leaseEnd, 9999);
    }

    public void displayInfo(){
        if(getLeaseEnd() < getLeaseStart()){ // check calculateTotalPrice()
            System.out.println("Lease of " 
            + getCarBrandModel()
            + " starts at " 
            + getLeaseStart() 
            + ". Month ends at "
            + getLeaseEnd() 
            + ". Month of next year with cost " // since you can't lease backwards in time
            + calculateTotalPrice());
        }
        System.out.println("Lease of " 
            + getCarBrandModel()
            + " starts at " 
            + getLeaseStart() 
            + ". Month ends at "
            + getLeaseEnd() 
            + ". Month with cost "
            + calculateTotalPrice());
    }
    public int calculateTotalPrice(){
        if(getLeaseEnd() < getLeaseStart()){ 
            //if the end date is less than the start date, assuming the end date is meant the next year, 
            //lease period can still go up to 12 month at max. However calculateTotalPrice needs this little tweak
            return getMonthlyCost()*(getLeaseEnd() - getLeaseStart() + 13);
        }
        return getMonthlyCost()*(getLeaseEnd() - getLeaseStart() + 1);
    }

    public void setCarBrandModel(Car car){
        this.car = car;
    }

    public String getCar(){
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
        this.monthlyCost = monthlyCost;
    }

    public int getMonthlyCost(){
        return monthlyCost;
    }
}