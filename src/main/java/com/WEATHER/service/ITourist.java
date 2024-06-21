package com.WEATHER.service;

import com.WEATHER.pojo.Tourist;

import java.util.List;

public interface ITourist
{
    //Creation OP
    String registerTourist(Tourist tourist);

    //Update OPS
    String updateData(Tourist tourist);
    String updateById(Integer ID,Double budget);

    //Retrieval OPS
    Tourist fetchTouristById(Integer ID);
    List<Tourist>fetchAllTourists();

    //Deletion OPS
    String deleteTouristById(Integer ID);

}
