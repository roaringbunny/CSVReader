package com.ebay.tao.csvreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * https://howtodoinjava.com/spring-batch/flatfileitemreader-read-csv-example/
 *
 */
@SpringBootApplication
public class CSVReader implements ApplicationRunner {

	private static final Pattern SummaryPattern = Pattern.compile("\\s*total number.*", Pattern.CASE_INSENSITIVE);

	public static void main(String[] args) {
		try {
			// SpringApplication.run(CSVReader.class, args);
			readFile();
		} catch (IOException ex) {
			Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private static boolean ignoreRecord(CSVRecord r) {
		if (r == null) {
			return true;
		} else {
			if ((r.getRecordNumber() == 1L) || (r.size() == 0) || SummaryPattern.matcher(r.get(0)).matches()) {
				return true;
			}
			return StreamSupport.stream(r.spliterator(), false).filter(c -> !c.trim().isEmpty()).collect(Collectors.toList()).isEmpty();
		}
	}

	private static void readFile() throws IOException {
		String filePath = "C:\\Windows\\Temp\\BCDProcessingFiles\\waiting_recon_3\\item_bcdfile00003_f0001.man.csv";

		try (FileReader fileReader = new FileReader(filePath);
				BufferedReader reader = new BufferedReader(fileReader);) {

			CSVParser records = CSVFormat.EXCEL.parse(fileReader);
			records.forEach(r -> {
				if (ignoreRecord(r)) {
					System.out.println("Ignore record");
				} else {
					Double amount = Double.valueOf(r.get(6));
					BigDecimal bd = new BigDecimal(Math.abs(amount)).setScale(2, RoundingMode.HALF_EVEN);
					BigDecimal bd2 = new BigDecimal(Math.abs(amount)).setScale(2, RoundingMode.HALF_UP);
					System.out.println(ToStringBuilder.reflectionToString(new Object[]{r.getRecordNumber(), amount, bd, bd2}));
				}

			});
			/*
			String header = reader.readLine();
			String line = reader.readLine();
			while (line != null) {
			Scanner scanner = new Scanner(line.trim());
			scanner.useDelimiter("\\s*,\\s*");
			Object token = scanner.next();
			while (scanner.hasNext()) {
			System.out.println(token);
			token = scanner.next();
			}
			line = reader.readLine();
			}
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
