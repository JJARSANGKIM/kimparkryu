package com.temkpr.pawintail.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {
    @CreatedDate
    @Column(name = "regDate", updatable = false)
    private LocalDateTime regDate;
    @LastModifiedBy
    @Column(name = "modDate", updatable = false)
    private LocalDateTime modDate;

    @PrePersist
    void PrePersist() {
        this.regDate = LocalDateTime.now();
        this.modDate = LocalDateTime.now();
    }
     @PreUpdate
     void preUpdate () {
         this.modDate = LocalDateTime.now();
     }
      
    }
    
