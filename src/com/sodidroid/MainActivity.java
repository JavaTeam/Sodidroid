package com.sodidroid;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.ViewById;
import com.sodidroid.R;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;


/**
 * Point d'entr�e de l'application.
 * 
 * L'application, pour des raisons de simplicit� ne g�re que des densit�s moyenne (mdpi) (ratio pixel / dp de 1).
 * Toutes les ressources graphiques suivent ce format. 
 * Dans une application r�elle, il faudrait fournir autant de ressources que de r�solutions d'�crans.
 * Pour voir la r�solution de l'�cran, il peut �tre utile de se rapprocher de ce site : 
 * http://en.wikipedia.org/wiki/List_of_displays_by_pixel_density
 * 
 * Google met � disposition des icones que vous pouvez int�grer � vos applis. 
 * Elles sont disponibles sous : 
 * http://developer.android.com/guide/practices/ui_guidelines/icon_design.html#design-tips
 * 
 * Dans cet exemple, les agences sont stock�es dans une base Sqlite, int�gr�e � l'application.
 * Dans une application r�elle, on appelerai un WebService pour r�cup�rer les infos des agences, 
 * la base Sqlite servirait de cache pour ces informations.
 * 
 * Android Annotation est utilis� ici pour simplifier le code.
 * 
 * @author Florent Dupont
 * 
 */
@EActivity(R.layout.activity_main)
@NoTitle
public class MainActivity extends Activity {

	@ViewById(R.id.imageMap)
	protected ImageView mapButton;
	
    @Click(R.id.imageMap)
    protected void mapButtonClicked() {
    	// lance une nouvelle activite
		 final Intent t = new Intent(this, AgencyListActivity_.class);
		 startActivity(t);
    }
    
}
