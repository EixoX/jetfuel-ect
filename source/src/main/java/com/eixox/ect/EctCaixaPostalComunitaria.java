package com.eixox.ect;

import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;
import com.eixox.data.text.Csv;
import com.eixox.data.text.CsvFile;

@DatabaseTable
@CsvFile(separator = "@")
public class EctCaixaPostalComunitaria {

	/**
	 * CPC_NU chave da caixa postal comunitária NUMBER(8)
	 */
	@DatabaseColumn
	@Unique
	@Csv
	public int cpc_id;

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
	 * CPC_NO nome da CPC VARCHAR2(72)
	 */
	@DatabaseColumn
	@Csv
	public String cpc_nome;

	/**
	 * CPC_ENDERECO endereço da CPC VARCHAR2(100)
	 */
	@DatabaseColumn
	@Csv
	public String cpc_endereco;

	/**
	 * CEP CEP da CPC CHAR(8)
	 */
	@DatabaseColumn
	@Csv
	public int cep;

}
