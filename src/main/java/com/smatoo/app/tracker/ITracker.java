package com.smatoo.app.tracker;

public interface ITracker{
	public void add(Integer id);

	public Integer currentCountUniqueRequest();

	public void clear();
}
