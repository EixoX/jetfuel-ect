package com.eixox.usecases.sigep;

import java.net.MalformedURLException;
import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.eixox.restrictions.Required;
import com.eixox.usecases.SoapUsecase;
import com.eixox.xml.Xml;

public class ConsultaRastreio extends SoapUsecase<ConsultaRastreio.Parameters, ConsultaRastreio.Response> {

	@Override
	protected Element createEnvelopeElement(Document document) {
		Element envelope = super.createEnvelopeElement(document);
		envelope.setAttribute("xmlns:tns", "http://resource.webservice.correios.com.br/");
		return envelope;
	}

	@Xml(name = "tns:buscaEventos")
	public static class Parameters {

		@Required
		@Xml
		public String usuario;

		@Required
		@Xml
		public String senha;

		@Required
		@Xml
		public String tipo = "";

		@Required
		@Xml
		public String resultado = "";

		@Required
		@Xml
		public String lingua = "101";

		@Required
		@Xml
		public String objetos;
	}

	@Xml(name = "ns2:buscaEventosResponse")
	public static class Response {

		@Xml(name = "return")
		public ResponseReturn ret;
	}

	@Xml(name = "return")
	public static class ResponseReturn {
		@Xml
		public String versao;
		@Xml
		public int qtd;
		@Xml
		public ResponseObject objeto;
	}

	@Xml
	public static class ResponseObject {

		/**
		 * Número do objeto
		 */
		@Xml
		public String numero;
		/**
		 * Sigla do objeto solicitado
		 */
		@Xml
		public String sigla;
		/**
		 * Nome do objeto solicitado
		 */
		@Xml
		public String nome;
		/**
		 * Categoria do objeto solicitado
		 */
		@Xml
		public String categoria;

		@Xml
		public ResponseEvent evento;
	}

	@Xml
	public static class ResponseEvent {

		/**
		 * Tipo do evento de retorno
		 */
		@Xml
		public String tipo;
		/**
		 * Status do evento de retorno
		 * 
		 */
		@Xml
		public String status;
		/**
		 * Data do evento
		 */
		@Xml
		public String data;

		/**
		 * Hora do evento
		 */
		@Xml
		public String hora;

		/**
		 * Descrição do evento
		 */
		@Xml
		public String descricao;

		/**
		 * Detalhe adicional do evento
		 * 
		 */
		@Xml
		public String detalhe;

		/**
		 * Local onde ocorreu o evento
		 */
		@Xml
		public String local;

		/**
		 * CEP da unidade ECT
		 * 
		 */
		@Xml
		public String codigo;

		/**
		 * Cidade onde ocorreu o evento
		 */
		@Xml
		public String cidade;

		/**
		 * Unidade da Federação
		 */
		@Xml
		public String uf;

	}

	@Override
	protected URL getUrl() throws MalformedURLException {
		return new URL("https://webservice.correios.com.br/service/rastro");
	}

}
