package com.WEATHER.dao;

import com.WEATHER.pojo.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristREPO extends JpaRepository<Tourist,Integer>
{
}
