package com.eixox.ect;

import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;
import com.eixox.data.text.Csv;
import com.eixox.data.text.CsvFile;

/**
 * Logradouro, onde XX representa a sigla da UF. Este arquivo contém os
 * registros das localidades codificadas por logradouro(LOC_IN_SIT=1). Para
 * encontrar o bairro do logradouro, utilize o campo BAI_NU_INI(relacionamento
 * com LOG_BAIRRO, campo BAI_NU)  o bairro final, campo BAI_NU_FIM, está sendo
 * desativado.
 * 
 * @author Rodrigo Portela
 *
 */
@DatabaseTable
@CsvFile(separator = "@")
public class EctLogradouro {

	/**
	 * LOG_NU chave do logradouro NUMBER(8)
	 */
	@Csv
	@DatabaseColumn
	public int logradouro_id;

	/***
	 * UFE_SG sigla da UF CHAR(2)
	 */
	@Csv
	@DatabaseColumn
	public String uf;

	/**
	 * LOC_NU chave da localidade NUMBER(8)
	 */
	@Csv
	@DatabaseColumn
	public int localidade_id;

	/**
	 * BAI_NU_INI chave do bairro inicial do logradouro NUMBER(8)
	 */
	@Csv
	@DatabaseColumn
	public int bairro_id;

	/**
	 * BAI_NU_FIM chave do bairro final do logradouro (opcional) NUMBER(8)
	 */
	@Csv
	public int bairro_fim_id;

	/**
	 * LOG_NO nome do logradouro VARCHAR2(100)
	 */
	@Csv
	@DatabaseColumn
	public String logradouro;

	/**
	 * LOG_COMPLEMENTO complemento do logradouro (opcional) VARCHAR2(100)
	 */
	@Csv
	@DatabaseColumn
	public String complemento;

	/**
	 * CEP CEP do logradouro CHAR(8)
	 */
	@Csv
	@DatabaseColumn
	@Unique
	public int cep;

	/**
	 * TLO_TX tipo de logradouro VARCHAR2(36)
	 */
	@Csv
	@DatabaseColumn
	public String tipo;

	/**
	 * LOG_STA_TLO indicador de utilização do tipo de logradouro (S ou N)
	 * (opcional) CHAR(1)
	 */
	@Csv
	@DatabaseColumn
	public char tipo_utilizacao;

	/**
	 * LOG_NO_ABREV abreviatura do nome do logradouro (opcional) VARCHAR2(36)
	 */
	@Csv
	@DatabaseColumn
	public String logradouro_abrev;

}
