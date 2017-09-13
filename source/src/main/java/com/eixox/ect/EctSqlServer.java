package com.eixox.ect;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import com.eixox.data.sql.DatabaseStorage;
import com.eixox.data.sql.MsSqlServer;

public class EctSqlServer<T> extends DatabaseStorage<T> {

	private static final HashMap<Class<?>, EctSqlServer<?>> INSTANCES = new HashMap<Class<?>, EctSqlServer<?>>();

	@SuppressWarnings("unchecked")
	public static synchronized final <T> EctSqlServer<T> getInstance(Class<T> claz) {
		EctSqlServer<T> instance = (EctSqlServer<T>) INSTANCES.get(claz);
		if (instance == null) {
			try {
				instance = new EctSqlServer<T>(claz);
				INSTANCES.put(claz, instance);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return instance;
	}

	private EctSqlServer(Class<T> claz) throws SQLException {
		super(claz, createEctDb());
	}

	private static final MsSqlServer createEctDb() {
		Properties props = new Properties();
		props.setProperty("user", "glamprod");
		props.setProperty("password", "3xUPcZVlud6F");
		return new MsSqlServer("jdbc:jtds:sqlserver://sqlprod.glambox.com.br/EixoX.Brasil", props);
	}

}
