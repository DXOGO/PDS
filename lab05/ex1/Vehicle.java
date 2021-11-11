//package ex1;

public interface Vehicle {
    public int getMaxVolume();
    public int getMaxPassangers();

}

class Scooter implements Vehicle{

    private int maxVolume = 0;
    private int maxPassangers = 1;


    public int getMaxVolume(){
        return this.maxVolume;
    }
    
    public int getMaxPassangers(){
        return this.maxPassangers;
    }

    public String toString(){
        String str = "Use a Scooter";

        return str;
    }
}

class Micro implements Vehicle{
    private int maxVolume = 250;
    private int maxPassangers = 1;


    public int getMaxVolume(){
        return this.maxVolume;
    }
    
    public int getMaxPassangers(){
        return this.maxPassangers;
    }

    public String toString(){
        String str = "Use a Micro car";

        return str;
    }
}

class City implements Vehicle{
    private int maxVolume = 250;
    private int maxPassangers = 3;


    public int getMaxVolume(){
        return this.maxVolume;
    }
    
    public int getMaxPassangers(){
        return this.maxPassangers;
    }   

    public String toString(){
        String str = "Use a City car";

        return str;
    }
}

class Family implements Vehicle{
    private int maxVolume = 600;
    private int maxPassangers = 4;


    public int getMaxVolume(){
        return this.maxVolume;
    }
    
    public int getMaxPassangers(){
        return this.maxPassangers;
    }

    public String toString(){
        String str = "Use a Family car";

        return str;
    }
}

class Van implements Vehicle{
    private int maxVolume = 1000;
    private int maxPassangers = 4;

    public int getMaxVolume(){
        return this.maxVolume;
    }
    
    public int getMaxPassangers(){
        return this.maxPassangers;
    }

    public String toString(){
        String str = "Use a Van";

        return str;
    }
    
}