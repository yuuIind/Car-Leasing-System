public class ExtraServices implements Insurance{
    private String type;
    private int cost;

    public ExtraServices(String type, int cost){
        setType(type);
        setCost(cost);
    }

    public ExtraServices(){
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public double makeInsurance() {
        return getCost()*((double) 20/100);
    }
}
