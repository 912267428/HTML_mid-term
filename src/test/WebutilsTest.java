package test;

import utils.Webutils;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class WebutilsTest {
    public static void main(String[] args) {
        String str="8";
        int de=5;
        int c= Webutils.parseint(str,de);
        System.out.println(c);
    }


}