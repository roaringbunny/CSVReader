package com.ebay.tao.csvreader.files;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class RegexFilenameFilter implements FilenameFilter {

	private final Pattern pattern;

	public RegexFilenameFilter(String regex) {
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	}

	@Override
	public boolean accept(File dir, String name) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
