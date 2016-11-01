package com.TpJdbc.app;

public class Notation {
	private float moyCC;
	private float moyTest;
	private Module module;
	private Etudiant etudiant;
	
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public float getMoyTest() {
		return moyTest;
	}
	public void setMoyTest(float moyTest) {
		this.moyTest = moyTest;
	}
	public float getMoyCC() {
		return moyCC;
	}
	public void setMoyCC(float moyCC) {
		this.moyCC = moyCC;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etudiant == null) ? 0 : etudiant.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + Float.floatToIntBits(moyCC);
		result = prime * result + Float.floatToIntBits(moyTest);
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
		Notation other = (Notation) obj;
		if (etudiant == null) {
			if (other.etudiant != null)
				return false;
		} else if (!etudiant.equals(other.etudiant))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (Float.floatToIntBits(moyCC) != Float.floatToIntBits(other.moyCC))
			return false;
		if (Float.floatToIntBits(moyTest) != Float.floatToIntBits(other.moyTest))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Notation [moyCC=" + moyCC + ", moyTest=" + moyTest + ", module=" + module + ", etudiant=" + etudiant
				+ "]";
	}

	
	
}
