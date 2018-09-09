package com.ebay.tao.csvreader.files;

import com.ebay.tao.csvreader.Validator;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class BcdFiles {

	private final File parent;

	public BcdFiles(String bcdGeneratedFilesPath) {
		parent = Validator.getReadWriteDirectory(bcdGeneratedFilesPath);
	}

	public List<File> getFoldersAwaitingRecon(String awaitingReconDirectoryNameRegex) {
		File[] files = parent.listFiles(new RegexFilenameFilter(awaitingReconDirectoryNameRegex));
		for (File item : files) {
			Validator.validateReadWriteDirectory(item);
		}
		return Arrays.asList(files);
	}

	public List<File> getReconFolderBcdFiles(File folder) {
		Validator.validateReadWriteDirectory(folder);
		File[] files = folder.listFiles(new BcdFileFilter());
		for (File item : files) {
			Validator.validateFile(item);
			Validator.validateCanRead(item);
		}
		return Arrays.asList(files);
	}

}
