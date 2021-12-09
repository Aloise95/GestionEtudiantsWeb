/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

public class Promotion {
    private String nom;
    private ArrayList<Etudiant>listEtud=new ArrayList<Etudiant>();
    
    
    public Promotion(String _nom)
    {      
	nom=_nom;     
    }

    public  void ajouterEtud(Etudiant e){
        listEtud.add(e);
    }
    
    private double moyenne(){
        double somme=0.0;
            if(listEtud.size()==0) return 0.0;
            for(Etudiant e:listEtud)
                somme +=e.moyenne();
        return somme/listEtud.size();
    }
    
    public String getNom() {
        return nom;
    }
    
    public String toString(){
    String s=new String();
    s += this.nom+"\n";
    for(Etudiant e:listEtud)    
        s +=e +"\n";
        s +="Moyenne generale : \n"+this.moyenne()+"\n";
    return s;
    }
    
    public Etudiant meilleurEtudiant() {
        Etudiant best = null;
        double bestMoyenne = 0;
        for(Etudiant e:listEtud)
            if (e.moyenne() > bestMoyenne) {
                best = e;
                bestMoyenne = e.moyenne();
            }
        return best;
    }

    /*public static void main(String args[]) {
        Promotion p2016 = new Promotion(2016);
        Etudiant et1 = new Etudiant("Roger", "Rabbit", 22);
        Etudiant et2 = new Etudiant("Mickey", "Mouse", 30);
        Etudiant et3 = new Etudiant("Bibi", "Phoque", 20); 
        p2016.ajouterEtud(et1);
        p2016.ajouterEtud(et2);
        p2016.ajouterEtud(et3);
        et1.ajouterNote(14);
        et1.ajouterNote(11);
        et2.ajouterNote(15);
        et3.ajouterNote(15);
        et3.ajouterNote(12);
        System.out.println(p2016);
    }*/
    
}



/* commentaire test */