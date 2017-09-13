package com.eixox.ect;

import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;
import com.eixox.data.text.Csv;
import com.eixox.data.text.CsvFile;

/**
 * Bairro
 * 
 * @author Rodrigo Portela
 *
 */
@DatabaseTable
@CsvFile(separator = "@")
public class EctBairro {

	/**
	 * BAI_NU chave do bairro NUMBER(8)
	 */
	@DatabaseColumn
	@Unique
	@Csv
	public int bairro_id;

	/**
	 * UFE_SG sigla da UF CHAR(2)
	 */
	@DatabaseColumn
	@Csv
	public String uf;

	/**
	 * LOC_NU chave da localidade NUMBER(8)
	 */
	@DatabaseColumn
	@Csv
	public int localidade_id;

	/**
	 * BAI_NO nome do bairro VARCHAR2(72)
	 */
	@DatabaseColumn
	@Csv
	public String bairro_nome;

	/**
	 * BAI_NO_ABREV abreviatura do nome do bairro (opcional) VARCHAR2(36)
	 */
	@DatabaseColumn
	@Csv
	public String bairro_abrev;
}
