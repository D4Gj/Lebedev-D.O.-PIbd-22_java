import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MultiLevelParking {
	ArrayList<Park<ITractor, IWheel>> parkStages;
    private final int countPlaces = 15;
    
    int picWid;
    int picHeight;
    
    public MultiLevelParking(int countStages, int pictureWidth, int pictureHeight)
    {
    	picWid=pictureWidth;
    	picHeight=pictureHeight;
    	parkStages = new ArrayList<Park<ITractor, IWheel>>();
        for (int i = 0; i < countStages; i++)
        {
        	parkStages.add(new Park<ITractor, IWheel>(countPlaces, pictureWidth, pictureHeight));
        }
    }

    public Park<ITractor, IWheel> level(int index)
    {
        if (index > -1 && index < parkStages.size())
        {
            return parkStages.get(index);
        }
        return null;
    }
    
    public ITractor getTrac(int parkIndex, int transportIndex) {
    	return parkStages.get(parkIndex).getTrac(transportIndex);
    }

	public boolean SaveLevel(String name,int lvl) throws IOException {
		try {
			if (lvl < parkStages.size() && lvl > 0) {
				return false;
			}
		FileWriter fw = new FileWriter(name);
        WriteToFile("Level:"+ lvl + "\n", fw);
        Park<ITractor, IWheel> level = parkStages.get(lvl);
        for (int i = 0; i < countPlaces; i++)
        {
            ITractor tractor = level.getTrac(i);
            if (tractor != null)
            {
                if (tractor.getClass().getName() == "tractor")
                {
                    WriteToFile(i + ":tractor:", fw);
                }
                if (tractor.getClass().getName() == "workTractor")
                {
                    WriteToFile(i + ":workTractor:", fw);
                }
                WriteToFile(tractor.ToString() + "\n", fw);
            }
        }
        
        fw.close();
        return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	 private void WriteToFile(String text, FileWriter fw)
	    {
	        try {
				fw.write(text);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

	public boolean SaveData(String name) throws IOException {
		FileWriter fw = new FileWriter(name);
        WriteToFile("CountLevels:"+ parkStages.size() + "\n", fw);
        for (Park<ITractor, IWheel> level : parkStages)
        {
            WriteToFile("Level" + "\n", fw);
            for (int i = 0; i < parkStages.size(); i++)
            {
                ITractor tractor = level.getTrac(i);
                if (tractor != null)
                {
                    if (tractor.getClass().getName() == "tractor")
                    {
                        WriteToFile(i + ":tractor:", fw);
                    }
                    if (tractor.getClass().getName() == "workTractor")
                    {
                        WriteToFile(i + ":workTractor:", fw);
                    }
                    WriteToFile(tractor.ToString() + "\n", fw);
                }
            }
        }
        fw.close();
        return true;
	}

	public boolean LoadData(String absolutePath) throws IOException {
		FileReader fr = new FileReader(absolutePath);
        String bufferTextFromFile = "";
        int counter = -1;
        
        int c;
        while ((char)(c = fr.read()) != '\n') {
        	bufferTextFromFile += (char)c;
        }
        
        if(bufferTextFromFile.contains("CountLevels")) {
        	int count = Integer.parseInt(bufferTextFromFile.split(":")[1]);
        	if(parkStages != null) {
        		parkStages.clear();
        	}
        	parkStages = new ArrayList<Park<ITractor, IWheel>>(count);
            bufferTextFromFile = "";
        } else {
        	return false;
        }
        
        while ((c = fr.read()) != -1) {
        	if ((char)c == '\n') {        		
        		ITractor tractor = null;
                
                if(bufferTextFromFile.equals("Level")) {
                	counter++;
                	parkStages.add(new Park<ITractor, IWheel>(countPlaces, picWid,picHeight));
                    bufferTextFromFile = "";
                	continue;
                }
                
                if (bufferTextFromFile.split(":").length > 1) {
        	       	if(bufferTextFromFile.split(":")[1].equals("tractor")) {
        	       		tractor = new tractor(bufferTextFromFile.split(":")[2]);
        	       	} 
        	       	else if(bufferTextFromFile.split(":")[1].equals("workTractor")) {
        	       		tractor = new workTractor(bufferTextFromFile.split(":")[2]);
        	       	}
        	       	parkStages.get(counter).setTractor(Integer.parseInt(bufferTextFromFile.split(":")[0]), tractor);
                }
                
                bufferTextFromFile = "";
            } else {
            	bufferTextFromFile += (char)c;
            }
        }
        
        return true;
	}

	public boolean LoadLevel(String absolutePath) throws IOException {
		try {
		FileReader fr = new FileReader(absolutePath);
        String bufferTextFromFile = "";
        int lvl = 0;
        
        int c;
        while ((char)(c = fr.read()) != '\n') {
        	bufferTextFromFile += (char)c;
        }
        
        if (bufferTextFromFile.contains("Level")) {
           	lvl = Integer.parseInt(bufferTextFromFile.split(":")[1]);
           	bufferTextFromFile = "";
        } else {
        	return false;
        }
        
        if (parkStages.size() < lvl) {
        	return false;
        }

        parkStages.set(lvl, new Park<ITractor, IWheel>(countPlaces, picWid, picHeight));
        
        while ((c = fr.read()) != -1) {
        	if ((char)c == '\n') {                
                ITractor tractor = null;
                
                if(bufferTextFromFile == null) {
                	continue;
                }
                
                if (bufferTextFromFile.split(":").length > 2) {
        	       	if(bufferTextFromFile.split(":")[1].equals("tractor")) {
        	       		tractor = new tractor(bufferTextFromFile.split(":")[2]);
        	       	} 
        	       	else if(bufferTextFromFile.split(":")[1].equals("workTractor")) {
        	       		tractor = new workTractor(bufferTextFromFile.split(":")[2]);
        	       	}
        	       	
        	       	parkStages.get(lvl).setTractor(Integer.parseInt(bufferTextFromFile.split(":")[0]), tractor);
                }
                
                bufferTextFromFile = "";
            } else {
            	bufferTextFromFile += (char)c;
            }
          } 
        }catch (Exception e) {
			e.printStackTrace();
			return false;
		}
        return true;
	}
}
