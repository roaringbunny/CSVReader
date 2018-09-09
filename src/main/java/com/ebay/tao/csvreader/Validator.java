package com.ebay.tao.csvreader;

import java.io.File;

public class Validator {

	public static File getReadWriteDirectory(String path) {
		File file = new File(path);
		validateReadWriteDirectory(file);
		return file;
	}

	public static boolean isFile(File file) {
		return (file != null) && file.exists() && file.isFile();
	}

	public static void validateDirectory(File file) {
		validateExists(file, String.format("Required path does not exist %s", getPath(file)));
		if (!file.isDirectory()) {
			throw new IllegalArgumentException(String.format("Required path is not a Directory: %s", getPath(file)));
		}
	}

	public static void validateExists(File file, String message) {
		validateNotNull(file, "Required path is NULL");
		if (!file.exists()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validateNotNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validateReadWriteFile(File file) {
		validateFile(file);
		validateCanReadWrite(file);
	}

	private static String getPath(File file) {
		String path = (file == null) ? "NULL" : file.getPath();
		return isEmpty(path) ? "NULL" : path;
	}

	public static boolean isEmpty(String string) {
		return (string == null) || string.trim().isEmpty();
	}

	public static void validateCanRead(File file) {
		validateNotNull(file, "Required path is NULL");
		if (!file.canRead()) {
			throw new IllegalArgumentException(String.format("Required path is not readable: %s", getPath(file)));
		}
	}

	public static void validateCanReadWrite(File file) {
		validateCanRead(file);
		validateCanWrite(file);
	}

	public static void validateCanWrite(File file) {
		validateNotNull(file, "Required path is NULL");
		if (!file.canWrite()) {
			throw new IllegalArgumentException(String.format("Required path is not writable: %s", getPath(file)));
		}
	}

	public static void validateReadWriteDirectory(File file) {
		validateDirectory(file);
		validateCanReadWrite(file);
	}

	public static void validateFile(File file) {
		validateExists(file, String.format("Required path does not exist %s", getPath(file)));
		if (!file.isFile()) {
			throw new IllegalArgumentException(String.format("Required path is not a File: %s", getPath(file)));
		}
	}
}
