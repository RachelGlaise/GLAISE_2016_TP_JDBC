package com.TpJdbc.app;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AssociationNotation {
	private Set<Lien> liens;
	private static AssociationNotation instance;
	
	public void creerLien(Module module, Etudiant etudiant, Notation notation){
		Lien lienTemp = new Lien(module, etudiant);
		  lienTemp.setNotation(notation);
		  liens.add(lienTemp);
	}
	
	public void supprimerLien(Module module, Etudiant etudiant)
	{
		for(Lien li : liens)
			if(li.getModule() == module && li.getEtudiant() == etudiant)
				liens.remove(li);
	}
	
	public void supprimerLien(Lien lien)
	{
		liens.remove(lien);
	}
	
	public Lien getLien(Module module, Etudiant etudiant)
	{
		for(Lien li : liens)
			if(li.getModule() == module && li.getEtudiant() == etudiant)
				return li;
		return null;
	}
	
	public Set<Lien> getLiens(Etudiant etudiant)
	{
		Set<Lien> liensEtu = new HashSet<Lien>();
		for(Lien li : liens)
			if(li.getEtudiant() == etudiant)
				liensEtu.add(li);
		return liensEtu;
	}
	
	public Set<Lien> getLiens(Module module)
	{
		Set<Lien> liensMod = new HashSet<Lien>();
		for(Lien li : liens)
			if(li.getModule() == module)
				liensMod.add(li);
		return liensMod;
	}
	
	public Set<Lien> getLiens() {
		return liens;
	}
	
	public Set<Module> getModules(Etudiant etudiant)
	{
		Set<Module> modules = new HashSet<Module>();
		for(Lien li : liens )
			if(li.getEtudiant() == etudiant) modules.add(li.getModule());
		return modules;		
	}
	
	public Set<Etudiant> getEtudiants(Module module)
	{
		Set<Etudiant> etudiants = new HashSet<Etudiant>();
		for(Lien li : liens )
			if(li.getModule() == module) etudiants.add(li.getEtudiant());
		return etudiants;
	}
	
	public static AssociationNotation getInstance() {
		if (instance == null)
			instance = new AssociationNotation();
		return instance;
	}
	
}
