/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author santi
 */
public class Starter {
    
    private ArrayList<Person> clientes;

    public Starter() {
        this.clientes = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        Vet v = new Vet();
        
    }
    
    public void addClietne(String name, String id){
        clientes.add(new Person(name, id));
    }
    
    
    public void readPets(Vet v) throws FileNotFoundException, IOException{
        BufferedReader bf = new BufferedReader(new FileReader("pets.txt"));
        String line;
        while((line = bf.readLine()) != null){
            String[] mascota = line.split(" ");
            
            //ID repetido
            boolean rep = false;
            for(int i = 0; i < v.getDogs().size(); i++) if(v.getDogs().get(i).getId().equals(mascota[1])) rep = true;
            for(int i = 0; i < v.getCats().size(); i++) if(v.getCats().get(i).getId().equals(mascota[1])) rep = true;
            for(int i = 0; i < v.getHamsters().size(); i++) if(v.getHamsters().get(i).getId().equals(mascota[1])) rep = true;
            
            if(rep){
                System.out.println("IllegalArgumentException");
                String line2 = bf.readLine();
            }
            else{
                //Agrega la mascota a la veterinaria
                if(mascota[0] == "Dog") v.addDog(mascota[1], mascota[2], mascota[3], mascota[4]);
                else if(mascota[0] == "Cat") v.addCat(mascota[1], mascota[2], mascota[3], Boolean.parseBoolean(mascota[4]));
                else v.addHamster(mascota[1], mascota[2], mascota[3], Double.parseDouble(mascota[4]));
                //Lee Dueño
                String line2 = bf.readLine();
                String[] owner = line2.split(" ");
                
                rep = false;
                for(int i = 0; i < this.clientes.size(); i++) if(this.clientes.get(i).getId().equals(owner[1])) rep = true;

                if(rep){
                    System.out.println("IllegalArgumentException");
                }
                else{
                    //Mira si existe el dueño
                    boolean existeOwner = false;
                    for(int i = 0; i < this.clientes.size(); i++){
                        if(this.clientes.get(i).getName().equals(owner[0])){
                            //Como sí existe le agrega una mascota
                            existeOwner = true;
                            if(mascota[0] == "Dog") this.clientes.get(i).addDog(mascota[1], mascota[2], mascota[3], mascota[4]);
                            else if(mascota[0] == "Cat") this.clientes.get(i).addCat(mascota[1], mascota[2], mascota[3], Boolean.parseBoolean(mascota[4]));
                            else this.clientes.get(i).addHamster(mascota[1], mascota[2], mascota[3], Double.parseDouble(mascota[4]));
                        }
                    }
                    if(!existeOwner){
                        //Como no existe, lo creo y ahí si se lo agrego
                        addClietne(owner[0], owner[1]);
                        if(mascota[0] == "Dog") this.clientes.get(clientes.size() - 1).addDog(mascota[1], mascota[2], mascota[3], mascota[4]);
                        else if(mascota[0] == "Cat") this.clientes.get(clientes.size() - 1).addCat(mascota[1], mascota[2], mascota[3], Boolean.parseBoolean(mascota[4]));
                        else this.clientes.get(clientes.size() - 1).addHamster(mascota[1], mascota[2], mascota[3], Double.parseDouble(mascota[4]));
                    }
                    
                }
            }
        }
    }
    
    public void saveInfoPets(Vet v) throws FileNotFoundException{
        PrintStream out = new PrintStream(new File("pets.txt"));
        for(int i = 0; i < clientes.size(); i++){
            String[] pet = new String[4];
            String[] ow = {clientes.get(i).getId(), clientes.get(i).getName()};
            for(int j = 0; j < clientes.get(i).getDogs().size(); i++){
                out.print("Dog");
                pet[0] = clientes.get(i).getDogs().get(j).getId();
                pet[1] = clientes.get(i).getDogs().get(j).getName();
                pet[2] = clientes.get(i).getDogs().get(j).getHairColor();
                pet[3] = clientes.get(i).getDogs().get(j).getBreed();
                printIn(out, pet, 4);
                printIn(out, ow, 2);
            }
            for(int j = 0; j < clientes.get(i).getCats().size(); i++){
                System.out.println("Cat");
                pet[0] = clientes.get(i).getCats().get(j).getId();
                pet[1] = clientes.get(i).getCats().get(j).getName();
                pet[2] = clientes.get(i).getCats().get(j).getHairColor();
                pet[3] = String.valueOf(clientes.get(i).getCats().get(j).isIsHunter());
                printIn(out, pet, 4);
                printIn(out, ow, 2);
            }
            for(int j = 0; j < clientes.get(i).getHamsters().size(); i++){
                System.out.println("Hamster");
                pet[0] = clientes.get(i).getHamsters().get(j).getId();
                pet[1] = clientes.get(i).getHamsters().get(j).getName();
                pet[2] = clientes.get(i).getHamsters().get(j).getHairColor();
                pet[3] = String.valueOf(clientes.get(i).getHamsters().get(j).getWeight());
                printIn(out, pet, 4);
                printIn(out, ow, 2);
            }
            
        }
    }
    
    public void printIn(PrintStream pr, String[] cad, int tam){
        for(int i = 0; i < tam ; i++){
            pr.print(cad + " ");
        }
    }
    
    public void manageVet(Vet v, String action){
        String[] path = action.split(" ");
        switch (path[0]){
            case "1" : 
                //Busca el Id y lo elimina
                for(int i = 0; i < v.getDogs().size(); i++) if(v.getDogs().get(i).getId().equals(path[1])) v.getDogs().remove(i);
                for(int i = 0; i < v.getCats().size(); i++) if(v.getCats().get(i).getId().equals(path[1]))  v.getCats().remove(i);
                for(int i = 0; i < v.getHamsters().size(); i++) if(v.getHamsters().get(i).getId().equals(path[1]))  v.getHamsters().remove(i);
            break;
            case "2" : 
                for(int i = 0; i < this.clientes.size(); i++){
                    if(this.clientes.get(i).getId().equals(path[1])){
                        //Como sí existe le agrega una mascota
                        System.out.println("");
                            
                    }
                }
            break;
            
            case "3" :
                
                switch(path[1]){
                    case "Dog" : 
                        System.out.println("Perros");
                        for(int i = 0; i < v.getDogs().size(); i++){
                            System.out.print(v.getDogs().get(i).getId()+ " ");
                            System.out.print(v.getDogs().get(i).getName() + " ");                            
                            System.out.print(v.getDogs().get(i).getHairColor()+ " ");
                            System.out.print(v.getDogs().get(i).getBreed()+ " ");
                        }
                    break;  
                    case "Cat" : 
                        System.out.println("Gatos");
                        for(int i = 0; i < v.getDogs().size(); i++){
                            System.out.print(v.getCats().get(i).getId()+ " ");
                            System.out.print(v.getCats().get(i).getName() + " ");                            
                            System.out.print(v.getCats().get(i).getHairColor()+ " ");
                            System.out.print(v.getCats().get(i).isIsHunter()+ " ");
                        }
                    break; 
                    case "Hamster" : 
                        System.out.println("Hamsters");
                        for(int i = 0; i < v.getDogs().size(); i++){
                            System.out.print(v.getHamsters().get(i).getId()+ " ");
                            System.out.print(v.getHamsters().get(i).getName() + " ");                            
                            System.out.print(v.getHamsters().get(i).getHairColor()+ " ");
                            System.out.print(v.getHamsters().get(i).getWeight()+ " ");
                        }
                    break; 
                }
                    
            break;
            
            case "4" :
                
            break;
        }
    }
}
