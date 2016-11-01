package com.TpJdbc.app;

public class Enseignement {
	 	private Etudiant Etudiant;
	    private Module Module;
	    private Prof Prof;
	    


	    @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Etudiant == null) ? 0 : Etudiant.hashCode());
			result = prime * result + ((Module == null) ? 0 : Module.hashCode());
			result = prime * result + ((Prof == null) ? 0 : Prof.hashCode());
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
			Enseignement other = (Enseignement) obj;
			if (Etudiant == null) {
				if (other.Etudiant != null)
					return false;
			} else if (!Etudiant.equals(other.Etudiant))
				return false;
			if (Module == null) {
				if (other.Module != null)
					return false;
			} else if (!Module.equals(other.Module))
				return false;
			if (Prof == null) {
				if (other.Prof != null)
					return false;
			} else if (!Prof.equals(other.Prof))
				return false;
			return true;
		}


		public Module getModule() {
			return Module;
		}
		
	    public Prof getProf() {
	    	return Prof;
	    }
	    
		public Etudiant getEtudiant() {
			return Etudiant;
		}

	    public void setEtudiant(Etudiant etudiant) {
	    	Etudiant = etudiant;
	    }
	    
	    public void setProf(Prof prof) {
	    	Prof = prof;
	    }
	    
	    public void setModule(Module module) {
	    	Module = module;
	    }
	    
	    @Override
		public String toString() {
			return "Enseignement [Etudiant=" + Etudiant + ", Module=" + Module + ", Prof=" + Prof + "]";
		}

}
