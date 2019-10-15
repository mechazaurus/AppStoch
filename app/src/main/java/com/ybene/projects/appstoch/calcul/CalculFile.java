package com.ybene.projects.appstoch.calcul;

public class CalculFile {
    private double lambda;
    private double mu;
    private int s;
    private int k;

    public CalculFile(double lambda, Unites uniteLambda, double mu, Unites uniteMu, int s, int k) {
        switch (uniteLambda){
            case CPS:
                this.lambda = lambda;
                break;
            case CPM:
                this.lambda = lambda*60;
                break;
            case CPH:
                this.lambda = lambda*3600;
                break;
            case CPJ:
                this.lambda = lambda*3600*24;
                break;
            case SECONDES:
                this.lambda = 1/lambda;
                break;
            case MINUTES:
                this.lambda = 1/(60*lambda);
                break;
            case HEURES:
                this.lambda = 1/(3600*lambda);
                break;
            case JOURS:
                this.lambda = 1/(24*3600*lambda);
                break;
        }
        switch (uniteMu){
            case CPS:
                this.mu = mu;
                break;
            case CPM:
                this.mu = mu*60;
                break;
            case CPH:
                this.mu = mu*3600;
                break;
            case CPJ:
                this.mu = mu*3600*24;
                break;
            case SECONDES:
                this.mu = 1/mu;
                break;
            case MINUTES:
                this.mu = 1/(60*mu);
                break;
            case HEURES:
                this.mu = 1/(3600*mu);
                break;
            case JOURS:
                this.mu = 1/(24*3600*mu);
                break;
        }
        this.s = s;
        this.k = k;
    }

    private double q0;
    private double w;
    private double wq;
    private double l;
    private double lq;

    public void compute(){
        if (s>1) computeMMS();
        else if (k>0) computeMM1k();
        else computeMM1();
    }

    private void computeMM1(){
        q0 = 1-lambda/mu;
        w = 1/(mu-lambda);
        wq = lambda/(mu*(mu-lambda));
        l = lambda/(mu-lambda);
        lq = lambda*lambda/(mu*(mu-lambda));
    }

    private void computeMM1k(){

    }

    private void computeMMS(){

    }

    public double getQn(int n){
        if (s>1) return getQnMMS(n);
        else if (k>0) return getQnMM1k(n);
        else return getQnMM1(n);
    }

    private double getQnMM1(int n) {
        double qn = q0;
        for (int i=0; i<n; i++) qn*=(lambda/mu);
        return qn;
    }

    private double getQnMM1k(int n) {
        return 1;
    }

    private double getQnMMS(int n) {
        return 1;
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

    public double getWq() {
        return wq;
    }

    public double getL() {
        return l;
    }

    public double getLq() {
        return lq;
    }
}
