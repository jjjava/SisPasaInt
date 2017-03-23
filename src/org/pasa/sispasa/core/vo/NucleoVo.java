package org.pasa.sispasa.core.vo;

import java.util.List;

import org.pasa.sispasa.core.model.Estado;
import org.pasa.sispasa.core.model.Nucleo;
import org.pasa.sispasa.core.model.NucleoMunicipio;
import org.pasa.sispasa.core.model.Regional;

public class NucleoVo extends AtributosComunsVO{

	private Nucleo nucleo;
	private NucleoMunicipio nucleoMunicipio;
	private List<Nucleo> listaNucleos;
	private List<Regional> listaRegionais;
	private List<Estado> listaEstados;
	private Boolean detalhar;
	private String paginaAtual;
	

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

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public NucleoMunicipio getNucleoMunicipio() {
		return nucleoMunicipio;
	}

	public void setNucleoMunicipio(NucleoMunicipio nucleoMunicipio) {
		this.nucleoMunicipio = nucleoMunicipio;
	}

	public Boolean getDetalhar() {
		return detalhar;
	}

	public void setDetalhar(Boolean detalhar) {
		this.detalhar = detalhar;
	}

	public String getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(String paginaAtual) {
		this.paginaAtual = paginaAtual;
	}
}
