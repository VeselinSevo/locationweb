package com.project.locationweb.services;

import com.project.locationweb.entities.Location;
import com.project.locationweb.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class LocationServiceImpl implements LocationService {
    public LocationRepository getLocationRepository() {
        return locationRepository;
    }

    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Autowired
    private LocationRepository locationRepository;



    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location newLocation) throws Exception {
        Location currentLocation = getLocationById(newLocation.getId());
        currentLocation.setName(newLocation.getName());
        currentLocation.setType(newLocation.getType());
        currentLocation.setCountry(newLocation.getCountry());
        currentLocation.setPost_number(newLocation.getPost_number());
        return locationRepository.save(currentLocation);
    }

    @Override
    public void deleteLocation(Location location) {
        locationRepository.delete(location);
    }

    @Override
    public Location getLocationById(int id) throws Exception {
        return locationRepository.findById(id).orElseThrow(() -> new Exception("Location not found"));
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public List<Location> getLocationsByName(String name, Boolean sort) {
        return !sort ? locationRepository.findByName(name) : locationRepository.findByNameSortByName(name);
// -------------------------------------------------------------
//        ArrayList<Location> locations = new ArrayList<Location>();
//
//        for (Location location : locationRepository.findAll()) {
//            if (location.getName().equals(name)) {
//                 locations.add(location);
//            }
//        }
//        return locations;
// -------------------------------------------------------------

    }

    @Override
    public List<Location> getLocationsByCountry(String country, Boolean sort) {
        return !sort ? locationRepository.findByCountry(country) : locationRepository.findByCountrySortByCountry(country);
}
    @Override
    public List<Location> sortLocationById() {
        return locationRepository.findByOrderByIdAsc();
    }
}
