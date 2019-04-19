/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seeder;

import Lib.UserLib;
import Model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Timy
 */
public class UserSeeder {
    
    protected User userModel;
    
    
    public UserSeeder() {    
        userModel = new User();
    }
    
    public void seed() {
        List<String> type = new ArrayList<>();
        type.add("Admin");
        type.add("Admin Kasir");
        type.add("Admin Gudang");
        
        for (String item: type) {
            String username = item.replace(" ", "_").toLowerCase();
            
            UserLib user = userModel.findItemOnUserameAndType(username, item);
            
            if (user == null) {
                List<String> request = new ArrayList<>();
                request.add(item);
                request.add(username);
                request.add("123");
                request.add(item);
                
                userModel.create(request);
            }
        }
    }
    
}
