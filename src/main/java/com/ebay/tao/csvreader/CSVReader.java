package com.ebay.tao.csvreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;

/**
 * https://howtodoinjava.com/spring-batch/flatfileitemreader-read-csv-example/
 *
 */
@SpringBootApplication
public class CSVReader implements ApplicationRunner {

	public static void main(String[] args) {
		try {
			// SpringApplication.run(CSVReader.class, args);
			readFile();
		} catch (IOException ex) {
			Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private static void readFile() throws IOException {
		String filePath = "C:\\Windows\\Temp\\BCDProcessingFiles\\waiting_recon_3\\item_bcdfile00003_f0001.man.csv";
		try (FileReader fileReader = new FileReader(filePath);
				BufferedReader reader = new BufferedReader(fileReader);) {
			System.out.println("Hi!");
			/*
			FlatFileItemReader reader = new FlatFileItemReader();
			reader.setResource(new FileSystemResource("input/inputData.csv"));
			reader.setLinesToSkip(1);
			reader.read();
			System.out.println("Hi");
			 */
		}
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
