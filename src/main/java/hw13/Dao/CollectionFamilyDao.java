package hw13.Dao;

import hw13.Entities.Family;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class CollectionFamilyDao implements DAO<Family> {

    private ArrayList<Family> families = new ArrayList<>();


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
            throw new IllegalArgumentException("Unable to delete family!");
        }
    }

    @Override
    public boolean deleteFamily(Family fam) {
        try{
            families.remove(fam);
            return true;
        } catch (Exception ex){
            throw new IllegalArgumentException("Unable to delete family!");
        }
    }

    @Override
    public void saveFamily(Family fam) {
        int index = families.indexOf(fam);
        if(index != -1){
            families.set(index,fam);
        } else{
            families.add(fam);
        }
    }

    public void saveToDB(){
        File file = new File("bookings.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        String line;
        for (: ) {
            line = String.format();
            bw.write(line);
            bw.write("\n");
        }
        bw.close();
    }
}
