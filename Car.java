public class Car{
    private String carBrandModel;
    private int carModelYear;

    public Car(String carBrandModel, int carModelYear){
        setCarBrandModel(carBrandModel);
        setCarModelYear(carModelYear);
    }
    public Car(){
        setCarBrandModel("Default Brand Model");
        setCarModelYear(0);
    }
    public Car(String carBrandModel){
        this(carBrandModel, 0);
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