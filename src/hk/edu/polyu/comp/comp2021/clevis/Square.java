package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.util.Vertex;

import java.util.ArrayList;

public class Square extends Rectangle{
    public Square(Vertex p, Vector direct, int z) {
        super(p,direct,z);
    }
    @Override
    public String[] getInfo(String name){
        ArrayList<String> result = new ArrayList<>();
        result.add(name+"is a Square");
        result.add("Top-Left Corner : "+String.format("%.2f", p.x)+" "+String.format("%.2f", p.y));
        result.add("Side length : "+String.format("%.2f", direct.x));
        return (String[])result.toArray();
    }
}
