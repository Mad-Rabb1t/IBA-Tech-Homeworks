package hw11.Dao;

import hw11.Entities.Family;

import java.util.ArrayList;

public class CollectionFamilyDao implements DAO<Family> {

    ArrayList<Family> families = new ArrayList<>();


    @Override
    public ArrayList<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        try{ families.remove(index);
            return true;
        }
        catch (Exception ex) {
            System.out.println("Unable to delete family!");
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family fam) {
        try{
            families.remove(fam);
            return true;
        } catch (Exception ex){
            System.out.println("Unable to delete family!");
        }
        return false;
    }

    @Override
    public void saveFamily(Family fam) {
        boolean familyFound = false;
        for (int i =0; i < families.size(); i++) {
            if(families.get(i).hashCode()==fam.hashCode()){
                if(families.get(i).equals(fam)){
                    families.set(i,fam);
                    familyFound = true;
                }
            }
        }
        if(!familyFound){
            families.add(fam);
        }

    }
}
