package fr.thomas.ohce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    DetectionPalindrome detectionPalindrome;
    @BeforeEach
    public void init(){
        detectionPalindrome = new DetectionPalindrome(Main.getSystemLanguage(), Main.getCurrentHour());
    }

    // Test de l'affichage de "Bonjour"
    @Test
    public void testBonjour(){
        String result = "";
        if(Main.getCurrentHour() < 18){
            result = (Main.getSystemLanguage().equals(DetectionPalindrome.LANGUAGE_FR)) ? "Bonjour" : "Hello";
        }
        else{
            result = (Main.getSystemLanguage().equals(DetectionPalindrome.LANGUAGE_FR)) ? "Bonsoir" : "Good evening";
        }

        assertTrue(detectionPalindrome.traiter("Test").startsWith(result));
    }

    // Test de l'affichage de "Au revoir"
    @Test
    public void testAuRevoir(){
        String result = "";
        if(Main.getCurrentHour() < 18){
            result = (Main.getSystemLanguage().equals(DetectionPalindrome.LANGUAGE_FR)) ? "Bonne journée" : "Have a good day";
        }
        else {
            result = (Main.getSystemLanguage().equals(DetectionPalindrome.LANGUAGE_FR)) ? "Bonne soirée" : "Have a good evening";
        }

        assertTrue(detectionPalindrome.traiter("Test").endsWith(result));
    }

    // Test de l'inversion
    @Test
    public void testMotInverse(){
        String result = "esarhp";
        assertTrue(detectionPalindrome.traiter("phrase").contains(result));
    }

    // Test de l'affichage de "Bien dit !"
    @Test
    public void testPalindrome(){
        String result = detectionPalindrome.sayIsPalindrome();
        assertTrue(detectionPalindrome.traiter("radar").contains(result));
    }

    // Cas de test N°1
    @Test
    public void testPalindromeAnglaisSoir(){
        String hello = "Good evening";
        String bye = "Have a good evening";
        String wellSaid = "Well said";
        List<String> words = List.of(hello, bye, wellSaid);
        DetectionPalindrome detectionPalindrome1 = new DetectionPalindrome("en", 20);

        for(String word : words){
            assertTrue(detectionPalindrome1.traiter("radar").contains(word));
        }
    }

    // Cas de test N°2
    @Test
    public void testNonPalindromeFrancaisMatin(){
        String hello = "Bonjour";
        String bye = "Bonne journée";
        String wellSaid = "Bien dit";
        List<String> words = List.of(hello, bye, wellSaid);
        DetectionPalindrome detectionPalindrome1 = new DetectionPalindrome("fr", 8);
        for(String word : words){
            if(words.get(words.size() - 1).equals(word)){
                assertFalse(detectionPalindrome1.traiter("test").contains(word));
            }
            else{
                assertTrue(detectionPalindrome1.traiter("test").contains(word));
            }
        }
    }

    // Cas de test N°3
    @Test
    public void testReal(){
        String motATester = "radar";
        String hello = "Bonjour";
        String bye = "Bonne journée";
        String wellSaid = "Bien dit";
        List<String> words = List.of(hello, bye, wellSaid);
        DetectionPalindrome detectionPalindrome = new DetectionPalindrome(Main.getSystemLanguage(), Main.getCurrentHour());
        String result = detectionPalindrome.traiter(motATester);
        for(String word : words){
            assertTrue(result.contains(word));
        }
    }

    // Test de la non présence de saut de ligne
    @Test
    public void noNewLine(){
        assertFalse(detectionPalindrome.traiter("Test").contains("\n"));
    }
}
