/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.util.*;

/**
 *
 * @author santi
 */
public class Vet {
    private ArrayList<Dog> dogs;
    private ArrayList<Cat> cats;
    private ArrayList<Hamster> hamsters;

    public Vet() {
        dogs = new ArrayList<>();
        cats = new ArrayList<>();
        hamsters = new ArrayList<>();
    }
    
    
    public void addDog(String id, String name, String hairColor, String breed){
        dogs.add(new Dog(breed, id, name, hairColor));
    }
    
    public void addCat(String id, String name, String hariColor, boolean isHunter){
        cats.add(new Cat(isHunter, id, name, hariColor));
    }
    
    public void addHamster(String id, String name, String hairColor, double weight){
        hamsters.add(new Hamster(weight, id, name, hairColor));
    }

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public ArrayList<Cat> getCats() {
        return cats;
    }

    public ArrayList<Hamster> getHamsters() {
        return hamsters;
    }

    public void setDogs(ArrayList<Dog> dogs) {
        this.dogs = dogs;
    }

    public void setCats(ArrayList<Cat> cats) {
        this.cats = cats;
    }

    public void setHamsters(ArrayList<Hamster> hamsters) {
        this.hamsters = hamsters;
    }
    
    
    
    
    
}
