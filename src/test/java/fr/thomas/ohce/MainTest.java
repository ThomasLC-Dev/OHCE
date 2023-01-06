package fr.thomas.ohce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    DetectionPalindrome detectionPalindrome;

    @BeforeEach
    public void init(){
        detectionPalindrome = new DetectionPalindrome(Main.getSystemLanguage(), Main.getCurrentHour());
    }

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

    @Test
    public void testMotInverse(){
        String result = "esarhp";
        assertTrue(detectionPalindrome.traiter("phrase").contains(result));
    }

    @Test
    public void testPalindrome(){
        String result = detectionPalindrome.sayIsPalindrome();
        assertTrue(detectionPalindrome.traiter("radar").contains(result));
    }

    @Test
    public void testPalindromeAnglaisSoir(){
        String hello = "Good evening";
        String bye = "Have a good evening";
        String wellSaid = "Well said";
        DetectionPalindrome detectionPalindrome1 = new DetectionPalindrome("en", 20);
        assertTrue(detectionPalindrome1.traiter("radar").contains(hello));
        assertTrue(detectionPalindrome1.traiter("radar").contains(bye));
        assertTrue(detectionPalindrome1.traiter("radar").contains(wellSaid));
    }

    @Test
    public void testNonPalindromeFrancaisMatin(){
        String hello = "Bonjour";
        String bye = "Bonne journée";
        String wellSaid = "Bien dit";
        DetectionPalindrome detectionPalindrome1 = new DetectionPalindrome("fr", 8);
        assertTrue(detectionPalindrome1.traiter("test").contains(hello));
        assertTrue(detectionPalindrome1.traiter("test").contains(bye));
        assertFalse(detectionPalindrome1.traiter("test").contains(wellSaid));
    }

    @Test
    public void testReal(){
        String motATester = "radar";
        String hello = "Bonjour";
        String bye = "Bonne journée";
        String wellSaid = "Bien dit";
        DetectionPalindrome detectionPalindrome = new DetectionPalindrome(Main.getSystemLanguage(), Main.getCurrentHour());
        String result = detectionPalindrome.traiter(motATester);
        assertTrue(result.contains(hello));
        assertTrue(result.contains(bye));
        assertTrue(result.contains(wellSaid));
    }

    @Test
    public void noNewLine(){
        assertFalse(detectionPalindrome.traiter("Test").contains("\n"));
    }
}
