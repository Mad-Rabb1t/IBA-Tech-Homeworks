package hw11.Service;

import hw11.Dao.CollectionFamilyDao;
import hw11.Dao.DAO;
import hw11.Entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FamilyService {
    DAO<Family> dao = new CollectionFamilyDao();

    public ArrayList<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public void displayAllFamilies() {
        System.out.println("Families: ");
        dao.getAllFamilies().forEach(System.out::println);
    }

    public ArrayList<Family> getFamiliesBiggerThan(int size) {
        return (ArrayList<Family>) dao.getAllFamilies().stream().filter(family -> family.countFamily() > size)
                .collect(Collectors.toList());
    }

    public ArrayList<Family> getFamiliesLessThan(int size) {
        return (ArrayList<Family>) dao.getAllFamilies().stream().filter(family -> family.countFamily() < size)
                .collect(Collectors.toList());
    }

    public ArrayList<Family> countFamiliesWithMemberNumber(int size) {
        return (ArrayList<Family>) dao.getAllFamilies().stream().filter(family -> family.countFamily() == size)
                .collect(Collectors.toList());
    }

    public void createNewFamily(Human dad, Human mom) {
        Family fam = new Family(dad, mom);
        dad.setFamily(fam);
        mom.setFamily(fam);
        dao.saveFamily(fam);
    }

    public boolean deleteFamilyByIndex(int index) {
        return dao.deleteFamily(index);
    }

    public Family bornChild(Family fam, String gender, String cld_name) {
        gender = gender.toLowerCase().trim();
        switch (gender) {
            case ("feminine"):

            case ("girl"): {
                fam.addChild(new Woman(cld_name, fam.getFather().getSurname(), LocalDate.now(), fam));
                break;
            }

            case ("masculine"):

            case ("boy"): {
                fam.addChild(new Man(cld_name, fam.getFather().getSurname(), LocalDate.now(), fam));
                break;
            }

            default:
                System.out.println("Unable to create a child! Please enter valid parameters");
        }

        dao.saveFamily(fam);
        return fam;
    }

    public Family adoptChild(Family fam, Human cld) {
        cld.setFamily(fam);
        fam.addChild(cld);
        dao.saveFamily(fam);
        return fam;
    }

    public void deleteAllChildrenOlderThan(int age) {
        dao.getAllFamilies().forEach(family -> family.getChildren().removeIf(human -> human.getAge() > age));
    }

    public int count() {
        return dao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return dao.getFamilyByIndex(index);
    }

    public ArrayList<Pet> getPets(int index) {
        return new ArrayList<>(dao.getFamilyByIndex(index).getPet());
    }

    public void addPet(int index, Pet pet) {
        Family fam = dao.getFamilyByIndex(index);
        fam.setPet(pet);
        dao.saveFamily(fam);
    }
}
