package org.pasa.sispasa.core.vo;

import java.util.List;

import org.pasa.sispasa.core.model.Nucleo;
import org.pasa.sispasa.core.model.Regional;

public class NucleoVo extends AtributosComunsVO{

	private Nucleo nucleo;
	private List<Nucleo> listaNucleos;
	private List<Regional> listaRegionais;

	public Nucleo getNucleo() {
		return nucleo;
	}

	public void setNucleo(Nucleo nucleo) {
		this.nucleo = nucleo;
	}

	public List<Nucleo> getListaNucleos() {
		return listaNucleos;
	}

	public void setListaNucleos(List<Nucleo> listaNucleos) {
		this.listaNucleos = listaNucleos;
	}

	public List<Regional> getListaRegionais() {
		return listaRegionais;
	}

	public void setListaRegionais(List<Regional> listaRegionais) {
		this.listaRegionais = listaRegionais;
	}
}
