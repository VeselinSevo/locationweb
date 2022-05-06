package com.project.locationweb.controller;

import com.project.locationweb.entities.Location;
import com.project.locationweb.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")

public class LocationRESTController {

    @Autowired
    LocationService locationService;

    @GetMapping
    public List<Location> getLocations(){
        return locationService.getAllLocations();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location){
        return locationService.saveLocation(location);
    }
    @PutMapping
    public Location updateLocation(@RequestBody Location location){
        return locationService.saveLocation(location);
    }
    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id){

        try {
            locationService.deleteLocation(locationService.getLocationById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/{id}")
    public Location getLocation(@PathVariable("id") int id){
        try {
            return locationService.getLocationById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
