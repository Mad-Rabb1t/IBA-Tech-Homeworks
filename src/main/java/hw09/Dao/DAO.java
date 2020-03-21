package hw09.Dao;

import hw09.Entities.Family;

import java.util.ArrayList;

public interface DAO<E> {
    ArrayList<E> getAllFamilies();
    E getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family fam);
    void saveFamily(Family fam);
}
