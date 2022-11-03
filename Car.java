public class Car{
    private String carBrandModel;
    private int carModelYear;

    public Car(String carBrandModel, int carModelYear){
        setCarBrandModel(carBrandModel);
        setCarModelYear(carModelYear);
    }
    public Car(String carBrandModel){
        this(carBrandModel, -1);
    }
    public void setCarBrandModel(String carBrandModel){
        this.carBrandModel = carBrandModel;
    }

    public String getCarBrandModel(){
        return carBrandModel;
    }

    public void setCarModelYear(int carModelYear){
        this.carModelYear = carModelYear;
    }

    public int getCarModelYear(){
        return carModelYear;
    }
    
}