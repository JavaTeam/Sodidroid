package com.sodidroid.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;

/**
 * Classe DAO met � disposition toutes les donn�es des agences.
 * Ici, j'utilise des rawQuery pour simplifier la mise en place.
 *  
 * @author Florent Dupont
 *
 */
@EBean
public class AgencyDao {
	
	private DataBaseHelper helper;
	
	@RootContext
	protected Context context;
	
	@AfterInject
	protected void init() {
		helper = new DataBaseHelper(context);
	}
	
	/** 
	 * La bonne pratique est de ne pas charger "tous" les objets en m�moire, mais seulement
	 * ceux pour lesquels on travaille a un instant t.
	 * On retourne donc un Cursor, c'est � dire un pointeur vers un enregistrement de la base.
	 * On pourra it�rer sur le curseur pour r�cup�rer un enregistrement
	 * @return Cursor curseur de l'agence
	 */
	public Cursor getAllAgencies() {
		
		SQLiteDatabase database = helper.getReadableDatabase();
		
		// possibilit� de r�cup�rer tous les r�sultats en passant directement par une requ�te SQL
		// avec un rawQuery
		Cursor cursor = database.rawQuery("select * from agency", null);
		
		return cursor;
	}
	
	/**
	 * R�cup�re le curseur sur l'agence dont l'ID est pass� en param�tre.
	 * @param id
	 * @return
	 */
	public Cursor getAgencyById(int id) {
		// 
		SQLiteDatabase database = helper.getReadableDatabase();
		Cursor c = database.rawQuery("select * from agency where _id = ?", new String[] { ""+id });
		// positionne le curseur
		c.moveToFirst();
		return c;
	}
	
}
