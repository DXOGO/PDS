import java.util.Random;

//package pds_2021_111.lab01;

public class Coordinates {
    private int x;
    private int y;

    Coordinates() {
    } 

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }    

    /**
     * @return int return the x
     */
    public int getX() { return x; }
    
    /**
     * @return int return the y
     */
    public int getY() { return y; }

    /**
     * @param x the x to set
     */
    public void setX(int x) { this.x = x; }    

    /**
     * @param y the y to set
     */
    public void setY(int y) { this.y = y; }

    
    public String toString() {
        return (this.x + 1)  + "," + (this.y + 1);
    }

    public boolean equals(Coordinates c2) {
        return (this.x == c2.getX() && this.y == c2.getY());
    }

    public void randomCoordinate(int limit) {
        Random r = new Random();
        this.setX(r.nextInt(limit));
        this.setY(r.nextInt(limit));
    }

}
