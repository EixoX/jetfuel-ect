package com.eixox.ect;

import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;
import com.eixox.data.text.Csv;
import com.eixox.data.text.CsvFile;

/**
 * Faixa de CEP das Localidades codificadas. Este arquivo contém dados relativos
 * às faixas de CEP das localidades classificadas na categoria
 * político-administrativa de município codificadas com CEP único ou codificadas
 * por logradouros.
 * 
 * @author Rodrigo Portela
 *
 */
@DatabaseTable
@CsvFile(separator = "@")
public class EctLocalidadeFaixa {

	/**
	 * LOC_NU chave da localidade NUMBER(8)
	 */
	@DatabaseColumn
	@Unique
	@Csv
	public int localidade_id;

	/**
	 * LOC_CEP_INI CEP inicial da localidade CHAR(8)
	 */
	@DatabaseColumn
	@Csv
	public int cep_ini;

	/**
	 * LOC_CEP_FIM CEP final da localidade CHAR(8)
	 */
	@DatabaseColumn
	@Csv
	public int cep_fim;

	/**
	 * LOC_TIPO_FAIXA tipo de Faixa de CEP: T –Total do Município C – Exclusiva
	 * da Sede Urbana CHAR(1)
	 */
	@DatabaseColumn
	@Csv
	public char tipo_faixa;

}
