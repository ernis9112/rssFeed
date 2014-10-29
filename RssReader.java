import java.net.URL;  

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  

import org.w3c.dom.Document;  
import org.w3c.dom.Element;   
import org.w3c.dom.NodeList;  
  
public abstract class RssReader {
	
   private String name;
  
   public RssReader() {}
   
   public void setName(String newName){
		name = newName;
   }

   public void writeFeed(String url) {
      try {  
         DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
         Document doc = builder.parse(new URL(url).openStream());
         NodeList items = doc.getElementsByTagName("item"); 
         
         System.out.println(this.name);
         Database db = new Database();		
  
         for (int i = 0; i < items.getLength(); i++) {  
            Element item = (Element)items.item(i);
            String fDate = getValue(item, "pubDate");
            String fCate = getValue(item, "category");
            String fLink = getValue(item, "link");
            String fTitl = getValue(item, "title");
    		try {
    	 	    db.executeQuery("INSERT OR IGNORE INTO rssfeeds VALUES('" + fDate + "', '" + this.name + "', '" + fCate + "', '" + fLink + "', '" + fTitl + "')", "insert");
    	    } catch (Exception e) {
    	 	    e.printStackTrace();
    	 	}
            Logger.getInstance().addLog("Nuskaitytas naujas rss is url:" + url);
         }  
      } catch (Exception e) {  
         e.printStackTrace();  
      }  
   }  
  
   public String getValue(Element parent, String nodeName) {  
      return parent.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue();  
   }  
}  
