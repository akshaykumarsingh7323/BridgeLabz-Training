package com.workshop.smartcitytransport;

class MetroService implements TransportService {

    public String getServiceName() { 
    		return "Metro"; 
    	}
    
    public double getFare() { 
    		return 60; 
    	}
    
    public String getRoute() { 
    		return "A-C"; 
    	}
    
    public int getDepartureTime() { 
    		return 8; 
    	}
}