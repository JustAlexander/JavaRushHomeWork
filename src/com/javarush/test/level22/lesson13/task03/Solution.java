package com.javarush.test.level22.lesson13.task03;


/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        return (telNumber.matches("^\\+(?=(.*\\d){12})(?!(.*\\d){13,})[\\d\\-()]+$") || telNumber.matches("^\\d(?=(.*\\d){9})(?!(.*\\d){10,})[\\d\\-()]+$") ||
                telNumber.matches("^\\((?=(.*\\d){10})(?!(.*\\d){11,})[\\d\\-()]+$") || telNumber.matches("^\\-(?=(.*\\d){10})(?!(.*\\d){11,})[\\d\\-()]+$")) &&
                telNumber.matches("[^-]*-\\d[^-]*(?:[^-]*-\\d[^-]*)?|.[^-]*") && telNumber.matches("([^()-]*\\(\\d{3}\\)[^()]*)|(.[^()]*)") &&
                telNumber.matches("[\\d\\-()+]*") && telNumber.matches(".*\\d$");
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567")+ " true");
        System.out.println(checkTelNumber("+38(050)1234567-")+ " false");
        System.out.println(checkTelNumber("+38050(123)(456)7")+ " false");
        System.out.println(checkTelNumber("++380501234567")+ " true");
        System.out.println(checkTelNumber("(380)501234567")+ " false");
        System.out.println(checkTelNumber("+38050123--4567")+ " false");
        System.out.println(checkTelNumber("050123--4567")+ " false");
        System.out.println(checkTelNumber("0-50123-4567")+ " true");
        System.out.println(checkTelNumber("+38)050(1234567")+ " false");
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7")+ " false");
        System.out.println(checkTelNumber("050���4567")+ " false");
        System.out.println(checkTelNumber("050123456")+ " false");
        System.out.println(checkTelNumber("(0)501234567")+ " false");
        System.out.println(checkTelNumber("+38-(050)1234567")+ " false");
        System.out.println(checkTelNumber("+38((050)1234567")+ " false");
        System.out.println(checkTelNumber("+5(0--5)1234567")+ " false");
        System.out.println(checkTelNumber("1-23456789-0")+ " false");
        System.out.println(checkTelNumber("+38051202(345)-7")+ " true");
        System.out.println(checkTelNumber("+38051202(345)7")+ " true");
        System.out.println(checkTelNumber("(345)0512027")+ " true");
        System.out.println(checkTelNumber("+-313450531202")+ " true");
        System.out.println(checkTelNumber("+313450--531202")+ " false");
        System.out.println(checkTelNumber("38xx501A34567")+ " false");
        System.out.println(checkTelNumber("3805012345")+ " true");
        System.out.println(checkTelNumber("+38(0501234567")+ " false");
        System.out.println(checkTelNumber("+38(050)1234567")+ " true");
        System.out.println(checkTelNumber("+38(05)1234567")+ " false");
        System.out.println(checkTelNumber("(3)80501234567")+ " false");
        System.out.println(checkTelNumber("380-50123-45")+ " true");
        System.out.println(checkTelNumber("(380)501-234567")+ " false");
        System.out.println(checkTelNumber("(38-0)501234567")+ " false");
        System.out.println(checkTelNumber("380-(501)234567")+ " false");
        System.out.println(checkTelNumber("380(50-1)234567")+ " false");
        System.out.println(checkTelNumber("380(501)(23)4567")+ " false");
        System.out.println(checkTelNumber("+38050123(456)7")+ " true");
        System.out.println(checkTelNumber("+38050123(456)76")+ " false");
        System.out.println(checkTelNumber("+380501234(567)")+ " false");
        System.out.println(checkTelNumber("3-805-0123-45")+ " false");
        System.out.println("-3805-012345" + checkTelNumber("-3805-012345")+ " true");
        System.out.println(checkTelNumber("3805-012345-")+ " false");
        System.out.println(checkTelNumber("+38(05)01234567")+ " false");
        System.out.println(checkTelNumber("+38(0501)234567")+ " false");
        System.out.println(checkTelNumber("+38050123-45-67")+ " true");
        System.out.println(checkTelNumber("050123-4567")+ " true");
        System.out.println(checkTelNumber("7-4-4123689-5")+ " false");
        System.out.println(checkTelNumber("+313450--531202�")+ " false");
        System.out.println(checkTelNumber("AB")+ " false");
        System.out.println(checkTelNumber("1AB1")+ " false");
        System.out.println(checkTelNumber("ab")+ " false");
        System.out.println(checkTelNumber("1ab1")+ " false");
        System.out.println(checkTelNumber("aB")+ " false");
        System.out.println(checkTelNumber("1aB1")+ " false");
        System.out.println(checkTelNumber("12345678910")+ " false");
        System.out.println(checkTelNumber("+38")+ " false");
        System.out.println(checkTelNumber("-12345678910")+ " true");


    }
}
