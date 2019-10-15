package com.ybene.projects.appstoch.calcul;

public class CalculFile {
    private double lambda;
    private double mu;
    private int s;
    private int k;

    public CalculFile(double lambda, Unites uniteLambda, double mu, Unites uniteMu, int s, int k) {
        this.lambda = lambda;
        this.mu = mu;
        this.s = s;
        this.k = k;
    }

    private double q0;
    private double w;
    private double l;

    public void compute(){
        if (s>1) computeMMS();
        else if (k>0) computeMM1k();
        else computeMM1();
    }

    private void computeMM1(){

    }

    private void computeMM1k(){

    }

    private void computeMMS(){

    }

    public double getRho(){
        return lambda/mu;
    }

    public double getQ0() {
        return q0;
    }

    public double getW() {
        return w;
    }

    public double getL() {
        return l;
    }
}
