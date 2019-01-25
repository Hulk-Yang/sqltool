package com.view.system.dialog;

import java.io.File;

import javax.swing.filechooser.FileFilter;
public class DefaultFileFilter extends FileFilter{
	private boolean  auto=false;
	private String suffix;
	public DefaultFileFilter(boolean auto,String suffix){
		this.auto = auto;
		this.suffix = suffix;
	}

	@Override
	public boolean accept(File f) {
		if (f.isDirectory()){
			f = new File("D:"+File.separator+"a.xml");
			return true;
		}
		 return f.getName().endsWith("."+suffix);
	}

	@Override
	public String getDescription() {
		// TODO �Զ����ɵķ������
		return "."+suffix;
	}


}
