import java.util.Objects;

public class Lease implements Comparable<Lease>{
    private Car car;
    private int leaseDuration;
    private String leaseDurationType;
    private String leaseId;
    
    public Lease(){
        car = new Car();
    }

    public Lease(Car car,int leaseDuration, String leaseDurationType, String leaseId ){
        setCar(car);
        setLeaseDuration(leaseDuration);
        setLeaseDurationType(leaseDurationType);
        setLeaseId(leaseId);
    }

    public Lease(String carBrandModel, int carModelYear,  String leaseId ){
        setCar(carBrandModel, carModelYear);
        setLeaseId(leaseId);
    }

    public void setCar(Car car){
        this.car = car;
    }

    public void setCar(String carBrandModel, int carModelYear){
        this.car.setCarBrandModel(carBrandModel);
        this.car.setCarModelYear(carModelYear);
    }

    public int getLeaseDuration() {
        return leaseDuration;
    }

    public void setLeaseDuration(int leaseDuration) {
        this.leaseDuration = leaseDuration;
    }

    public String getLeaseDurationType() {
        return leaseDurationType;
    }

    public void setLeaseDurationType(String leaseDurationType) {
        this.leaseDurationType = leaseDurationType;
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

    public int getCarYear(){
        return car.getCarModelYear();
    }

    public String getCarBrand(){
        return car.getCarBrandModel();
    }

    public void setLeaseId(String leaseId){
        this.leaseId = leaseId;
    }

    public String getLeaseId(){
        return leaseId;
    }

    @Override
    public int compareTo(Lease o) {
        if(this.getCarYear() == o.getCarYear()){
            if (this.getCarBrand().equalsIgnoreCase(o.getCarBrand())) {
                if (this.getLeaseId().equalsIgnoreCase(o.getLeaseId())) {
                    return 0;
                }
                return this.getLeaseId().compareToIgnoreCase(o.getLeaseId());
            }
            return this.getCarBrand().compareToIgnoreCase(o.getCarBrand());
        }
        return this.getCarYear() - o.getCarYear();
    }
}