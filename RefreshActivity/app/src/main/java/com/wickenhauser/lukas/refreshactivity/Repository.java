package com.wickenhauser.lukas.refreshactivity;

import java.util.LinkedList;

/**
 * Created by Lukas on 1/31/2015.
 */
public class Repository {
    private static Repository ourInstance = new Repository();

    public static Repository getInstance() {
        return ourInstance;
    }
    private LinkedList<Supplierung> list;

    private Repository() {
        list=new LinkedList<>();
    }

    public void AddSupplierung(Supplierung s){
        list.add(s);
    }

    public LinkedList<Supplierung> getList() {
        return list;
    }
}
