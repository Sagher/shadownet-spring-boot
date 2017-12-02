package com.shadow.net.geoIP;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

import java.io.IOException;

public class GeoIPv4 {

    public static Location resolved;

    private static LookupService lookUp;

    static {
        try {
            lookUp = new LookupService(GeoIPv4.class.getResource("GeoLiteCity.dat").getFile(),
                    LookupService.GEOIP_MEMORY_CACHE);

            System.out.println("GeoIP Database loaded: " + lookUp.getDatabaseInfo());
        } catch (IOException e) {
            System.out.println("Could not load geo ip database: " + e.getMessage());
        }
    }

    public static String getLocation(String ipAddress) {
        if (lookUp.getLocation(ipAddress) != null) {
            resolved = lookUp.getLocation(ipAddress);
            return resolved.countryName;
        } else {
            resolved = null;
        }
        return "N/A";
    }

}
