package asuender;

import java.util.*;

/**
 * @author Andreas Suender
 * @version 05-12-2022
 */
public class RegexTest {
    public static void main(String[] args) {
        Regex regex = new Regex();
        regex.setRegex("^(http(s?):\\/\\/)?(((www\\.)?+[a-z0-9\\.\\-\\_]+(\\.[a-z]{2,3})+)|(\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b))(\\/[a-z0-9\\_\\-\\s\\.\\/\\?\\%\\#\\&\\=]*)?$");

        List<String> urls = Arrays.asList(
            "www.ibm.com",
            "www.java.sun.com",
            "www.zend.com",
            "java.sun.com",
            "www.php.net",
            "www.IBM.com",
            "www.ris.bka.gv.at",
            "www.Web addresses can't have spaces.com",
            "www..com",
            "192.168.1.0",
            "192.168.1.256",
            "256.1.1.1",
            "172.435.123.123",
            "192.192.258.192"
        );

        regex.setStrings(urls);

        for (int i = 0; i < urls.size(); i++) {
            System.out.println(urls.get(i) + ": " + regex.match(i));
        }
    }
}
