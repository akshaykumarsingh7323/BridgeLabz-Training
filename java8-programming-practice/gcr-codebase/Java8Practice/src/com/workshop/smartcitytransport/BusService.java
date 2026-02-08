package com.workshop.smartcitytransport;

class BusService implements TransportService {

    public String getServiceName() { 
    		return "Bus"; 
    	}
    
    public double getFare() { 
    		return 40; 			
    }
    public String getRoute() { 
    		return "A-B"; 
    	}
    
    public int getDepartureTime() { 
    		return 9; 
    	}
}
