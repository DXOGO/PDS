//package pds_2021_111.lab01;

public class StringSizeComp implements java.util.Comparator<String> {

    public int compare(String s1, String s2) {
        return s2.length() - s1.length(); // ordena por ordem decrescente de tamanho
    } 
    
}