package com.slearn.util;

/**
 * Created by E-M on 3/18/2017.
 */
public class QuestionQAns {

    private long q;
    private long a;

    public QuestionQAns() {

    }

    public long getQ() {
        return q;
    }

    public void setQ(long q) {
        this.q = q;
    }

    public long getA() {
        return a;
    }

    public void setA(long a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "QuestionQAns{" +
                "q=" + q +
                ", a=" + a +
                '}';
    }
}
