package com.mnazarenka.service.common;

import com.mnazarenka.annotation.Loggable;
import com.mnazarenka.dao.common.BaseDao;
import com.mnazarenka.dao.entity.BaseEntity;
import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Loggable
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    public abstract BaseDao<T> getDao();

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public T find(Long id) {
        T entity = getDao().find(id);
        Hibernate.initialize(entity);
        return entity;
    }

    @Override
    public T create(T entity) {
        return getDao().create(entity);
    }

    @Override
    public void update(T entity) {
        getDao().update(entity);
    }

    @Override
    public void delete(T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        getDao().delete(id);
    }
}
