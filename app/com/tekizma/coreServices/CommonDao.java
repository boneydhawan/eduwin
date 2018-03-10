package com.tekizma.coreServices;

import java.util.List;
import java.util.Map;

public interface CommonDao<T>{
    
    public T find(Class<T> clazz, Object id);
    
    public T create(T t);
    
    public T update(T t);
    
    public void delete(T t);
    
    public List<T> findByNamedQuery(String queryName);
    
	public List<T> findByNamedQuery(String queryName, Map<String, Object> params);

	public Object findObjectByNamedQuery(String queryName,
			Map<String, Object> params);
    
    public List<T> executeNativeQuery(String sqlScript);
}