/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

public class Etudiant {
    private String nom, prenom;
    private int age;
    private double moyenne;
    private ArrayList<Integer> notes = new ArrayList<Integer>();
    
    public Etudiant(String _nom, String _prenom, int _age) {
	nom = _nom;
	prenom = _prenom;
	age = _age;
        
    } 
    
     public double getMoyenne()
    {
        moyenne = this.moyenne();
        return moyenne;
    }
    
    public void ajouterNote(int n){
        notes.add(n);
                }
   
    public double moyenne(){
        double somme = 0;
        if(notes.size() == 0) return 0.0;
        for(int n:notes){
            somme += n;
        }
        return somme/notes.size();
    }
    
    public String toString()
    {
       // return nom+","+prenom+","+age+"ans : notes "+notes+"Moyenne :"+this.moyenne();
        String retour = "";
            retour = retour + "Nom : " + nom + "   ";
            retour = retour + "Prénom : " + prenom + "   ";
            retour = retour + "Age : " + age + "  ";
            retour = retour +"Notes : "+notes+"  ";
            retour = retour +"Moyenne : "+getMoyenne()+"\n";
            return retour;
        
    }
    
   
    
    /*public static void main(String args[]){
        ArrayList<Etudiant> listeEtud = new ArrayList<Etudiant>();
        listeEtud.add(new Etudiant("Roger", "Rabbit", 22));
        listeEtud.add (new Etudiant("Mickey", "Mouse", 30));
        listeEtud.add (new Etudiant("Bibi", "Phoque", 20));       
       System.out.println("Etudiants: ");
       System.out.println(listeEtud);
    }*/
}
