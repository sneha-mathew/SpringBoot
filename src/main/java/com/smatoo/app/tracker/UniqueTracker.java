package com.smatoo.app.tracker;

import java.util.Set;

import org.springframework.stereotype.Service;

import java.util.HashSet;
@Service
public class UniqueTracker implements ITracker{
	Set<Integer> uniqueIdSet;
	
	UniqueTracker()
	{
		clear();
	}
	
	@Override
	public void add(Integer id) {
	  uniqueIdSet.add(id);
	}

	@Override
	public Integer currentCountUniqueRequest() {
		return uniqueIdSet.size();		
	}

	@Override
	public void clear() {
		uniqueIdSet= new HashSet();
		System.out.println("cleared");
		
	}

}
