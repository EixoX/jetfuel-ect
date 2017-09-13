package com.eixox.ect;

import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;
import com.eixox.data.text.Csv;
import com.eixox.data.text.CsvFile;

/**
 * Faixa de CEP de UF
 * 
 * @author Rodrigo Portela
 *
 */
@DatabaseTable
@CsvFile(separator = "@")
public class EctUfFaixa {

	/**
	 * sigla da UF
	 */
	@DatabaseColumn
	@Unique
	@Csv
	public String uf;

	/**
	 * CEP inicial da UF
	 */
	@DatabaseColumn
	@Csv
	public int cep_ini;

	/**
	 * CEP final da UF
	 */
	@DatabaseColumn
	@Csv
	public int cep_fim;

}
