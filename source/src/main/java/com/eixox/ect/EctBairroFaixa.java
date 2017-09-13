package com.eixox.ect;

import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;
import com.eixox.data.text.Csv;
import com.eixox.data.text.CsvFile;

/**
 * Faixa de CEP de Bairro
 * 
 * @author Rodrigo Portela
 *
 */
@DatabaseTable
@CsvFile(separator = "@")
public class EctBairroFaixa {

	/**
	 * BAI_NU chave do bairro NUMBER(8)
	 */
	@DatabaseColumn
	@Unique
	@Csv
	public int bairro_id;

	/**
	 * FCB_CEP_INI CEP inicial do bairro CHAR(8)
	 */
	@DatabaseColumn
	@Csv
	public int cep_ini;

	/**
	 * FCB_CEP_FIM CEP final do bairro CHAR(8)
	 */
	@DatabaseColumn
	@Csv
	public int cep_fim;
	
	

}
