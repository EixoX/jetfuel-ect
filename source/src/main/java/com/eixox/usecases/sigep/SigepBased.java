package com.eixox.usecases.sigep;

import java.net.MalformedURLException;
import java.net.URL;

import com.eixox.usecases.SoapUsecase;

public class SigepBased<TParams, TResult> extends SoapUsecase<TParams, TResult> {

	@Override
	protected URL getUrl() throws MalformedURLException {
		return is_debugging
				? new URL("https://apphom.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente")
				: new URL("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente");
	}

}
