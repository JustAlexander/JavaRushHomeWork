package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;


/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        if (args.length != 2)
            return;
        Charset w1251 = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");
        InputStream file = new FileInputStream(args[0]);
        BufferedInputStream inputStream = new BufferedInputStream(file);
        OutputStream outFile = new FileOutputStream(args[1]);
        BufferedOutputStream outputStream = new BufferedOutputStream(outFile);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String s = new String(buffer, utf);
        buffer = s.getBytes(w1251);
        outputStream.write(buffer);
        inputStream.close();
        outputStream.close();
        file.close();
        outFile.close();
    }
}
