package com.eixox.usecases.sigep;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.eixox.restrictions.Required;
import com.eixox.xml.Xml;

public class ConsultaContratos extends SigepBased<ConsultaContratos.Parameters, ConsultaContratos.Response> {

	@Override
	protected Element createEnvelopeElement(Document document) {
		Element element = super.createEnvelopeElement(document);
		element.setAttribute("xmlns:cli", "http://cliente.bean.master.sigep.bsb.correios.com.br/");
		return element;
	}

	@Xml(name = "cli:buscaCliente")
	public static class Parameters {

		/**
		 * Número do contrato
		 */
		@Xml
		@Required
		public String idContrato;

		/**
		 * Cartão de postagem vinculado ao contrato
		 */
		@Xml
		@Required
		public String idCartaoPostagem;

		/**
		 * Login do usuário para autenticação (Fornecido pelo Representante
		 * Comercial dos Correios mediante carta de solicitação)
		 */
		@Xml
		@Required
		public String usuario;

		/**
		 * Senha de autenticação. (Fornecida pelo Representante Comercial dos
		 * Correios mediante carta de solicitação)
		 */
		@Xml
		@Required
		public String senha;
	}

	@Xml(name = "ns2:buscaClienteResponse")
	public static class Response {

		@Xml(name = "return")
		public ResponseResult ret;

	}

	@Xml(name = "return")
	public static class ResponseResult {
		@Xml
		public String cnpj;
		@Xml
		public ResponseContrato contratos;
	}

	@Xml
	public static class ResponseContrato {

		@Xml
		public String codigoDiretoria;

		@Xml
		public ArrayList<ResponseCartaoPostagem> cartoesPostagem;

	}

	@Xml(name = "cartoesPostagem")
	public static class ResponseCartaoPostagem {

		@Xml
		public String numero;

		@Xml
		public String codigoAdministrativo;

		@Xml
		public ArrayList<ResponseServico> servicos;
	}

	@Xml(name = "servicos")
	public static class ResponseServico {
		/**
		 * Código do serviço, será utilizado no XML da PLP
		 */
		@Xml
		public String codigo;

		/**
		 * Nome do serviço
		 */
		@Xml
		public String descricao;
		/**
		 * ID do serviço, será utilizado no método solicitaEtiquetas() -
		 */
		@Xml
		public String id;
	}

}
