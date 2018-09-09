package com.ebay.tao.csvreader;

import org.springframework.batch.item.file.FlatFileItemReader;
public class CSVReader {

	public static void main(String[] args) {
		readFile();
	}

	private static void readFile() {
		FlatFileItemReader reader = new FlatFileItemReader();
		System.out.println("Hi");
	}
	
	
}
