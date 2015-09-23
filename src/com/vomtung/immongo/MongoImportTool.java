package com.vomtung.immongo;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;
/**
 * 
 * @author vominhtung
 *
 */
public class MongoImportTool {

	private MainFrame frame;
	
	private Integer documentImportCount=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MongoImportTool mongoImportTool = new MongoImportTool();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MongoImportTool() {
		frame = new MainFrame();
		frame.setVisible(true);
		frame.getBtnImport().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					frame.getLoggingTextArea().setText("");
					documentImportCount=0;
					excutePost(frame.getSourceJSONURLTextField().getText(),null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	void parseStringArray(String input){
		String mongoDBURL = frame.getDestinationURLTextField().getText();
		Integer mongoPort = Integer.parseInt(frame.getDestinationPortTextField().getText());
		String destinationDataBase = frame.getDestinationDataBase().getText();
		String destinationCollection = frame.getDestinationCollectionTextField().getText();
		JSONArray array = new JSONArray (input);
		Mongo mongo = new Mongo(mongoDBURL, mongoPort);
		DB db = mongo.getDB(destinationDataBase);
		DBCollection collection = db.getCollection(destinationCollection);
		for (int i = 0; i < array.length(); i++) {
			documentImportCount++;
			JSONObject jSONObject = array.getJSONObject(i);
			logging(jSONObject.toString());
			DBObject dbObject = (DBObject) JSON.parse(jSONObject.toString());
			WriteResult writeResult = collection.insert(dbObject);
			logging("inserted:"+jSONObject+" to Mongo Database");
		}
		logging("Finish!, imported "+documentImportCount+" document to MongoDB");
	}
	
	public void excutePost(String targetURL, String urlParameters) throws Exception {
		logging("Begin import progress");
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(targetURL);
            logging("Executing request " + httpget.getRequestLine());
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            logging("received data from server:"+responseBody);
            parseStringArray(responseBody);
        } finally {
            httpclient.close();
        }
	}
	
	public void logging(String text){
		text = this.frame.getLoggingTextArea().getText()+'\n'+text;
		this.frame.getLoggingTextArea().setText(text);
	}
}
