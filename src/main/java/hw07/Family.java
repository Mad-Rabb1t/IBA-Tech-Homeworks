package hw07;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children = new Human[1];
    private Integer cld_index = 0;
    protected Pet pet;


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

//    public Human[] getChildren() {
//        return children;
//    }
//
//    public void setChildren(Human[] children) {
//        this.children = children;
//    }

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
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
            if (children[index]!=null){
                if(index == children.length - 1){
                    Human[] temp = new Human[children.length -1];
                    System.arraycopy(children,0,temp,0,children.length - 1);
                    children = temp;
                } else {
                    Human[] temp = new Human[children.length - 1];
                    System.arraycopy(children,0,temp,0, index);
                    System.arraycopy(children,index+1, temp, index, children.length - index - 1);
                    children = temp;
                }
            cld_index--;
            return true;
        } else{
                System.out.println("Unable to delete the child...");
            }
        } catch (Exception ex) {
            System.out.println("Unable to delete the child...");
        }
        return false;
    }

    public boolean deleteChild(Human child) {
        try {
            for (int i = 0; i < children.length; i++) {
//                if (children[i].hashCode() == child.hashCode()) {
                    if (children[i].equals(child)) {
//                        children[i] = null;
                        if(i == children.length - 1){
                            Human[] temp = new Human[children.length -1];
                            System.arraycopy(children,0,temp,0,children.length - 1);
                            children = temp;
                        } else {
                            Human[] temp = new Human[children.length - 1];
                            System.arraycopy(children,0,temp,0, i);
                            System.arraycopy(children,i+1, temp, i, children.length - i - 1);
                            children = temp;
                        }

                        cld_index--;
                        return true;
                    }
//                }
            }

        } catch ( Exception ex) {
            System.out.println("Error occurred");
        }
        System.out.println("Unable to delete the child...");
        return false;
    }

    public int countFamily() {
        int count = 0;
        for (Human child : children) {
            if (child != null)
                count++;
        }
        return count+2;
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

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family has been deleted...");
        super.finalize();
    }
}