package com.example.recette.service.impl;

import com.example.recette.bean.Etape;
import com.example.recette.dao.EtapeDao;
import com.example.recette.service.facade.EtapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtapeServiceImp implements EtapeService {
    @Autowired
    private EtapeDao etapeDao;


    @Override
    public int deleteByRef(String ref) {
        return etapeDao.deleteByRef(ref);
    }


    @Override
    public int save(Etape etape) {
        etapeDao.save(etape);
        return 1;
    }


    @Override
    public int update(Etape etape) {
        return 0;
    }
}
