package com.githubdemo.operations;


/*
 * Constants class to use configurable properties
 */
public class Repository {
	
	// Netflix Property file names and prefix made static -
	// to avoid error while passing repo names from constants
	public final String NETFILX_PROP = "netflixconfig.properties";
	public final String NETFILX_REPO_PREFIX = "Netfilx/";

	// Repo names NETFLIX	
	public static final String NETFILX_POLLYJS = "Netfilx/pollyjs";
	public static final String NETFILX_CONDUCTOR = "Netfilx/conductor";
	public static final String NETFILX_SCUMBLR = "Netfilx/Scumblr";
	public static final String NETFILX_VAMF = "Netfilx/vmaf";
	public static final String NETFILX_ZUUL = "Netfilx/zuul";
	
	// Google Property file names and prefix made static -
	// to avoid error while passing repo names from constants
	public final String GOOGLE_PROP = "googleconfig.properties";
	public final String GOOGLE_REPO_PREFIX = "google/";	
	
	// Repo names GOOGLE
	public static final String GOOGLE_RSPIRV = "google/rspirv";
	public static final String GOOGLE_ANGLE = "google/angle";
	public static final String GOOGLE_LEVELDB = "google/leveldb";
	public static final String GOOGLE_SNAPPY = "google/snappy";
	public static final String GOOGLE_REJOINER = "google/rejoiner";
	
	
}
