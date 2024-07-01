package task;

import data.Address;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountFloor {
    private Map<Integer, Integer> map = new HashMap<>();
    public CountFloor(){
        map = new HashMap<>();
    }
    public void CountingFloor(List<Address> addresses){
        for(Address address : addresses){
            if(!map.containsKey(address.getFloor())){
                map.put(address.getFloor(), 0);
            }
            int currentValue = map.get(address.getFloor());
            currentValue += 1;
            map.put(address.getFloor(), currentValue);
        }
        System.out.println(map);
    }
}
