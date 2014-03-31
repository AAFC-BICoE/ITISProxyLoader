package ca.gc.agr.mbb.itisproxyloader;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;


@RunWith(JUnit4.class)
public class ItisLoaderTest{

    @Test//(timeout=20000)
    public void runnit(){
	System.err.println("KKKKKKKKKKKKKKK");
	try{
	    Class.forName("org.sqlite.JDBC");
	}catch(ClassNotFoundException e){
	    e.printStackTrace();
	    return;
	}

	    /*
	try{
	    int numRecords = 700000;
	    int numThreads = 3;
	    int chunk = 10000;
	    List<Thread> threads = new ArrayList<Thread>();

	    for(int j=0; j<numRecords; j+= chunk*numThreads){
		for(int i=0; i<numThreads; i++){
		    ItisLoader itisLoader = new ItisLoader();
		    itisLoader.url = "jdbc:sqlite:/home/newtong/work/itisproxyloader/data/itisSqlite081613/ITIS.sqlite";
		    itisLoader.start = j + i*chunk;
		    itisLoader.end = j + i*chunk + chunk;
		    Thread t = new Thread(itisLoader);
		    t.start();
		    threads.add(t);
		}
		for(Thread t: threads){
		    t.join();
		}
	    }

	}
	catch(Throwable t){
	    t.printStackTrace();
	}
	    */
	ItisLoader itisLoader = new ItisLoader();
	itisLoader.start = 0;
	itisLoader.end = 9999999;
	//itisLoader.tsn = 895126;
	//itisLoader.tsn = 183833;
	//itisLoader.url = "jdbc:sqlite:/home/newtong/work/itisproxyloader/data/itisSqlite081613/ITIS.sqlite";
	
	System.err.println("ItisLoaderTest: start run");
	itisLoader.run();

    }


}
