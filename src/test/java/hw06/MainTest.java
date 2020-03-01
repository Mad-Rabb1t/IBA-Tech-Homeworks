package hw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void stringTest(){
        Pet max = new Pet(Pet.species.Dog, "Max", 7, 81, new String[]{"play", "bite", "bark"});
        String actual = max.toString();
        String expected = "Dog{nickname = Max, age = 7,trickLevel=81,habits = [play, bite, bark]\n";
        assertEquals(expected,actual);
    }
    @Test
    void addChildTest(){
        Human child = new Human("Kamran","Rzayev",20,100,new String[7][2]);
        Family fam = new Family(new Human(), new Human());
        fam.addChild(child);
        assertEquals("Kamran", fam.getChildren()[0].getName());
        assertEquals(fam,child.getFamily());
    }
    @Test
    void deleteChildTest1(){
        Human child = new Human("Kamran","Rzayev",20,100,new String[7][2]);
        Human child2 = new Human("John","Smith",5,100,new String[7][2]);
        Human child3 = new Human();
        Family fam = new Family(new Human(), new Human());
        fam.addChild(child);
        fam.addChild(child2);
        assertFalse(fam.deleteChild(child3));//non existing child
        assertTrue(fam.deleteChild(child));
        assertEquals(child2,fam.getChildren()[0]);
    }
    @Test
    void deleteChildTest2(){
        Human child = new Human("Kamran","Rzayev",20,100,new String[7][2]);
        Human child2 = new Human("John","Smith",5,100,new String[7][2]);
        Family fam = new Family(new Human(), new Human());
        fam.addChild(child);
        fam.addChild(child2);
        assertFalse(fam.deleteChild(3));
        assertTrue(fam.deleteChild(1));
        assertEquals(child2,fam.getChildren()[0]);
    }
    @Test
    void countFamilyTest(){
        Human child = new Human("Kamran","Rzayev",20,100,new String[7][2]);
        Human child2 = new Human("John","Smith",5,100,new String[7][2]);
        Family fam = new Family(new Human(), new Human());
        fam.addChild(child);
        fam.addChild(child2);
        assertEquals(4, fam.countFamily());
        fam.addChild(new Human());
        assertEquals(5,fam.countFamily());
    }
}
