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
 * Point d'entrée de l'application.
 * 
 * L'application, pour des raisons de simplicité ne gère que des densités moyenne (mdpi) (ratio pixel / dp de 1).
 * Toutes les ressources graphiques suivent ce format. 
 * Dans une application réelle, il faudrait fournir autant de ressources que de résolutions d'écrans.
 * Pour voir la résolution de l'écran, il peut être utile de se rapprocher de ce site : 
 * http://en.wikipedia.org/wiki/List_of_displays_by_pixel_density
 * 
 * Google met à disposition des icones que vous pouvez intégrer à vos applis. 
 * Elles sont disponibles sous : 
 * http://developer.android.com/guide/practices/ui_guidelines/icon_design.html#design-tips
 * 
 * Dans cet exemple, les agences sont stockées dans une base Sqlite, intégrée à l'application.
 * Dans une application réelle, on appelerai un WebService pour récupérer les infos des agences, 
 * la base Sqlite servirait de cache pour ces informations.
 * 
 * Android Annotation est utilisé ici pour simplifier le code.
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
