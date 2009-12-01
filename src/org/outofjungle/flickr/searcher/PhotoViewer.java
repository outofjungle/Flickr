package org.outofjungle.flickr.searcher;

import java.io.InputStream;
import java.net.URL;

import org.outofjungle.flickr.searcher.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class PhotoViewer extends Activity {
 
	public static final String PHOTO_URL = "";
	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photoviewer);

		try {
			String url = getIntent().getStringExtra(PHOTO_URL);
			URL resource = new URL(url);
			InputStream istream = (InputStream) resource.getContent();
			Drawable photo = Drawable.createFromStream(istream, "src");

			ImageView imageview = (ImageView) findViewById(R.id.photoviewer);
			imageview.setImageDrawable(photo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
