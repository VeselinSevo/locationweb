package com.project.locationweb.services;

import com.project.locationweb.entities.Location;
import java.util.List;

public interface LocationService {
   Location saveLocation(Location location);

   Location updateLocation(Location newLocation) throws Exception;

   void deleteLocation(Location location);

   Location getLocationById(int id) throws Exception;

   List<Location> getAllLocations();

   List<Location> getLocationsByName(String name, Boolean sort);

   List<Location> getLocationsByCountry(String name, Boolean sort);

   List<Location> sortLocationById();

   List<Location> sortLocationByName();

   List<Location> sortLocationByCountry();

   List<Location> sortLocationByPostNumber();

   List<Location> sortLocationByType();
}
