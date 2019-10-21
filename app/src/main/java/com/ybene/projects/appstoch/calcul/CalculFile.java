package com.ybene.projects.appstoch.calcul;

public class CalculFile {
    private double lambda;
    private double mu;
    private double rho;
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
        switch (uniteMu) {
            case CPS:
                this.mu = mu;
                break;
            case CPM:
                this.mu = mu * 60;
                break;
            case CPH:
                this.mu = mu * 3600;
                break;
            case CPJ:
                this.mu = mu * 3600 * 24;
                break;
            case SECONDES:
                this.mu = 1 / mu;
                break;
            case MINUTES:
                this.mu = 1 / (60 * mu);
                break;
            case HEURES:
                this.mu = 1 / (3600 * mu);
                break;
            case JOURS:
                this.mu = 1 / (24 * 3600 * mu);
                break;
        }
        this.s = s;
        this.k = k;
        rho = lambda/(s*mu);
        if (s>1) computeMMS();
        else if (k>0) computeMM1k();
        else computeMM1();
    }

    private double q0;
    private double w;
    private double wq;
    private double l;
    private double lq;

    private void computeMM1(){
        q0 = 1-lambda/mu;
        w = 1/(mu-lambda);
        wq = lambda/(mu*(mu-lambda));
        l = lambda/(mu-lambda);
        lq = lambda*lambda/(mu*(mu-lambda));
    }

    private void computeMM1k(){
        q0 = (1-rho)/(1-Math.pow(rho, k-1));
        w = 1/(mu-lambda);
        wq = lambda/(mu*(mu-lambda));
        l = rho*(1-(k+1)*Math.pow(rho, k)+k*Math.pow(rho, k+1))/((1-rho)*(1-Math.pow(rho, k+1)));
        lq = l-(1-q0);
    }

    private void computeMMS(){
        double somme = 0;
        for (int j = 0; j < s; j++)
            somme+=Math.pow(rho*s,j)/f(j)+Math.pow(rho*s,s)/(f(s)*(1-rho));
        q0 = 1/somme;
        lq = q0*Math.pow(rho*s,s)*rho/(f(s)*(1-rho)*(1-rho));
        wq = lq/lambda;
        w = wq + 1/mu;
        l = lambda*w;
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
        return (1-rho)*Math.pow(rho, n)/(1-Math.pow(rho, k-1));
    }

    private double getQnMMS(int n) {
        if (n<s) return Math.pow(rho*s, n)/f(n)*q0;
        else return Math.pow(s, s)*Math.pow(rho, n)/f(s)*q0;
    }

    public double getPsejour(double t){
        if (s>1) return getPejourMMS(t);
        else return getPejourMM1(t);
    }

    private double getPejourMM1(double t) {
        return Math.exp(-mu*Math.pow(1-rho, t));
    }

    private double getPejourMMS(double t) {
        double g = q0*Math.pow(rho*s, s)/(f(s)*(1-rho));
        double sm1mrs = s - 1 - rho * s;
        double mmut = -mu * t;
        double exp = Math.exp(mmut * sm1mrs);
        double d = (1 - exp) / sm1mrs;
        return Math.exp(mmut) * (1 + g * d);
    }

    public double getRho(){
        return rho;
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

    private int f(int n){
        if (n==0) return 1;
        else if (n<3) return n;
        else return n*f(n-1);
    }
}
