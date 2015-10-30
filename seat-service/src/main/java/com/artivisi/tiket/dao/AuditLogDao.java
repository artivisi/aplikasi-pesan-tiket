package com.artivisi.tiket.dao;

import com.artivisi.tiket.entity.AuditLog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuditLogDao extends PagingAndSortingRepository<AuditLog, String>{}
