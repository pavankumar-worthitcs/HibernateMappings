package com.wcs.HibernateMapping.service;

import com.wcs.HibernateMapping.dao.IdCardDao;
import com.wcs.HibernateMapping.dto.IdCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdCardService {
    @Autowired
    IdCardDao idCardDao;

    public IdCard saveIdCard(IdCard idCard) {
        return idCardDao.saveIdCard(idCard);
    }


    public IdCard fetchIdCardById(Long idCardId) {
        return idCardDao.fetchIdCardById(idCardId);
    }

    public IdCard deleteIdCardById(Long idCardId) {
        return idCardDao.deleteIdCardById(idCardId);
    }

    public IdCard updateIdCardById(Long idCardId, IdCard newIdCard) {
        return idCardDao.updateIdCardById(idCardId, newIdCard);
    }
}
