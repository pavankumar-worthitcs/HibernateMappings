package com.wcs.HibernateMapping.dao;

import com.wcs.HibernateMapping.dto.IdCard;
import com.wcs.HibernateMapping.repo.IdCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class IdCardDao {
    
    @Autowired
    IdCardRepo idCardRepo;

    public IdCard saveIdCard(IdCard idCard){
        return idCardRepo.save(idCard);
    }

    public IdCard fetchIdCardById(Long idCardId){
        Optional<IdCard> dbIdCard =idCardRepo.findById(idCardId);
        return dbIdCard.orElse(null);
    }
    public IdCard updateIdCardById(Long idCardId,IdCard newIdCard){
        IdCard dbIdCard =fetchIdCardById(idCardId);
        if(dbIdCard!= null){
            newIdCard.setIdCardId(idCardId);
            return saveIdCard(newIdCard);
        }
        return null;
    }
    public IdCard deleteIdCardById(Long idCardId){
        IdCard dbIdCard= fetchIdCardById(idCardId);
        if(dbIdCard!=null) idCardRepo.delete(dbIdCard);
        return dbIdCard;
    }
}
