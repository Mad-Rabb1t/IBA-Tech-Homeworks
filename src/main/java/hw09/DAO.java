package hw09;

import java.util.ArrayList;

interface DAO<E> {
    ArrayList<E> getAllFamilies();
    E getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family fam);
    void saveFamily(Family fam);
}
