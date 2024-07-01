package task;

import data.Address;
import data.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DublicateAddress {
    private final Map<String, List<Client>> map;
    public DublicateAddress(){
        map = new HashMap<>();
    };
    public void findDublicateAddress(List<Client> clients, List<Address> addresses){
        for(Address address: addresses){
            if(!map.containsKey(address.getStreet())){
                map.put(address.getStreet(), new ArrayList<>());
            }
            for(Client client : clients) {
                if (client.getAddressId() == address.getId()) {
                    map.get(address.getStreet()).add(client);
                }
            }
        }
        printHashMap(addresses);
    }
    private void printHashMap(List<Address> addresses) {
        for (Map.Entry<String, List<Client>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty() && entry.getValue().size() > 1) {
                System.out.println("Key: " + entry.getKey());
                System.out.println("Values:");
                for (Client client : entry.getValue()) {
                    System.out.println("- ID " + client.getId() + ", name: " + client.getName() + ", number: " + client.getPersonnelNumber());
                }
                System.out.println("-----------------------");
            }
        }
    }
}
