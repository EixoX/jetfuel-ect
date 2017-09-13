package com.eixox.ect;

import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;
import com.eixox.data.text.Csv;
import com.eixox.data.text.CsvFile;

/**
 * O arquivo LOG_LOCALIDADE contempla os municípios, distritos e povoados do
 * Brasil.
 * 
 * Os CEPs presentes neste arquivo valem para todos os logradouros da cidade,
 * não necessitando consulta nos demais arquivos.
 * 
 * @author Rodrigo Portela
 *
 */
@CsvFile(separator = "@")
@DatabaseTable
public class EctLocalidade {

	/**
	 * LOC_NU chave da localidade NUMBER(8)
	 */
	@Csv
	@Unique
	@DatabaseColumn
	public int localidade_id;

	/**
	 * UFE_SG sigla da UF CHAR(2)
	 */
	@Csv
	@DatabaseColumn
	public String uf;

	/**
	 * LOC_NO nome da localidade VARCHAR(72)
	 */
	@Csv
	@DatabaseColumn
	public String localidade_nome;

	/**
	 * CEP CEP da localidade (para localidade não codificada, ou seja loc_in_sit
	 * = 0) (opcional) CHAR(8)
	 */
	@Csv
	@DatabaseColumn
	public int cep;

	/**
	 * LOC_IN_SIT situação da localidade: 0= não codificada em nível de
	 * Logradouro, 1= Localidade codificada em nível de Logradouro e 2= Distrito
	 * ou Povoado inserido na codificação em nível de Logradouro. CHAR(1)
	 */
	@Csv
	@DatabaseColumn
	public int localidade_situacao;

	/**
	 * LOC_IN_TIPO_LOC tipo de localidade:D–Distrito,M–Município,P–Povoado.
	 * CHAR(1)
	 */
	@Csv
	@DatabaseColumn
	public char localidade_tipo;

	/**
	 * LOC_NU_SUB chave da localidade de subordinação (opcional) NUMBER(8)
	 */
	@Csv
	@DatabaseColumn
	public int localidade_subordinada_id;

	/**
	 * LOC_NO_ABREV abreviatura do nome da localidade (opcional) VARCHAR(36)
	 */
	@Csv
	@DatabaseColumn
	public String localidade_abrev;

	/**
	 * MUN_NU Código do município IBGE (opcional) CHAR(7)
	 */
	@Csv
	@DatabaseColumn
	public int localidade_ibge;

}
