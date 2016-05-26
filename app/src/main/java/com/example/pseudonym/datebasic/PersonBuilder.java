package com.example.pseudonym.datebasic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * Created by c_pse on 2016/5/26.
 */
public class PersonBuilder {

    public List<Person> buildFromAssetFile(Context context, String filename){
        InputStream is=null;
        try{
            // 1. open asset file: preset_person.xml
            is = context.getAssets().open(filename);

            // 2. create xpath object
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =  builderFactory.newDocumentBuilder();

            Document xmlDocument = builder.parse(is);

            XPath xPath =  XPathFactory.newInstance().newXPath();

            // 3. query person node_list with
            String person_expression = "//person";
            NodeList person_node_list = (NodeList)xPath.compile(person_expression).evaluate(xmlDocument, XPathConstants.NODESET);
            List<Person> person_list = new ArrayList<>();

            for(int i = 0; i < person_node_list.getLength(); i++){
                Node memo_node = person_node_list.item(i);
                // a. get drawable image
                String expr = "image";
                String strValue = xPath.compile(expr).evaluate(memo_node);
                Bitmap image_bitmap = BitmapFactory.decodeStream(context.getAssets().open(strValue));
//                Bitmap image_bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_menu_gallery);
                image_bitmap.setDensity(Bitmap.DENSITY_NONE);
                Bitmap bMapScaled = Bitmap.createScaledBitmap(image_bitmap, 24, 24, true);
                Drawable image = new BitmapDrawable(context.getResources(),image_bitmap);

                // b. get name
                expr = "name";
                strValue = xPath.compile(expr).evaluate(memo_node);

                // c. new memo and add it to list
                Person person = new Person(strValue, image);
                person_list.add(person);
            }

            return person_list;

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null)
                {
                    is.close();
                }
            } catch (Exception ignored) {}
        }

        return null;
    }
}
