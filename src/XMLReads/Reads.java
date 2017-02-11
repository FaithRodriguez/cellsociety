/**
 * Written by Gideon Pfeffer
 * sets up the XML reader for all sub classes
 */
package XMLReads;

import cellsociety_team06.ReadXMLFile;

public class Reads{
	private ReadXMLFile files;
	private String type;
	private int size;

	/**
	 * reads the XML file based on the string and size
	 */
	public Reads(String type, int s){
		this.type = type;
		files = new ReadXMLFile();
		size = s;
	}

	/**
	 * returns the character at that index
	 * of the map generated by the XML reader
	 */
	public Character get(int i, int j){
		return files.returnMap(size).get(type).get(i).get(j);
	}

	/**
	 * @returns the size of the map generated by the XML
	 */
	public int size(){
		return size;
	}
	
	/**
	 * @returns the height of the xml generated map
	 */
	public int height(){
		return files.returnMap(size).get(type).size();
	}

	/**
	 * @returns the width of the xml generated map
	 */
	public int width(){
		return files.returnMap(size).get(type).get(0).size();
	}

}
