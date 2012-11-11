package com.sodidroid;

import java.text.MessageFormat;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageButton;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.Extra;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.ViewById;
import com.sodidroid.dao.AgencyDao;
import com.sodidroid.model.Agency;



/**
 * Activité des détails des agences
 * 
 * @author Florent Dupont
 *
 */
@EActivity(R.layout.activity_agency_detail)
@NoTitle
public class AgencyDetailActivity extends Activity {

	@Bean
	protected AgencyDao _repo;
	
	@ViewById(R.id.detail_name)
	protected TextView _agencyName;
	
	@ViewById(R.id.detail_label)
	protected TextView _agencyLabel;
	
	@ViewById(R.id.detail_address)
	protected TextView _agencyAddress;
	
	@ViewById(R.id.detail_phone)
	protected TextView _agencyPhone;
	
	@ViewById(R.id.detail_call_btn)
	protected ImageButton _callBtn;
	
	@ViewById(R.id.detail_map_btn)
	protected ImageButton _mapBtn;
	
	private Agency _currentAgency;
	
	@Extra
	protected int selectedAgencyId;
	
	@AfterViews
	protected void init() {
		 _currentAgency = Agency.fromCursor(_repo.getAgencyById(selectedAgencyId));
	        
		_agencyName.setText(_currentAgency.getName());
		_agencyLabel.setText(_currentAgency.getLabel());
		_agencyAddress.setText(_currentAgency.getAddress());
		_agencyPhone.setText(_currentAgency.getPhone());
	}
	
    
    @Click(R.id.detail_call_btn)
    void startCall() {
    	Uri dialUri = Uri.parse("tel:" + _currentAgency.getPhone());
    	Intent intent = new Intent(Intent.ACTION_DIAL, dialUri);
    	
    	startActivity(intent);
    }
    
    @Click(R.id.detail_map_btn)
    void startMap() {
	
    	//MessageFormat format = new MessageFormat("");
    	//format.setLocale(Locale.US);
    	
    	Locale.setDefault(Locale.US);
    	
    	// 1er solution : Ouvre Gmaps, mais sans label
    	//String str = MessageFormat.format("geo:{0},{1}?z=15", _currentAgency.getLatitude(), _currentAgency.getLongitude());
		
    	// 2eme solution : laisse le choix à l'utilisateur.
    	// affiche un Label
		String str = MessageFormat.format("http://maps.google.com/maps?q=Sodifrance@{0},{1}", _currentAgency.getLatitude(), _currentAgency.getLongitude());
		
		// 3 eme solution : solution élégante car label, et d'office sur gmaps
		// ca va fonctionner avec des adresses géographiques. Dans notre cas, les adresses 
    	// sont des adresses postales (CEDEX) qui ne sont pas toutes trouvées par le
    	// service Google Maps !
    	//String str = MessageFormat.format("geo:0,0?q={0}&z=5", _currentAgency.getAddress());
		
		// plus d'info, jeter un oeil ici
		// http://picchiri.wordpress.com/2010/02/24/google-maps-parameter/

		Uri uri = Uri.parse(str);
    	Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    	
		startActivity(intent);
    }

}
