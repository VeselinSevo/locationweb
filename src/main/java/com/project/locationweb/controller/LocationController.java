package com.project.locationweb.controller;

import com.project.locationweb.entities.Location;
import com.project.locationweb.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;


@Controller
public class LocationController {
    @Autowired
    LocationService service;

    @GetMapping("/show-create")
    public String showCreate() {
        return "createLocation";
    }

    @PostMapping("/save-location")
    public String saveLocation(@ModelAttribute() Location location, ModelMap modelMap) {
        Location locationSaved = service.saveLocation(location);
        String msg = "Location saved with id: " + locationSaved.getId();
        int id = locationSaved.getId();
        modelMap.addAttribute("msg", msg);
        modelMap.addAttribute("newLocationId", id);
        return "createLocation";
    }

    @GetMapping("/display-locations")
    public String displayAllLocations(ModelMap modelMap) {
        List<Location> locations = service.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/delete-location")
    public RedirectView deleteLocation(@RequestParam("id") int id, ModelMap modelMap) throws Exception {
        Location deletedLocation = service.getLocationById(id);
        service.deleteLocation(deletedLocation);
        return new RedirectView("/locationweb/display-locations");

    }

    @RequestMapping("/edit-location")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) throws Exception {
        Location selectedLocation = service.getLocationById(id);
        modelMap.addAttribute("location", selectedLocation);
        return "editLocation";
    }

    @RequestMapping("/update-location")
    public RedirectView updateLocation(@ModelAttribute() Location location, ModelMap modelMap) throws Exception {
        service.updateLocation(location);
        return new RedirectView("/locationweb/display-locations");
    }

    @RequestMapping("/search-location-by-name") // also sorts by name
    public String searchLocationByName(@RequestParam("name") String name, @RequestParam(name = "sort", required = false) Boolean sort, ModelMap modelMap) throws Exception {
        List<Location> searchedLocations = service.getLocationsByName(name, sort);
        modelMap.addAttribute("locations", searchedLocations);
        return "displayLocations";
    }
    @RequestMapping("/search-location-by-country") // also sorts by country
    public String searchLocationByCountry(@RequestParam("country") String country, @RequestParam(name = "sort", required = false) Boolean sort, ModelMap modelMap) throws Exception {
        List<Location> searchedLocations = service.getLocationsByName(country, sort);
        modelMap.addAttribute("locations", searchedLocations);
        return "displayLocations";
    }

    @RequestMapping("/sort-location-by-id")
    public String sortById(ModelMap modelMap) throws Exception {

        List<Location> sortedByIdLocations = service.sortLocationById();
        modelMap.addAttribute("locations", sortedByIdLocations);
        return "displayLocations";
    }
}


