import java.net.URL;  

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  

import org.w3c.dom.Document;  
import org.w3c.dom.Element;   
import org.w3c.dom.NodeList;  
  
public abstract class RssReader implements Reader {
	
   private String name;
   private boolean haveCategory = false;
  
   public RssReader() {}
   
   public void setName(String newName){
		name = newName;
   }
   
   public void setHaveCategory(boolean bool){
	   haveCategory = bool;
   }
   
   public boolean getHaveCategory(){
	   return haveCategory;
   }

   public void writeFeed(String url) {
      try {  
         DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
         Document doc = builder.parse(new URL(url).openStream());
         NodeList items = doc.getElementsByTagName("item"); 
         
         System.out.println(this.name);
         final IConnection conn = new Database("jdbc:sqlite:database.db");	
  
         for (int i = 0; i < items.getLength(); i++) {  
            Element item = (Element)items.item(i);
            String fDate = getValue(item, "pubDate");
            String fCate = "None";
            if(haveCategory)
            	fCate = getValue(item, "category");
            String fLink = getValue(item, "link");
            String fTitl = getValue(item, "title");
    		try {
    			conn.executeQuery("INSERT OR IGNORE INTO rssfeeds VALUES('" + fDate + "', '" + this.name + "', '" + fCate + "', '" + fLink + "', '" + fTitl + "')", "insert", "");
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
      String result = parent.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue(); 
      if(result == null)
    	  result = "Empty";
      return result;
   }
}  
