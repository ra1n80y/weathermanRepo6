package com.WEATHER.service;

import com.WEATHER.dao.TouristREPO;
import com.WEATHER.exception.TouristNotFoundException;
import com.WEATHER.pojo.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TouristImpl implements ITourist
{
    @Autowired
    private TouristREPO repo;

    @Override
    public String registerTourist(Tourist tourist)
    {
        Integer ID = repo.save (tourist).getTid ();
        return "Data saved for tourist with id "+ID;
    }

    @Override
    public String updateData(Tourist tourist)
    {
        //Service-layer method for @PutMapping
        Optional<Tourist>optional=repo.findById (tourist.getTid ());

        if(optional.isPresent ())
        {
           repo.save (tourist);
           return "Tourist: "+tourist.getTid ()+" is updated";
        }
        else
            throw new TouristNotFoundException ("Tourist: "+tourist.getTid ()+" not found lmao");
    }

    @Override
    public String updateById(Integer ID,Double budget)
    {
        //Service-layer method for @PatchMapping
        Optional<Tourist>optional=repo.findById (ID);

        if(optional.isPresent ())
        {
            Tourist tourist=optional.get ();
            tourist.setBudget (budget);
            repo.save (tourist);
            return "Tourist: "+tourist.getTid ()+" is updated";
        }
        else
            throw new TouristNotFoundException ("Tourist: "+ID+" not found lmao");
    }

    @Override
    public Tourist fetchTouristById(Integer ID)
    {
        return repo.findById (ID)
                .orElseThrow (()->new TouristNotFoundException ("ID: "+ID+" not found"));
    }

    @Override
    public List<Tourist> fetchAllTourists()
    {
        return repo.findAll ();
    }

    @Override
    public String deleteTouristById(Integer ID)
    {
        Optional<Tourist>optional=repo.findById (ID);

        if(optional.isPresent ())
        {
            repo.delete(optional.get ());
            return "Tourist: "+ID+" is deleted";
        }
        else
            throw new TouristNotFoundException ("Tourist: "+ID+" not found lmao");
    }
}
