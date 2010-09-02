package br.univali.celine.lms.ajax;

import java.util.HashMap;


public class AjaxInterface {

	private static AjaxInterface instance = null;
	private static HashMap<String, Object> attributes;	
	
	private static final String UPLOAD_PROGRESS = "_uploadProgress";
	private static final String UPLOAD_STATUS = "_uploadStatus";
	

	private AjaxInterface() {
		
		attributes = new HashMap<String, Object>();		
	}
	
	public static AjaxInterface getInstance() {
	
		if (instance == null)
			instance = new AjaxInterface();
		
		return instance;		
	}
	
	
	private synchronized static Object getAttribute(String name) {
		
		if (attributes.containsKey(name))
			return attributes.get(name);
		
		return null;		
	}
	
	
	private synchronized static void setAttribute(String name, Object attribute) {
		
		removeAttribute(name);		
		attributes.put(name, attribute);		
	}
	
	
	private synchronized static void removeAttribute(String name) {
		
		if (attributes.containsKey(name))
			attributes.remove(name);		
	}
	
	
	
	public synchronized static double getUploadProgress(String userName) {
		
		Double doub;
		
		if ( (doub = (Double) getAttribute(userName + UPLOAD_PROGRESS)) == null)
			doub = 100.0;
		
		return doub;   		
	}
	
	public synchronized static int getUploadStatus(String userName) {
		
		Integer sint;
		
		if ( (sint = (Integer) getAttribute(userName + UPLOAD_STATUS)) == null)
			sint = 0;
		
		return sint;
	}
	
	
	public synchronized void updateStatus(String userName, int status) {
		
		setAttribute(userName + UPLOAD_STATUS, status);
		
	}
	
	public synchronized void removeStatus(String userName) {
		
		removeAttribute(userName + UPLOAD_STATUS);
	
	}
	
	public synchronized void updateProgress(String userName, double progress) {		
		
		setAttribute(userName + UPLOAD_PROGRESS, progress);		
	}
	
	
	public synchronized void removeProgress(String userName) {
		
		removeAttribute(userName + UPLOAD_PROGRESS);		
	}
	
	
}
