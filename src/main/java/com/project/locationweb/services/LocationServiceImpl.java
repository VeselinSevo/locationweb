package com.project.locationweb.services;

import com.project.locationweb.entities.Location;
import com.project.locationweb.repos.LocationRepository;
import com.project.locationweb.util.EmailUtil;
import com.project.locationweb.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
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
    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private ReportUtil reportUtil;
    @Autowired
    ServletContext sc;


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
        currentLocation.setPostNumber(newLocation.getPostNumber());
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
    }
    @Override
    public List<Location> getLocationsByCountry(String country, Boolean sort) {
        return !sort ? locationRepository.findByCountry(country) : locationRepository.findByCountrySortByCountry(country);
    }
    @Override
    public List<Location> sortLocationById() {
        return locationRepository.orderByIdAsc();
    }
    @Override
    public List<Location> sortLocationByName() {
        return locationRepository.orderByNameAsc();
    }
    @Override
    public List<Location> sortLocationByCountry() {
        return locationRepository.orderByCountryAsc();
    }
    @Override
    public List<Location> sortLocationByPostNumber() {
        return locationRepository.orderByPostNumberAsc();
    }
    @Override
    public List<Location> sortLocationByType() {
        return locationRepository.orderByTypeAsc();
    }

    @Override
    public List<Object[]> findTypeAndTypeCount() {
        return locationRepository.findTypeAndTypeCount();
    }
    @Override
    public void sendEmail(String email, String title, String content) {
        emailUtil.sendEmailString(email, title, content);
    }

    @Override
    public void generateReport() {
        String path = sc.getRealPath("/");
        List<Object[]> data = findTypeAndTypeCount();
        reportUtil.generatePieChart(path, data);
    }
}
