package com.ebay.tao.csvreader.batch;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.batch.item.ItemWriter;

public class ConsoleItemWriter<T> implements ItemWriter<T> {

	@Override
	public void write(List<? extends T> items) throws Exception {
		items.forEach((item) -> {
			System.out.println(ToStringBuilder.reflectionToString(item));
		});
	}
}
