package com.company;

import java.net.URL;
import java.util.Scanner;
import java.util.Random;

public class MovieTitleGen
{
    public static void main(String[] args) throws Exception
    {
        Random rand = new Random();
        String[] adjectives = arrayFromUrl("https://cs.leanderisd.org/txt/adjectives.txt");
        String[] nouns      = arrayFromUrl("https://cs.leanderisd.org/txt/nouns.txt");
        int adjIndex = rand.nextInt(adjectives.length-1);
        int nounIndex = rand.nextInt(nouns.length-1);

        System.out.println("Myxyllplyk's Random Movie Title Generator\n");

        System.out.print("Choosing randomly from " + adjectives.length + " adjectives ");
        System.out.println("and " + nouns.length + " nouns (" + (adjectives.length*nouns.length) + " combinations).");

        String adjective =adjectives[adjIndex];
        String noun = nouns[adjIndex];;

        System.out.println( "Your movie title is: " + adjective + " " + noun );
    }

    /**
     *	@param url - the URL to read words from
     *	@return An array of words, initialized from the given URL
     */
    public static String[] arrayFromUrl( String url ) throws Exception
    {
        Scanner fin = new Scanner((new URL(url)).openStream());
        int count = fin.nextInt();

        String[] words = new String[count];

        for ( int i=0; i<words.length; i++ )
        {
            words[i] = fin.next();
        }
        fin.close();

        return words;
    }

}