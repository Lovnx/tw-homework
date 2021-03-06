package com.tw.homework.conference;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * function - core class of file reader
 * author - yezhiyuan
 * date - 02 08 2018
 */
public class FileReader extends AllocateTemplate {

	@Override
	public void operate(Object object) throws Exception {
		if (!(object instanceof String) || object == null) {
			throw new RuntimeException("Please check the file name!");
		}
		getTalkList((String)object);
	}
	
	private void getTalkList(String fileName) throws Exception{
		List<String> stringList = getTalkStringListFromFile(fileName);
		getTalkObjectListFromFile(stringList);
	}
	
	private List<String> getTalkStringListFromFile(String fileName) throws Exception{
        List<String> talkList = new ArrayList<String>();
        try{
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = br.readLine();
            while (line != null)   {
                talkList.add(line);
                line = br.readLine();
            }
            in.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        return talkList;
    }
	
	private void getTalkObjectListFromFile(List<String> talkList) throws Exception{
        if (talkList == null)
            throw new RuntimeException("talkList is Empty");

        String minSuffix = "min";
        String lightningSuffix = "lightning";

        for(String conference : talkList) {
            int lastSpaceIndex = conference.lastIndexOf(" ");
            if (lastSpaceIndex == -1)
                throw new RuntimeException("Invalid talk, " + conference + ". Talk time must be specify.");

            String name = conference.substring(0, lastSpaceIndex);
            String timeStr = conference.substring(lastSpaceIndex + 1);
            if (name == null || "".equals(name.trim()))
                throw new RuntimeException("Invalid talk name, " + conference);
            else if (!timeStr.endsWith(minSuffix) && !timeStr.endsWith(lightningSuffix))
                throw new RuntimeException("Invalid talk time, " + conference + ". Time must be in min or in lightning");

            int time = 0;
			try {
                if (timeStr.endsWith(minSuffix)) {
                    time = Integer.parseInt(timeStr.substring(0, timeStr.indexOf(minSuffix)));
                }
                else if (timeStr.endsWith(lightningSuffix)) {
                    String lightningTime = timeStr.substring(0, timeStr.indexOf(lightningSuffix));
                    if ("".equals(lightningTime))
                        time = 5;
                    else
                        time = Integer.parseInt(lightningTime) * 5;
                }
            } catch (NumberFormatException nfe) {
                throw new RuntimeException("Unbale to parse time " + timeStr + " for talk " + conference);
            }
			INITIAL_CONFERENCE_LIST.add(new Conference(conference, name, time));
        }
    }
}