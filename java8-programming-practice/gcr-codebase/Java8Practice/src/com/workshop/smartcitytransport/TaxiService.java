package com.workshop.smartcitytransport;

import java.time.LocalTime;

class TaxiService implements TransportService {

    public String getServiceName() { 
    		return "Taxi"; 
    	}
    
    public double getFare() { 
    		return 120; 
    	}
    
    public String getRoute() { 
    		return "B-C"; 
    	}
    
    public int getDepartureTime() { 
    		return 7; 
    	}
}
