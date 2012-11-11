package com.sodidroid.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;

/**
 * Classe DAO met à disposition toutes les données des agences.
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
	 * La bonne pratique est de ne pas charger "tous" les objets en mémoire, mais seulement
	 * ceux pour lesquels on travaille a un instant t.
	 * On retourne donc un Cursor, c'est à dire un pointeur vers un enregistrement de la base.
	 * On pourra itérer sur le curseur pour récupérer un enregistrement
	 * @return Cursor curseur de l'agence
	 */
	public Cursor getAllAgencies() {
		
		SQLiteDatabase database = helper.getReadableDatabase();
		
		// possibilité de récupérer tous les résultats en passant directement par une requête SQL
		// avec un rawQuery
		Cursor cursor = database.rawQuery("select * from agency", null);
		
		return cursor;
	}
	
	/**
	 * Récupère le curseur sur l'agence dont l'ID est passé en paramètre.
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
