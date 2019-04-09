package com.bs.service;


public interface BaseService{
	public void sessionClear();
	public void sessionFlush();
	public void sessionRefresh(Object object);
}

