package com.example.pseudonym.datebasic;

import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * Created by c_pse on 2016/5/20.
 */

public class Days2TodayBuilder {
    protected final String TAG = "Days2TodayBuilder";

    public List<Memo> buildFromAssetFile(Context context, String filename){
        InputStream is=null;
        try{
            is = context.getAssets().open(filename);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =  builderFactory.newDocumentBuilder();

            Document xmlDocument = builder.parse(is);

            XPath xPath =  XPathFactory.newInstance().newXPath();

            String expression = "//person/memo/type[@id='daystonow']/@hint";
            System.out.println(expression);
            String hint = xPath.compile(expression).evaluate(xmlDocument);
            Log.d(TAG,hint);



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
