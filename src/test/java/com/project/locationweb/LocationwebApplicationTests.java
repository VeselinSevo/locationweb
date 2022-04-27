package com.project.locationweb;

import com.project.locationweb.entities.Location;
import com.project.locationweb.repos.LocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Properties;

@SpringBootTest
class LocationwebApplicationTests {
//	@Autowired
//	LocationRepository locationRepository;
//
//	@Test
//	public void testCreateLocation() {
//		Location location = new Location();
//		location.setName("Indjija");
//		location.setCountry("Srbija");
//		location.setPost_number(15000);
//		location.setType("Rural");
//
//		locationRepository.save(location);
//	}
//
//
//
//	@Test
//	public void testEditLocation() {
//		Location location = locationRepository.findById(2).get();
//		location.setName("Novi Sad");
//		locationRepository.save(location);
//	}
//
//	@Test
//	public void testFindLocationById() {
//		Location location = locationRepository.findById(2).get();
//		System.out.println(location);
//		//OR
//		//System.out.println(locationRepository.findById(2).get());
//	}
//
//	@Test
//	public void testDeleteLocation() {
//		locationRepository.deleteById(6);
//	}
//
//
//	@Test
//	public void testDisplayLocation() {
//		for (Location location : locationRepository.findAll()) {
//			System.out.println(location);
//		}
//	}
}
