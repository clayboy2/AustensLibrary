/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author austenclay
 */
public class Encrypt {
    
    public static String encrpyt(String key, String phrase)
    {
        String toReturn = null;
        if (key.length()==0||phrase.length()==0)
        {
            return toReturn;
        }
        toReturn = "";
        for (int i = 0, c = 0; i<phrase.length();i++,c++)
        {
            try
            {
                key.charAt(c);
            }
            catch (Exception e)
            {
                c = 0;
            }
            int one = (int)phrase.charAt(i);
            int two = (int)key.charAt(c);
            if (i%2==0)
            {
                int res = one + two;
                char resChar = (char)res;
                toReturn += resChar;
            }
            else
            {
                int res = one - two;
                char resChar = (char)res;
                toReturn += resChar;
            }
        }
        return toReturn;
    }
    
    public static String decrypt(String key, String phrase)
    {
        String toReturn = null;
        if (key.length()==0||phrase.length()==0)
        {
            return toReturn;
        }
        for (int i = 0, c = 0; i < phrase.length();i++,c++)
        {
            int one = (int)phrase.charAt(i);
            int two = (int)key.charAt(c);
            if (i%2==0)
            {
                int res = one - two;
                char resChar = (char)res;
                toReturn += resChar;
            }
            else
            {
                int res = one + two;
                char resChar = (char)res;
                toReturn += resChar;
            }
        }
        return toReturn;
    }
}
