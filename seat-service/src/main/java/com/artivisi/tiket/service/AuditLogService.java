package com.artivisi.tiket.service;

import com.artivisi.tiket.dao.AuditLogDao;
import org.springframework.stereotype.Service;

import com.artivisi.tiket.entity.AuditLog;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Service
public class AuditLogService {

    @Autowired private AuditLogDao dao;

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void log(String user, String action, String data){
        AuditLog log = new AuditLog();
        log.setUser(user);
        log.setAction(action);
        log.setData(data);
        dao.save(log);
    }
}
