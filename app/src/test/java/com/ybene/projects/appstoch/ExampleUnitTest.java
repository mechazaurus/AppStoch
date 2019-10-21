package com.ybene.projects.appstoch;

import com.ybene.projects.appstoch.calcul.CalculFile;
import com.ybene.projects.appstoch.calcul.Unites;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void aviation() {
        CalculFile file2 = new CalculFile(50, Unites.SECONDES, 60, Unites.SECONDES, 2, 0);
        CalculFile file3 = new CalculFile(50, Unites.SECONDES, 60, Unites.SECONDES, 3, 0);
        CalculFile file4 = new CalculFile(50, Unites.SECONDES, 60, Unites.SECONDES, 4, 0);
        afficher(file2);
        afficher(file3);
        afficher(file4);
        Assert.assertTrue(true);
    }

    private void afficher(CalculFile file){
        System.out.println("S = "+file.getS()+"     q0 = "+file.getQ0()+"     L = "+file.getL());
    }

    @Test
    public void pompe() {
        CalculFile file = new CalculFile(10, Unites.CPH, 5, Unites.MINUTES, 1, 0);
        System.out.println(file.getQ0());
        System.out.println(file.getLq());
        System.out.println(file.getWq());
        System.out.println(file.getPsejour(600));
        Assert.assertTrue(true);
    }

}