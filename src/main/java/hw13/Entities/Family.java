package hw13.Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private ArrayList<Human> children = new ArrayList<>();
    protected HashSet<Pet> pets = new HashSet<>();

    public Family(Human father, Human mother, HashSet<Pet> pets) {
        this.father = father;
        this.mother = mother;
        this.pets = pets;
        father.setFamily(this);
        mother.setFamily(this);
    }

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        father.setFamily(this);
        mother.setFamily(this);
    }

    public Human getFather() {
        return father;
    }

    public HashSet<Pet> getPet() {
        return pets;
    }

    public void setPet(Pet pet) {
        this.pets.add(pet);
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void describePet() {
        for (Pet pet : pets) {
            System.out.printf("I have a %s, he is %d years old, he is ", pet.getSpecies(), pet.getAge());
            if (pet.getTrickLevel() < 50) System.out.println("almost not sly.");
            else System.out.println("very sly");
        }

    }

    public void addChild(Human child) {
        children.add(child);
    }

    public boolean deleteChild(int index) {
        try {
            children.remove(index);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean deleteChild(Human child) {
        try {
            children.remove(child);
        } catch (Exception ex) {
            System.out.println("Error occurred");
        }
        System.out.println("Unable to delete the child...");
        return false;
    }

    public int countFamily() {
        return children.size() + 2;
    }

    public String prettyFormat(){
        StringBuilder children = new StringBuilder();
        for (Human cld: this.children){
            children.append("\n               ");
            if(cld instanceof Woman) children.append("girl: ").append(cld.prettyFormat());
            else children.append("boy: ").append(cld.prettyFormat());
        }
        StringBuilder pets = new StringBuilder();
        pets.append("pets: ");
        this.pets.forEach(pet -> pets.append(pet.prettyFormat()));
        return String.format("family:\n       mother: %s,\n       father: %s,\n       children:%s\n       %s\n",
                mother.prettyFormat(), father.prettyFormat(), children, pets);
    }

    public String dbFormat(){
        StringBuilder cld = new StringBuilder();
        this.children.forEach(child -> cld.append(child.dbFormat()).append("~cld~"));
        StringBuilder pts = new StringBuilder();
        pets.forEach(pet -> pts.append(pet.dbFormat()).append("~pet~") );
        return String.format("%s~D~%s~D~%s~D~%s\n",
                mother.dbFormat(), father.dbFormat(), cld, pts);
    }

    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}", mother, father, children.toString(), pets.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) &&
                father.equals(family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }
}