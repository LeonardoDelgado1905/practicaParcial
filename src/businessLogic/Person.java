/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class Person {
    private String name;
    private String id;
    
    private ArrayList<Dog> dogs;
    private ArrayList<Cat> cats;
    private ArrayList<Hamster> hamsters;
    
    public Person(String name, String id) {
        this.name = name;
        this.id = id;
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

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
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
