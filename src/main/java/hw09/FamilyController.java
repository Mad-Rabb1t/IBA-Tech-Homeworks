package hw09;

import java.util.ArrayList;

public class FamilyController {

    FamilyService serv = new FamilyService();

    public ArrayList<Family> getAllFamilies() {
        return serv.getAllFamilies();
    }

    public void displayAllFamilies() {
        serv.displayAllFamilies();
    }

    public ArrayList<Family> getFamiliesBiggerThan(int size) {
        return serv.getFamiliesBiggerThan(size);
    }

    public ArrayList<Family> getFamiliesLessThan(int size) {
        return serv.getFamiliesLessThan(size);
    }

    public ArrayList<Family> countFamiliesWithMemberNumber(int size) {
        return serv.countFamiliesWithMemberNumber(size);
    }

    public void createNewFamily(Human dad, Human mom) {
        serv.createNewFamily(dad, mom);
    }

    public boolean deleteFamilyByIndex(int index) {
        return serv.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family fam, String gender, String cld_name) {
        return serv.bornChild(fam, gender, cld_name);
    }

    public Family adoptChild(Family fam, Human cld) {
        return serv.adoptChild(fam, cld);
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
