package com.eixox.ect;

import java.util.List;
import java.util.function.Consumer;

import com.eixox.data.sql.DatabaseStorage;
import com.eixox.data.text.CsvAspect;
import com.eixox.data.text.TextFileStorage;

public class EctFileImporter<T> implements Runnable {

	public CsvAspect<T> aspect;
	public String file_name;
	public DatabaseStorage<T> storage;

	@Override
	public void run() {
		run(new Consumer<T>() {
			public void accept(T item) {
				storage.save(item);
			}
		});
	}

	public void run(Consumer<T> consumer) {
		TextFileStorage<T> textStorage = new TextFileStorage<T>(aspect, file_name, "ISO-8859-1");
		List<T> list = textStorage.select().toList();
		list.parallelStream().forEach(consumer);
	}

}
