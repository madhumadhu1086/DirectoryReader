package com.teksystems.directoryreader;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class DirectoryReaderFileVisitor<Path> extends SimpleFileVisitor<Path> {
	private List<DirectoryVo> directoryVos;
	
	public DirectoryReaderFileVisitor(List<DirectoryVo> directoryVo) {
		super();
		this.directoryVos = directoryVo;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
		String absolutePath = path.toString();
		absolutePath = absolutePath.replace(".\\testdirectory\\", "");
		String a[] = absolutePath.split(File.separator+File.separator);
		DirectoryVo directoryVo = new DirectoryVo();
		directoryVo.setTabs(a.length);
		directoryVo.setAbsolutePath(absolutePath);
		directoryVo.setDirectory(true);
		directoryVo.setFileName(a[a.length-1]);	
		directoryVos.add(directoryVo);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
		String absolutePath = path.toString();
		absolutePath = absolutePath.replace(".\\testdirectory\\", "");
		String a[] = absolutePath.split(File.separator+File.separator);
		DirectoryVo directoryVo = new DirectoryVo();
		directoryVo.setTabs(a.length);
		directoryVo.setAbsolutePath(absolutePath);
		directoryVo.setDirectory(false);
		directoryVo.setFileName(a[a.length-1]);	
		directoryVo.setExtension(a[a.length-1].substring(a[a.length-1].indexOf(".")));
		directoryVos.add(directoryVo);
		return FileVisitResult.CONTINUE;
	}
}
