package com.sodidroid.model;

import lombok.Getter;
import lombok.Setter;
import android.database.Cursor;

/**
 * Objet métier représentant une agence.
 * @author Florent Dupont
 *
 */
public class Agency {

	@Getter @Setter
	private int id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String label;
	
	@Getter @Setter
	private String address;
	
	@Getter @Setter
	private double longitude;
	
	@Getter @Setter
	private double latitude;
	
	@Getter @Setter
	private String phone;
	
	/**
	 * Méthode utilitaire permettant de mapper le résultat d'un curseur avec l'objet métier
	 * @param c Cursor
	 * @return l'objet Agency 
	 */
	public static Agency fromCursor(Cursor c) {
		Agency agency = new Agency();
		agency.id      = c.getInt(c.getColumnIndex("_id"));
		agency.name = c.getString(c.getColumnIndex("name"));
		agency.label = c.getString(c.getColumnIndex("label"));
		agency.address = c.getString(c.getColumnIndex("address"));
		agency.longitude = c.getDouble(c.getColumnIndex("longitude"));
		agency.latitude = c.getDouble(c.getColumnIndex("latitude"));
		agency.phone = c.getString(c.getColumnIndex("phone"));
		
		// gère les retours à la ligne récupérés en base.
		agency.address = agency.address.replaceAll("<br>", "\n");
		
		return agency;
	}
	
}
