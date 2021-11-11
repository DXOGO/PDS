//package ex1;

public class VehicleFactory {

    static Vehicle scooter = new Scooter();
    static Vehicle micro = new Micro();
    static Vehicle city = new City();
    static Vehicle family = new Family();
    static Vehicle van = new Van();

    static private int ps;
    static private int[] lug;
    static private boolean wheelchair;
    
    public static Vehicle getVehicle(int passengers) {

        ps = passengers;
        lug = new int[]{0};
        wheelchair = false;
        verify(ps, lug, wheelchair);

        return null;
    }

    public static Vehicle getVehicle(int passengers, int[] luggage) {
        
        ps = passengers;
        lug = luggage;
        wheelchair = false;

        verify(ps, lug, wheelchair);

        return null;
    }

    public static Vehicle getVehicle(int passengers, boolean hasWheelchair) {

        ps = passengers;
        lug = new int[]{0};
        wheelchair = hasWheelchair;

        verify(ps, lug, wheelchair);

        return null;
    }

    public static Vehicle getVehicle(int passengers, int[] luggage, boolean hasWheelchair) {
        
        ps = passengers;
        lug = luggage;
        wheelchair = hasWheelchair;

        verify(passengers, lug, hasWheelchair);

        return null;
    }
    
    public static Vehicle verify(int passenger, int[] luggage, boolean wheelchair){

        int no_luggage = scooter.getMaxVolume();
        int max_luggage = van.getMaxVolume();
        int min_passenger = scooter.getMaxPassangers();
        int max_passenger = van.getMaxPassangers();

        int all_luggage = 0;

        for (int i : luggage){
            all_luggage += i;
        }

        if (wheelchair == true && passenger <= max_passenger && all_luggage <= max_luggage){
            if (all_luggage == no_luggage){
                System.out.println(Str(passenger, wheelchair) + ": " + van.toString());
                return new Van();
            } else {
                System.out.println(Str(passenger, luggage, wheelchair) + ": " + van.toString());
                return new Van();
            }
        }
        else{
            if (passenger == min_passenger){
                if (all_luggage == no_luggage){
                    System.out.println(Str(passenger, wheelchair) + ": " + scooter.toString());
                    return new Scooter();
                }
                else if (all_luggage <= micro.getMaxVolume()) {
                    System.out.println(Str(passenger, luggage, wheelchair) + ": " + micro.toString());
                    return new Micro();
                }
                else {System.out.println("[No results for entry parameters]");}   
            
            }else if(passenger <= max_passenger){
                if (all_luggage == no_luggage ){
                    if (passenger == city.getMaxPassangers()){
                        System.out.println(Str(passenger, wheelchair) + ": " + city.toString());
                        return new City();
                    } else {
                        System.out.println(Str(passenger, wheelchair) + ": " + family.toString());
                        return new Family();
                    }
                }
                if (all_luggage <= city.getMaxVolume()){
                    System.out.println(Str(passenger, luggage, wheelchair) + ": " + city.toString());
                    return new City();
                }
                else if (all_luggage <= family.getMaxVolume()){
                    System.out.println(Str(passenger, luggage, wheelchair) + ": " + family.toString());
                    return new Family();
                }
                else if (all_luggage <= max_luggage){
                    System.out.println(Str(passenger, luggage, wheelchair) + ": " + van.toString());
                    return new Van();
                }
                else {System.out.println("[No results for entry parameters]");}
            } else {System.out.println("[No results for entry parameters]");}
        }
        return null;
    }

public static String Str(int p, boolean wc){
    String str = "";
    if (wc == true){
        str = "Vehicle for " + p + " passengers and wheelchair";
    } else {
        str = "Vehicle for " + p + " passengers";
    }
    return str; 
}

public static String Str(int p, int[] l, boolean wc){
    String str = "";

    if (wc == true){
        str = "Vehicle for " + p + " passengers with " + l.length + " items of luggage and wheelchair";
    } else{
        str = "Vehicle for " + p + " passengers with " + l.length + " items of luggage";
    }
    
    return str; 
}
}

