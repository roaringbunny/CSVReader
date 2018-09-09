package com.ebay.tao.csvreader.files;

import com.ebay.tao.csvreader.Validator;
import java.io.File;
import java.io.FileFilter;

public class BcdFileFilter implements FileFilter {

	public BcdFileFilter() {
	}

	@Override
	public boolean accept(File pathname) {
		return Validator.isFile(pathname) && matchesBcdFormat(pathname);
	}

	private boolean matchesBcdFormat(File pathname) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
