package hw12.Controller;

import hw12.Entities.Family;
import hw12.Entities.FamilyOverflowException;
import hw12.Entities.Human;
import hw12.Entities.Pet;
import hw12.Service.FamilyService;

import java.util.ArrayList;

public class FamilyController {

    private FamilyService serv = new FamilyService();

    public ArrayList<Family> getAllFamilies() {
        return serv.getAllFamilies();
    }

    public void displayAllFamilies() {
        serv.displayAllFamilies().forEach(family -> System.out.println(family.prettyFormat()));
    }

    public ArrayList<Family> getFamiliesBiggerThan(int size) {
        return serv.getFamiliesBiggerThan(size);
    }

    public ArrayList<Family> getFamiliesLessThan(int size) {
        return serv.getFamiliesLessThan(size);
    }

    public int countFamiliesWithMemberNumber(int size) {
        return serv.countFamiliesWithMemberNumber(size);
    }

    public void createNewFamily(Human dad, Human mom) {
        serv.createNewFamily(dad, mom);
    }

    public boolean deleteFamilyByIndex(int index) {
        try {
            serv.deleteFamilyByIndex(index);
            return true;
        } catch (IllegalArgumentException ex) {
            ex.getMessage();
            return false;
        }
    }

    public void bornChild(Family fam, String boy_name, String girl_name) {
        if (fam.countFamily() >= 10) throw new FamilyOverflowException("This family has too many children!");
        serv.bornChild(fam, boy_name, girl_name);
    }

    public void adoptChild(Family fam, Human cld) {
        if (fam.countFamily() >= 10) throw new FamilyOverflowException("This family has too many children!");
        serv.adoptChild(fam, cld);
    }

    public void deleteAllChildrenOlderThan(int age) {
        serv.deleteAllChildrenOlderThan(age);
    }

    public int count() {
        return serv.count();
    }

    public Family getFamilyById(int index) {
        return serv.getFamilyById(index);
    }

    public ArrayList<Pet> getPets(int index) {
        return serv.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        serv.addPet(index, pet);
    }
}
