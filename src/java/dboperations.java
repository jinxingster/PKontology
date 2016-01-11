
import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ROUROU
 */
public class dboperations {
    
    
    
    public static void insertPaper(SQLiteConnection db, String name, String author, String publishe, String year, String myname, int nofkeys, String comment)
	{
		 try {
		    	
		    	SQLiteStatement statement = db.prepare(
		            "INSERT INTO tpaper (NAME, AUTHOR, PUBLISHE, YEAR, MYNAME, NOFKEYS, COMMENT)  VALUES(?,?,?,?,?,?,?)");
		    	  statement.bind(1, name);
			      statement.bind(2,author);
			      statement.bind(3,publishe);
			      statement.bind(4,year);
			      statement.bind(5,myname);
			      statement.bind(6,nofkeys);
			      statement.bind(7,comment);
			      statement.stepThrough();
			      statement.dispose();
		    	 
		   
		      
		    } catch (SQLiteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		 
		 
		 public static void insertTerm(SQLiteConnection db, String paper, String term, String Relation, int value)
			{
				 try {
				    	
				    	SQLiteStatement statement = db.prepare(
				            "INSERT INTO tterm (PAPER, TERM, relation,VALUE)  VALUES(?,?,?,?)");
				    	  statement.bind(1, paper);
					      statement.bind(2,term);
					      statement.bind(3,Relation);
					      statement.bind(4,value);
					   
					      statement.stepThrough();
					      statement.dispose();
				    	 
				   
				      
				    } catch (SQLiteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}

    
}
