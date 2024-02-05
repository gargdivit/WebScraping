package com.google.search;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class GoogleSearchApp {
    public static void main(String[] args) throws IOException {
        //get the keyword
        Scanner sc=new Scanner(System.in);
        System.out.println("Please provide the keyword: ");
        String keyword=sc.nextLine();

        //search over your preferred search engine
        String url="https://www.google.com/search"+"?q="+ keyword;

        Document doc= Jsoup.connect(url).get();
        String html= doc.html();
        Files.write(Paths.get("D:\\Java scraping\\file.txt"), html.getBytes());

        Elements links = doc.select("cite");

        for (Element link: links){
            System.out.println(link.text());
        }
        sc.close();
    }
}
