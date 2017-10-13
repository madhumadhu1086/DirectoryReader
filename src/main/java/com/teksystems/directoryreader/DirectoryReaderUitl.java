package com.teksystems.directoryreader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectoryReaderUitl {
	
	/**
	 * Main driver and entry point
	 *
	 * @param args
	 */
	public static void main(String args[]) {
		String dirname = "./testdirectory/Main Project";
		try {
			List<DirectoryVo> list = new ArrayList<DirectoryVo>();
			Files.walkFileTree(Paths.get(dirname), new DirectoryReaderFileVisitor<Path>(list));
			Collections.sort(list);
			list.stream().forEach(directoryVo -> {
				for (int i = 1; i < directoryVo.getTabs(); i++) {
					System.out.print(" ");
				}
				if(directoryVo.isDirectory()) {
					System.out.println("- Project: "+directoryVo.getFileName()+" - URL: "+directoryVo.getAbsolutePath());
				} else {
					System.out.println("- Document: "+directoryVo.getFileName()+" - Extension: "+directoryVo.getExtension()+" - URL:"+directoryVo.getAbsolutePath());
				}
			});
		} catch (IOException exc) {
			System.out.println("I/O Error");
		}
	}

}
