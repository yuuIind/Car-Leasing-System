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
        if (carModelYear < 1950){ // models starts from year 1950
            this.carModelYear = 1950;
        }
        else if (carModelYear > 2022){ // and goes up to 2022
            this.carModelYear = 2022;     // values other than valid model years are set as
                                        // limit values
        }
        else {
            this.carModelYear = carModelYear;
        }
    }

    public int getCarModelYear(){
        return carModelYear;
    }
    
}