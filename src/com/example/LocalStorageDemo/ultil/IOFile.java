package com.example.LocalStorageDemo.ultil;

import android.util.Log;

import java.io.*;

/**
 * User: anhnt
 * Date: 10/22/13
 * Time: 9:38 AM
 */
public class IOFile
{
    private static final String TAG = "IOFile";

    public static boolean writeTextToSD(String filePath, String fileName, String content)
    {
        if (ExternalMemoryManager.MEMORY_MODE_READ_WRITE == ExternalMemoryManager.checkExternalMemory())
        {
            File dir = new File(filePath);
            dir.mkdirs();
            File file = new File(dir, fileName);

            try
            {
                FileOutputStream f = new FileOutputStream(file);
                PrintWriter pw = new PrintWriter(f);
                pw.println(content);
                pw.flush();
                pw.close();
                f.close();
                return true;
            }
            catch (FileNotFoundException e)
            {
                Log.i(TAG, "File not found.");
            }
            catch (IOException e)
            {
                Log.i(TAG, "IO exception.");
            }
        }
        return false;
    }

    public static String loadTextFromSD(String path, String name)
    {
        String content = "";
        if (ExternalMemoryManager.MEMORY_MODE_NOT_READ_WRITE != ExternalMemoryManager.checkExternalMemory())
        {
            String textInLine = "";
            try
            {
                File file = new File(path + "/" + name);
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                textInLine = bufferedReader.readLine();
                while (textInLine != null)
                {
                    content += textInLine + "\n";
                    textInLine = bufferedReader.readLine();
                }
                content = content.trim();
                bufferedReader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return content;
    }

    public static boolean writeXMLToSD()
    {
        if (ExternalMemoryManager.MEMORY_MODE_READ_WRITE == ExternalMemoryManager.checkExternalMemory())
        {
//            try
//            {
//                FileInputStream fis = null;
//                InputStreamReader isr = null;
//
//                fis = context.openFileInput(filename);
//                isr = new InputStreamReader(fis);
//                char[] inputBuffer = new char[fis.available()];
//                isr.read(inputBuffer);
//                data = new String(inputBuffer);
//                isr.close();
//                fis.close();
//
//    /*
//     * converting the String data to XML format
//     * so that the DOM parser understand it as an XML input.
//     */
//                InputStream is = new ByteArrayInputStream(data.getBytes("UTF-8"));
//
//                ArrayList<XmlData> xmlDataList = new ArrayList<XmlData>();
//
//                XmlData xmlDataObj;
//                DocumentBuilderFactory dbf;
//                DocumentBuilder db;
//                NodeList items = null;
//                Document dom;
//
//                dbf = DocumentBuilderFactory.newInstance();
//
//                db = dbf.newDocumentBuilder();
//
//                dom = db.parse(is);
//                // normalize the document
//                dom.getDocumentElement().normalize();
//
//                items = dom.getElementsByTagName("record");
//
//                ArrayList<String> arr = new ArrayList<String>();
//
//                for (int i = 0; i < items.getLength(); i++)
//                {
//
//                    Node item = items.item(i);
//
//                    arr.add(item.getNodeValue());
//
//                }
//                return true;
//            }
//            catch (ParserConfigurationException e)
//            {
//                e.printStackTrace();
//            }
        }
        return false;
    }

    public static boolean loadXMLFromSD()
    {
        if (ExternalMemoryManager.MEMORY_MODE_NOT_READ_WRITE != ExternalMemoryManager.checkExternalMemory())
        {
//            try
//            {
//                String filename = "file.txt";
//
//                FileOutputStream fos;
//
//                fos = openFileOutput(filename, Context.MODE_APPEND);
//
//
//                XmlSerializer serializer = Xml.newSerializer();
//
//                serializer.setOutput(fos, "UTF-8");
//
//                serializer.startDocument(null, Boolean.valueOf(true));
//                serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
//
//                serializer.startTag(null, "root");
//
//                for (int j = 0; j < 3; j++)
//                {
//
//                    serializer.startTag(null, "record");
//                    serializer.text(data);
//                    serializer.endTag(null, "record");
//                }
//                serializer.endDocument();
//
//                serializer.flush();
//
//                fos.close();
//                return true;
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//            }
        }
        return false;
    }
}
