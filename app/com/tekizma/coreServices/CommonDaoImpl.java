package com.tekizma.coreServices;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.Query;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

public class CommonDaoImpl<T> implements CommonDao<T>{
    
    private final JPAApi jpaApi;
    
    @Inject
    public CommonDaoImpl(JPAApi jpaApi){
        this.jpaApi = jpaApi;    
    }
    
    public T find(Class<T> clazz, Object id){
        return (T)jpaApi.em().find(clazz,id);    
    }
    
    public List<T> findByNamedQuery(String queryName) {
		Query queryObject = jpaApi.em().createNamedQuery(queryName);
		return queryObject.getResultList();
	}
    
    public Object findObjectByNamedQuery(String queryName,
			Map<String, Object> params) {
		List<T> results = findByNamedQuery(queryName, params);
		if (results == null || results.size() == 0 || results.size() > 1) {
			return null;
		}
		return results.get(0);
	}
    
    public List<T> findByNamedQuery(String queryName, Map<String, Object> params) {
		Query queryObject = jpaApi.em().createNamedQuery(queryName);
		if (params != null) {
			for (String key : params.keySet()) {
				queryObject.setParameter(key, params.get(key));
			}
		}
		return queryObject.getResultList();
	}
    
    public T create(T t) {
		this.jpaApi.em().persist(t);
		return t;
	}
    
    public T update(T t){
        return jpaApi.em().merge(t);
    } 
    
    public List<T> executeNativeQuery(String sqlScript){
    	List<T> list = (List<T>) jpaApi.em().createQuery(sqlScript).getResultList();
		return list;
    }

	@Override
	public void delete(T t) {
		t = jpaApi.em().merge(t);
		jpaApi.em().remove(t);
	}


}