package hw13.Dao;

import hw13.Entities.Family;

import java.util.ArrayList;

public interface DAO<E> {
    ArrayList<E> getAllFamilies();
    E getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family fam);
    void saveFamily(Family fam);
}
