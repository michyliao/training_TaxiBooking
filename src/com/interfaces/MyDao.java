package com.interfaces;
import java.util.List;
import java.util.UUID;

public interface MyDao<T> {
	
	public int create(T t);
	public int update(T t);
	public int delete(T t);
	public T find(String id, String... value);
	public List<T> findAll();
	

}
