package com.TpJdbc.app;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Module implements Serializable {
	
	private String code;
	private String libelle;
	private int hCoursPrev;
	private int hCoursRea;
	private int hTpPrev;
	private int	hTpRea;
	private String discipline;
	private int coeffTest;
	private int coeffCC;
	private Prof responsable;
	private Module pere;
	private Set<Etudiant> etudiants;
	private Set<Enseignement> enseignement = new HashSet<>();

	//CONSTRUCTEUR	
	public Module(){}

	//GETTERS-SETTERS
	public Module getPere() {
		return pere;
	}

	public void setPere(Module pere) {
		this.pere = pere;
	}
	
	public Prof getResponsable() {
		return responsable;
	}

	public void setResponsable(Prof responsable) {
		this.responsable = responsable;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int gethCoursPrev() {
		return hCoursPrev;
	}

	public void sethCoursPrev(int hCoursPrev) {
		this.hCoursPrev = hCoursPrev;
	}

	public int gethCoursRea() {
		return hCoursRea;
	}

	public void sethCoursRea(int hCoursRea) {
		this.hCoursRea = hCoursRea;
	}

	public int gethTpPrev() {
		return hTpPrev;
	}

	public void sethTpPrev(int hTpPrev) {
		this.hTpPrev = hTpPrev;
	}

	public int gethTpRea() {
		return hTpRea;
	}

	public void sethTpRea(int hTpRea) {
		this.hTpRea = hTpRea;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public int getCoeffTest() {
		return coeffTest;
	}

	public void setCoeffTest(int coeffTest) {
		this.coeffTest = coeffTest;
	}

	public int getCoeffCC() {
		return coeffCC;
	}

	public void setCoeffCC(int coeffCC) {
		this.coeffCC = coeffCC;
	}
	
	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + coeffCC;
		result = prime * result + coeffTest;
		result = prime * result + ((discipline == null) ? 0 : discipline.hashCode());
		result = prime * result + hCoursPrev;
		result = prime * result + hCoursRea;
		result = prime * result + hTpPrev;
		result = prime * result + hTpRea;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (coeffCC != other.coeffCC)
			return false;
		if (coeffTest != other.coeffTest)
			return false;
		if (discipline == null) {
			if (other.discipline != null)
				return false;
		} else if (!discipline.equals(other.discipline))
			return false;
		if (hCoursPrev != other.hCoursPrev)
			return false;
		if (hCoursRea != other.hCoursRea)
			return false;
		if (hTpPrev != other.hTpPrev)
			return false;
		if (hTpRea != other.hTpRea)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Module [code=" + code + ", libelle=" + libelle + ", hCoursPrev=" + hCoursPrev + ", hCoursRea="
				+ hCoursRea + ", hTpPrev=" + hTpPrev + ", hTpRea=" + hTpRea + ", discipline=" + discipline
				+ ", coeffTest=" + coeffTest + ", coeffCC=" + coeffCC + "]";
	}
	
	public void addEnseignement(Enseignement enseignement) 
	{
		this.enseignement.add(enseignement);
    }

	
}
