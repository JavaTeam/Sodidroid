package com.sodidroid;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.ViewById;
import com.sodidroid.dao.AgencyDao;

/**
 * 
 * Activité de liste des agences.
 * 
 * @author Florent Dupont
 *
 */
@EActivity(R.layout.activity_agency_list)
@NoTitle
public class AgencyListActivity extends Activity {
	
	@ViewById(R.id.agencylistview)
	protected ListView _agencyView;
	
	@Bean
	protected AgencyDao _repo;
	
	@AfterViews
	protected void init() {
		Cursor agencies = _repo.getAllAgencies();
		 
		 String[] from = {"name", "label"};
		 int [] to = {R.id.titre, R.id.description};
		 
		 final SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_agency_item, agencies, from, to );
		 
		_agencyView.setAdapter(adapter);
		
		// On se décharge de la gestion du cycle de vie du Cursor en appelant 
		// startManagingCursor().  La destruction du cursor (l'appel au close()) sera
		// lié à la destruction de l'activity.
		startManagingCursor(agencies);
	}
	
 
	 @ItemClick(R.id.agencylistview)
	 protected void itemViewClicked(int position) {
		 
		 final Intent t = new Intent(this, AgencyDetailActivity_.class);
		 t.putExtra("selectedAgencyId", (int)_agencyView.getItemIdAtPosition(position));
		 
		 startActivity(t);
	 }

}
