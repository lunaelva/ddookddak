package com.ddook.ddak.common.config;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.ddook.ddak.common.audit.UserAuditable;

public class AuditableListener {
	@PrePersist
    public void setAuditCreatedBy(Object entity) throws Exception {
        if (entity.getClass().isAnnotationPresent(Entity.class)) {
            Field field = getSingleField(entity.getClass(), "auditable");
            field.setAccessible(true);
            if (field.isAnnotationPresent(Embedded.class)) {
                Object auditable = field.get(entity);
                if (auditable == null) {
                    field.set(entity, new UserAuditable());
                    auditable = field.get(entity);
                }
                Field temporalCreatedField = auditable.getClass().getDeclaredField("regDate");
                Field temporalUpdatedField = auditable.getClass().getDeclaredField("updDate");
                setAuditValueTemporal(temporalCreatedField, auditable);
                setAuditValueTemporal(temporalUpdatedField, auditable);
            }
        }
    }

    @PreUpdate
    public void setAuditUpdatedBy(Object entity) throws Exception {
        if (entity.getClass().isAnnotationPresent(Entity.class)) {
            Field field = getSingleField(entity.getClass(), "auditable");
            field.setAccessible(true);
            if (field.isAnnotationPresent(Embedded.class)) {
                Object auditable = field.get(entity);
                if (auditable == null) {
                    field.set(entity, new UserAuditable());
                    auditable = field.get(entity);
                }
                Field temporalField = auditable.getClass().getDeclaredField("updDate");
                setAuditValueTemporal(temporalField, auditable);
            }
        }
    }

    protected void setAuditValueTemporal(Field field, Object entity) throws IllegalArgumentException, IllegalAccessException {  
        field.setAccessible(true);
        field.set(entity, LocalDateTime.now());
    }

    private Field getSingleField(Class<?> clazz, String fieldName) throws IllegalStateException {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException nsf) {
            // Try superclass
            if (clazz.getSuperclass() != null) {
                return getSingleField(clazz.getSuperclass(), fieldName);
            }

            return null;
        }
    }
}

