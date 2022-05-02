package com.project.locationweb.repos;

import com.project.locationweb.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("SELECT location FROM Location location WHERE location.country LIKE :name%")
    List<Location> findByName(@Param("name") String name);

    @Query("SELECT location FROM Location location WHERE location.country LIKE :country%")
    List<Location> findByCountry(@Param("country")String country);

    @Query("SELECT location FROM Location location WHERE location.name LIKE :name% ORDER BY name")
    List<Location> findByNameSortByName(@Param("name") String ime);

    @Query("SELECT location FROM Location location WHERE location.country LIKE :country% ORDER BY country")
    List<Location> findByCountrySortByCountry(@Param("country") String country);

    @Query("SELECT location FROM Location location ORDER BY id")
    List<Location> orderByIdAsc();

    @Query("SELECT location FROM Location location ORDER BY name")
    List<Location> orderByNameAsc();

    @Query("SELECT location FROM Location location ORDER BY country")
    List<Location> orderByCountryAsc();

    @Query("SELECT location FROM Location location ORDER BY postNumber")
    List<Location> orderByPostNumberAsc();

    @Query("SELECT location FROM Location location ORDER BY type")
    List<Location> orderByTypeAsc();

    @Query("SELECT type, count(type) FROM Location location GROUP BY type")
    List<Object[]> findTypeAndTypeCount();


}
