import java.util.ArrayList;

public class MultiLevelParking {
	ArrayList<Park<ITractor, IWheel>> parkStages;
    private final int countPlaces = 15;
    
    public MultiLevelParking(int countStages, int pictureWidth, int pictureHeight)
    {
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
    	if(parkIndex<0 || parkIndex>=parkStages.size())
    		return null;
    	return parkStages.get(parkIndex).getTrac(transportIndex);
    }
}
