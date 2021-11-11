//package ex1;

public class ex1{
    public static void main(String[] args) {
    
        int[] luggage;
        Vehicle v;
        
        //Get vehicle for 1 passenger without luggage
        v = VehicleFactory.getVehicle(1);

        //Get vehicle for 2 passenger without luggage
        v = VehicleFactory.getVehicle(4);

        //Get vehicle for 1 passenger with two items of luggage
        luggage = new int[]{100, 140}; // two bags with a total volume of 240
        v = VehicleFactory.getVehicle(1, luggage);
        
        // Get vehicle for 3 passengers with three items of luggage
        luggage = new int[]{50, 200, 240}; // three bags with a total volume of 490
        v = VehicleFactory.getVehicle(3, luggage);
        
        // Get vehicle for 1 passengers and wheelchair
        v = VehicleFactory.getVehicle(1, true);

        // Get vehicle for 1 passengers and no wheelchair
        v = VehicleFactory.getVehicle(1, false);
    
        // Get vehicle for 2 passenger without luggage
        v = VehicleFactory.getVehicle(2); // diz que não nenhum veículo encontrado

        luggage = new int[]{300, 340, 310}; // three bags with a total volume of 950
        v = VehicleFactory.getVehicle(3, luggage);

        // Get vehicle for 5 passengers and wheelchair
        v = VehicleFactory.getVehicle(5, true); 

        // Get vehicle for 4 passengers, luggage and wheelchair
        luggage = new int[]{2000};
        v = VehicleFactory.getVehicle(4, luggage, true);

    }
}

