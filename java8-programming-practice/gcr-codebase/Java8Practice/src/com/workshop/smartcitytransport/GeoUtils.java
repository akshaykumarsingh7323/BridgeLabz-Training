package com.workshop.smartcitytransport;

interface GeoUtils {
    static double calculateDistance(double lat1, double lat2) {
        return Math.abs(lat1 - lat2) * 10; 
    }
}

