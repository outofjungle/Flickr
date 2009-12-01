package org.outofjungle.flickr;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FlickrYQLHandler extends DefaultHandler {

	private ArrayList<FlickrRecord> photos = new ArrayList<FlickrRecord>();

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if ((localName.compareTo("photo") == 0) && (attributes.getLength() > 0)) {
			FlickrRecord photo = new FlickrRecord(
					attributes.getValue(uri, "farm"),
					attributes.getValue(uri, "id"),
					attributes.getValue(uri, "owner"),
					attributes.getValue(uri, "secret"),
					attributes.getValue(uri, "server"),
					attributes.getValue(uri, "title"));
			photos.add(photo);
		}
	}
	
	public ArrayList<FlickrRecord> getPhotos() {
		return photos;
	}
}
