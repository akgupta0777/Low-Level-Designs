package Models;

public class Location {
    private double x;
    private double y;

    public Location(double x,double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }

    public double calculateDistance(Location dest){
        return Math.sqrt(Math.pow(dest.getX()-this.x,2)+Math.pow((dest.getY()-this.y),2));
    }

    @Override
    public String toString(){
        return "{x: "+getX()+" y: "+getY()+"}";
    }
}
