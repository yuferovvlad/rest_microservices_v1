package com.example.rest_microservices.mapper;

import com.example.rest_microservices.model.Manufacturer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManufacturerMapper {

    @Insert("INSERT INTO manufacturer (mfr_id, mfr_name, country) VALUES (#{mfrId}, #{mfrName}, #{country})")
    void insertManufacturer(Manufacturer manufacturer);

    @Select("SELECT country, COUNT(DISTINCT mfr_name) as manufacturerCount " +
            "FROM manufacturer " +
            "GROUP BY country " +
           "HAVING COUNT(DISTINCT mfr_name) BETWEEN #{min} AND #{max}")
    List<Map<String, Object>> countManufacturersByCountry(@Param("min") int min, @Param("max") int max);
}

