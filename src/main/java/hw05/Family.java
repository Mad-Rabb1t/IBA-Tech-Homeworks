package hw05;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children = new Human[1];
    private Integer cld_index = 0;
    private Pet pet;

    public Family(Human father, Human mother, Pet pet) {
        this.father = father;
        this.mother = mother;
        this.pet = pet;
        father.setFamily(this);
        mother.setFamily(this);
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public void greetPet() {
        System.out.printf("Hello, %s\n", this.pet.getNickname());
    }

    public void describePet() {
        System.out.printf("I have a %s, he is %d years old, he is ", pet.getSpecies(), pet.getAge());
        if (pet.getTrickLevel() < 50) System.out.println("almost not sly.");
        else System.out.println("very sly");
    }

    public void addChild(Human child) {
        if(cld_index == children.length) {
            children = Arrays.copyOf(children,children.length+1);
        }
        children[cld_index] = child;
        cld_index++;
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        try {
            for (; index - 1 < children.length - 1; index++) {
                children[index - 1] = children[index];
            }
            cld_index--;
        } catch (Exception ex) {
            System.out.println("Unable to delete the child ");
            return false;
        }
        return true;
    }

    public boolean deleteChild(Human child) {
        try {
            for (int i = 0; i < children.length - 1; i++) {
                if (children[i].hashCode() == child.hashCode()) {
                    if (children[i].equals(child)) {
                        if (children.length - 1 - i >= 0)
                            System.arraycopy(children, i + 1, children, i, children.length - 1 - i);
                    } else return false;
                } else return false;
            }
            cld_index--;
        } catch (Exception ex) {
            System.out.println("Unable to delete the child ");
        }
        return true;
    }

    public int countFamily() {
        return children.length + 2;
    }

    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}", mother, father, Arrays.toString(children), pet);
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
