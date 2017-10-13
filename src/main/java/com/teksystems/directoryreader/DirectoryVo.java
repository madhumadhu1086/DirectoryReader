package com.teksystems.directoryreader;

import java.util.Objects;

public class DirectoryVo implements Comparable<DirectoryVo> {
	private String fileName;
	private String absolutePath;
	private int tabs;
	private boolean directory;
	private String extension;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getAbsolutePath() {
		return absolutePath;
	}
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}
	public int getTabs() {
		return tabs;
	}
	public void setTabs(int tabs) {
		this.tabs = tabs;
	}
	public boolean isDirectory() {
		return directory;
	}
	public void setDirectory(boolean directory) {
		this.directory = directory;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	/**
	 * This methods sort the list of files by extension
	 */
	@Override
	public int compareTo(DirectoryVo directoryVo) {
		if(Objects.nonNull(this.getExtension()) && Objects.nonNull(directoryVo.getExtension())) {
			return this.getExtension().compareTo(directoryVo.getExtension());
		}
		return this.getAbsolutePath().compareTo(directoryVo.getAbsolutePath());
	}
	
	

}
