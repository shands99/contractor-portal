package org.jemco.contractorportal.timesheet.composite;

import java.util.Map;

public class CacheUtils {

	public static interface CacheCallback<T> {
		T get();
	}
	
	public static <T> T checkCache(Map<String, T> cache, String key, CacheCallback<T> cb) 
	{
		T object = cache.get(key);
		if (object == null) {
			object = cb.get();
			cache.put(key, object);
		}
		return object;
	}
	
}
