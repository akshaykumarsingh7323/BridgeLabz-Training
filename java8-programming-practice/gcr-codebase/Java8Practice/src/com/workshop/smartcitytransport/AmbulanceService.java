package com.workshop.smartcitytransport;

class AmbulanceService implements TransportService, EmergencyService {

    public String getServiceName() { 
    		return "Ambulance"; 
    	}	
    
    public double getFare() { 
    		return 0; 
    	}
    
    public String getRoute() { 
    		return "Any"; 
    	}
    
    public int getDepartureTime() { 
    		return 0; 
    	}
}
