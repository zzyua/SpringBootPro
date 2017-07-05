package com.boot.util.poi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FloderUtil {
	
	private static String rootpath  = "E:\\PoiUtil\\files";
	
	public static List<String> getFilesNames(){
		

		List<String> files = new ArrayList<String>();
		String path =rootpath; // 路径
		File f = new File(path);
		if (!f.exists()) {
			System.out.println(path + " not exists");
			return files;
		}

		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (fs.isDirectory()) {
				//System.out.println(fs.getName() + " [目录]");
			} else {
				//System.out.println(fs.getName());
				files.add(rootpath+"\\"+fs.getName());
			}
		}
	
		
		
		return files;
		
	}
	
	

}
