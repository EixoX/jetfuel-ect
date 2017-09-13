package com.eixox.ect;

import com.eixox.data.CompositeKey;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;
import com.eixox.data.text.Csv;
import com.eixox.data.text.CsvFile;

/**
 * Outras denominações da Localidade (denominação popular, denominação anterior)
 * 
 * @author Rodrigo Portela
 *
 */
@DatabaseTable
@CsvFile(separator = "@")
public class EctLocalidadeAlias {

	/**
	 * LOC_NU chave da localidade NUMBER(8)
	 */
	@DatabaseColumn
	@CompositeKey
	@Csv
	public int localidade_id;

	/**
	 * VAL_NU ordem da denominação NUMBER(8)
	 */
	@DatabaseColumn
	@CompositeKey
	@Csv
	public int ordinal;

	/**
	 * VAL_TX Denominação VARCHAR2(72)
	 */
	@DatabaseColumn
	@Csv
	public String localidade_alias;
}
